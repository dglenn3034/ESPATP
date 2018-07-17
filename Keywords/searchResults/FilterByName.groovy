package searchResults

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class searchResults {

	@Keyword
	def filterByName (String columnName) {
		println ('Filtering on ' + columnName)
		def TestObject myColumnFilterObject = findTestObject('Page_Earth Sensor Portal/SearchResults/CoveredAreasTab/ColumnFilter')
		def String ColumnFilterXp = myColumnFilterObject.findPropertyValue('xpath')
		println('ColumnFilterXp = ' + ColumnFilterXp)
		def String Xp = ColumnFilterXp.replace('Column', columnName)
		println('Modified Column Filter Xp = ' + Xp)
		def TestObject tmpObject = WebUI.modifyObjectProperty(myColumnFilterObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)
	}

	@Keyword
	def sortByName (String columnName) {
		println ('Sorting on ' + columnName)
		def TestObject myColumnSortObject = findTestObject('Page_Earth Sensor Portal/SearchResults/CoveredAreasTab/ColumnSort')
		def String ColumnSortXp = myColumnSortObject.findPropertyValue('xpath')
		println('ColumnSortXp = ' + ColumnSortXp)
		def String Xp = ColumnSortXp.replace('Column', columnName)
		println('Modified Column Sort Xp = ' + Xp)
		def TestObject tmpObject = WebUI.modifyObjectProperty(myColumnSortObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)
	}
}
