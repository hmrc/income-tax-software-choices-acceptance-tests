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
import uk.gov.hmrc.test.ui.pages.AccountingPeriodPage.AccountingPeriod.*
import uk.gov.hmrc.test.ui.pages.AdditionalIncomePage.AdditionalIncome
import uk.gov.hmrc.test.ui.pages.AdditionalIncomePage.AdditionalIncome.*
import uk.gov.hmrc.test.ui.pages.BusinessIncomePage.BusinessIncome.*
import uk.gov.hmrc.test.ui.pages.HowYouFindSoftwarePage.JourneyType.{Check, Find}
import uk.gov.hmrc.test.ui.pages.OtherItemsPage.OtherItems
import uk.gov.hmrc.test.ui.pages.OtherItemsPage.OtherItems.*
import uk.gov.hmrc.test.ui.pages.UserTypePage.UserType.{Agent, SoleTraderOrLandlord}

class SoleTraderOrLandlordSpec extends BaseSpec {

  Feature("Sole Trader or Landlord journey") {

    Scenario("User answers pre-search questions and finds out more information about a software vendor") {

      Given("I disable all feature switches")
      FeatureSwitchPage.disableAllFeatureSwitches()

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select 'As a sole trader or landlord' and click continue")
      UserTypePage.selectUserType(SoleTraderOrLandlord)

      When("I select my business income sources and click continue")
      BusinessIncomePage.selectBusinessIncomes(Seq(SelfEmployment))

      And("I select my additional income sources and click continue")
      AdditionalIncomePage.selectAdditionalIncomes(Seq(UkInterest))

      And("I select my other income sources and click continue")
      OtherItemsPage.selectOtherItems(Seq(PrivatePensionContributions))

      And("I select my accounting period and click continue")
      AccountingPeriodPage.selectAccountingPeriod(SixthToFifth)

      And("On the CYA page I click continue")
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.submitPage()

      And("On the choosing software page I click continue")
      ChoosingSoftwarePage.onPage()
      ChoosingSoftwarePage.submitPage()

      And("On the software results page I select Change answers")
      SoftwareResultsPage.onPage(isUnguided = false)
      SoftwareResultsPage.clickChangeAnswers()

      And("On the CYA page I click continue")
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.submitPage()

      And("On the choosing software page I click continue")
      ChoosingSoftwarePage.onPage()
      ChoosingSoftwarePage.submitPage()

      And("On the software results page I select a preference filter")
      SoftwareResultsPage.onPage(isUnguided = false)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "05", expected = true)
      SoftwareResultsPage.selectPreferenceFilters(Seq("VAT"))
      SoftwareResultsPage.onPage(isUnguided = false)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "05", expected = false)

      And("On the software results page I clear all preference filters")
      SoftwareResultsPage.clearFilters()
      SoftwareResultsPage.onPage(isUnguided = false)
      SoftwareResultsPage.checkVendorDisplayed(vendor = "05", expected = true)

      And("On the software results page I select the first vendor")
      SoftwareResultsPage.selectVendorLink(1)

      Then("I am on the product details page for vendor 5")
      ProductDetailsPage.onPage()
    }

    Scenario("User has a non aligned accounting period") {

      Given("I disable all feature switches")
      FeatureSwitchPage.disableAllFeatureSwitches()

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select 'As a sole trader or landlord' and click continue")
      UserTypePage.selectUserType(SoleTraderOrLandlord)

      When("I select my business income sources and click continue")
      BusinessIncomePage.selectBusinessIncomes(Seq(SelfEmployment))

      And("I select my additional income sources and click continue")
      AdditionalIncomePage.selectAdditionalIncomes(Seq(AdditionalIncome.NoneOfThese))

      And("I select my other income sources and click continue")
      OtherItemsPage.selectOtherItems(Seq(OtherItems.NoneOfThese))

      And("I select my accounting period and click continue")
      AccountingPeriodPage.selectAccountingPeriod(NeitherOfThese)

      And("On the accounting period not aligned page I click continue")
      AccountingPeriodNotAlignedPage.onPage()
      AccountingPeriodNotAlignedPage.submitPage()

      And("On the CYA page I click continue")
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.submitPage()

      And("On the choosing software page I click continue")
      ChoosingSoftwarePage.onPage()
      ChoosingSoftwarePage.submitPage()

      Then("I am the software results page")
      SoftwareResultsPage.onPage(isUnguided = false)
    }

    Scenario("User selects options which results in no all-in-one software and they click Finish") {

      Given("I disable all feature switches")
      FeatureSwitchPage.disableAllFeatureSwitches()

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select 'As a sole trader or landlord' and click continue")
      UserTypePage.selectUserType(SoleTraderOrLandlord)

      When("I select my business income sources and click continue")
      BusinessIncomePage.selectBusinessIncomes(Seq(SelfEmployment, UKProperty, ForeignProperty))

      And("I select my additional income sources and click continue")
      AdditionalIncomePage.selectAdditionalIncomes(Seq(UkInterest, ForeignInterest))

      And("I select my other income sources and click continue")
      OtherItemsPage.selectOtherItems(Seq(PrivatePensionContributions))

      And("I select my accounting period and click continue")
      AccountingPeriodPage.selectAccountingPeriod(FirstToThirtyFirst)

      And("On the CYA page I click continue")
      CheckYourAnswersPage.submitPage()

      And("I am on the zero results page and click finish")
      ZeroResultsPage.finish()

      Then("I am on the session expired page")
      SessionExpiredPage.onPage()
    }

    Scenario("User selects Find journey when Check Journey feature switch enabled") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select the 'Find' option and click continue")
      HowYouFindSoftwarePage.selectJourney(Find)

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
      SoftwareResultsPage.onPage(isUnguided = false)
    }

    Scenario("User changes user answers in Find Journey") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select the 'Find' option and click continue")
      HowYouFindSoftwarePage.selectJourney(Find)

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

      And("On the CYA page, I can change my user type answer to 'Agent'")
      CheckYourAnswersPage.assertUserTypeAnswer("Sole trader or landlord")
      CheckYourAnswersPage.clickChangeUserType()
      UserTypePage.selectUserType(Agent)
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertUserTypeAnswer("Agent")

      And("On the CYA page, I can change my business incomes answer to 'UK Property'")
      CheckYourAnswersPage.assertBusinessIncomesAnswer("Being self-employed as a sole trader")
      CheckYourAnswersPage.clickChangeBusinessIncomes()
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

      And("On the choosing software page I click continue")
      ChoosingSoftwarePage.onPage()
      ChoosingSoftwarePage.submitPage()

      Then("I am on the software results page")
      SoftwareResultsPage.onPage(isUnguided = false)
    }

    Scenario("User changes user answers in Check Journey") {

      Given("I enable the Check Journey feature switch")
      FeatureSwitchPage.setFeatureSwitches(Seq("CheckJourney"))

      Given("I navigate to the index route")
      IndexPage.goTo()

      And("I select the 'Check' option and click continue")
      HowYouFindSoftwarePage.selectJourney(Check)

      And("I can select future product and return")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("Maybe Vendor")
      EnterSoftwareNamePage.submitPage()
      SoftwareInDevelopmentPage.onPage()
      SoftwareInDevelopmentPage.goBack()
      EnterSoftwareNamePage.onPage()

      And("I can select spreadsheet product and return")
      EnterSoftwareNamePage.enterAndSelectSoftwareName("WPS Spreadsheets")
      EnterSoftwareNamePage.submitPage()
      NeedAdditionalSoftwarePage.onPage()
      NeedAdditionalSoftwarePage.goBack()
      EnterSoftwareNamePage.onPage()

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

      And("On the CYA page, I can change my product to other softwareType and return")
      CheckYourAnswersPage.assertSoftwareNameAnswer("vendor 03")
      CheckYourAnswersPage.clickChangeSoftwareName()
      EnterSoftwareNamePage.enterAndSelectSoftwareName("Maybe Vendor")
      EnterSoftwareNamePage.submitPage()
      SoftwareInDevelopmentPage.onPage()
      SoftwareInDevelopmentPage.goBack()
      EnterSoftwareNamePage.enterAndSelectSoftwareName("WPS Spreadsheets")
      EnterSoftwareNamePage.submitPage()
      NeedAdditionalSoftwarePage.onPage()
      NeedAdditionalSoftwarePage.goBack()
      EnterSoftwareNamePage.enterAndSelectSoftwareName("vendor 03")
      EnterSoftwareNamePage.submitPage()
      CheckYourAnswersPage.onPage()

      And("On the CYA page, I can change my selected product answer to 'vendor 05'")
      CheckYourAnswersPage.assertSoftwareNameAnswer("vendor 03")
      CheckYourAnswersPage.clickChangeSoftwareName()
      EnterSoftwareNamePage.enterAndSelectSoftwareName("vendor 05")
      EnterSoftwareNamePage.submitPage()
      CheckYourAnswersPage.onPage()
      CheckYourAnswersPage.assertSoftwareNameAnswer("vendor 05")

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
