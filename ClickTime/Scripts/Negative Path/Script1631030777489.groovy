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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod
import com.kms.katalon.core.testobject.ConditionType as ConditionType

'Verify user name text box displays.'
WebUI.verifyElementVisible(findTestObject('Page_WordGame/userName'), FailureHandling.STOP_ON_FAILURE)

if (WebUI.getAttribute(findTestObject('Page_WordGame/userName'), 'value').equals('')) {
    WebUI.sendKeys(findTestObject('Page_WordGame/userName'), GlobalVariable.userName)
}

'Expand Categories List-box'
WebUI.click(findTestObject('Page_WordGame/Category'), FailureHandling.STOP_ON_FAILURE)

'Selecting TV Shows from the list-box'
WebUI.selectOptionByLabel(findTestObject('Page_WordGame/Category'), category, false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_WordGame/loadGame'))

WebUI.waitForElementVisible(findTestObject('Page_WordGame/restartGame'), 10)

for (int i = 0; i < word.length(); i++) {
    TestObject myNewObject = new TestObject()

    myNewObject.addProperty('Text', ConditionType.EQUALS, String.valueOf(word.charAt(i)))

    WebUI.verifyElementVisible(myNewObject)

    WebUI.click(myNewObject)
}

WebUI.waitForElementVisible(findTestObject('Page_WordGame/You have missed 6 guess(es)'), 5)

WebUI.click(findTestObject('Page_WordGame/restartGame'))

