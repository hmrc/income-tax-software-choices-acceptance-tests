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
import uk.gov.hmrc.test.ui.pages.SoftwareResultsPage
import uk.gov.hmrc.test.ui.pages.SoftwareResultsPage._

class SoftwareResultsStepDef extends BaseStepDef {

  Then("^I am on the combined software results page$") { () =>
    assertUrl(SoftwareResultsPage.zeroResultsUrl)
  }

  And("""^On the search software page, I click on the vendor link: (\d)$""") { (index: Int) =>
    driver
      .findElement(By.id(s"software-vendor-${index - 1}"))
      .findElement(By.tagName("a"))
      .click()
  }

}
