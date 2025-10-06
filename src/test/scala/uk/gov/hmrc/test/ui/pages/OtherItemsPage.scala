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

package uk.gov.hmrc.test.ui.pages

object OtherItemsPage extends BasePage {

  val url: String = getPageURL("/what-else-do-you-need-to-tell-us")

  enum OtherItems(val id: String):
    case PrivatePensionContributions extends OtherItems("otherItems")
    case CharitableGiving extends OtherItems("otherItems-2")
    case CapitalGainsTax extends OtherItems("otherItems-3")
    case StudentLoan extends OtherItems("otherItems-4")
    case MarriageAllowance extends OtherItems("otherItems-5")
    case VoluntaryClass2NationalInsurance extends OtherItems("otherItems-6")
    case HighIncomeChildBenefitCharge extends OtherItems("otherItems-7")
    case NoneOfThese extends OtherItems("otherItems-9")

  def selectOtherItems(otherItems: Seq[OtherItems]): Unit = {
    assertUrl(url)
    otherItems.map(_.id).foreach(clickById)
    submitPage()
  }
}
