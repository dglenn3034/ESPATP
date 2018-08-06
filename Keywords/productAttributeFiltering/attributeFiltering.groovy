package productAttributeFiltering

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
/*
 * Assumes the product selector dialog is open 
 * clicks the appropriate product filter button
 * adds a line
 * sets the name field
 * sets the operator
 * sets the value
 * clicks OK
 */
public class attributeFiltering {

	@Keyword
	def SetAttributeFilter (String ProductName, String Operator, String AttributeName, String AttributeValue, Boolean IsDate) {

		def Integer clsNdx

		/* set Product Filter */
		clsNdx = SetProductFilter (ProductName)
		println ('Found ' + clsNdx.toString() + ' Clauses')

		/* set the attribute name */
		SetAttributeName (AttributeName, clsNdx)

		/* set the value */
		SetAttributeValue (AttributeValue, IsDate, clsNdx)
		
		/* set the operator */
		SetOperatorValue (Operator, clsNdx)

		/* OK */
		WebUI.click(findTestObject('Catalog/ProductSelection/AttributeFilterOK_Button'))
	}

	def SetProductFilter (String ProductName) {
		def String Xp = null
		def TestObject tmpObject = null
		def TestObject myObj = findTestObject('Catalog/ProductSelection/ProductFilter')
		def String FilterXp = myObj.findPropertyValue('xpath')
		def Integer clsNdx = 1

		/* click the Product filter to get the attribute filter dialog open */
		Xp = FilterXp.replace('PRODUCT', ProductName)
		tmpObject = WebUI.modifyObjectProperty(myObj, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)

		/* wait on dialog (for some reason) */
		WebUI.verifyElementClickable(findTestObject('Catalog/ProductSelection/AttributeFilterAddLine_Button'))

		/* add a clause */
		WebUI.click(findTestObject('Catalog/ProductSelection/AttributeFilterAddLine_Button'))

		/* get the number of clauses now added */
		myObj = findTestObject('Catalog/ProductSelection/AttributeFilterNextClause')
		FilterXp = myObj.findPropertyValue('xpath')
		Xp = FilterXp.replace('ROWNDX','1')
		tmpObject = WebUI.modifyObjectProperty(myObj, 'xpath', 'equals', Xp, true)

		while (clsNdx < 10) {
			try {
				WebUI.verifyElementPresent(tmpObject, 1)
				println (' Found clause number ' + clsNdx.toString() )
				clsNdx = clsNdx + 1
				Xp = Xp.replace((clsNdx-1).toString(),clsNdx.toString())
				tmpObject = WebUI.modifyObjectProperty(myObj, 'xpath', 'equals', Xp, true)
			}
			catch (Exception e) {
				clsNdx = clsNdx - 1
				println (clsNdx.toString() + ' clauses found')
				return clsNdx
			}
		}


		return clsNdx
	}

	def SetAttributeName (String AttributeName, Integer clsNdx) {
		def TestObject tmpObject = null
		def TestObject myObj = null
		def String FilterXp = null
		def String Xp = null


		/* set the attribute name */
		myObj = findTestObject('Catalog/ProductSelection/AttributeFilterAttributeNameDropdown')
		FilterXp = myObj.findPropertyValue('xpath')
		Xp = FilterXp.replace('ROWNDX', clsNdx.toString())
		Xp = Xp.replace('ATTNAME', AttributeName)
		tmpObject = WebUI.modifyObjectProperty(myObj, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)
	}

	def SetOperatorValue (String Operator, Integer clsNdx) {
		def TestObject tmpObject = null
		def TestObject myObj = null
		def String FilterXp = null
		def String Xp = null

		/* set the operator */
		myObj = findTestObject('Catalog/ProductSelection/AttributeFilterOperator')
		FilterXp = myObj.findPropertyValue('xpath')
		Xp = FilterXp.replace('ROWNDX', clsNdx.toString())
		Xp = Xp.replace('OPERATOR', Operator)
		tmpObject = WebUI.modifyObjectProperty(myObj, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)
	}

	def SetAttributeValue (String AttributeValue, Boolean IsDate, Integer clsNdx) {
		def TestObject tmpObject = null
		def TestObject myObj = null
		def String Xp = null
		def String FilterXp = null

		/* set the value */
		if (IsDate == true) {
			myObj = findTestObject('Catalog/ProductSelection/AttributeFilterDateValue_Field')
		}
		else {
			myObj = findTestObject('Catalog/ProductSelection/AttributeFilterValue_Field')
		}
		FilterXp = myObj.findPropertyValue('xpath')
		Xp = FilterXp.replace('ROWNDX', clsNdx.toString())
		tmpObject = WebUI.modifyObjectProperty(myObj, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.setText(tmpObject, AttributeValue)
	}
}
