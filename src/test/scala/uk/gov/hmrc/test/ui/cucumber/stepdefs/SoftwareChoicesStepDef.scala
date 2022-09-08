/*
 * Copyright 2022 HM Revenue & Customs
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

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.test.ui.pages.SoftwareChoicesHomePage
import uk.gov.hmrc.test.ui.pages.SoftwareChoicesHomePage._

import scala.jdk.CollectionConverters.iterableAsScalaIterableConverter

class SoftwareChoicesStepDef extends BaseStepDef {

  Given("^I navigate to the Software Choices home page$") { () =>
    SoftwareChoicesHomePage.loadPage
  }

  Then("^I am on the Software Choices home page$") { () =>
    assertUrl(SoftwareChoicesHomePage.url)
  }

  When("""^I enter '(.*)' into the search bar$""") { (searchTerm: String) =>
    write(searchBarId, searchTerm)
  }

  And("""^I wait for the software vendor list to update$""") { () =>
    fluentWait
      .until(ExpectedConditions.presenceOfElementLocated(By.id(softwareVendorsId)))
  }

  Then("""^I am presented with a list of vendors matching '(.*)'$""") { (matchingTerm: String) =>
    driver
      .findElements(By.cssSelector(".govuk-grid-column-two-thirds > div > h3"))
      .asScala
      .foreach(_.getText should include(matchingTerm))
  }

  Then("""^I am presented with an alpha list of vendors matching '(.*)'$""") { (matchingTerm: String) =>
    driver
      .findElements(By.cssSelector(".govuk-grid-column-two-thirds > div > h3"))
      .asScala
      .foreach(_.getText should include(matchingTerm))
  }

  Then("""^I am presented with an alpha list of (.*) vendors$""") { (count: Int) =>
    val alphaCountId = "vendor-count"
    fluentWait
      .until(ExpectedConditions.presenceOfElementLocated(By.id(alphaCountId)))
    driver
      .findElement(By.id(alphaCountId)).getText should include(count.toString)
  }

  Then("""^I am presented with a list of (.*) vendors$""") { (count: Int) =>
    val betaCountClass = "software-vendors-num"
    fluentWait
      .until(ExpectedConditions.presenceOfElementLocated(By.className(betaCountClass)))
    driver
      .findElement(By.className(betaCountClass)).getText should include(count.toString)
  }

  When("""^I open the '(.*)' accordion fold$""") { (accordionFoldName: String) =>
    val accordionFold = driver
      .findElement(By.id(toAccordionFoldId(accordionFoldName)))
    if (accordionFold.getAttribute("aria-expanded") == "false")
      accordionFold.click()
  }

  When("I have opened all folds") { () =>
    toAccordionFoldId.values.foreach(accordionFoldId => {
      val accordionFold = driver
        .findElement(By.id(accordionFoldId))
      if (accordionFold.getAttribute("aria-expanded") == "false")
        accordionFold.click()
    })
  }

  When("""^I select the '(.*)' checkbox$""") { (checkbox: String) =>
    val checkboxId: String = toFilterId(checkbox)
    driver
      .findElement(By.id(checkboxId))
      .click()
  }

  And("""^I click on the first vendor$""") { () =>
    driver
      .findElement(By.id("software-vendor-0"))
      .findElement(By.className("govuk-link"))
      .click()
  }

  And("""^I wait for the details page to load$""") { () =>
    fluentWait
      .until(ExpectedConditions.presenceOfElementLocated(By.className("hmrc-report-technical-issue")))
  }

  And("""^I click to apply filters$""") { () =>
    driver
      .findElement(By.cssSelector(".apply-filters-button"))
      .click()
  }

  Then("""^I am presented with an alpha list of vendors which provide '(.*)'$""") { (text: String) =>
    driver
      .findElements(By.cssSelector("#software-vendor-list > div"))
      .asScala
      .foreach(_.getText should include(text))
  }

  Then("""^The page contains the label for '(.*)'$""") { (text: String) =>
    driver
      .findElement(By.id("main-content")).getText should include (text)
  }

  Then("""^I am presented with a list of vendors which provide '(.*)'$""") { (text: String) =>
    driver
      .findElements(By.cssSelector("#software-vendor-list > div"))
      .asScala
      .foreach(_.getText should include(text))
  }

  Given("""^I have selected all filters$""") { () =>
    toFilterId.values.foreach(checkboxId => {
      val filter = driver
        .findElement(By.id(checkboxId))
      if (!filter.isSelected) filter.click()
    })
  }

  When("""^I click to clear filters$""") { () =>
    driver
      .findElement(By.cssSelector(".clear-filters-button"))
      .click()
  }

  Then("""^There are no selected filters$""") { () =>
    toFilterId.values.foreach(checkboxId => {
      driver
        .findElement(By.id(checkboxId))
        .isSelected shouldBe false
    })
  }

}
