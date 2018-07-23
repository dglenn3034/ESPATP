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

WebUI.callTestCase(findTestCase('Utilities/GetLoginInfo'), [('Site') : 'dummy.com', ('username') : '', ('pwd') : 'pwd', ('Role') : 'Company Admin'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.AdminSite)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUiBuiltInKeywords.waitForPageLoad(4)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/a_ Organizations'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/AddOrganizationButton'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/OrganizationName'), 'ATPOrganization')

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/textarea_description'), 
    'Organization for ATP exercise')

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/OrganizationDeliveryBucket'), 
    GlobalVariable.GeoCueDeliveryBucket)

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/OrganizationDeliveryPrefix'), 
    GlobalVariable.GeoCueDeliveryPrefix)

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/OrganizationGroupPulldown'), 
    'airgon.com')

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/OrganizationSaveButton'))

'Wait on success message to clear'
WebUI.delay(5)

WebUI.callTestCase(findTestCase('Utilities/AdminConsoleSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

