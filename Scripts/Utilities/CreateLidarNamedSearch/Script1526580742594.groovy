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

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogProducts_Button'))

WebUiBuiltInKeywords.check(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelectionAirborne_Lidar_Checkbox'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelectionAirborneLidar_Filter_button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/AttributeFilter_AddLineButton'))

WebUI.selectOptionByLabel(findTestObject('Page_Earth Sensor Portal/ProductSelection/AttributeFilterAttributeName_Dropdown'), 
    'Name', false, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/ProductSelection/AttributeLikeFilterValue_Field'), 'DavCo_BH')

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelection_OK', [('variable') : '']))

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogAOIImport_Button'))

WebUI.sendKeys(findTestObject('Page_Earth Sensor Portal/AOI/AOIFIlePath_Field'), 'Z:\\ESP\\Test_data\\Davidson_County_Digitized.zip')

WebUI.click(findTestObject('Page_Earth Sensor Portal/AOI/AOIExecutetheImport_button'))

WebUI.waitForElementVisible(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResults_Grid'), 0)

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogSaveNamedSearch_Button'), 2)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogSaveNamedSearch_Button'))

WebUI.setText(findTestObject('Page_Earth Sensor Portal/NamedSearch/NamedSearchSaveName_Field'), NamedSearch)

WebUI.click(findTestObject('Page_Earth Sensor Portal/NamedSearch/SaveNamedSearchSave_Button'))

