/*
 * Copyright 2024 HM Revenue & Customs
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

import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.{By, NoSuchElementException, WebDriver}
import org.scalatest.compatible.Assertion
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.test.ui.conf.TestConfiguration

import java.time.Duration

trait BasePage extends Matchers with PageObject {

  val url: String

  def onPage(): Unit            = assertUrl(url)
  def onPage(url: String): Unit = assertUrl(url)

  def goTo(): Unit = {
    get(url)
    assertUrl(url)
  }

  def clickById(id: String): Unit =
    click(By.id(id))

  def fluentWait: FluentWait[WebDriver] = new FluentWait[WebDriver](Driver.instance)
    .withTimeout(Duration.ofSeconds(2))
    .pollingEvery(Duration.ofMillis(250))
    .ignoring(classOf[NoSuchElementException])

  def write(id: String, text: String): Unit =
    sendKeys(By.id(id), text)

  def assertUrl(url: String): Unit =
    fluentWait.until(ExpectedConditions.urlContains(url))

  def submitPage(): Unit = {
    val currentURL = getCurrentUrl
    Driver.instance.findElement(By.cssSelector("""form > button""")).click()
    fluentWait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentURL)))
  }

  def getPageURL(url: String): String =
    TestConfiguration.url("software-choices-frontend") + url

  def waitForElement(locator: By): Unit = fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator))

  def assertPresenceOfElement(selector: By, expectedResult: Boolean): Assertion = {
    waitForElement(By.cssSelector("footer"))
    val elementDisplayed = Driver.instance.findElements(selector).size() > 0
    assert(
      elementDisplayed == expectedResult,
      s"Presence of element $selector does not match expected result of $expectedResult"
    )
  }

}
