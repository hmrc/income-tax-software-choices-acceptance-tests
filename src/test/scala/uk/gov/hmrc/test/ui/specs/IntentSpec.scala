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
import uk.gov.hmrc.test.ui.specs.tags.Intent

class IntentSpec extends BaseSpec {

  Feature("Intent Journey") {

    Scenario("User answers pre-search questions and finds out more information about software vendor 1", Intent) {

      Given("I set required feature switches")
      FeatureSwitchPage.setFeatureSwitches(Seq("Intent"))

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

      Then("I should be on the software results page")
      SoftwareResultsPage.onPage()
    }

  }
}
