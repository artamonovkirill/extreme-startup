package com.github.artamonovkirill

import org.scalatest.{FunSpec, Matchers}

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
