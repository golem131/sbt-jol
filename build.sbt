import bintray.Keys._

sbtPlugin := true

organization := "pl.project13.sbt"
name := "sbt-jol"

scalaVersion := "2.10.6"
scalacOptions ++= List(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-target:jvm-1.6",
  "-encoding", "UTF-8"
)

object Versions {
  val jol = "0.8"
}

libraryDependencies ++= {
  Seq(
    "org.openjdk.jol" % "jol-core" % Versions.jol, 
    "org.openjdk.jol" % "jol-cli"  % Versions.jol
  )
}

publishTo := {
  if (isSnapshot.value) Some(Classpaths.sbtPluginSnapshots) else Some(Classpaths.sbtPluginReleases)
}

// publishing settings

publishMavenStyle := false
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))
bintrayPublishSettings
repository in bintray := "sbt-plugins"
bintrayOrganization in bintray := None

scriptedSettings
scriptedLaunchOpts += s"-Dproject.version=${version.value}"
