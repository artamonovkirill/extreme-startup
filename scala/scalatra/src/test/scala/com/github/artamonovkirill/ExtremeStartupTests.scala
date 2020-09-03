package com.github.artamonovkirill

import org.scalatest.matchers.should.Matchers
import org.scalatest.funspec.AnyFunSpec

class ExtremeStartupTests extends AnyFunSpec with Matchers {

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
