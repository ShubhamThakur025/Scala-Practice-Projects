package ping.pong.actors

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import ping.pong.Messages.*
import scala.util.Random

object CoinTossActor {
  def apply(): Behavior[Command] = Behaviors.receive { (context, message) => {
    message match
      case TossRequest(replyTo) =>
        val winner = if (Random.nextBoolean()) "Ping" else "Pong"
        context.log.info(s"$winner won the toss!")
        replyTo ! TossResult(winner)
        Behaviors.same
      case _ => Behaviors.unhandled
  }
  }
}
