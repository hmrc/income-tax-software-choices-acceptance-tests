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

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages.UserTypePage.UserType
import uk.gov.hmrc.test.ui.pages.{FeatureSwitchPage, IndexPage, ProductDetailsPage, SoftwareResultsPage, UserTypePage}

class AgentSpec extends BaseSpec {

  Feature("Agent journey") {

    Scenario("Agent uses the software choices tool and views details for vendor 1") {

      Given("I disable all feature switches")
      FeatureSwitchPage.disableAllFeatureSwitches()

      Given("I navigate to the index route")
      IndexPage.goTo()

      When("I select 'As an agent' and click continue")
      UserTypePage.selectUserType(UserType.Agent)

      And("On the software results page I select a preference filter")
      SoftwareResultsPage.onPage(isAgent = true)
      SoftwareResultsPage.checkVendorDisplayed(1, true)
      SoftwareResultsPage.selectPreferenceFilters(Seq("Free version"))
      SoftwareResultsPage.onPage(isAgent = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = 1, expected = false)

      And("On the software results page I clear all preference filters")
      SoftwareResultsPage.clearFilters()
      SoftwareResultsPage.onPage(isAgent = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = 1, expected = true)

      And("On the software results page I select the first vendor")
      SoftwareResultsPage.selectVendorLink(1)

      Then("I am on the product details page for vendor 1")
      ProductDetailsPage.onVendorPage("vendor 01")
    }
  }
}
