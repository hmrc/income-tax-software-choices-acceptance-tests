/*
 * Copyright 2026 HM Revenue & Customs
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

import uk.gov.hmrc.test.ui.pages.AccountingPeriodPage.AccountingPeriod.SixthToFifth
import uk.gov.hmrc.test.ui.pages.AdditionalIncomePage.AdditionalIncome.UkInterest
import uk.gov.hmrc.test.ui.pages.BusinessIncomePage.BusinessIncome.SelfEmployment
import uk.gov.hmrc.test.ui.pages.OtherItemsPage.OtherItems.PrivatePensionContributions
import uk.gov.hmrc.test.ui.pages.UserTypePage.UserType.SoleTraderOrLandlord
import uk.gov.hmrc.test.ui.pages.{AccountingPeriodPage, AdditionalIncomePage, BusinessIncomePage, CheckYourAnswersPage, ChoosingSoftwarePage, EnterSoftwareNamePage, FeatureSwitchPage, HowYouFindSoftwarePage, IndexPage, NeedAdditionalSoftwarePage, NoSoftwareListedPage, OtherItemsPage, SoftwareResultsPage, UserTypePage}

class CheckJourneySpec extends BaseSpec {

  Feature("Check journey") {
    Scenario("User checks if their software is fully compatible") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      Given("I navigate directly to the do u have software page")
      HowYouFindSoftwarePage.goTo()

      And("I select 'Check' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I should be on the Enter Software Name page")
      EnterSoftwareNamePage.onPage()

      And("I type in my software name and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("vendor 01")
      EnterSoftwareNamePage.submitPage()

      Then("I should be taken to the How will you use it page")
      Thread.sleep(1000)
      UserTypePage.onPage()
    }
    Scenario("User checks if they need additional software") {

      Given("I navigate directly to the do u have software page")
      HowYouFindSoftwarePage.goTo()

      When("I select 'Check if my current software is compatible' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I should be on the Enter Software Name page")
      EnterSoftwareNamePage.onPage()

      And("I type in my software name and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("Google Sheets")
      EnterSoftwareNamePage.submitPage()

      And("I should be taken to the You will need Additional Software ")
      NeedAdditionalSoftwarePage.onPage()
      NeedAdditionalSoftwarePage.submitPage()

      And("I click on Find Compatible Software ")
      UserTypePage.selectUserType(SoleTraderOrLandlord)

      And("I select my business income sources and click continue")
      BusinessIncomePage.selectBusinessIncomes(Seq(SelfEmployment))

      And("I select my additional income sources and click continue")
      AdditionalIncomePage.selectAdditionalIncomes(Seq(UkInterest))

      And("I select my other income sources and click continue")
      OtherItemsPage.selectOtherItems(Seq(PrivatePensionContributions))

      And("I select my accounting period and click continue")
      AccountingPeriodPage.selectAccountingPeriod(SixthToFifth)

      And("On the CYA page I click View your Results")
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.submitPage()

      And("On the choosing software page I click continue")
      ChoosingSoftwarePage.onPage()
      ChoosingSoftwarePage.submitPage()

      And("On the software results page I select Change answers")
      SoftwareResultsPage.onPage(isAgent = false)
      SoftwareResultsPage.clickChangeAnswers()

      And("On the CYA page I click confirm and continue")
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.submitPage()

      And("On the choosing software page I click continue")
      ChoosingSoftwarePage.onPage()
      ChoosingSoftwarePage.submitPage()

      And("On the software results page I select a preference filter")
      SoftwareResultsPage.onPage(isAgent = false)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "05", expected = true)
      SoftwareResultsPage.selectPreferenceFilters(Seq("VAT"))
      SoftwareResultsPage.onPage(isAgent = false)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "05", expected = false)

      Then("On the software results page I clear all preference filters")
      SoftwareResultsPage.clearFilters()
      SoftwareResultsPage.onPage(isAgent = false)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "05", expected = true)
    }

    Scenario("User checks if their software is not listed") {

      Given("I navigate directly to the do u have software page")
      HowYouFindSoftwarePage.goTo()

      When("I select the 'Check' option and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I should be on the Enter Software Name page")
      EnterSoftwareNamePage.onPage()

      And("I type in an unlisted software name and submit")
      EnterSoftwareNamePage.writeAndCheckIfNotListed("Vendor11")

      Then("I should be directed to the no software listed static page")
      NoSoftwareListedPage.onPage()
    }
/* TO DO: Once the software in development page is ready, update this test case.
    Scenario("User checks if their software is in development") {

      Given("I navigate directly to the do u have software page")
      HowYouFindSoftwarePage.goTo()

      When("I select the 'Check' option and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I should be on the Enter Software Name page")
      EnterSoftwareNamePage.onPage()

      And("I type in an software name and submit")
      EnterSoftwareNamePage.writeAndCheckIfNotListed("Vendor11")

      Then("I should be directed to the software in development static page")
      SoftwareInDevelopmentPage.onPage()
    }*/

  }
}
