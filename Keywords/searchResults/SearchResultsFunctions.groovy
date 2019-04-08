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

/*
 * Collection of custom Keywords to use with the Search Results Grid - Covered Products Tab control set
 */

public class searchResults {

	@Keyword
	def sortByName (String columnName) {
		println ('Sorting on ' + columnName)
		def TestObject myColumnSortObject = findTestObject('Catalog/SearchResults/CoveredAreasTab/ColumnSort')
		def String ColumnSortXp = myColumnSortObject.findPropertyValue('xpath')
		println('ColumnSortXp = ' + ColumnSortXp)
		def String Xp = ColumnSortXp.replace('Column', columnName)
		println('Modified Column Sort Xp = ' + Xp)
		def TestObject tmpObject = WebUI.modifyObjectProperty(myColumnSortObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)
	}

	@Keyword
	def LikeFilterOnColumn (String columnName, String nameValue) {
		println ('Filtering on ' + columnName + ' for ' + nameValue)

		def TestObject myColumnFilterObject = findTestObject('Catalog/SearchResults/CoveredAreasTab/ColumnFilter')
		def String ColumnFilterXp = myColumnFilterObject.findPropertyValue('xpath')
		def String Xp = ColumnFilterXp.replace('Column', columnName)
		println('Modified Column Filter Xp = ' + Xp)
		def TestObject tmpObject = WebUI.modifyObjectProperty(myColumnFilterObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)

		def TestObject myLikeFilterObject = findTestObject('Grid/LikeFilter')
		def String LikeFilterXp = myLikeFilterObject.findPropertyValue('xpath')

		Xp = LikeFilterXp.replace('Column', columnName)
		println('Like Filter Xp = ' + Xp)
		tmpObject = WebUI.modifyObjectProperty(myLikeFilterObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.setText(tmpObject, nameValue)
	}

	@Keyword
	def NumericFilterOnColumn (String columnName, String GTValue, String LTValue) {
		println ('Filtering on ' + columnName + ' [' + GTValue + ',' + LTValue + ']')

		def TestObject myColumnFilterObject = findTestObject('Catalog/SearchResults/CoveredAreasTab/ColumnFilter')
		def String ColumnFilterXp = myColumnFilterObject.findPropertyValue('xpath')
		def String Xp = ColumnFilterXp.replace('Column', columnName)
		println('Modified Column Filter Xp = ' + Xp)
		def TestObject tmpObject = WebUI.modifyObjectProperty(myColumnFilterObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)

		def TestObject myNumericFilterObject = findTestObject('Catalog/SearchResults/CoveredAreasTab/NumericFilter')
		def String NumericFilterXp = myNumericFilterObject.findPropertyValue('xpath')

		Xp = NumericFilterXp.replace('OPERATOR', '≥ ')
		println('Modified Column Filter Xp = ' + Xp)
		tmpObject = WebUI.modifyObjectProperty(myNumericFilterObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.setText(tmpObject, GTValue)

		Xp = NumericFilterXp.replace('OPERATOR', '≤ ')
		println('Modified Column Filter Xp = ' + Xp)
		tmpObject = WebUI.modifyObjectProperty(myNumericFilterObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.setText(tmpObject, LTValue)
	}

	@Keyword
	def VerifyValueInGrid (Integer colNdx, Integer rowIndex, String aValue) {

		println ('Verifying that row ' + rowIndex.toString() + ' for column ' + colNdx.toString() + ' has value = ' + aValue)

		/* make sure the column is present 
		 WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsFieldsToggle_button'))
		 */

		/* 'check' the column 
		 def Integer colIndex = GetSetColumn (columnName)
		 println ('Index for column = ' + colIndex)
		 */

		/* colIndex = colIndex + 2 bump over to skip first two columns of icons */

		/* validate the value is in the field specified */
		def TestObject myValueObject = findTestObject('Catalog/SearchResults/CoveredAreasTab/GridValue')
		def String ValXp = myValueObject.findPropertyValue('xpath')

		def String Xp = ValXp.replace('COLNDX', colNdx.toString())
		Xp = Xp.replace('ROWNDX', rowIndex.toString())
		println('Value Xp = ' + Xp)
		def TestObject tmpValObject = WebUI.modifyObjectProperty(myValueObject, 'xpath', 'equals', Xp, true)
		def String txtVal = WebUiBuiltInKeywords.getText(tmpValObject)
		println('Value = ' + txtVal)
		WebUI.verifyElementText(tmpValObject, aValue)
	}
	@Keyword
	def GetSetColumn (String columnName) {
		println ('Searching for index for ' + columnName)


		def TestObject myCheckBoxObject = findTestObject('Catalog/SearchResults/CoveredAreasTab/ColumnCheckbox')
		def String ChkBoxXp = myCheckBoxObject.findPropertyValue('xpath')

		def TestObject myCheckBoxLabelObject = findTestObject('Catalog/SearchResults/CoveredAreasTab/ColumnCheckboxLabel')
		def String ChkBoxLabelXp = myCheckBoxLabelObject.findPropertyValue('xpath')

		def Integer checkedCount = 0
		def Integer ndx = 1
		def Integer colNdx = 0
		def String sndx, Xp
		def boolean found = false

		WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsFieldsToggle_button'))

		/* arbitrary stop point of 20 for ndx */
		while (colNdx < 1 && ndx < 20 && found == false) {

			sndx = ndx.toString()
			Xp = ChkBoxLabelXp.replace('NDX', sndx)
			println ('Xpath for next Check Box Label = ' + Xp)
			def TestObject myObjLabel = WebUI.modifyObjectProperty(myCheckBoxLabelObject, 'xpath', 'equals', Xp, true)

			Xp = ChkBoxXp.replace('NDX', sndx)
			def TestObject myObjBox = WebUI.modifyObjectProperty(myCheckBoxObject, 'xpath', 'equals', Xp, true)

			def String cName = WebUI.getText(myObjLabel)
			println ('retrieved text for column ' + sndx + ' = ' + cName)

			if (cName == columnName) {

				/* check the box */
				WebUiBuiltInKeywords.check(myObjBox)
				found = true
				colNdx = checkedCount + 1
			}
			else {

				def String val = WebUI.getAttribute(myObjBox, 'checked')
				if (val == 'true') {
					checkedCount = checkedCount + 1
				}
			}
			ndx = ndx + 1
		}

		WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsFieldsToggle_button'))

		if (ndx == 20) {
			throw new com.kms.katalon.core.exception.StepFailedException('Failed to find column name = ' + columnName)
		}

		return colNdx
	}
	@Keyword
	def SetSearchResultsColumnFirst (String columnName) {
		println ('Setting SR Grid to one column' + columnName)
		def TestObject myCheckBoxObject = findTestObject('Catalog/SearchResults/CoveredAreasTab/ColumnCheckbox')
		def String ChkBoxXp = myCheckBoxObject.findPropertyValue('xpath')

		def TestObject myCheckBoxLabelObject = findTestObject('Catalog/SearchResults/CoveredAreasTab/ColumnCheckboxLabel')
		def String ChkBoxLabelXp = myCheckBoxLabelObject.findPropertyValue('xpath')

		def Integer checkedCount = 0
		def Integer ndx = 1
		def String sndx, Xp
		def boolean found = false

		WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsFieldsToggle_button'))

		/* arbitrary stop point of 20 for ndx */
		while (ndx < 20 && found == false) {
			sndx = ndx.toString()
			Xp = ChkBoxLabelXp.replace('NDX', sndx)
			println ('Xpath for next Check Box Label = ' + Xp)
			def TestObject myObjLabel = WebUI.modifyObjectProperty(myCheckBoxLabelObject, 'xpath', 'equals', Xp, true)

			Xp = ChkBoxXp.replace('NDX', sndx)
			def TestObject myObjBox = WebUI.modifyObjectProperty(myCheckBoxObject, 'xpath', 'equals', Xp, true)

			def String cName = WebUI.getText(myObjLabel)
			println ('retrieved text for column ' + sndx + ' = ' + cName)

			if (cName == columnName) {

				/* check the box */
				WebUiBuiltInKeywords.check(myObjBox)
				found = true
			}
			else {
				WebUiBuiltInKeywords.uncheck(myObjBox)
			}
			ndx = ndx + 1
		}

		WebUI.click(findTestObject('Catalog/SearchResults/SearchResultsFieldsToggle_button'))

		if (ndx == 20) {
			throw new com.kms.katalon.core.exception.StepFailedException('Failed to find column name = ' + columnName)
		}
		return ndx
	}
}
