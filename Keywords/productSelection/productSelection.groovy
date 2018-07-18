package productSelection

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


public class productSelection {
	@Keyword
	def clearAllProducts () {
		println ('Clearing all products')
		def TestObject myObj = findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelectionAnyCheckBox')
		def String FilterXp = myObj.findPropertyValue('xpath')
		def Integer ndx=1
		def String Xp = null
		def TestObject tmpObject = null

		while ( ndx < 20) {

			Xp = FilterXp.replace('CHKNDX', ndx.toString(ndx))
			tmpObject = WebUI.modifyObjectProperty(myObj, 'xpath', 'equals', Xp, true)
			println('Modified Product Filter Xp = ' + Xp)

			try {
				WebUiBuiltInKeywords.verifyElementPresent(tmpObject, 2, FailureHandling.STOP_ON_FAILURE)
				WebUiBuiltInKeywords.uncheck(tmpObject)
				ndx = ndx + 1
			}
			catch (Exception e) {
				println ('cleared all products')
				return
			}
		}
		return
	}



	@Keyword
	def SelectProduct (String productName) {
		println ('Set Product Selection for ' + productName)
		def TestObject myObj = findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelector')
		def String FilterXp = myObj.findPropertyValue('xpath')
		def String Xp = FilterXp.replace('PRODUCT', productName)
		println('Modified Product Filter Xp = ' + Xp)
		def TestObject tmpObject = WebUI.modifyObjectProperty(myObj, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)
		return
	}

	@Keyword
	def SelectChildProduct (String productName, String childName) {
		println ('Set Product Child Selection for ' + productName + ' - ' + childName)
		def TestObject myObj = findTestObject('Page_Earth Sensor Portal/ProductSelection/ChildProductSelector')
		def String FilterXp = myObj.findPropertyValue('xpath')
		def String Xp = null
		def TestObject tmpObject = null

		Xp = FilterXp.replace('PRODUCT', productName)
		Xp = Xp.replace('CHILD', childName)
		println('Modified Child Product Filter Xp = ' + Xp)

		tmpObject = WebUI.modifyObjectProperty(myObj, 'xpath', 'equals', Xp, true)
		WebUiBuiltInKeywords.click(tmpObject)
		return
	}
}
