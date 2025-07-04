/*
 * Copyright 2024 HM Revenue & Customs
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

import scala.jdk.CollectionConverters._

class SoftwareChoicesStepDef extends BaseStepDef {

  Given("^I navigate to the Software Choices home page$") { () =>
    SoftwareChoicesHomePage.loadPage
  }

  Then("^I am on the Software Choices home page$") { () =>
    assertUrl(SoftwareChoicesHomePage.url)
  }

  Then("^I am on the combined software results page$") { () =>
    assertUrl(SoftwareChoicesHomePage.zeroResultsUrl)
  }

  When("""^I enter '(.*)' into the search bar$""") { (searchTerm: String) =>
    write(searchBarId, searchTerm)
  }

  Then("""^I am presented with a list of vendors matching '(.*)'$""") { (matchingTerm: String) =>
    driver
      .findElements(By.cssSelector("#software-vendor-list > div > h3"))
      .asScala
      .foreach(_.getText should include(matchingTerm))
  }

  Then("""^I am presented with a list of (.*) vendors$""") { (count: Int) =>
    fluentWait
      .until(ExpectedConditions.presenceOfElementLocated(By.id(vendorCountId)))
    driver
      .findElements(By.cssSelector(s"#$softwareVendorList > div"))
      .size() shouldBe count
  }

  Then("""^I click the clear all filters link$""") { () =>
    driver
      .findElement(By.linkText("Clear all filters"))
      .click()
  }

  When("""^I select the '(.*)' checkbox$""") { (checkbox: String) =>
    val checkboxId: String = toFilterId(checkbox)
    driver
      .findElement(By.id(checkboxId))
      .click()
  }

  And("""^On the search software page, I click on the vendor link: (\d)$""") { (index: Int) =>
    driver
      .findElement(By.id(s"software-vendor-${index - 1}"))
      .findElement(By.tagName("a"))
      .click()
  }

  Given("""^I have selected all filters$""") { () =>
    toFilterId.values.foreach { checkboxId =>
      val filter = driver
        .findElement(By.id(checkboxId))
      if (!filter.isSelected) filter.click()
    }
  }

  val extraPricingOptions: Seq[String] = Seq("free-trial-filter", "paid-for-filter")

  val overseasPropertyOption: Seq[String] = Seq("overseas-property-filter")

  Then("""^There are no selected and enabled filters excluding extra pricing options and overseas property option$""") {
    () =>
      toFilterId.values
        .filter(f => !(overseasPropertyOption ++ extraPricingOptions).contains(f))
        .foreach { checkboxId =>
          val cb = driver
            .findElement(By.id(checkboxId))
          cb.isEnabled && cb.isSelected shouldBe false //Can't be Enabled AND Selected
        }
  }

  Then("""^I click on the search button$""") { () =>
    driver
      .findElement(By.id("searchButton"))
      .click()
  }

  Then("""^I click on the apply filters button$""") { () =>
    driver
      .findElement(By.cssSelector(".apply-filters-button"))
      .click()
  }

}
