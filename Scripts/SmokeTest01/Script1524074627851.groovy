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

WebUI.callTestCase(findTestCase('GetLoginInfo'), [('Site') : 'dummy.com', ('username') : '', ('pwd') : 'pwd'], FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.site)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/Canvas'))

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogNamedSearch_Button'), 3)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogNamedSearch_Button'))

WebUI.selectOptionByLabel(findTestObject('Page_Earth Sensor Portal/NamedSearch/NamedSearch_SelectField'), 'SmokeTest01', 
    true, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page_Earth Sensor Portal/NamedSearch/NamedSearch_DeleteButton'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page_Earth Sensor Portal/NamedSearch/NamedSearchesCancel_Button'), FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogProducts_Button'), 3)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogProducts_Button'))

WebUiBuiltInKeywords.check(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductselectionLandsat8NDVI_Checkbox'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelectionLandsat8Filter_button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductFilter_AddLineButton'))

WebUI.setText(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductFilter_DateSelectorField'), '01/01/2017')

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelection_OK', [('variable') : '']))

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogAOIImport_Button'))

WebUI.sendKeys(findTestObject('Page_Earth Sensor Portal/AOI/AOIFIlePath_Field'), '\\\\diskstation1\\Data\\Rob_MUSES\\Shapefile_test_datasets\\AL.kmz')

WebUI.click(findTestObject('Page_Earth Sensor Portal/AOI/AOIExecutetheImport_button'))

WebUI.waitForElementVisible(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResults_Grid'), 0)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Histograms/HistogramShowHideFilters_button'))

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Histograms/HistogramFiltersList_Button'), 0)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Histograms/HistogramFiltersList_Button'))

WebUI.check(findTestObject('Page_Earth Sensor Portal/Histograms/HistogramCloudCoverageFull_CheckBox'))

WebUI.check(findTestObject('Page_Earth Sensor Portal/Histograms/HistogramSunElevation_CheckBox'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Histograms/HistogramSunElevation_button'))

WebUI.setText(findTestObject('Page_Earth Sensor Portal/Histograms/HistogramOpenFilterFirstValue_input'), '0')

WebUI.setText(findTestObject('Page_Earth Sensor Portal/Histograms/HistogramOpenFilterSecondvalue_Field'), '40')

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogSaveNamedSearch_Button'), 2)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogSaveNamedSearch_Button'))

WebUI.setText(findTestObject('Page_Earth Sensor Portal/NamedSearch/NamedSearchSaveName_Field'), 'SmokeTest01')

WebUI.click(findTestObject('Page_Earth Sensor Portal/NamedSearch/SaveNamedSearchSave_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResults_SelectFirstRow'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsAddSelectedToCart_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCart_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartCheckout_Button'))

def date = new Date()

SimpleDateFormat sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

String aDate = sdf.format(new Date())

String OName = 'ATPSmokeTestOrder' + aDate

WebUI.setText(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartOrderName_Field'), OName)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartOrderDescription_Field'), OName)

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartPreviewOrder_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartPlaceOrder_Button'))

WebUI.delay(2)

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.callTestCase(findTestCase('Utilities/CatalogSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

