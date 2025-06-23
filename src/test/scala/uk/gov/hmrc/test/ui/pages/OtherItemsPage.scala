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

object OtherItemsPage extends BasePage {

  val otherItemsPageUrl: String = TestConfiguration.url("software-choices-frontend") + "/other-items"

  val fromOtherItemToId: Map[String, String] = Map(
    "Private pension contributions"        -> "otherItems",
    "Charitable giving"                    -> "otherItems-2",
    "Capital Gains Tax"                    -> "otherItems-3",
    "Student Loan"                         -> "otherItems-4",
    "Marriage Allowance"                   -> "otherItems-5",
    "Voluntary Class 2 National Insurance" -> "otherItems-6",
    "High Income Child Benefit Charge"     -> "otherItems-7",
    "None of these"                        -> "otherItems-9"
  )

}
