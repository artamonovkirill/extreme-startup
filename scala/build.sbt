
ThisBuild / scalaVersion := "2.13.4"
ThisBuild / organization := "com.github.artamonovkirill"

lazy val scalatra = project
  .settings(
    name := "Scalatra",
    libraryDependencies += "org.scalatra" %% "scalatra" % "2.7.0",
    libraryDependencies += "javax.servlet" % "javax.servlet-api" % "4.0.1",
    libraryDependencies += "org.eclipse.jetty" % "jetty-servlet" % "9.4.35.v20201120",
    libraryDependencies += "org.scalatra" %% "scalatra-scalatest" % "2.7.1" % Test)