package technicalTest
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Test1 {
	
	private static String productLabel = ''
	private static String productPrice = ''

	@Given("User Open Souca Demo")
	def userOpenSaucaDemo() {
		WebUI.openBrowser(GlobalVariable.url)
	}

	@When("User Input Username (.*)")
	def userInputUsername(String username) {
		WebUI.setText(findTestObject('Object Repository/Element/userName'), username)
	}

	@When("User Input Password (.*)")
	def userInputPassword(String password) {
		WebUI.setText(findTestObject('Element/password'), password)
	}

	@Then("User Submit Button")
	def userSubmitButton() {
		WebUI.click(findTestObject('Element/submitButton'))
		WebUI.takeFullPageScreenshot()
		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Element/priceonCart'), 5)) {
		}else {
			WebUI.setText(findTestObject('Object Repository/Element/userName'), 'standard_user')
			WebUI.setText(findTestObject('Element/password'), 'secret_sauce')
			WebUI.click(findTestObject('Element/submitButton'))
		}
	}

	@Then("User Count Product")
	def userCountProduct() {
		List<WebElement> productElements = WebUI.findWebElements(findTestObject('Object Repository/Element/listProduct'), 10)
		int sizeProductElements = productElements.size()
		KeywordUtil.logInfo("Jumlah produk yang ditemukan: " + sizeProductElements)
		KeywordUtil.logInfo("Isi Element ditemukan: " + productElements)

		assert sizeProductElements == 6
		WebUI.takeFullPageScreenshot()
	}

	@When("User Add to Chart Following Product Title")
	def userAddtoChart() {
		WebUI.click(findTestObject('Object Repository/Element/buttonAddtoCart'))
	}

	@When("User Get Label and Price Product")
	def userGetLabelandPriceProduct() {
		productLabel = WebUI.getText(findTestObject('Object Repository/Element/labelProduct'))
		productPrice = WebUI.getText(findTestObject('Object Repository/Element/priceProduct'))
		KeywordUtil.logInfo(productLabel +' '+ productPrice + ' is found')
	}

	@When("User Verify Remove in Add to Chart")
	def userVerifyRemoveAddtoChart() {
		WebUI.verifyElementText(findTestObject('Object Repository/Element/buttonAddtoCart'),'Remove')
		WebUI.takeFullPageScreenshot()
	}

	@When("User Open Chart")
	def userOpenChart() {
		WebUI.click(findTestObject('Object Repository/Element/shopCartLInk'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Element/labelonCart'), 5)
	}

	@Then("User Verify Label and Price in Your Chart")
	def userVerifyLabelandPrice() {
		WebUI.verifyElementText(findTestObject('Object Repository/Element/labelonCart'),productLabel.trim())
		WebUI.verifyElementText(findTestObject('Object Repository/Element/priceonCart2'),productPrice.trim())
		WebUI.takeFullPageScreenshot()
	}
}