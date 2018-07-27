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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'Company Admin', ('Company') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.AdminSite)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 5)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Reports/ReportsViewDetails'))

'GeoCue Organization in GeoCue company'
WebUiBuiltInKeywords.selectOptionByLabel(findTestObject('Admin Console/Reports/ReportsOrderReportOrganization'), 'Geocue', 
    false)

WebUiBuiltInKeywords.setText(findTestObject('Admin Console/Reports/ReportsDatePickStart'), '04/01/2018')

'To clear date picker box'
WebUI.click(findTestObject('Admin Console/Reports/OrderReportHeader'))

WebUiBuiltInKeywords.setText(findTestObject('Admin Console/Reports/ReportsDatePickEnd'), '06/01/2018')

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Reports/ReportsOrderReportPreview'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Reports/ReportsDismissOrderPreview'))

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Reports/ReportsOrderReportEmail'))

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Reports/ReportsOKButton'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

'Wait on Report submitted message to clear'
WebUI.delay(5)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Reports/a_Users'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.delay(3)

WebUI.click(findTestObject('Admin Console/Reports/UserReportHeader'))

'GeoCue Organization in GeoCue company'
WebUiBuiltInKeywords.selectOptionByLabel(findTestObject('Admin Console/Reports/ReportsUserReportOrganization'), 'Geocue', 
    false)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Reports/ReportsUserReportPreview'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Reports/ReportsDismissOrderPreview'))

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Reports/ReportsUserReportsEmail'))

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Reports/ReportsOKButton'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.delay(3)

WebUI.callTestCase(findTestCase('Utilities/AdminConsoleSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

