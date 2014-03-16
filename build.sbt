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
  "org.apache.derby" % "derby" % "10.4.1.3",
  "org.json" % "json" % "20140107",
  "org.apache.commons" % "commons-lang3" % "3.2.1",
  "commons-codec" % "commons-codec" % "1.9",
  "com.restfb" % "restfb" % "1.6.14"
)     

play.Project.playJavaSettings
