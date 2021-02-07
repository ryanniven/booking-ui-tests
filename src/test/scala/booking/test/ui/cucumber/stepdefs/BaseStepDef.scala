package booking.test.ui.cucumber.stepdefs

import booking.test.ui.driver.{BrowserDriver, SingletonDriver}
import org.scalatest.matchers.should.Matchers
import org.scalatest.concurrent.Eventually
import io.cucumber.scala.{EN, ScalaDsl}

import scala.util.Try

trait BaseStepDef extends ScalaDsl with EN with BrowserDriver with Eventually with Matchers {

  sys.addShutdownHook {
    Try(SingletonDriver.closeInstance())
  }
}
