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
import uk.gov.hmrc.test.ui.pages.AdditionalIncomePage.AdditionalIncome
import uk.gov.hmrc.test.ui.pages.BusinessIncomePage.BusinessIncome.{ForeignProperty, SelfEmployment, UKProperty}
import uk.gov.hmrc.test.ui.pages.OtherItemsPage.OtherItems
import uk.gov.hmrc.test.ui.pages.UserTypePage.UserType.SoleTraderOrLandlord
import uk.gov.hmrc.test.ui.pages.{AccountingPeriodPage, AdditionalIncomePage, BusinessIncomePage, CheckYourAnswersPage, ChoosingSoftwarePage, EnterSoftwareNamePage, FeatureSwitchPage, HowYouFindSoftwarePage, IndexPage, NeedAdditionalSoftwarePage, NoSoftwareListedPage, OtherItemsPage, SoftwareResultsPage, UserTypePage}

class CheckJourneySpec extends BaseSpec {

  Feature("Check journey") {
    Scenario("User checks if their software is fully compatible") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select 'Check' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I should be on the Enter Software Name page")
      EnterSoftwareNamePage.onPage()

      And("I type in my software name and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("vendor 01")
      EnterSoftwareNamePage.submitPage()

      And("I select 'As a sole trader or landlord' and click continue")
      UserTypePage.selectUserType(SoleTraderOrLandlord)

      When("I select my business income sources and click continue")
      BusinessIncomePage.selectBusinessIncomes(Seq(SelfEmployment, UKProperty, ForeignProperty))

      And("I select my additional income sources and click continue")
      AdditionalIncomePage.selectAdditionalIncomes(Seq(AdditionalIncome.NoneOfThese))

      And("I select my other income sources and click continue")
      OtherItemsPage.selectOtherItems(Seq(OtherItems.NoneOfThese))

      And("I select my accounting period and click continue")
      AccountingPeriodPage.selectAccountingPeriod(SixthToFifth)

      And("On the CYA page I click continue")
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.submitPage()

      And("On the choosing software page I click continue")
      ChoosingSoftwarePage.onPage()
      ChoosingSoftwarePage.submitPage()

      Then("I am on the software results page")
      SoftwareResultsPage.onPage(isAgent = false)

    }
    Scenario("User checks if they need additional software") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      When("I select 'Check if my current software is compatible' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I should be on the Enter Software Name page")
      EnterSoftwareNamePage.onPage()

      And("I type in my software name and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("Google Sheets")
      EnterSoftwareNamePage.submitPage()

      And("I should be taken to the You will need Additional Software ")
      NeedAdditionalSoftwarePage.onPage()
    }

    Scenario("User checks if their software is not listed") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      When("I select 'Check if my current software is compatible' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I should be on the Enter Software Name page")
      EnterSoftwareNamePage.onPage()

      And("I type in an unlisted software name and click on My software is not listed")
      EnterSoftwareNamePage.write("enter-software-name", "Vendor11")
      NoSoftwareListedPage.clickSoftwareNotListed()

      Then("I should be directed to the no software listed static page")
      NoSoftwareListedPage.onPage()
    }
    /* TO DO: Once the software in development page is ready, update this test case.
    Scenario("User checks if their software is in development") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      When("I select the 'Check' option and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I should be on the Enter Software Name page")
      EnterSoftwareNamePage.onPage()

      And("I type in my software name and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("Vendor11")
      EnterSoftwareNamePage.submitPage()

      Then("I should be directed to the software in development static page")
      SoftwareInDevelopmentPage.onPage()
    }*/

  }
}
