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
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat as SimpleDateFormat
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'User', ('Company') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.click(findTestObject('Cesium/canvas'))

found = WebUI.callTestCase(findTestCase('Utilities/NamedSearchExists'), [('NamedSearch') : 'ATPSmokeTest'], FailureHandling.STOP_ON_FAILURE)

if (found == true) {
    println('Named Search is found, deleting it...')

    WebUI.click(findTestObject('Catalog/NamedSearch/NamedSearch_DeleteButton'))

    WebUI.click(findTestObject('OKButton'))
} else {
    println(' No such named Search')

    WebUI.click(findTestObject('Catalog/NamedSearch/NamedSearchesCancel_Button'))
}

WebUI.delay(3)

WebUI.click(findTestObject('Catalog/Main/CatalogProducts_Button'))

CustomKeywords.'productSelection.productSelection.SelectChildProduct'('Landsat8', 'NDVI')

CustomKeywords.'productAttributeFiltering.attributeFiltering.SetAttributeFilter'('Landsat8', '>=', 'Date Acquired', '06/01/2017', 
    true)

WebUI.click(findTestObject('Catalog/ProductSelection/ProductSelection_OK', [('variable') : '']))

WebUI.click(findTestObject('Catalog/Main/CatalogAOIImport_Button'))

WebUI.sendKeys(findTestObject('Catalog/AOI/AOIFIlePath_Field'), '\\\\diskstation1\\Data\\Rob_MUSES\\Shapefile_test_datasets\\rob_coloradio.shp_file_lp360.zip')

WebUI.click(findTestObject('Catalog/AOI/AOIExecutetheImport_button'))

WebUI.waitForElementVisible(findTestObject('Catalog/SearchResults/SearchResults_Grid'), 0)

WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsMinimize'))

WebUI.click(findTestObject('Catalog/Main/AdvancedSlideOut'))

WebUI.click(findTestObject('Catalog/Histograms/HistogramShowHideFilters_button'))

WebUI.waitForElementClickable(findTestObject('Catalog/Histograms/HistogramFiltersList_Button'), 0)

WebUI.click(findTestObject('Catalog/Histograms/HistogramFiltersList_Button'))

WebUI.check(findTestObject('Catalog/Histograms/HistogramCloudCoverageFull_CheckBox'))

WebUI.check(findTestObject('Catalog/Histograms/HistogramSunElevation_CheckBox'))

WebUI.click(findTestObject('OKButton'))

WebUI.delay(5)

WebUI.click(findTestObject('Catalog/Histograms/HistogramSunElevation_button'))

WebUI.setText(findTestObject('Catalog/Histograms/HistogramOpenFilterFirstValue_input'), '60')

WebUI.setText(findTestObject('Catalog/Histograms/HistogramOpenFilterSecondvalue_Field'), '70')

WebUI.click(findTestObject('OKButton'))

WebUI.waitForElementClickable(findTestObject('Catalog/Main/CatalogSaveNamedSearch_Button'), 2)

WebUI.click(findTestObject('Catalog/Main/CatalogSaveNamedSearch_Button'))

WebUI.setText(findTestObject('Catalog/NamedSearch/NamedSearchSaveName_Field'), 'ATPSmokeTest')

WebUI.click(findTestObject('Catalog/NamedSearch/SaveNamedSearchSave_Button'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsMaximize'))

WebUI.click(findTestObject('Catalog/SearchResults/SearchResults_SelectFirstRow'))

WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsAddSelectedToCart_Button'))

WebUI.click(findTestObject('Catalog/OrderCart/OrderCart_Button'))

WebUI.click(findTestObject('Catalog/OrderCart/OrderCartCheckout_Button'))

if (GlobalVariable.site.contains('get3di')) {
    WebUI.click(findTestObject('OKButton'))
}

def date = new Date()

SimpleDateFormat sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

String aDate = sdf.format(new Date())

String OName = 'ATPSmokeTestOrder' + aDate

WebUI.setText(findTestObject('Catalog/OrderCart/OrderCartOrderName_Field'), OName)

WebUI.setText(findTestObject('Catalog/OrderCart/OrderCartOrderDescription_Field'), OName)

WebUI.click(findTestObject('Catalog/OrderCart/OrderCartPreviewOrder_Button'))

WebUI.click(findTestObject('Catalog/OrderCart/OrderCartPlaceOrder_Button'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.click(findTestObject('OKButton'))

WebUI.callTestCase(findTestCase('Utilities/CatalogSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

