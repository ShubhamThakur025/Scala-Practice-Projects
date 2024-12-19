package ping.pong.actors

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import ping.pong.Messages.{Command, Strike}

object GameActor {
  def apply(name: String): Behavior[Command] = Behaviors.receive { (context, message) => {
    message match
      case Strike =>
        context.log.info(s"$name strikes!")
        Behaviors.same
      case _ => Behaviors.unhandled
  }
  }
}
