import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Utilities/GetLoginInfo'), [('Site') : 'dummy.com', ('username') : '', ('pwd') : 'pwd'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.site)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/Canvas'))

not_run: WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogNamedSearch_Button'), 3)

not_run: WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogNamedSearch_Button'))

try {
    WebUI.callTestCase(findTestCase('Utilities/NamedSearchExists'), [('NamedSearch') : 'SmokeTest01'], FailureHandling.STOP_ON_FAILURE)

    println('Named Search SmokeTest01 does exist, we will delete it and recreate it')

    WebUI.click(findTestObject('Page_Earth Sensor Portal/NamedSearch/NamedSearch_DeleteButton'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'), FailureHandling.STOP_ON_FAILURE)
}
catch (Exception e) {
    println('Named Search SmokeTest01 does not exist, we will create it')

    WebUI.click(findTestObject('Page_Earth Sensor Portal/NamedSearch/NamedSearchesCancel_Button'))
} 

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogProducts_Button'), 3)

