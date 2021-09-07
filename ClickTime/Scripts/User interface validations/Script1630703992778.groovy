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
import org.codehaus.groovy.vmplugin.v7.Selector as Selector
import org.openqa.selenium.Keys as Keys

'Verify user name text box displays.'
WebUI.verifyElementVisible(findTestObject('Page_WordGame/userName'), FailureHandling.STOP_ON_FAILURE)

'Verify Username Length = 50'
WebUI.verifyElementAttributeValue(findTestObject('Page_WordGame/userName'), 'maxlength', '50', 10, FailureHandling.STOP_ON_FAILURE)

'Verify Category list-box displays.'
WebUI.verifyElementVisible(findTestObject('Page_WordGame/Category'), FailureHandling.STOP_ON_FAILURE)

'Expand Categories List-box'
WebUI.click(findTestObject('Page_WordGame/Category'), FailureHandling.STOP_ON_FAILURE)

'Verify Categories List-box values.'
for (String category : GlobalVariable.categories) {
    WebUI.verifyOptionPresentByLabel(findTestObject('Page_WordGame/Category'), category, false, 10)
}

'Taking a screenshot of the list-box values.'
WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

'Close list-box'
WebUI.click(findTestObject('Page_WordGame/Category'), FailureHandling.STOP_ON_FAILURE)

'Take a screenshot of evidece of the full welcome form'
WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

'Verifying buton load game is disabled'
WebUI.verifyElementHasAttribute(findTestObject('Page_WordGame/loadGame'), 'disabled', 10, FailureHandling.STOP_ON_FAILURE)

'Filling username textbox'
WebUI.sendKeys(findTestObject('Page_WordGame/userName'), GlobalVariable.userName, FailureHandling.STOP_ON_FAILURE)

'Selecting TV Shows from the list-box'
WebUI.selectOptionByLabel(findTestObject('Page_WordGame/Category'), GlobalVariable.defaultCategory, false, FailureHandling.STOP_ON_FAILURE)

'Verifying buton load game is enabled'
WebUI.verifyElementNotHasAttribute(findTestObject('Page_WordGame/loadGame'), 'disabled', 10, FailureHandling.STOP_ON_FAILURE)

'Taking a screenshot of evidence button Load game is now enabled.'
WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

'Click on Load Game Button.'
WebUI.click(findTestObject('Page_WordGame/loadGame'), FailureHandling.STOP_ON_FAILURE)

'Wait for game page displays.'
WebUI.waitForElementVisible(findTestObject('Page_WordGame/restartGame'), 10, FailureHandling.STOP_ON_FAILURE)

'Set the XPATH selector for Welcome Message Test Object.'
CustomKeywords.'common.changeSelector.setNewWelcomeSelector'(findTestObject('Page_WordGame/welcomeMessage'), GlobalVariable.userName)

'Verifying Welcome message displays with the user name'
WebUI.verifyElementVisible(findTestObject('Page_WordGame/welcomeMessage'), FailureHandling.STOP_ON_FAILURE)

'Set the XPATH for the Current Category message.'
CustomKeywords.'common.changeSelector.setNewCategorySelector'(findTestObject('Page_WordGame/currentCategory'), GlobalVariable.defaultCategory)

'Verifying word phrase displays'
WebUI.verifyElementVisible(findTestObject('Page_WordGame/wordPhrase'), FailureHandling.STOP_ON_FAILURE)

'Verifying the whole alphabet displays.'
for (String character : GlobalVariable.alphabet) {
    CustomKeywords.'common.changeSelector.setNewCharSelector'(findTestObject('Page_WordGame/letter'), character)

    WebUI.verifyElementVisible(findTestObject('Page_WordGame/letter'))
}

'Verifying current state message displays'
WebUI.verifyElementVisible(findTestObject('Page_WordGame/currentState'), FailureHandling.STOP_ON_FAILURE)

'Verifying Restart Game button displays'
WebUI.verifyElementVisible(findTestObject('Page_WordGame/restartGame'), FailureHandling.STOP_ON_FAILURE)

'Taking a screenshot of the form'
WebUI.takeScreenshot()

WebUI.click(findTestObject('Page_WordGame/restartGame'))

