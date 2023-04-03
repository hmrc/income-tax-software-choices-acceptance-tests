import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "webdriver-factory" % "0.42.0"   % Test,
    "org.scalatest"       %% "scalatest"         % "3.2.14"   % Test,
    "org.scalatestplus"   %% "selenium-4-4"      % "3.2.14.0" % Test,
    "com.vladsch.flexmark" % "flexmark-all"      % "0.62.2"   % Test,
    "io.cucumber"         %% "cucumber-scala"    % "8.10.1"   % Test,
    "io.cucumber"          % "cucumber-junit"    % "7.8.1"    % Test,
    "junit"                % "junit"             % "4.13.2"   % Test,
    "com.novocode"         % "junit-interface"   % "0.11"     % Test,
    "com.typesafe"         % "config"            % "1.4.2"    % Test
  )

}
