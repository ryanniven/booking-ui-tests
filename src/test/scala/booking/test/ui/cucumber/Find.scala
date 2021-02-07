package booking.test.ui.cucumber

import booking.test.ui.cucumber.stepdefs.BaseStepDef
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.{By, WebElement}

object Find extends BaseStepDef {

  private def find(by: By): WebElement = {
    Wait.fluentWait.until(ExpectedConditions.presenceOfElementLocated(by))
    driver.findElement(by)
  }

  def findById(id: String) = find(By.id(id))

  def findByName(name: String) = find(By.name(name))

  def findByCss(css: String) = find(By.cssSelector(css))

  def findByXpath(id: String) = find(By.xpath(id))

  def findByTagName(tagName: String) = find(By.tagName(tagName))

  def findByLinkText(text: String) = find(By.linkText(text))

  def findURL() = driver.getCurrentUrl

  def findH1() = findByTagName("h1")
}
