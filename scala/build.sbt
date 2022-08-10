
ThisBuild / scalaVersion := "2.13.8"
ThisBuild / organization := "com.github.artamonovkirill"

lazy val scalatra = project
  .settings(
    name := "Scalatra",
    libraryDependencies += "org.scalatra" %% "scalatra" % "2.8.2",
    libraryDependencies += "javax.servlet" % "javax.servlet-api" % "4.0.1",
    libraryDependencies += "org.eclipse.jetty" % "jetty-servlet" % "9.4.48.v20220622",
    libraryDependencies += "org.scalatra" %% "scalatra-scalatest" % "2.8.2" % Test)