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
import uk.gov.hmrc.test.ui.pages.*

class CheckJourneySpec extends BaseSpec {

  Feature("Check journey") {
    Scenario("User checks if their software is fully compatible") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select 'Check' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I type in my software name 'vendor 05'  and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("vendor 05")
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

      Then("I am on the fully compatible page")
      FullyCompatiblePage.onPage()
    }

    Scenario("User checks if their software is partly compatible") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select 'Check' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I type in my software name 'vendor 04'  and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("vendor 04")
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

      Then("I am on the partly compatible page")
      PartlyCompatiblePage.onPage()
    }

    Scenario("User checks if their software is compatible for quarterly updates only") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select 'Check' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I type in my software name 'vendor 02'  and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("vendor 02")
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
      //CheckYourAnswersPage.submitPage()

      /* To Do - Update this to redirect to the correct page once the quarterly updates only page is implemented. */
      //Then("I am on the compatible for quarterly updates page")

    }

    Scenario("User checks if they need additional software") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      When("I select 'Check if my current software is compatible' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I type in my software name as 'Google Sheets' and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("Google Sheets")
      EnterSoftwareNamePage.submitPage()

      And("I should be taken to the You will need Additional Software ")
      NeedAdditionalSoftwarePage.submitPage()

      Then("I select 'As a sole trader or landlord' and click continue")
      UserTypePage.selectUserType(SoleTraderOrLandlord)
    }

    Scenario("User checks if their software is not listed") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      When("I select 'Check if my current software is compatible' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I type in an unlisted software name 'Vendor11' and click on My software is not listed")
      EnterSoftwareNamePage.write("enter-software-name", "Vendor11")
      NoSoftwareListedPage.clickSoftwareNotListed()

      Then("I should be directed to the no software listed static page")
      NoSoftwareListedPage.onPage()
    }
    Scenario("User checks if their software is in development") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      When("I select 'Check if my current software is compatible' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I type in my software name as 'Maybe Vendor' and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("Maybe Vendor")
      EnterSoftwareNamePage.submitPage()

      And("I should be directed to the software in development static page")
      SoftwareInDevelopmentPage.submitPage()

      Then("I select 'As a sole trader or landlord' and click continue")
      UserTypePage.selectUserType(SoleTraderOrLandlord)
    }

  }
}
