package com.github.artamonovkirill

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatra.test.scalatest.ScalatraFunSuite

@RunWith(classOf[JUnitRunner])
class ExtremeStartupHttpTests extends ScalatraFunSuite {

  addServlet(classOf[ExtremeStartup], "/*")

  test("exposes root endpoint") {
    get("/") {
      status should equal(200)
      body should equal("Hello!")
    }
  }

  test("returns query if given") {
    get("/?q=foo") {
      status should equal(200)
      body should equal("foo")
    }
  }

}
