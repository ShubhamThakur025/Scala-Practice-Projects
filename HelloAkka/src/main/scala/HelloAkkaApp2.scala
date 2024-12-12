import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object HelloAkkaApp2 {
  private object Child {
    def apply(): Behavior[String] = Behaviors.receive { (context, message) =>
      context.log.info(s"Child received a message: $message")
      if (message.toLowerCase == "fail") {
        throw new Exception("Child is failing")
      }
      Behaviors.same
    }
  }

  private object Parent {
    def apply(): Behavior[String] = Behaviors.setup { context =>
      val child1: ActorRef[String] = context.spawn(Child(), "child1")
      context.watch(child1)

      Behaviors.receiveMessage[String] { message =>
        context.log.info(s"Parent received a message: $message")
        message match {
          case "createChild" =>
            context.log.info("Creating child actor...")
            child1 ! "hello"
          case "failChild" =>
            context.log.info("Instructing child to fail...")
            child1 ! "fail"
          case _ =>
            context.log.info("Unknown message")
        }
        Behaviors.same
      }.receiveSignal {
        case (context, akka.actor.typed.Terminated(ref)) if ref == child1 =>
          context.log.info(s"Child actor $ref has failed or terminated!")
          Behaviors.same
        case _ =>
          context.log.info("Parent actor is stopping.")
          Behaviors.same
      }
    }
  }


  def main(args: Array[String]): Unit = {
    val system: ActorSystem[String] = ActorSystem(Parent(), "ActorWatchSystem")
    system ! "createChild"
    system ! "failChild"
    Thread.sleep(1000)
    system.terminate()
  }
}
