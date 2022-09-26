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

  val searchBarId: String = "searchTerm"

  val softwareVendorsId: String = "software-vendor-0"

  val toAccordionFoldId: Map[String, String] = Map(
    "Pricing" -> "accordion-default-heading-1",
    "Income type" -> "accordion-default-heading-2",
    "Compatible with" -> "accordion-default-heading-3",
    "Mobile app" -> "accordion-default-heading-4",
    "Software type" -> "accordion-default-heading-5",
    "Software for" -> "accordion-default-heading-6",
    "Business type" -> "accordion-default-heading-7",
    "Software compatibility" -> "accordion-default-heading-8",
    "Language" -> "accordion-default-heading-9",
    "Accessibility features" -> "accordion-default-heading-10"
  )

  val toFilterId: Map[String, String] = Map(
    "Free trial" -> "free-trial-filter",
    "Free version" -> "free-version-filter",
    "Paid for" -> "paid-for-filter",

    "Sole trader" -> "sole-trader-filter",
    "UK property" -> "uk-property-filter",
    "Overseas property" -> "overseas-property-filter",

    "Microsoft" -> "microsoft-windows-filter",
    "Mac OS" -> "mac-os-filter",

    "Android" -> "android-filter",
    "Apple iOS" -> "apple-ios-filter",

    "Browser based" -> "browser-based-filter",
    "Application based" -> "application-based-filter",

    "Record keeping" -> "record-keeping-filter",
    "Bridging" -> "bridging-filter",

    "Individual" -> "individual-filter",
    "Agent" -> "agent-filter",

    "VAT" -> "vat-filter",

    "Welsh" -> "welsh-filter",

    "Visual" -> "visual-filter",
    "Hearing" -> "hearing-filter",
    "Motor" -> "motor-filter",
    "Cognitive" -> "cognitive-filter",
  )

  def loadPage: this.type = {
    driver.navigate().to(url)
    assertUrl(url)
    this
  }

}
