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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'User', ('Company') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.click(findTestObject('Cesium/canvas'))

WebUiBuiltInKeywords.click(findTestObject('Catalog/Main/CatalogOrderHistory_button'))

CustomKeywords.'genericGrid.gridOperations.AddOneColumn'('Order Name', true)

CustomKeywords.'genericGrid.gridOperations.AddOneColumn'('Status', false)

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Order Name')

WebUiBuiltInKeywords.setText(findTestObject('Grid/LikeFilter'), 'ATP')

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Status')

WebUiBuiltInKeywords.setText(findTestObject('Grid/LikeFilter'), 'SUCCESS')

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

CustomKeywords.'genericGrid.gridOperations.ExecuteGridFunction'(1, 'Zoom')

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

CustomKeywords.'genericGrid.gridOperations.SelectRow'(1, true)

CustomKeywords.'genericGrid.gridOperations.SelectRow'(1, false)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

CustomKeywords.'genericGrid.gridOperations.ExecuteGridFunction'(1, 'Details')

CustomKeywords.'genericGrid.gridOperations.ExecuteGridFunction'(1, 'Popup')

WebUiBuiltInKeywords.click(findTestObject('Catalog/OrderHistory/OrderDetailsPopup_XButton'))

WebUiBuiltInKeywords.click(findTestObject('Catalog/OrderHistory/OrderDetails_XButton'))

WebUiBuiltInKeywords.click(findTestObject('Catalog/OrderHistory/OrderHistory_XButton'))

WebUI.callTestCase(findTestCase('Utilities/CatalogSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

