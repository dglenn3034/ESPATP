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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Company') : '', ('Role') : 'User'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Cesium/CesiumSearchField'), 'Houston')

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.click(findTestObject('Cesium/CesiumSearchButton'))

'Not sure why this is needed, but we have to wait until Cesium search is finished resetting the view before we can rest the AOI to the view '
WebUI.delay(3)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.click(findTestObject('Catalog/Main/CatalogAOIAsView_Button'))

WebUI.click(findTestObject('Catalog/Main/CatalogProducts_Button'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

CustomKeywords.'productSelection.productSelection.SelectChildProduct'('Landsat8', 'NDVI')

CustomKeywords.'productSelection.productSelection.SelectProduct'('OrthoImages')

WebUI.click(findTestObject('Catalog/ProductSelection/ProductSelection_OK'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

CustomKeywords.'searchResults.searchResults.SetSearchResultsColumnFirst'('Product Name')

WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsFieldsToggle_button'))

CustomKeywords.'searchResults.searchResults.sortByName'('Product Name')

WebUI.click(findTestObject('Catalog/SearchResults/SearchResults_SelectFirstRow'))

CustomKeywords.'searchResults.searchResults.sortByName'('Product Name')

WebUI.click(findTestObject('Catalog/SearchResults/SearchResults_SelectFirstRow'))

WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsAddSelectedToCart_Button'))

WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsDismissButton'))

WebUI.click(findTestObject('Catalog/OrderCart/OrderCart_Button'))

WebUI.click(findTestObject('Catalog/OrderCart/OrderCartCheckout_Button'))

if (GlobalVariable.site.contains('get3di')) {
    WebUI.click(findTestObject('OKButton'))
}


def date = new Date()

SimpleDateFormat sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

String aDate = sdf.format(new Date())

String OName = 'ATPLSandOrthoOrder-' + aDate

WebUI.setText(findTestObject('Catalog/OrderCart/OrderCartOrderName_Field'), OName)

WebUI.click(findTestObject('Catalog/OrderCart/OrderCartPreviewOrder_Button'))

WebUI.click(findTestObject('Catalog/OrderCart/OrderCartPlaceOrder_Button'))

WebUI.delay(3)

WebUI.click(findTestObject('OKButton'))

WebUI.callTestCase(findTestCase('Utilities/CatalogSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

