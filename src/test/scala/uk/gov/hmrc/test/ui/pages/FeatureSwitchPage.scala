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

object FeatureSwitchPage extends BasePage {

  val url: String = getPageURL("/test-only/feature-switch")

  val featureSwitches = Map {
    "Intent" -> "intent"
  }

  def setFeatureSwitches(switches: Seq[String]): Unit = {
    goTo()
    switches.foreach { switch =>
      selectCheckbox(checkBoxSelector(featureSwitches.getOrElse(switch, fail("Not a valid feature switch"))))
    }
    click(By.id("continue-button"))
  }

  def disableAllFeatureSwitches(): Unit = {
    goTo()
    featureSwitches.foreach(switch => deselectCheckbox(checkBoxSelector(switch._2)))
    click(By.id("continue-button"))
  }

  private def checkBoxSelector(value: String) = By.cssSelector(s"input[type='checkbox'][value='$value']")

}
