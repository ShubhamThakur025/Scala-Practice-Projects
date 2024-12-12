import akka.actor.typed.{ActorSystem, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object HelloAkkaApp {
  private object Greeter {
    def apply(): Behavior[String] = Behaviors.receive{(context, message) =>
      context.log.info(s"Received Message: $message")
      if(message.toLowerCase == "hello") {
        context.log.info("Hello there!")
      } else {
        context.log.info(s"Unknown message: $message")
      }
      Behaviors.same
    }
  }

  def main(args: Array[String]): Unit = {
    val system: ActorSystem[String] = ActorSystem(Greeter(), "GreeterSystem")

    system ! "Hello"
    system ! "How are you?"

    system.terminate()
  }
}
