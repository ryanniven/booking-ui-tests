package booking.test.ui.driver

import com.typesafe.scalalogging.LazyLogging

import org.openqa.selenium.WebDriver

trait BrowserDriver extends LazyLogging {
  logger.info(
    s"Instantiating Browser: ${sys.props.getOrElse("browser", "'browser' System property not set. This is required")}"
  )

  implicit lazy val driver: WebDriver = SingletonDriver.getInstance()

  sys.addShutdownHook {
    SingletonDriver.closeInstance()
  }
}
