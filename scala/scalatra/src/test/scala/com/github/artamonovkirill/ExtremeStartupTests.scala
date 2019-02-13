package com.github.artamonovkirill

@RunWith(classOf[JUnitRunner])
class ExtremeStartupTests extends FunSpec with Matchers {

  describe("handles") {
    it("multiple queries") {
      ExtremeStartup.question("a=b&q=foo") should equal(Some("foo1"))
    }

    it("no query value") {
      ExtremeStartup.question("q=") should equal(None)
      ExtremeStartup.question("q") should equal(None)
    }
  }

}
