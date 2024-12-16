import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

object InteractionPattern1 {
  object Backend {
    sealed trait Request
    final case class StartTranslationJob(taskId: Int, site: String, replyTo: ActorRef[Response]) extends Request

    sealed trait Response
    final case class JobStarted(taskId: Int) extends Response
    final case class JobPending(taskId: Int, progress: Double) extends Response
    final case class JobCompleted(taskId: Int, site: String) extends Response
  }

  
  object Frontend {
    sealed trait Command
    final case class Translate(site: String, replyTo: ActorRef[String]) extends Command
    private final case class WrappedBackendResponse(response: Backend.Response) extends Command

    def apply(backend: ActorRef[Backend.Request]): Behavior[Command] =
      Behaviors.setup[Command]{context =>
        val backendResponseAdapter: ActorRef[Backend.Response] = context.messageAdapter(message => WrappedBackendResponse(message))

        def active(count: Int, inProgress: Map[Int, ActorRef[String]]): Behavior[Command] = {
            Behaviors.receiveMessage{
              case Translate(site, replyTo) =>
                val taskId = count + 1
                backend ! Backend.StartTranslationJob(taskId, site, backendResponseAdapter)
                active(taskId, inProgress.updated(taskId, replyTo))

              case wrapped: WrappedBackendResponse =>
                wrapped.response match
                  case Backend.JobStarted(taskId) =>
                    context.log.info(s"Task started $taskId")
                    Behaviors.same
                  case Backend.JobPending(taskId, progress) =>
                    context.log.info(s"Task pending $taskId. Progress: $progress")
                    Behaviors.same
                  case Backend.JobCompleted(taskId, result) =>
                    context.log.info(s"Task completed $taskId. Result: $result")
                    inProgress(taskId) ! result
                    active(count, inProgress - taskId)
            }
        }
        active(inProgress = Map.empty, count = 0)
      }
  }
}
