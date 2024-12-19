package ping.pong

import akka.actor.typed.ActorRef

object Messages {
  sealed trait Command

  case class TossRequest(replyTo: ActorRef[TossResult]) extends Command

  case class TossResult(winner: String) extends Command

  case object StartGame extends Command

  case object Strike extends Command

  case class StartPlay(strike: ActorRef[Command]) extends Command

  case object End extends Command
}