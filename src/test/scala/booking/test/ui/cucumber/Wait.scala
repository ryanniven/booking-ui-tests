package booking.test.ui.cucumber

import java.util.concurrent.TimeUnit

import booking.test.ui.cucumber.stepdefs.BaseStepDef
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.{By, WebDriver, WebElement}

object Wait extends BaseStepDef {
  val url = ""

  def fluentWait: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(20, TimeUnit.SECONDS)
    .pollingEvery(250, TimeUnit.MILLISECONDS)
    .ignoring(classOf[org.openqa.selenium.NoSuchElementException])

  def waitForElement(id: String): WebElement = waitForElement(By.id(id))

  def waitForElements(h1: String): WebElement = waitForElement(By.tagName(h1))

  private def waitForElement(by: By): WebElement = fluentWait.until(ExpectedConditions.presenceOfElementLocated(by))

  def secondsWait(secs: Int) = Thread.sleep(secs.*(1000))

}
