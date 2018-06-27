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

WebUI.callTestCase(findTestCase('Utilities/GetLoginInfo'), [('Site') : 'dummy.com', ('username') : '', ('pwd') : 'pwd'], FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.AdminSite)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 5)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsViewDetails'))

'GeoCue Organization in GeoCue company'
WebUiBuiltInKeywords.selectOptionByValue(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsOrderReportOrganization'), 
    '70CDF0F3358140198A4A473F1B915CCF', false)

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsDatePickEnd'), '04/01/2018')

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsDatePickStart'), '06/01/2018')

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsOrderReportPreview'))

WebUiBuiltInKeywords.delay(5)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsDismissOrderPreview'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsOrderReportEmail'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsOKButton'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 5)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/a_Users'))

'GeoCue Organization in GeoCue company'
WebUiBuiltInKeywords.selectOptionByValue(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsUserReportOrganization'), 
    '70CDF0F3358140198A4A473F1B915CCF', false)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsUserReportPreview'))

WebUiBuiltInKeywords.delay(5)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsDismissOrderPreview'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsUserReportsEmail'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Reports/ReportsOKButton'))

WebUiBuiltInKeywords.delay(5)

WebUI.callTestCase(findTestCase('Utilities/AdminConsoleSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

