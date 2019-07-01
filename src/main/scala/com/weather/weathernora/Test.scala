package com.weather.weathernora

import akka.actor.{Actor, ActorSystem}
//import akka.http.scaladsl.Http
//import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
//import akka.util.ByteString
import scala.util.parsing.json._
import scala.concurrent.Future
import scala.util.{ Success, Failure }
import scala.io.Source.fromInputStream

import scalaj.http._

import spray.json._
import spray.json.lenses.JsonLenses._
import spray.json.DefaultJsonProtocol._

case class weatherType(interval: String, attributes: Seq[String])

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

  def getWeather(what: String) = {
    val body = getApi.body

    /*
    val weatherCurr = weatherType("currently", Seq("summary", "temperature", "apparentTemperature", "humidity", "precipProbability"))
    val weatherHour = weatherType("hourly", Seq("summary", "temperature", "apparentTemperature", "humidity", "precipProbability"))
    val weatherDaily = weatherType("daily", Seq("summary", "temperature", "apparentTemperature", "humidity", "precipProbability", "temperatureHigh", "temperatureLow"))
    val weatherMap = Map("current" -> weatherCurr, "hour" -> weatherHour, "day" -> weatherDaily)

    val wtype = weatherMap(type)

    val currentTempQ = 'currently / 'apparentTemperature
    val interval = wtype.interval
    val attributes = wtype.attributes

    // need to figure out how we can query the array's for day/hourly easy
    // read them as a sequence body.export[Seq[JsValue]]('hourly / 'data)
    // two different methods ?
    queryResults = attributes.map{ case(s: String) => {
      if (interval == "currently") {
        query = '${interval} / '${s}
        body.extract[Float](query)
      }
      else {
        query = '${interval} / 'data
        body.extract[Float](query)
      }
    }}


    val currentTemp = body.extract[Float](currentTempQ)
    currentTemp
  }
  */
  // element(0) in query gives the first element in json array
  // ex body.extract[JsValue]('daily / 'data / element(0))
  // OR return Vector(JsValue)
  // ex body.extract[JsValue]('daily / 'data / *)



  //val responseFuture: Future[HttpResponse] = {
  //  Http().singleRequest(HttpRequest(uri = "https://akka.io"))
  //}
  }

  def main(args: Array[String]): Unit = {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

    val response: HttpResponse[JsValue] = Http("https://api.darksky.net/forecast/3e7a45712a2ab6d9870de14df945a833/42.3601,-71.0589").execute(parser = {inputStream =>
        JsonParser(fromInputStream(inputStream).mkString)
    })
    println(response)

  }

}
