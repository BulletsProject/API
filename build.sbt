import com.github.play2war.plugin._

name := "bullet5"

version := "1.0-SNAPSHOT"

Play2WarPlugin.play2WarSettings

Play2WarKeys.servletVersion := "3.0"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.18",
  "org.apache.derby" % "derby" % "10.4.1.3"
)     

play.Project.playJavaSettings
