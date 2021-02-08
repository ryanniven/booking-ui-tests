@suite

Feature: Example Feature file using Cucumber

  Scenario: search for pen on amazon
    Given I navigate to the book page
    And I select the //*[@id="TableBookingFormpeople"]/div/div/label[2] button
    Then I populate tomorrows date into the TableBookingFormdate-input field
    And I select the //*[@id="buttons"]/label[1] button
    And I enter Dixie Normous into the TableBookingFormname-input field
    And I enter 07769696420 into the TableBookingFormtelephone-input field
    And I enter stop_shouting@me.com into the TableBookingFormmarketing_email-input field
    And I enter slow down, lie down into the TableBookingFormspecialRequests-input field
    Then I select the //*[@id="TableBookingFormtermsAndConditions"]/div/label/div button
    Then I select the //*[@id="TableBookingFormmarketing_selected"]/div/label/div button
#    this doesn't work as expected... will have to toggle this off for tests
    Then I select the //*[@id="recaptcha-anchor"]/div[1] button
    Then I click submit




