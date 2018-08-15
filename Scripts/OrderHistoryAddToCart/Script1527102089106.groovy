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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'User', ('Company') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.click(findTestObject('Cesium/canvas'))

WebUiBuiltInKeywords.click(findTestObject('Catalog/Main/CatalogOrderHistory_button'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

CustomKeywords.'genericGrid.gridOperations.SetGridJustOneColumn'('Order Name')

CustomKeywords.'genericGrid.gridOperations.AddOneColumn'('Status', false)

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Order Name')

WebUiBuiltInKeywords.setText(findTestObject('Grid/LikeFilter'), 'ATPLS')

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Status')

WebUiBuiltInKeywords.setText(findTestObject('Grid/LikeFilter'), 'SUCCESS')

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.click(findTestObject('Catalog/OrderHistory/OrderHistoryAddtoCartButton'))

WebUiBuiltInKeywords.click(findTestObject('Catalog/OrderHistory/OrderHistory_XButton'))

WebUiBuiltInKeywords.click(findTestObject('Catalog/OrderCart/OrderCart_Button'))

CustomKeywords.'genericGrid.gridOperations.ExecuteGridFunction'(1, 'Remove')

WebUiBuiltInKeywords.click(findTestObject('Catalog/OrderCart/OrderCartCheckout_Button'))

def date = new Date()

SimpleDateFormat sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

String aDate = sdf.format(new Date())

String OName = 'ATPOrderCartReOrderTest-' + aDate

WebUI.setText(findTestObject('Catalog/OrderCart/OrderCartOrderName_Field'), OName)

WebUI.click(findTestObject('Catalog/OrderCart/OrderCartPreviewOrder_Button'))

WebUI.delay(2)

WebUI.click(findTestObject('Catalog/OrderCart/OrderCartPlaceOrder_Button'))

WebUiBuiltInKeywords.delay(3)

WebUI.click(findTestObject('OKButton'))

WebUI.callTestCase(findTestCase('Utilities/CatalogSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

