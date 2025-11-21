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

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.scalatest.compatible.Assertion

object SoftwareResultsPage extends BasePage {

  val url: String = getPageURL("/software-results")

  val toFilterId: Map[String, String] = Map(
    "Free version"                   -> "free-version-filter",
    "Bridging"                       -> "bridging-filter",
    "VAT"                            -> "vat-filter",
    "Blindness or impaired vision"   -> "visual-filter",
    "Deafness or impaired hearing"   -> "hearing-filter",
    "Motor or physical difficulties" -> "motor-filter",
    "Cognitive impairments"          -> "cognitive-filter"
  )

  def onPage(isAgent: Boolean): Assertion = {
    assertUrl(url)
    assertPresenceOfElement(By.cssSelector("#agent-filter"), isAgent)
  }

  def selectVendorLink(index: Int): Unit = {
    val linkSelector: By = By.cssSelector(s"#software-vendor-${index - 1} a")
    click(linkSelector)
  }

  def selectPreferenceFilters(preferences: Seq[String]): Unit = {
    preferences.map(toFilterId).foreach(id => selectCheckbox(By.id(id)))
    click(By.cssSelector(".apply-filters-button"))
  }

  def clearFilters(): Unit = {
    click(By.linkText("Clear filters"))
    assertUrl(url)
  }

  def checkVendorDisplayed(vendor: Int, expected: Boolean): Assertion =
    fluentWait.until(
      ExpectedConditions.refreshed(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#software-vendor-0"))
      )
    )
    assertPresenceOfElement(By.partialLinkText(s"vendor 0$vendor"), expected)

}
