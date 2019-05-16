package aleka

import akka.actor.{Actor, Props, ActorRef, ActorLogging}
import akka.event.Logging

class Brain extends Actor with ActorLogging {

  // actors we communicate with
  val mouth = context.actorSelection("../mouth")

  // handle messages sent to us
  def receive = {
    case Hello => {
      log.info("Brain got a hello message")
      mouth ! SayHello
    }
    case unknown => {
      log.info("Brain got an unknown message: " + unknown)
    }
  }
}
