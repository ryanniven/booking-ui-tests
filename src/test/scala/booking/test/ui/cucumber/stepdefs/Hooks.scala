package booking.test.ui.cucumber.stepdefs

import booking.test.ui.driver.BrowserDriver
import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.openqa.selenium.{OutputType, TakesScreenshot}

class Hooks extends ScalaDsl with EN with BrowserDriver {
  After { scenario: Scenario =>
    if (scenario.isFailed) {
      val screenshotName = scenario.getName.replaceAll(" ", "_")
      val screenshot     = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.BYTES)
      scenario.attach(screenshot, "image/png", screenshotName)
    }
  }
}
