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

import uk.gov.hmrc.test.ui.pages.*
import uk.gov.hmrc.test.ui.pages.HowYouFindSoftwarePage.JourneyType.ViewAll
import uk.gov.hmrc.test.ui.pages.UserTypePage.UserType

class UnguidedJourneySpec extends BaseSpec {

  Feature("Unguided journey") {

    Scenario("An Agent selects View All journey when Check feature switch is enabled") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      When("I navigate to the index route")
      IndexPage.goTo()

      And("I select the 'Show a list of all' option and click continue")
      HowYouFindSoftwarePage.selectJourney(ViewAll)

      And("I select 'As an agent' and click continue")
      UserTypePage.selectUserType(UserType.Agent)

      And("On the software results page I select a preference filter")
      SoftwareResultsPage.onPage(isAgent = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "01", expected = true)
      SoftwareResultsPage.selectPreferenceFilters(Seq("Free version"))
      SoftwareResultsPage.onPage(isAgent = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "01", expected = false)

    }

    Scenario("An Individual selects View All journey when Check feature switch is enabled") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      When("I navigate to the index route")
      IndexPage.goTo()

      And("I select the 'Show a list of all' option and click continue")
      HowYouFindSoftwarePage.selectJourney(ViewAll)

      And("I select 'As an individual' and click continue")
      UserTypePage.selectUserType(UserType.SoleTraderOrLandlord)

      And("On the software results page I clear all preference filters")
      SoftwareResultsPage.clearFilters()
      SoftwareResultsPage.onPage(isAgent = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "01", expected = true)
    }
  }
}
