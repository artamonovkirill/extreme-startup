package com.github.artamonovkirill

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class ExtremeStartupTests extends FunSpec with Matchers {

  describe("handles") {
    it("multiple queries") {
      ExtremeStartup.question("a=b&q=foo") should equal(Some("foo"))
    }

    it("no query value") {
      ExtremeStartup.question("q=") should equal(None)
      ExtremeStartup.question("q") should equal(None)
    }
  }

}
