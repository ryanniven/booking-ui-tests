package booking.test.ui.driver

import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxOptions}
import org.openqa.selenium.{MutableCapabilities, WebDriver}
import scala.collection.JavaConverters._

class BrowserFactory {
  def createBrowser(browserType: Option[String], customOptions: Option[MutableCapabilities]): WebDriver =
    browserType match {
      case Some("chrome")  => chromeInstance(chromeOptions(customOptions))
      case Some("firefox") => firefoxInstance(firefoxOptions(customOptions))
      case Some(browser)   =>
        throw BrowserCreationException(
          s"'browser' property '$browser' not supported by " +
            s"the webdriver-factory library."
        )
      case None            =>
        throw BrowserCreationException("'browser' property is not set, this is required to instantiate a Browser")
    }

  private def chromeInstance(options: ChromeOptions): WebDriver =
    new ChromeDriver(options)

  private def firefoxInstance(options: FirefoxOptions): WebDriver = {
    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null")
    val driver = new FirefoxDriver(options)
    driver.manage().window().maximize()
    driver
  }

  def chromeOptions(customOptions: Option[MutableCapabilities]): ChromeOptions =
    customOptions match {
      case Some(options) =>
        val userOptions = options.asInstanceOf[ChromeOptions]
        userOptions
      case None          =>
        val defaultOptions = new ChromeOptions()
        defaultOptions.addArguments("start-maximized")
        // `--use-cmd-decoder` and `--use-gl` are added as a workaround for slow test duration in chrome 85 and higher (PBD-822)
        // Can be reverted once the issue is fixed in the future versions of Chrome.
        defaultOptions.addArguments("--use-cmd-decoder=validating")
        defaultOptions.addArguments("--use-gl=desktop")
        defaultOptions
    }

  def firefoxOptions(customOptions: Option[MutableCapabilities]): FirefoxOptions =
    customOptions match {
      case Some(options) =>
        val userOptions = options.asInstanceOf[FirefoxOptions]
        userOptions
      case None          =>
        val defaultOptions = new FirefoxOptions()
        defaultOptions.setAcceptInsecureCerts(true)
        defaultOptions
    }
}
case class BrowserCreationException(message: String) extends RuntimeException(message)
