package booking.test.ui.cucumber.stepdefs

import booking.test.ui.cucumber.Find._

class StepDef extends BaseStepDef {
  val url: String = url: String

  Given("""^I navigate to (.*)$""") { url: String =>
//    driver.navigate().to(TestConfiguration.url("name-of-frontend-service") + url)
    driver.navigate().to(url)
  }

  And("""^I select the (.*) id$""") { id: String =>
    findById(id).click()
  }

  And("""^I enter (.*) into the (.*) field$""") { (text: String, id: String) =>
    findById(id).sendKeys(text)
  }

  Then("""^I check (.*) contains (.*)""") { (id: String, text: String) =>
    findById(id).getText.contains(text)
  }

}
