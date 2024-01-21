name := "hello-jqwik-java"

version := "0.2"

compile / javacOptions += "-Xlint:all"

javaOptions += "-enableassertions"

ThisBuild / scalaVersion := "2.13.12"

ThisBuild / libraryDependencies ++= Seq(
  "net.aichler" % "jupiter-interface" % "0.11.1" % Test,
  "net.jqwik"   % "jqwik"             % "1.8.2"  % Test
)

jacocoReportSettings := JacocoReportSettings()
  .withThresholds(
    JacocoThresholds(
      instruction = 80,
      method = 100,
      branch = 100,
      complexity = 100,
      line = 90,
      clazz = 100)
  )
  .withFormats(JacocoReportFormats.HTML)

jacocoExcludes := Seq("**.Main*")

enablePlugins(JavaAppPackaging)
