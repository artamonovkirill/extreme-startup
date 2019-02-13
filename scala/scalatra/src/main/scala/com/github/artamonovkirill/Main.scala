package com.github.artamonovkirill

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}


object Main extends App {
  val server = new Server(5555)
  val root = new ServletContextHandler(server, "/", SESSIONS)

  val servlet = new ExtremeStartup().asInstanceOf[javax.servlet.Servlet]

  root.addServlet(new ServletHolder(servlet), "/*")

  server.start()
  server.join()
}
