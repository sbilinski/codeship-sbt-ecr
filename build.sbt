scalaVersion := "2.11.8"
version      := "0.1.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

packageName in Docker := "codeship-scala-docker"
version     in Docker := version.value
dockerUpdateLatest    := true

