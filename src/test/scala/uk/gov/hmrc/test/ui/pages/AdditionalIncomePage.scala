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

object AdditionalIncomePage extends BasePage {

  val url: String = getPageURL("/which-additional-income-source")

  enum AdditionalIncome(val id: String):
    case UkInterest extends AdditionalIncome("additionalIncome")
    case ConstructionIndustryScheme extends AdditionalIncome("additionalIncome-2")
    case EmploymentPAYE extends AdditionalIncome("additionalIncome-3")
    case UkDividends extends AdditionalIncome("additionalIncome-4")
    case StatePensionIncome extends AdditionalIncome("additionalIncome-5")
    case PrivatePensionIncomes extends AdditionalIncome("additionalIncome-6")
    case ForeignDividends extends AdditionalIncome("additionalIncome-7")
    case ForeignInterest extends AdditionalIncome("additionalIncome-8")
    case NoneOfThese extends AdditionalIncome("additionalIncome-10")

  def selectAdditionalIncomes(additionalIncome: Seq[AdditionalIncome]): Unit = {
    assertUrl(url)
    additionalIncome.map(_.id).foreach(clickById)
    submitPage()
  }

}
