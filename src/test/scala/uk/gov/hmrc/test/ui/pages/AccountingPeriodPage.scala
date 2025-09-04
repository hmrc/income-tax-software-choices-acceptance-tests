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

object AccountingPeriodPage extends BasePage {

  val accountingPeriodPageUrl: String =
    getPageURL("/accounting-period-check")

  val fromAccountingPeriodToId: Map[String, String] = Map(
    "6 April to 5 April"  -> "accounting-period",
    "1 April to 31 March" -> "accounting-period-2",
    "Neither of these"    -> "accounting-period-4"
  )

}
