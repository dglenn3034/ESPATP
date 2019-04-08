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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'User', ('Company') : 'Teledyne'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.click(findTestObject('Cesium/canvas'))

WebUI.setText(findTestObject('Cesium/CesiumSearchField'), 'France')

WebUI.click(findTestObject('Cesium/CesiumSearchButton'))

WebUI.delay(3, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Catalog/Main/CatalogAOIAsView_Button'))

WebUI.delay(3, FailureHandling.STOP_ON_FAILURE)

WebUiBuiltInKeywords.click(findTestObject('Catalog/Main/CatalogProducts_Button'))

CustomKeywords.'productSelection.productSelection.SelectChildProduct'('DESIS-30', 'L1C')

WebUiBuiltInKeywords.click(findTestObject('Catalog/ProductSelection/ProductSelection_OK'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.click(findTestObject('Catalog/SearchResults/SearchResults_SelectFirstRow'))

WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsAddSelectedToCart_Button'))

WebUiBuiltInKeywords.click(findTestObject('Catalog/OrderCart/OrderCart_Button'))

WebUiBuiltInKeywords.click(findTestObject('Catalog/OrderCart/OrderCartCheckout_Button'))

WebUI.click(findTestObject('Catalog/PostProcessing/PostProcessing_button_Add'))

WebUI.selectOptionByLabel(findTestObject('Catalog/PostProcessingDESIS/MapProjection'), 'UTM_Zone_of_Scene_Center(+1)', false)

WebUiBuiltInKeywords.selectOptionByLabel(findTestObject('Catalog/PostProcessingDESIS/ImageResampling'), 'Cubic Convolution', 
    false)

not_run: WebUiBuiltInKeywords.selectOptionByLabel(findTestObject('Catalog/PostProcessingDESIS/TerrainCorrection'), 'Yes', 
    false)

not_run: WebUI.setText(findTestObject('Catalog/PostProcessingDESIS/OzoneValue'), '300')

WebUI.click(findTestObject('Catalog/PostProcessing/PostProcessingOK_Button'))

def date = new Date()

SimpleDateFormat sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

String aDate = sdf.format(new Date())

String OName = 'ATPDESISCatalogOrder-' + aDate

WebUiBuiltInKeywords.setText(findTestObject('Catalog/OrderCart/OrderCartOrderName_Field'), OName)

WebUI.click(findTestObject('Catalog/OrderCart/OrderCartPreviewOrder_Button'))

WebUiBuiltInKeywords.click(findTestObject('Catalog/OrderCart/OrderCartPlaceOrder_Button'))

WebUiBuiltInKeywords.delay(2)

WebUiBuiltInKeywords.click(findTestObject('OKButton'))

WebUI.callTestCase(findTestCase('Utilities/CatalogSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

