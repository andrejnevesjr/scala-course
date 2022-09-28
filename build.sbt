val ScalaTest = "3.2.13"

lazy val root = (project in file("."))
  .settings(
    organization := "com.train",
    name := "trainapp",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.12.16",
    assembly / mainClass := Some("com.train.app.Main"),
    retrieveManaged := true,
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % ScalaTest  % "test",
    ),
    assembly / assemblyJarName  := "train-fatjar-0.0.1.jar",

  )

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-language:higherKinds",
  "-language:postfixOps",
  "-feature",
  "-Xfatal-warnings",
)