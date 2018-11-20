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
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

boolean found = true

println('Named Search to look for = ' + NamedSearch)

WebUI.delay(3)

WebUI.waitForElementClickable(findTestObject('Catalog/Main/CatalogNamedSearch_Button'), 3)

WebUI.click(findTestObject('Catalog/Main/CatalogNamedSearch_Button')) 

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

try {
    /*	def TestObject myNSObject = findTestObject('Catalog/NamedSearch/NamedSearch_SelectField')
	def String NSXp = myNSObject.findPropertyValue('xpath')
	println('NSXp = ' + NSXp)
	def String Xp = NSXp.replace('NS', NamedSearch)
	println('Xp = ' + Xp)

	def TestObject tmpObject = WebUI.modifyObjectProperty(myNSObject, 'xpath', 'equals', Xp, true)
	WebUiBuiltInKeywords.click(tmpObject) */
    WebUI.selectOptionByLabel(findTestObject('Catalog/NamedSearch/NamedSearch_SelectField'), NamedSearch, false)

    found = true
}
catch (Exception e) {
    println('No such Named Search')

    found = false /* throw new com.kms.katalon.core.exception.('No such Named Search') */ 
} 

return found

