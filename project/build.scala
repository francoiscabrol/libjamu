import sbt.Keys._
import sbt._

object LibjamuBuild extends Build {

  //////////////////////////////////////////////////////////////////////////////
  // PROJECT INFO
  //////////////////////////////////////////////////////////////////////////////

  val ORGANIZATION = "francoiscabrol"
  val PROJECT_NAME = "libjamu"
  val PROJECT_VERSION = "0.5.1"

  //////////////////////////////////////////////////////////////////////////////
  // PROJECTS
  //////////////////////////////////////////////////////////////////////////////

  lazy val root = Project(
    id = PROJECT_NAME,
    base = file("."),
    settings = libjamuSettings
  )

  //////////////////////////////////////////////////////////////////////////////
  // SETTINGS
  //////////////////////////////////////////////////////////////////////////////

  lazy val libjamuSettings = Project.defaultSettings ++ basicSettings

  lazy val basicSettings = Seq(
    version := PROJECT_VERSION,
    organization := ORGANIZATION,

    javacOptions ++= Seq("-source", "1.7"),

    // Remove the scala dependencies
    crossPaths := false,
    autoScalaLibrary := false,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
}
