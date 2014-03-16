name := "bullet5"

version := "1.1-SNAPSHOT"


libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.18",
  "org.apache.derby" % "derby" % "10.4.1.3"
)     

play.Project.playJavaSettings
