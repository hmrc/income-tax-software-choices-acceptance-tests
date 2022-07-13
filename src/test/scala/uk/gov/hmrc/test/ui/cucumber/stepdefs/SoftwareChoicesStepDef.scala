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
    fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id(softwareVendorsId)))
  }

  Then("""^I am presented with a list of vendors matching '(.*)'$""") { (matchingTerm: String) =>
    driver
      .findElements(By.cssSelector(".govuk-grid-column-two-thirds > div > h3"))
      .asScala
      .foreach(_.getText should include(matchingTerm))
  }

}
