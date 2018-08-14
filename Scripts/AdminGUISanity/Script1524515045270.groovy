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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'Company Admin'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.AdminSite)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Admin Console/div_Users'), 1)

WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Admin Console/div_Groups'), 1)

WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Admin Console/div_Organizations'), 1)

WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Admin Console/div_Access Restriction'), 1)

WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Admin Console/div_Basemaps'), 1)

WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Admin Console/div_Reports'), 1)

WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Admin Console/a_ System Information'), 1)

WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Admin Console/a_ActivityLog'), 1)

WebUI.verifyElementPresent(findTestObject('Admin Console/a_Message'), 1)

WebUI.callTestCase(findTestCase('Utilities/AdminConsoleSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

