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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.datatable.DataTable
import uk.gov.hmrc.test.ui.pages.BusinessIncomePage._

import scala.jdk.CollectionConverters.IterableHasAsScala

class BusinessIncomeStepDef extends BaseStepDef {

  Given("""^I navigate to the business income page$""") { () =>
    loadPage(businessIncomePageUrl)
  }

  And("""^I am on the business income page, I select the following business income and click continue$""") {
    (businessIncome: DataTable) =>
      assertUrl(businessIncomePageUrl)
      businessIncome.asList().asScala.map(fromBusinessIncomeToId).foreach(clickById)
      submitPage()
  }

}
