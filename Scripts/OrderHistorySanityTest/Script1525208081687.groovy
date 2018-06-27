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

WebUI.navigateToUrl(GlobalVariable.site)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/Canvas'))

WebUiBuiltInKeywords.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogOrderHistory_button'), 
    5)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogOrderHistory_button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/ToggleColumnsButton'))

WebUI.uncheck(findTestObject('Page_Earth Sensor Portal/OrderHistory/ToggleCheckBox_dateSubmitted'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistory_OrderNameFilter'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderName_LikeBox'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderName_LikeBox'), 'ATP')

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistory_StatusFIlter'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/Status_LikeBox'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/OrderHistory/Status_LikeBox'), 'SUCCESS')

WebUiBuiltInKeywords.delay(3)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistory_ZoomToOrderButton'))

WebUiBuiltInKeywords.delay(2)

WebUI.mouseOver(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistory_Row1SelectBox'))

'click on header just to allow tooltip to clear'
WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistory_Row1SelectBox'))

WebUI.delay(3)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistory_DetailsButton'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderDetails_PopupImageButton'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderDetailsPopup_XButton'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderDetails_XButton'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistory_XButton'))

WebUI.callTestCase(findTestCase('Utilities/CatalogSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

