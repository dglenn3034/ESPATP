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
import java.text.SimpleDateFormat as SimpleDateFormat

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.site)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/Canvas'))

WebUiBuiltInKeywords.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogOrderHistory_button'), 
    0)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogOrderHistory_button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/ToggleColumnsButton'))

WebUI.uncheck(findTestObject('Page_Earth Sensor Portal/OrderHistory/ToggleCheckBox_dateSubmitted'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistory_OrderNameFilter'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderName_LikeBox'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderName_LikeBox'), 'ATPLS')

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistory_StatusFIlter'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/Status_LikeBox'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/OrderHistory/Status_LikeBox'), 'SUCCESS')

WebUiBuiltInKeywords.delay(3)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistoryAddtoCartButton'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderHistory/OrderHistory_XButton'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCart_Button'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartRemoveFromCart'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartCheckout_Button'))

def date = new Date()

SimpleDateFormat sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

String aDate = sdf.format(new Date())

String OName = 'ATPOrderCartReOrderTest-' + aDate

WebUI.setText(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartOrderName_Field'), OName)

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartPreviewOrder_Button'))

WebUI.delay(2)

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartPlaceOrder_Button'))

WebUiBuiltInKeywords.delay(3)

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.callTestCase(findTestCase('Utilities/CatalogSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

