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
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import java.time.Duration

trait BasePage extends BrowserDriver with Matchers {

  val continueButton = "continue-button"

  def fluentWait: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(2))
    .pollingEvery(Duration.ofMillis(250))
    .ignoring(classOf[NoSuchElementException])

  def write(id: String, text: String): Unit = driver
    .findElement(By.id(id))
    .sendKeys(text)

  def assertUrl(url: String): Unit =
    fluentWait.until(ExpectedConditions.urlContains(url))

  def loadPage(url: String): this.type = {
    driver.navigate().to(url)
    assertUrl(url)
    this
  }

  def submitPage(): Unit = {
    val currentURL = driver.getCurrentUrl
    driver.findElement(By.cssSelector("""form > button""")).click()
    fluentWait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentURL)))
  }

}
