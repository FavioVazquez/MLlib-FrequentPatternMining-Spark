name := "MLlib-FrequentPatternMining-Spark"

version := "1.0"

scalaVersion := "2.10.4"

unmanagedBase := baseDirectory.value / "lib"

libraryDependencies ++= Seq(
  //  "org.apache.spark" % "spark-core_2.10" % "1.3.1" % "provided",
  //  "org.apache.spark" %% "spark-sql"  % "1.3.1" % "provided",
  "org.apache.logging.log4j" % "log4j-api" % "2.2",
  "com.databricks" % "spark-csv_2.10" % "1.0.3",
  "org.apache.logging.log4j" % "log4j-core" % "2.2"
)

assemblyJarName in assembly := "MLlib-FrequentPatternMining.jar"

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))
    