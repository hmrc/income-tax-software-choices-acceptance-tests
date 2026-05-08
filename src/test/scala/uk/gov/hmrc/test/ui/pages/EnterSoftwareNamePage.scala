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

import uk.gov.hmrc.selenium.webdriver.Driver
import org.openqa.selenium.{By, Keys}
import org.openqa.selenium.support.ui.ExpectedConditions

object EnterSoftwareNamePage extends BasePage {

  val url: String = getPageURL("/enter-software-name")

  def enterAndSelectSoftwareName(name: String): Unit = {
    assertUrl(url)
    write("enter-software-name", name)
    val suggestion = By.cssSelector(".autocomplete__option")
    waitForElement(suggestion)
    Driver.instance.findElement(suggestion).click()
  }

  def clickSoftwareNotListed(): Unit = {
    val link = By.linkText("My software is not listed")
    Driver.instance.findElement(By.id("enter-software-name")).sendKeys(Keys.ESCAPE)
    fluentWait.until(ExpectedConditions.elementToBeClickable(link))
    click(link)
  }
}
