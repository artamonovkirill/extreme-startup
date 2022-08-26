
ThisBuild / scalaVersion := "3.1.3"
ThisBuild / organization := "com.github.artamonovkirill"

lazy val scalatra = project
  .settings(
    name := "Scalatra",
    libraryDependencies += "org.scalatra" %% "scalatra" % "3.0.0-M1",
    libraryDependencies += "javax.servlet" % "javax.servlet-api" % "4.0.1",
    libraryDependencies += "org.eclipse.jetty" % "jetty-servlet" % "9.4.48.v20220622",
    libraryDependencies += "org.scalatra" %% "scalatra-scalatest" % "3.0.0-M2" % Test)