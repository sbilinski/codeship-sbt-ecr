import com.amazonaws.regions.{Region, Regions}

scalaVersion := "2.11.8"
version      := "0.1.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(EcrPlugin)

packageName in Docker := "codeship-sbt-ecr"
version     in Docker := version.value
dockerUpdateLatest    := true

region           in Ecr := Region.getRegion(Regions.US_EAST_1)
repositoryName   in Ecr := (packageName in Docker).value
localDockerImage in Ecr := (packageName in Docker).value + ":" + (version in Docker).value

// Create the repository before authentication takes place (optional)
login in Ecr := ((login in Ecr) dependsOn (createRepository in Ecr)).value

// Authenticate and publish a local Docker image before pushing to ECR
push in Ecr := ((push in Ecr) dependsOn (publishLocal in Docker, login in Ecr)).value

