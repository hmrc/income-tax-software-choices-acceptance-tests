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

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions.*
import uk.gov.hmrc.selenium.webdriver.Driver
import scala.jdk.CollectionConverters.*

object CheckYourAnswersPage extends BasePage {

  val url: String = getPageURL("/check-answers")

  def clickChangeUserType(): Unit =
    clickLink("/find-making-tax-digital-income-tax-software/how-will-you-use-it?editMode=true")

  def clickChangeBusinessIncomes(): Unit =
    clickLink("/find-making-tax-digital-income-tax-software/which-income-source-quarterly-updates?editMode=true")

  def clickChangeAdditionalIncomes(): Unit =
    clickLink("/find-making-tax-digital-income-tax-software/which-other-income-source-tax-return?editMode=true")

  def clickChangeOtherItems(): Unit =
    clickLink("/find-making-tax-digital-income-tax-software/which-other-items-tax-return?editMode=true")

  def clickChangeAccountingPeriod(): Unit =
    clickLink("/find-making-tax-digital-income-tax-software/accounting-period-check?editMode=true")

  def assertUserTypeAnswer(expectedValue: String): Unit =
    assertUserAnswer("User type", expectedValue)

  def assertBusinessIncomesAnswer(expectedValue: String): Unit =
    assertUserAnswer("Income sources (quarterly updates and tax return)", expectedValue)

  def assertAdditionalIncomesAnswer(expectedValue: String): Unit =
    assertUserAnswer("Other incomes (tax return only)", expectedValue)

  def assertOtherItemsAnswer(expectedValue: String): Unit =
    assertUserAnswer("Other items (tax return only)", expectedValue)

  def assertAccountingPeriodAnswer(expectedValue: String): Unit =
    assertUserAnswer("Accounting period", expectedValue)

  private def clickLink(href: String): Unit =
    fluentWait.until(elementToBeClickable(By.cssSelector(s"a[href='$href']"))).click()

  private def assertUserAnswer(key: String, expectedValue: String): Unit = {
    val listRow = Driver.instance
      .findElements(By.cssSelector(".govuk-summary-list__row"))
      .asScala
      .find(elem => elem.findElement(By.cssSelector(".govuk-summary-list__key")).getText == key)

    fluentWait.until(
      textToBePresentInElement(listRow.get.findElement(By.cssSelector(".govuk-summary-list__value")), expectedValue)
    )
  }

}
