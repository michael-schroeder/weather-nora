package aleka

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

object Aleka1 extends App {
  // an actor needs an ActorSystem
  val system = ActorSystem("AlekaSystem")

  // create the actors
  val mouth = system.actorOf(Props[Mouth], name = "mouth")
  val brain = system.actorOf(Props[Brain], name = "brain")

  // send the brain two messages
  brain ! Hello
  brain ! "hello"

  Thread.sleep(500)

  // shut down the system
  system.terminate
}
