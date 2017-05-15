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

libraryDependencies ++= {
  val jol = "0.8"
  Seq(
    "org.openjdk.jol"        % "jol-core" % jol
    , "org.openjdk.jol"      % "jol-cli"  % jol

  )
}

//libraryDependencies += Dependencies.jol
//libraryDependencies += Dependencies.jolCli

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
