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
import uk.gov.hmrc.test.ui.pages.*
import uk.gov.hmrc.test.ui.pages.HowYouFindSoftwarePage.JourneyType.Find
class AgentSpec extends BaseSpec {

  Feature("Agent journey") {

    Scenario("Agent uses the software choices tool and views details for vendor 1") {

      Given("I disable all feature switches")
      FeatureSwitchPage.disableAllFeatureSwitches()

      When("I navigate to the index route")
      IndexPage.goTo()

      Given("I navigate directly to the do u have software page")
      HowYouFindSoftwarePage.goTo()

      And("I select the 'Find' option and click continue")
      HowYouFindSoftwarePage.selectJourney(Find)

      When("I select 'As an agent' and click continue")
      UserTypePage.selectUserType(UserType.Agent)

      And("On the software results page I select a preference filter")
      SoftwareResultsPage.onPage(isAgent = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "01", expected = true)
      SoftwareResultsPage.selectPreferenceFilters(Seq("Free version"))
      SoftwareResultsPage.onPage(isAgent = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "01", expected = false)

      And("On the software results page I clear all preference filters")
      SoftwareResultsPage.clearFilters()
      SoftwareResultsPage.onPage(isAgent = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "01", expected = true)

      And("On the software results page I select the first vendor")
      SoftwareResultsPage.selectVendorLink(1)

      Then("I am on the product details page for vendor 1")
      ProductDetailsPage.onPage()
    }

    Scenario("Agent user selects Find journey when Check feature switch is enabled") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I navigate directly to the do you have software page")
      HowYouFindSoftwarePage.goTo()

      And("I select the 'Find' option and click continue")
      HowYouFindSoftwarePage.selectJourney(Find)

      When("I select 'As an agent' and click continue")
      UserTypePage.selectUserType(UserType.Agent)

      Then("I am on the software results page")
      SoftwareResultsPage.onPage(isAgent = true)
    }
  }
}
