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
import uk.gov.hmrc.test.ui.pages.OtherItemsPage.OtherItems
import uk.gov.hmrc.test.ui.pages.OtherItemsPage.OtherItems.*
import uk.gov.hmrc.test.ui.pages.BusinessIncomePage.BusinessIncome.*
import uk.gov.hmrc.test.ui.pages.UserTypePage.UserType.SoleTraderOrLandlord

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

      And("On the software results page I select the first vendor")
      SoftwareResultsPage.onPage()
      SoftwareResultsPage.selectVendorLink(1)

      Then("I am on the product details page for vendor 5")
      ProductDetailsPage.onVendorPage("vendor 05")
    }

    Scenario("User has an unsupported accounting period") {

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

      Then("I am on the unsupported accounting period page")
      UnsupportedAccountingPeriodPage.onPage()
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
  }
}
