package booking.test.ui.cucumber.stepdefs

import java.time.{LocalDate}

import booking.test.ui.conf.TestConfiguration
import booking.test.ui.cucumber.Find._

class StepDef extends BaseStepDef {

  Given("""^I navigate to the (.*) page$""") { url: String =>
    driver.navigate.to(TestConfiguration.url("pub-booking-app") + url)
  }

  And("""^I click (.*)""") { id: String =>
    findById(id).click()
  }
  And("""^I select the (.*) button$""") { xpath: String =>
    findByXpath(xpath).click()
  }

  And("""^I enter (.*) into the (.*) field$""") { (text: String, id: String) =>
    findById(id).sendKeys(text)
  }

  And("""^I populate tomorrows date into the (.*) field$""") { (id: String) =>
    findById(id).sendKeys(LocalDate.now.plusDays(1).toString.format("yyyy-MM-dd"))
  }

  Then("""^I check (.*) contains (.*)""") { (id: String, text: String) =>
    findById(id).getText.contains(text)
  }

}
