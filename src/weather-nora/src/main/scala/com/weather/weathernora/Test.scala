package com.weather.weathernora

//import akka.actor.{Actor, ActorSystem}
//import akka.http.scaladsl.Http
//import akka.http.scaladsl.model._
//import akka.stream.ActorMaterializer
//import akka.util.ByteString
import scala.util.parsing.json._
import scala.concurrent.Future
import scala.util.{ Success, Failure }
import scala.io.Source.fromInputStream

import scalaj.http._

import spray.json._
import spray.json.lenses.JsonLenses._
import spray.json.DefaultJsonProtocol._


class Test {

  def test(s: String): String = {
    s.replaceAll("a", "b")
  }

  def getApi: HttpResponse[JsValue] = {
    val response: HttpResponse[JsValue] = Http("https://api.darksky.net/forecast/3e7a45712a2ab6d9870de14df945a833/42.3601,-71.0589?exclude=alerts,flags").execute(parser = {inputStream =>
        JsonParser(fromInputStream(inputStream).mkString)
    })
    response
  }

  def getWeather = {
    //current
    val weatherFieldsC = Seq("summary", "temperature", "apparentTemperature", "humidity", "precipProbability")
    //hourly
    val weatherFieldsH = Seq("summary", "temperature", "apparentTemperature", "humidity", "precipProbability")
    //daily
    val weatherFieldsD = Seq("summary", "temperature", "apparentTemperature", "humidity", "precipProbability", "temperatureHigh", "temperatureLow")
    val body = getApi.body
    val currentTempQ = 'currently / 'apparentTemperature
    val currentTemp = body.extract[Float](currentTempQ)
    currentTemp
  }
  // element(0) in query gives the first element in json array
  // ex body.extract[JsValue]('daily / 'data / element(0))
  // OR return Vector(JsValue)
  // ex body.extract[JsValue]('daily / 'data / *)



  //val responseFuture: Future[HttpResponse] = {
  //  Http().singleRequest(HttpRequest(uri = "https://akka.io"))
  //}

  def main(args: Array[String]): Unit = {
  //implicit val system = ActorSystem()
  //implicit val materializer = ActorMaterializer()
  //implicit val executionContext = system.dispatcher

    //val response: HttpResponse[String] = Http("https://api.darksky.net/forecase/3e7a45712a2ab6d9870de14df945a833/42.3601,-71.0589").asString
    //println(response.body)
    val response: HttpResponse[JsValue] = Http("https://api.darksky.net/forecast/3e7a45712a2ab6d9870de14df945a833/42.3601,-71.0589").execute(parser = {inputStream =>
        JsonParser(fromInputStream(inputStream).mkString)
    })
    println(response)

  }

}
