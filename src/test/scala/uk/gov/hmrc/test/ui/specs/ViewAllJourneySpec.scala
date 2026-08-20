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

class ViewAllJourneySpec extends BaseSpec {

  Feature("View All journey") {

    Scenario("An Agent selects View All journey and interacts with the filters") {

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select the 'Show a list of all' option and click continue")
      HowYouFindSoftwarePage.selectJourney(ViewAll)

      And("I select 'As an agent' and click continue")
      UserTypePage.selectUserType(UserType.Agent)

      And("On the software results page I select the free version preference filter")
      SoftwareResultsPage.onPage(isUnguided = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "04", expected = true)
      SoftwareResultsPage.selectPreferenceFilters(Seq("Free version"))
      SoftwareResultsPage.onPage(isUnguided = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "04", expected = false)

      And("On the software results page I deselect the free version preference filter")
      SoftwareResultsPage.deselectPreferenceFilters(Seq("Free version"))
      SoftwareResultsPage.onPage(isUnguided = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "04", expected = true)

      And("On the software results page I select four additional preference filters")
      SoftwareResultsPage.selectPreferenceFilters(
        Seq(
          "Web browser",
          "Android",
          "Cognitive impairments",
          "All-in-one software"
        )
      )
      SoftwareResultsPage.onPage(isUnguided = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "04", expected = false)

      And("On the software results page I remove two of the additional preference filters")
      SoftwareResultsPage.deselectPreferenceFilters(
        Seq(
          "Android",
          "All-in-one software"
        )
      )
      SoftwareResultsPage.onPage(isUnguided = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "04", expected = true)

      And("On the software results page I select both accounting period preference filters")
      SoftwareResultsPage.selectPreferenceFilters(
        Seq(
          "6 April to 5 April",
          "1 April to 31 March"
        )
      )
      SoftwareResultsPage.onPage(isUnguided = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "04", expected = false)

      And("On the software results page I deselect the calendar update period preference filter")
      SoftwareResultsPage.deselectPreferenceFilters(Seq("1 April to 31 March"))
      SoftwareResultsPage.onPage(isUnguided = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "04", expected = true)
    }

    Scenario("An Individual selects View All journey") {

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select the 'Show a list of all' option and click continue")
      HowYouFindSoftwarePage.selectJourney(ViewAll)

      And("I select 'As an individual' and click continue")
      UserTypePage.selectUserType(UserType.SoleTraderOrLandlord)

      And("On the software results page I clear all preference filters")
      SoftwareResultsPage.clearFilters()
      SoftwareResultsPage.onPage(isUnguided = true)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "01", expected = true)
    }
  }
}
