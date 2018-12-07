package genericGrid

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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class gridOperations {
	@Keyword
	def ExecuteGridFunction (Integer rowNdx, String gridFunctionName) {
		def TestObject myGridObject = findTestObject('Grid/GridRowFunctions')
		def String GridXp = myGridObject.findPropertyValue('xpath')
		println('GridXp = ' + GridXp)
		def String Xp = GridXp.replace('ROWNDX', rowNdx.toString())
		println('Xp = ' + Xp)


		if (gridFunctionName == 'Open') {
			Xp = Xp.replace('CLASS', 'fa-folder-open')
		}
		else if (gridFunctionName == 'AOI') {
			Xp = Xp.replace('CLASS', 'fa-crosshairs')
		}
		else if (gridFunctionName == 'AddToOrderCart') {
			Xp = Xp.replace('CLASS', 'fa-cart-plus')
		}
		else if (gridFunctionName == 'AddToSearchResults') {
			Xp = Xp.replace('CLASS', 'fa-folder-open')
		}
		else if (gridFunctionName == 'Zoom') {
			Xp = Xp.replace('CLASS', 'fa-search-plus')
		}
		else if (gridFunctionName == 'Delete') {
			Xp = Xp.replace('CLASS', 'fa-times')
		}
		else if (gridFunctionName == 'Browse') {
			Xp = Xp.replace('CLASS', 'fa-cogs')
		}
		else if (gridFunctionName == 'Show Image on Map') {
			Xp = Xp.replace('CLASS', 'fa-globe')
		}
		else if (gridFunctionName == 'Add to Workingset') {
			Xp = Xp.replace('CLASS', 'fa-gavel')
		}
		else if (gridFunctionName == 'Show Detail') {
			Xp = Xp.replace('CLASS', 'fa-file-image')
		}
		else if (gridFunctionName == 'Remove') {
			Xp = Xp.replace('CLASS', 'shopping-cart')
		}
		else if (gridFunctionName == 'Details') {
			Xp = Xp.replace('CLASS', 'fa-cubes')
		}
		else if (gridFunctionName == 'Popup') {
			Xp = Xp.replace('CLASS', 'file-image')
		}

		def TestObject tmpObject = WebUI.modifyObjectProperty(myGridObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)
	}
	@Keyword
	def ColumnFilter (String colName ) {
		def TestObject myGridObject = findTestObject('Grid/ColumnFilter')
		def String GridXp = myGridObject.findPropertyValue('xpath')
		println('GridXp = ' + GridXp)
		def String Xp = GridXp.replace('COLNAME', colName)
		println('Xp = ' + Xp)

		def TestObject tmpObject = WebUI.modifyObjectProperty(myGridObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)
	}

	@Keyword
	def ColumnFilterByString (String colName, String filterValue ) {
		def TestObject myGridObject = findTestObject('Grid/ColumnFilter')
		def String GridXp = myGridObject.findPropertyValue('xpath')
		println('GridXp = ' + GridXp)
		def String Xp = GridXp.replace('COLNAME', colName)
		println('Xp = ' + Xp)

		def TestObject tmpObject = WebUI.modifyObjectProperty(myGridObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)

		def TestObject myLikeFilterObject = findTestObject('Grid/LikeFilter')
		def String LikeFilterXp = myLikeFilterObject.findPropertyValue('xpath')

		Xp = LikeFilterXp.replace('Column', colName)
		println('Like Filter Xp = ' + Xp)
		tmpObject = WebUI.modifyObjectProperty(myLikeFilterObject, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.setText(tmpObject, filterValue)
	}

	@Keyword
	def SetGridJustOneColumn (String columnName) {

		/* clear columns */
		ClearColumns()

		/* add one column */
		Boolean First = false
		AddOneColumn(columnName, First)
	}
	@Keyword
	def AddOneColumn (String columnName, Boolean First) {
		println ('Checking column' + columnName)
		def TestObject myCheckBoxObject = findTestObject('Grid/ColumnDropdowncheckbox')
		def String ChkBoxXp = myCheckBoxObject.findPropertyValue('xpath')

		def TestObject myCheckBoxLabelObject = findTestObject('Grid/ColumnDropdownLabel')
		def String ChkBoxLabelXp = myCheckBoxLabelObject.findPropertyValue('xpath')

		def Integer checkedCount = 0
		def Integer ndx = 1
		def String sndx, Xp
		def boolean found = false

		WebUI.click(findTestObject('Grid/ColumnToggleGear'))

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
				if (First) {
					WebUiBuiltInKeywords.uncheck(myObjBox)
				}
				ndx = ndx + 1
			}
		}

		WebUI.click(findTestObject('Grid/ColumnToggleGear'))

		if (ndx == 20) {
			throw new com.kms.katalon.core.exception.StepFailedException('Failed to find column name = ' + columnName)
		}
	}
	@Keyword
	def ClearColumns ( ) {
		println ('Clearing Columns')
		def TestObject myCheckBoxObject = findTestObject('Grid/ColumnDropdowncheckbox')
		def String ChkBoxXp = myCheckBoxObject.findPropertyValue('xpath')

		def TestObject myObjBox
		def Integer ndx = 1
		def String sndx, Xp

		WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

		WebUI.click(findTestObject('Grid/ColumnToggleGear'))

		/* arbitrary stop point of 20 for ndx */
		while (ndx < 20 ) {
			sndx = ndx.toString()
			Xp = ChkBoxXp.replace('NDX', sndx)
			myObjBox = WebUI.modifyObjectProperty(myCheckBoxObject, 'xpath', 'equals', Xp, true)
			try {
				WebUiBuiltInKeywords.uncheck(myObjBox)
			}
			catch (Exception e) {
				WebUI.click(findTestObject('Grid/ColumnToggleGear'))
				return
			}
			ndx = ndx + 1
		}

		WebUI.click(findTestObject('Grid/ColumnToggleGear'))

		if (ndx == 20) {
			throw new com.kms.katalon.core.exception.StepFailedException('Tried to uncheck more than 20 items')
		}
	}
	@Keyword
	def SelectRow (Integer rowNdx, Boolean mouseOver) {
		def TestObject myCheckBoxObject = findTestObject('Grid/SelectRow')
		def String Xp = myCheckBoxObject.findPropertyValue('xpath')
		def TestObject myObjBox

		Xp = Xp.replace('ROWNDX', rowNdx.toString())

		myObjBox = WebUI.modifyObjectProperty(myCheckBoxObject, 'xpath', 'equals', Xp, true)

		if (mouseOver == true) {
			WebUiBuiltInKeywords.mouseOver(myObjBox)
		}
		else {
			WebUiBuiltInKeywords.click(myObjBox)
		}
	}
}