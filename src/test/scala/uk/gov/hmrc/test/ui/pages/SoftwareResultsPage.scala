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

import uk.gov.hmrc.test.ui.conf.TestConfiguration

object SoftwareResultsPage extends BasePage {

  val url: String = TestConfiguration.url("software-choices-frontend") + "/software-results"

  val zeroResultsUrl: String = url + "?zeroResults=true"

  val searchBarId: String = "searchTerm"

  val vendorCountId: String = "vendor-count"

  val softwareVendorList: String = "software-vendor-list"

  val toFilterId: Map[String, String] = Map(
    "Free version"                         -> "free-version-filter",
    "Record keeping"                       -> "record-keeping-filter",
    "Bridging"                             -> "bridging-filter",
    "VAT"                                  -> "vat-filter",
    "Blindness or impaired vision"         -> "visual-filter",
    "Deafness or impaired hearing"         -> "hearing-filter",
    "Motor or physical difficulties"       -> "motor-filter",
    "Cognitive impairments"                -> "cognitive-filter",
    "6th April to 5th April"               -> "standard-update-periods-filter",
    "1st April to 31st March"              -> "calendar-update-periods-filter",
    "Self-employment"                      -> "sole-trader-filter",
    "UK property"                          -> "uk-property-filter",
    "Foreign property"                     -> "overseas-property-filter",
    "Construction industry scheme (CIS)"   -> "construction-industry-scheme-filter",
    "Capital Gains Tax"                    -> "capital-gains-tax-filter",
    "Employment"                           -> "employment-filter",
    "Foreign Income"                       -> "foreign-income-filter",
    "UK Dividends"                         -> "uk-dividends-filter",
    "UK interest"                          -> "uk-interest-filter",
    "Charitable giving"                    -> "charitable-giving-filter",
    "High Income Child Benefit Charge"     -> "high-income-child-benefit-charge-filter",
    "Student loans"                        -> "student-loans-filter",
    "Voluntary Class 2 National Insurance" -> "voluntary-class-2-national-insurance-filter",
    "State pension income"                 -> "state-pension-income-filter",
    "Private pension income"               -> "private-pension-income-filter",
    "Payments into a private pension"      -> "payments-into-a-private-pension-filter",
    "Marriage Allowance"                   -> "marriage-allowance-filter"
  )

  def loadPage: this.type = {
    driver.navigate().to(url)
    assertUrl(url)
    this
  }

}
