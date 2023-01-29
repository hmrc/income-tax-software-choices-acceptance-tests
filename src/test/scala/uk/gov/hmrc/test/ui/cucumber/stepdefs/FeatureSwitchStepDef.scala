/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.datatable.DataTable
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.test.ui.pages.FeatureSwitchPage
import uk.gov.hmrc.test.ui.pages.FeatureSwitchPage._

class FeatureSwitchStepDef extends BaseStepDef {
  private val submitButtonId = "continue-button"

  Given("^I navigate to the Feature Switch page$") { () =>
    FeatureSwitchPage.loadPage
  }

  Then("^I am on the Feature Switch page$") { () => assertUrl(FeatureSwitchPage.url) }

  When("""^I (.*) the '(.*)' check box$""") { (checkOrUncheck: String, featureName: String) => setFeature(featureName, checkOrUncheck) }

  And("""^I click to update the Feature Switches$""") { () => submitFeatureSwitches() }

  And("""^I wait for the page to return$""") { () => waitForPage }

  And("""^The '(.*)' check box is (.*)$""") { (featureName: String, checkOrUncheck: String) =>
    val checkBox = getCheckBox(featureName)

    setFeature(featureName, checkOrUncheck)

    if (checkOrUncheck == "checked")
      checkBox.isSelected should be(true)

    if (checkOrUncheck == "unchecked")
      checkBox.isSelected should be(false)
  }

  And("^On the feature switch page I (.*) features$") { (checkOrUncheck: String, collection: DataTable) =>
    FeatureSwitchPage.loadPage
    collection.asList().forEach(featureName => setFeature(featureName, checkOrUncheck))
    submitFeatureSwitches()
    waitForPage
  }

  private def setFeature(featureName: String, checkOrUncheck: String) = {
    val checkBox = getCheckBox(featureName)

    if (checkOrUncheck == "check" && !checkBox.isSelected)
      checkBox.click()

    if (checkOrUncheck == "uncheck" && checkBox.isSelected)
      checkBox.click()
  }

  private def submitFeatureSwitches(): Unit = {
    driver
      .findElement(By.id(submitButtonId))
      .click()
  }

  private def waitForPage = {
    fluentWait
      .until(ExpectedConditions.presenceOfElementLocated(By.id(submitButtonId)))
  }

  private def getCheckBox(featureName: String) = {
    val checkBoxValue: String = switches.getOrElse(featureName, fail(s"Unknown feature name: $featureName"))
    driver
      .findElement(By.xpath(s"""//*[@value="$checkBoxValue"]"""))
  }

}
