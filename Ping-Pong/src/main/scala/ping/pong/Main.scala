package ping.pong

import akka.actor.typed.ActorSystem
import ping.pong.Messages.StartGame
import ping.pong.actors.ParentActor

object Main {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem(ParentActor(), "system")
    system ! StartGame
    Thread.sleep(5000)
    system.terminate()
  }
}


  
