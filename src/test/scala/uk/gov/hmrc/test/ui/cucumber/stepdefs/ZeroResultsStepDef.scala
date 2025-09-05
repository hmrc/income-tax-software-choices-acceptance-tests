/*
 * Copyright 2025 HM Revenue & Customs
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
import uk.gov.hmrc.test.ui.pages.ZeroResultsPage._

class ZeroResultsStepDef extends BaseStepDef {

  And("""^I click Back$""") { () =>
    driver
      .findElement(By.linkText("Back"))
      .click()
  }

  And("""^I am on the zero results page and I click finish$""") { () =>
    assertUrl(zeroResultsPageUrl)
    submitPage()
  }

  And("""^I am on the zero results page and I click browse software currently available$""") { () =>
    assertUrl(zeroResultsPageUrl)
    driver
      .findElement(By.linkText("browse software that’s currently available"))
      .click()
  }
}
