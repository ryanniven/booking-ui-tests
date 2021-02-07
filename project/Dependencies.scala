import sbt._

object Dependencies {

  val test = Seq(
    "org.scalatest"              %% "scalatest"       % "3.2.0"   % Test,
    "org.scalatestplus"          %% "selenium-3-141"  % "3.2.0.0" % Test,
    "com.vladsch.flexmark"        % "flexmark-all"    % "0.35.10" % Test,
    "io.cucumber"                %% "cucumber-scala"  % "6.1.1"   % Test,
    "io.cucumber"                 % "cucumber-junit"  % "6.1.1"   % Test,
    "junit"                       % "junit"           % "4.12"    % Test,
    "com.novocode"                % "junit-interface" % "0.11"    % Test,
    "com.typesafe"                % "config"          % "1.3.2"   % Test,
    "com.typesafe.scala-logging" %% "scala-logging"   % "3.9.2"   % Test
  )

}
