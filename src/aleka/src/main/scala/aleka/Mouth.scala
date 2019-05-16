package aleka

import akka.actor.Actor
import akka.event.Logging

class Mouth extends Actor {

  // another way to log
  val log = Logging(context.system, this)

  def receive = {
    case SayHello => {
      log.info("Mouth got a SayHello message")
      println("Hello back at you")
    }
    case unknown => {
      log.info("Mouth got an unknown message: " + unknown)
      println("Mouth: I don't know what that was.")
    }
  }
}
