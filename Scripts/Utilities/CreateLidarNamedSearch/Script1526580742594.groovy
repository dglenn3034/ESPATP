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

WebUI.click(findTestObject('Catalog/Main/CatalogProducts_Button'))

CustomKeywords.'productSelection.productSelection.SelectProduct'('Airborne LIDAR')

CustomKeywords.'productAttributeFiltering.attributeFiltering.SetAttributeFilter'('Airborne LIDAR', 'Like', 'Name', 'DavCo_A', 
    false)

WebUI.click(findTestObject('Catalog/ProductSelection/ProductSelection_OK', [('variable') : '']))

WebUI.click(findTestObject('Catalog/Main/CatalogAOIImport_Button'))

WebUI.sendKeys(findTestObject('Catalog/AOI/AOIFIlePath_Field'), 'Z:\\ESP\\Test_data\\Davidson_County_Digitized.zip')

WebUI.click(findTestObject('Catalog/AOI/AOIExecutetheImport_button'))

WebUI.waitForElementVisible(findTestObject('Catalog/SearchResults/SearchResults_Grid'), 0)

WebUI.waitForElementClickable(findTestObject('Catalog/Main/CatalogSaveNamedSearch_Button'), 2)

WebUI.click(findTestObject('Catalog/Main/CatalogSaveNamedSearch_Button'))

WebUI.setText(findTestObject('Catalog/NamedSearch/NamedSearchSaveName_Field'), NamedSearch)

WebUI.click(findTestObject('Catalog/NamedSearch/SaveNamedSearchSave_Button'))

