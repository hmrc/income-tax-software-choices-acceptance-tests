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

import uk.gov.hmrc.test.ui.pages.AccountingPeriodPage.AccountingPeriod.{FirstToThirtyFirst, SixthToFifth}
import uk.gov.hmrc.test.ui.pages.AdditionalIncomePage.AdditionalIncome
import uk.gov.hmrc.test.ui.pages.BusinessIncomePage.BusinessIncome.{ForeignProperty, SelfEmployment, UKProperty}
import uk.gov.hmrc.test.ui.pages.OtherItemsPage.OtherItems
import uk.gov.hmrc.test.ui.pages.UserTypePage.UserType.{Agent, SoleTraderOrLandlord}
import uk.gov.hmrc.test.ui.pages.*
import uk.gov.hmrc.test.ui.pages.AdditionalIncomePage.AdditionalIncome.UkInterest
import uk.gov.hmrc.test.ui.pages.HowYouFindSoftwarePage.JourneyType.Check
import uk.gov.hmrc.test.ui.pages.OtherItemsPage.OtherItems.StudentLoan

class CheckJourneySpec extends BaseSpec {

  Feature("Check journey") {
    Scenario("User checks fully compatible software") {

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

    Scenario("User checks partially compatible software") {

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
      PartiallyCompatiblePage.onPage()
    }

    Scenario("User checks software that is compatible for quarterly updates only") {

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

    Scenario("User checks not compatible software") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select 'Check' and click continue")
      HowYouFindSoftwarePage.selectJourney(HowYouFindSoftwarePage.JourneyType.Check)

      And("I type in my software name 'vendor 01'  and click continue")
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

      Then("On the software not compatible page I click the 'find compatible software' button")
      NotCompatiblePage.onPage()
      NotCompatiblePage.submitPage()
      SoftwareResultsPage.onPage()
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
      EnterSoftwareNamePage.clickSoftwareNotListed()

      And("I should be directed to the no software listed static page")
      NoSoftwareListedPage.submitPage()

      Then("I select 'As a sole trader or landlord' and click continue")
      UserTypePage.selectUserType(SoleTraderOrLandlord)

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

    Scenario("User can select other software type product and see recognition page") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select the 'Check' option and click continue")
      HowYouFindSoftwarePage.selectJourney(Check)

      And("I can select future product and see recognition page")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("Maybe Vendor")
      EnterSoftwareNamePage.submitPage()
      SoftwareInDevelopmentPage.onPage()

      And("I can select spreadsheet product and see recognition page")
      EnterSoftwareNamePage.goTo()
      EnterSoftwareNamePage.enterAndSelectSoftwareName("WPS Spreadsheets")
      EnterSoftwareNamePage.submitPage()
      NeedAdditionalSoftwarePage.onPage()

      And("I can select my software is not listed and see recognition page")
      EnterSoftwareNamePage.goTo()
      EnterSoftwareNamePage.clickSoftwareNotListed()
      NoSoftwareListedPage.onPage()
    }

    Scenario("User changes user answers") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select the 'Check' option and click continue")
      HowYouFindSoftwarePage.selectJourney(Check)

      And("I select 'Vendor 3' and click continue")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("vendor 03")
      EnterSoftwareNamePage.submitPage()

      And("I select 'As a sole trader or landlord' and click continue")
      UserTypePage.selectUserType(SoleTraderOrLandlord)

      When("I select my business income sources and click continue")
      BusinessIncomePage.selectBusinessIncomes(Seq(SelfEmployment))

      And("I select my additional income sources and click continue")
      AdditionalIncomePage.selectAdditionalIncomes(Seq(AdditionalIncome.NoneOfThese))

      And("I select my other income sources and click continue")
      OtherItemsPage.selectOtherItems(Seq(StudentLoan))

      And("I select my accounting period and click continue")
      AccountingPeriodPage.selectAccountingPeriod(SixthToFifth)
      CheckYourAnswersPage.onPage()

      And("On the CYA page, I can change the product to future product")
      CheckYourAnswersPage.assertSoftwareNameAnswer("vendor 03")
      CheckYourAnswersPage.clickChangeSoftwareName()
      EnterSoftwareNamePage.enterAndSelectSoftwareName("Maybe Vendor")
      EnterSoftwareNamePage.submitPage()
      SoftwareInDevelopmentPage.onPage()
      SoftwareInDevelopmentPage.submitPage()
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertSoftwareNameAnswer("Maybe Vendor")

      And("On the CYA page, I can change the product to a spreadsheet product")
      CheckYourAnswersPage.clickChangeSoftwareName()
      EnterSoftwareNamePage.enterAndSelectSoftwareName("WPS Spreadsheets")
      EnterSoftwareNamePage.submitPage()
      NeedAdditionalSoftwarePage.onPage()
      NeedAdditionalSoftwarePage.submitPage()
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertSoftwareNameAnswer("WPS Spreadsheets")

      And("On the CYA page, I can select my software is not listed")
      CheckYourAnswersPage.clickChangeSoftwareName()
      EnterSoftwareNamePage.clickSoftwareNotListed()
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertSoftwareNameAnswer("Software not listed")

      And("On the CYA page, I can change the selected product answer to 'vendor 05'")
      CheckYourAnswersPage.clickChangeSoftwareName()
      EnterSoftwareNamePage.enterAndSelectSoftwareName("vendor 03")
      EnterSoftwareNamePage.submitPage()
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertSoftwareNameAnswer("vendor 03")

      And("On the CYA page, I can change my user type answer to 'Agent'")
      CheckYourAnswersPage.assertUserTypeAnswer("Sole trader or landlord")
      CheckYourAnswersPage.clickChangeUserType()
      UserTypePage.selectUserType(Agent)
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertUserTypeAnswer("Agent")

      And("On the CYA page, I can change my business incomes answer to 'UK Property'")
      CheckYourAnswersPage.assertBusinessIncomesAnswer("Being self-employed as a sole trader")
      CheckYourAnswersPage.clickChangeBusinessIncomes()
      BusinessIncomePage.deselectBusinessIncomes(Seq(SelfEmployment))
      BusinessIncomePage.selectBusinessIncomes(Seq(UKProperty))
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertBusinessIncomesAnswer("Renting out a UK property")

      And("On the CYA page, I can change my additional incomes answer to 'UK interest'")
      CheckYourAnswersPage.assertAdditionalIncomesAnswer("None selected")
      CheckYourAnswersPage.clickChangeAdditionalIncomes()
      AdditionalIncomePage.selectAdditionalIncomes(Seq(UkInterest))
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertAdditionalIncomesAnswer("UK interest")

      And("On the CYA page, I can change my other items answer to 'None of these'")
      CheckYourAnswersPage.assertOtherItemsAnswer("Student loan")
      CheckYourAnswersPage.clickChangeOtherItems()
      OtherItemsPage.selectOtherItems(Seq(OtherItems.NoneOfThese))
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertOtherItemsAnswer("None selected")

      And("On the CYA page, I can change my accounting period answer to '1 April to 31 March'")
      CheckYourAnswersPage.assertAccountingPeriodAnswer("6 April to 5 April")
      CheckYourAnswersPage.clickChangeAccountingPeriod()
      AccountingPeriodPage.selectAccountingPeriod(FirstToThirtyFirst)
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertAccountingPeriodAnswer("1 April to 31 March")

      And("I select 'confirm and continue'")
      CheckYourAnswersPage.submitPage()

      Then("I am on the fully compatible page")
      FullyCompatiblePage.onPage()
    }
  }
}
