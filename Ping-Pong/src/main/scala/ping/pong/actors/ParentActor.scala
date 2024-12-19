package ping.pong.actors

import akka.actor.typed.{ActorRef, Behavior, Scheduler}
import akka.actor.typed.scaladsl.Behaviors
import akka.util.Timeout
import ping.pong.Messages._
import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object ParentActor {
  def apply(): Behavior[Command] = Behaviors.setup { context =>
    implicit val timeout: Timeout = 3.seconds
    implicit val scheduler: Scheduler = context.system.scheduler
    implicit val executionContext: ExecutionContextExecutor = context.executionContext

    val coinTossActor = context.spawn(CoinTossActor(), "coinTossActor")
    val pingActor = context.spawn(GameActor("Ping"), "pingActor")
    val pongActor = context.spawn(GameActor("Pong"), "pongActor")

    Behaviors.receiveMessage {
      case StartGame =>
        context.ask(coinTossActor, TossRequest.apply) {
          case Success(TossResult(winner)) =>
            if (winner == "Ping") {
              StartPlay(pingActor)
            } else {
              StartPlay(pongActor)
            }
          case Failure(e) => End
        }
        Behaviors.same

      case StartPlay(ref) =>
        ref ! Strike
        Behaviors.same

      case _ =>
        Behaviors.unhandled
    }
  }
}
