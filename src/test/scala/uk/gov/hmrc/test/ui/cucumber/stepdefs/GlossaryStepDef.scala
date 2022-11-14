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
import uk.gov.hmrc.test.ui.pages.GlossaryPage
import uk.gov.hmrc.test.ui.pages.GlossaryPage._

import scala.jdk.CollectionConverters._

class GlossaryStepDef extends BaseStepDef {

  Given("^I navigate to the Glossary page$") { () =>
    GlossaryPage.loadPage
    assertUrl(url)
  }

  When("""^On the glossary page, I enter '(.*)' into the search bar$""") { (searchTerm: String) =>
    write(searchBarId, searchTerm)
  }

  And("""^On the glossary page, I wait for the list to update$""") { () =>
    fluentWait.until(
      ExpectedConditions.presenceOfElementLocated(By.cssSelector(".loading"))
    )
    fluentWait.until(
      ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading"))
    )
  }

  Then("""^On the glossary page, I am presented with only rows which match '(.*)'$""") { (searchTerm: String) =>
    driver
      .findElements(By.cssSelector("govuk-summary-list__row:not(:first-child)"))
      .asScala
      .foreach { row =>
        row.findElement(By.cssSelector("dt")).getText + row.findElement(By.cssSelector("dd")).getText should include(
          searchTerm
        )
      }
  }

}
