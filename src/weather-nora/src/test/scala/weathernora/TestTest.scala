package com.weather.weathernora

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter


class TestTest extends FunSuite {
  val test = new Test()
  val result = test.responseFuture
  test("testing of test!") {
    assert(result == "baaa")
  }
}


