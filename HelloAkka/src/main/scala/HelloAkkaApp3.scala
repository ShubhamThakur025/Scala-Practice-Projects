import akka.actor.typed.{ActorRef, ActorSystem, Behavior, PostStop}
import akka.actor.typed.scaladsl.Behaviors

object HelloAkkaApp3 {
 object Child {
  def apply(): Behavior[String] = Behaviors.setup { context =>
   Behaviors.receiveMessage {
    case "stop" =>
     context.log.info("Child actor is stopping.")
     Behaviors.stopped
    case message =>
     context.log.info(s"Child received: $message")
     Behaviors.same
   }
  }
 }


 private object Parent{
  def apply(): Behavior[String] = Behaviors.setup{context =>
    val child: ActorRef[String] = context.spawn(Child(), "child")
    context.watch(child)
    Behaviors.receiveMessage[String]{
     case "stopChild" =>
      context.log.info("Parent is instructing the child to stop...")
      child ! "stop"
      Behaviors.same
     case "shutdown" =>
      context.log.info("Parent is shutting down")
      Behaviors.stopped
     case message =>
      context.log.info(s"Received Message: $message")
      Behaviors.same
    }.receiveSignal { case (_, PostStop) => context.log.info("Parent has stopped.")
     Behaviors.same
    case (context, akka.actor.typed.Terminated(ref)) if ref == child =>
     context.log.info(s"Child actor $ref has failed or terminated!")
     Behaviors.same
    }
  }
 }

 def main(args: Array[String]): Unit = {
  val system: ActorSystem[String] = ActorSystem(Parent(), "ActorSystem")
  system ! "stopChild"
  system ! "shutdown"
  Thread.sleep(1000)
  system.terminate()
 }
}
