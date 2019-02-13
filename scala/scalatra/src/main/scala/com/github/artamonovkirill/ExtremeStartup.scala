package com.github.artamonovkirill

import org.scalatra.ScalatraServlet

object ExtremeStartup {
  def question(query: String): Option[String] = {
    query
      .split("&")
      .find(q => q.startsWith("q"))
      .flatMap(q => q.split("=").tail.find(p => true))
  }
}

class ExtremeStartup extends ScalatraServlet {
  get("/") {
    val query = ExtremeStartup.question(request.queryString)
    println(s"Query is : $query")
    query.getOrElse("Hello!")
  }
}