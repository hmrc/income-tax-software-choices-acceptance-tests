/*
 * Copyright 2022 HM Revenue & Customs
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

object SoftwareChoicesHomePage extends BasePage {

  val url: String = TestConfiguration.url("software-choices-frontend") + "/"

  val pageTitle =
    "Choose the right software for your needs - Find software for Making Tax Digital for Income Tax - GOV.UK"

  val searchBarId: String = "searchTerm"

  val softwareVendorsId: String = "software-vendor-0"

  val toFilterId: Map[String, String] = Map(
    "Free trial" -> "free-trial-filter",
    "Free version" -> "free-version-filter",
    "Sole trader" -> "sole-trader-filter",
    "UK property" -> "uk-property-filter",
    "Overseas property" -> "overseas-property-filter",
    "Individual" -> "individual-filter",
    "Agent" -> "agent-filter",
    "Microsoft" -> "microsoft-windows-filter",
    "Mac OS" -> "mac-os-filter",
    "VAT" -> "vat-filter",
    "Android" -> "android-filter",
    "Apple iOS" -> "apple-ios-filter",
    "Browser based" -> "browser-based-filter",
    "Application based" -> "application-based-filter",
    "Visual" -> "visual-filter",
    "Hearing" -> "hearing-filter",
    "Motor" -> "motor-filter",
    "Cognitive" -> "cognitive-filter"
  )

  def loadPage: this.type = {
    driver.navigate().to(url)
    onPage(pageTitle)
    this
  }

}
