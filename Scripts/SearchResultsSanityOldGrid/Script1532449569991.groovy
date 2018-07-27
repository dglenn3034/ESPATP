import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/* Login using credentials from login test object */
WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Site') : 'dummy.com', ('username') : '', ('pwd') : 'pwd'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.site)

WebUI.setText(findTestObject('Catalog/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Catalog/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Catalog/Signin_Button'))

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Cesium/canvas'))

boolean found = null

/* if named Search ATPSearchResultsSanity exists, delete it and recreate it */
found = WebUI.callTestCase(findTestCase('Utilities/NamedSearchExists'), [('NamedSearch') : 'ATPSearchResultsSanity'], FailureHandling.STOP_ON_FAILURE)

if (found) {
    println('Named Search ATPSearchResultsSanity does exist, we will delete it and recreate it')

    WebUI.click(findTestObject('Catalog/NamedSearch/NamedSearch_DeleteButton'), FailureHandling.OPTIONAL)

    WebUI.click(findTestObject('OKButton'), FailureHandling.STOP_ON_FAILURE)
} else {
    println('Named Search ATPSearchResultsSanity does not exist, we will create it')

    WebUI.click(findTestObject('Catalog/NamedSearch/NamedSearchesCancel_Button'))
}

WebUI.verifyElementClickable(findTestObject('Catalog/Main/CatalogProducts_Button'))

WebUI.click(findTestObject('Catalog/Main/CatalogProducts_Button'))

CustomKeywords.'productSelection.productSelection.SelectProduct'('Airborne LIDAR')

CustomKeywords.'productAttributeFiltering.attributeFiltering.SetAttributeFilter'('Airborne LIDAR', 'Like', 'Name', 'DavCo_A', 
    false)

WebUiBuiltInKeywords.click(findTestObject('Catalog/ProductSelection/ProductSelection_OK'))

WebUI.click(findTestObject('Catalog/Main/CatalogAOIImport_Button'))

WebUI.sendKeys(findTestObject('Catalog/AOI/AOIFIlePath_Field'), '\\\\diskstation1\\Data\\Rob_MUSES\\Shapefile_test_datasets\\Davidson_County_Digitized.zip')

WebUI.click(findTestObject('Catalog/AOI/AOIExecutetheImport_button'))

WebUI.waitForElementVisible(findTestObject('Catalog/SearchResults/SearchResults_Grid'), 10)

WebUiBuiltInKeywords.click(findTestObject('Catalog/Main/CatalogSaveNamedSearch_Button'))

WebUI.setText(findTestObject('Catalog/NamedSearch/NamedSearchSaveName_Field'), 'ATPSearchResultsSanity')

WebUiBuiltInKeywords.click(findTestObject('Catalog/NamedSearch/SaveNamedSearchSave_Button'))

/* verify starting count */
'Search Results Sanity Starts Here'
WebUiBuiltInKeywords.verifyElementText(findTestObject('Catalog/SearchResults/SearchResultsField_Displaying'), 
    'Displaying 486 of 486 Item(s)')

WebUI.verifyElementClickable(findTestObject('Catalog/SearchResults/SearchResultsFieldsToggle_button'))

/* make sure the Name and Total Number of Points columns are enabled */
WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsFieldsToggle_button'))

/* 'check' the name column */
Integer nameIndex = CustomKeywords.'searchResults.searchResults.GetSetColumn'('Name')

println('Index for Name = ' + nameIndex)

/* 'check' the Total Number Of Points column */
Integer totPtsIndex = CustomKeywords.'searchResults.searchResults.GetSetColumn'('Total Number Of Points')

println('Index for Total Number Of Points = ' + nameIndex)

/* sort on Name column */
CustomKeywords.'searchResults.searchResults.sortByName'('Name')

nameIndex = (nameIndex + 2 /* bump over to skip first two columns of icons */ )

/* Test value of Name field in first row */
CustomKeywords.'searchResults.searchResults.VerifyValueInGrid'('Name', 1, 'DavCo_AG28')

/* sort again - reverse */
CustomKeywords.'searchResults.searchResults.sortByName'('Name')

/* Test value of Name field in first row (note: column name is from HTML not database */
CustomKeywords.'searchResults.searchResults.VerifyValueInGrid'('Name', 1, 'DavCo_AZ33')

/* Filter 'Name' to Like 'DavCo_AZ' */
CustomKeywords.'searchResults.searchResults.LikeFilterOnColumn'('Name', 'DavCo_AZ')

/* Verify count */
WebUiBuiltInKeywords.verifyElementText(findTestObject('Catalog/SearchResults/SearchResultsField_Displaying'), 
    'Displaying 32 of 486 Item(s)')

/* clear filters */
WebUiBuiltInKeywords.click(findTestObject('Catalog/SearchResults/SearchResultsClearAllFilters_Button'))

/* recheck count */
WebUiBuiltInKeywords.verifyElementText(findTestObject('Catalog/SearchResults/SearchResultsField_Displaying'), 
    'Displaying 486 of 486 Item(s)')

/* Filter on Total number of points [3500000, 4000000] */
CustomKeywords.'searchResults.searchResults.NumericFilterOnColumn'('Total Number Of Points', '3500000', '4000000')

/* verify Count */
WebUiBuiltInKeywords.verifyElementText(findTestObject('Catalog/SearchResults/SearchResultsField_Displaying'), 
    'Displaying 135 of 486 Item(s)')

/* logout */
WebUI.callTestCase(findTestCase('Utilities/CatalogSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

