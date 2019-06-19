package com.weather.weathernora

import akka.actor.{Actor, ActorSystem}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer

import scala.concurrent.Future
import scala.util.{ Success, Failure }

import spray.json.DefaultJsonProtocol


class Test {

  def test(s: String): String = {
    s.replaceAll("a", "b")
  }

  //val responseFuture: Future[HttpResponse] = {
  //  Http().singleRequest(HttpRequest(uri = "https://akka.io"))
  //}

  def main(args: Array[String]): Unit = {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  implicit val executionContext = system.dispatcher

  val responseFuture: Future[HttpResponse] = {
    Http().singleRequest(HttpRequest(uri = "https://akka.io"))
  }

  responseFuture.onComplete {
    case Success(res) => println(res)
    case Failure(e) => println(e)
  }


  }

}
