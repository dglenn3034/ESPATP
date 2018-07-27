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
import com.kms.katalon.core.testdata.ExcelData as ExcelData

ExcelData SRSData = findTestData('SearchResultsSanityData')

Integer rowNdx = 1

rowNdx = GlobalVariable.SRSRowNdx
ValidationString1 = SRSData.getValue(2, rowNdx)
ValidationString2 = SRSData.getValue(3, rowNdx)
ValidationString3 = SRSData.getValue(4, rowNdx)
ValidationString4 = SRSData.getValue(5, rowNdx)
ValidationString5 = SRSData.getValue(6, rowNdx)

println ("Validation String 1 = " + ValidationString1)
println ("Validation String 5 = " + ValidationString5)

WebUiBuiltInKeywords.click(findTestObject('Catalog/Main/CatalogNamedSearch_Button'))

WebUI.selectOptionByLabel(findTestObject('Catalog/NamedSearch/NamedSearch_SelectField'), 'ATPSearchResultsSanity', 
    false, FailureHandling.STOP_ON_FAILURE)

WebUiBuiltInKeywords.click(findTestObject('Catalog/NamedSearch/NamedSearchLoad_Button'))

'Search Results Sanity Starts Here'
WebUiBuiltInKeywords.verifyElementText(findTestObject('Catalog/SearchResults/SearchResultsField_Displaying'), 
    ValidationString1)

WebUI.verifyElementClickable(findTestObject('Catalog/SearchResults/SearchResultsFieldsToggle_button'))

/* make sure the Name and Total Number of Points columns are enabled */
WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsFieldsToggle_button'))

/* 'check' the name column */
Integer nameIndex = CustomKeywords.'searchResults.searchResults.GetSetColumn'('Name')

println('Index for Name = ' + nameIndex)

/* 'check' the Total Number Of Points column */
Integer totPtsIndex = CustomKeywords.'searchResults.searchResults.GetSetColumn'('Total Number Of Points')

println('Index for Total Number Of Points = ' + totPtsIndex)

/* sort on Name column */
CustomKeywords.'searchResults.searchResults.sortByName'('Name')

nameIndex = nameIndex + 2 /* bump over to skip first two columns of icons */ 

/* Test value of Name field in first row */
CustomKeywords.'searchResults.searchResults.VerifyValueInGrid'(nameIndex, 2, ValidationString2)

/* sort again - reverse */
CustomKeywords.'searchResults.searchResults.sortByName'('Name')

/* Test value of Name field in first row (note: column name is from HTML not database */
CustomKeywords.'searchResults.searchResults.VerifyValueInGrid'(nameIndex, 2, ValidationString3)

/* Filter 'Name' to Like 'DavCo_AZ' */
CustomKeywords.'searchResults.searchResults.LikeFilterOnColumn'('Name', 'DavCo_AG')

/* Verify count */
WebUiBuiltInKeywords.verifyElementText(findTestObject('Catalog/SearchResults/SearchResultsField_Displaying'), 
    ValidationString4)

/* clear filters */
WebUiBuiltInKeywords.click(findTestObject('Catalog/SearchResults/SearchResultsClearAllFilters_Button'))

/* recheck count */
WebUiBuiltInKeywords.verifyElementText(findTestObject('Catalog/SearchResults/SearchResultsField_Displaying'), 
    ValidationString1)

/* Filter on Total number of points [3500000, 4000000] */
CustomKeywords.'searchResults.searchResults.NumericFilterOnColumn'('Total Number Of Points', '4500000', '4800000')

/* verify Count */
WebUiBuiltInKeywords.verifyElementText(findTestObject('Catalog/SearchResults/SearchResultsField_Displaying'), 
    ValidationString5)

