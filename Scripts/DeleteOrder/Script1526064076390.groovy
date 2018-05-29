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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.AdminSite)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUiBuiltInKeywords.waitForPageLoad(10)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/a_ System Information'))

WebUiBuiltInKeywords.waitForElementVisible(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/RowDelete_Button'), 
    20)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/OrderNameFIlter_Button'))

WebUI.waitForElementVisible(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/OrderNameFIlter_LikeField'), 
    3)

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/OrderNameFIlter_LikeField'), 
    'ATPLS')

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/OrderStatusFilter_Button'))

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/Status_CREATEDCheckbox'), 
    3)

WebUI.uncheck(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/Status_CREATEDCheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/Status_STARTEDCheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/Status_SUBMITTEDCheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/Status_FAILURECheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/Status_WARNINGCheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/Status_CANCELEDCheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/Status_REJECTEDCheckbox'))

countOrders = WebUI.getText(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/TotalOrders_Field'))

println('Number of Orders = ' + countOrders)

WebUI.callTestCase(findTestCase('Utilities/JustDeleteOneATPOrder'), [:], FailureHandling.STOP_ON_FAILURE)

countOrders2 = WebUI.getText(findTestObject('Page_Earth Sensor Portal/Admin Console/SystemInformation/TotalOrders_Field'))

println('Number of Orders after delete = ' + countOrders2)

WebUI.callTestCase(findTestCase('Utilities/AdminConsoleSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

