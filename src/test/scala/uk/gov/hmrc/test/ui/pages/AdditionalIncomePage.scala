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

import uk.gov.hmrc.test.ui.conf.TestConfiguration

object AdditionalIncomePage extends BasePage {

  val additionalIncomePageUrl: String = TestConfiguration.url("software-choices-frontend") + "/additional-income"

  val fromAdditionalIncomeToId: Map[String, String] = Map(
    "UK interest"                  -> "additionalIncome",
    "Construction Industry Scheme" -> "additionalIncome-2",
    "Employment (PAYE)"            -> "additionalIncome-3",
    "UK dividends"                 -> "additionalIncome-4",
    "State pension income"         -> "additionalIncome-5",
    "Private pension incomes"      -> "additionalIncome-6",
    "Foreign dividends"            -> "additionalIncome-7",
    "Foreign interest"             -> "additionalIncome-8",
    "None of these"                -> "additionalIncome-10"
  )

}
