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

  val url: String = getPageURL("/accounting-period-check")

  enum AccountingPeriod(val id: String):
    case SixthToFifth extends AccountingPeriod("accounting-period")
    case FirstToThirtyFirst extends AccountingPeriod("accounting-period-2")
    case NeitherOfThese extends AccountingPeriod("accounting-period-4")

  def selectAccountingPeriod(accountingPeriod: AccountingPeriod): Unit = {
    assertUrl(AccountingPeriodPage.url)
    clickById(accountingPeriod.id)
    submitPage()
  }

}
