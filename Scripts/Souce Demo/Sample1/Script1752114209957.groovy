import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import static org.assertj.core.api.Assertions.*

WebUI.openBrowser(GlobalVariable.url)

WebUI.setText(findTestObject('Object Repository/Element/userName'), 'locked_out_user')

WebUI.setText(findTestObject('Element/password'), 'secret_sauce')

WebUI.click(findTestObject('Element/submitButton'))

WebUI.takeFullPageScreenshot()


if (WebUI.waitForElementPresent(findTestObject('Object Repository/Element/priceonCart'), 5)) {
	
}else {
	WebUI.setText(findTestObject('Object Repository/Element/userName'), 'standard_user')
	
	WebUI.setText(findTestObject('Element/password'), 'secret_sauce')
	
	WebUI.click(findTestObject('Element/submitButton'))
	
}

List<WebElement> productElements = WebUI.findWebElements(findTestObject('Object Repository/Element/listProduct'), 10)

int sizeProductElements = productElements.size()

KeywordUtil.logInfo("Jumlah produk yang ditemukan: " + sizeProductElements)

KeywordUtil.logInfo("Isi Element ditemukan: " + productElements)

assert sizeProductElements == 6

WebUI.click(findTestObject('Object Repository/Element/buttonAddtoCart'))

String productLabel = WebUI.getText(findTestObject('Object Repository/Element/labelProduct'))

String productPrice = WebUI.getText(findTestObject('Object Repository/Element/priceProduct'))

KeywordUtil.logInfo(productLabel +' '+ productPrice + ' is found')

WebUI.takeFullPageScreenshot()

WebUI.waitForElementPresent(findTestObject('Object Repository/Element/buttonRemove'), 5)

WebUI.click(findTestObject('Object Repository/Element/shopCartLInk'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Element/labelonCart'), 5)

WebUI.verifyElementText(findTestObject('Object Repository/Element/labelonCart'),productLabel.trim())

WebUI.verifyElementText(findTestObject('Object Repository/Element/priceonCart2'),productPrice.trim())

WebUI.takeFullPageScreenshot()

