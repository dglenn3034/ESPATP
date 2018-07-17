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

println ('Searching for index for ' + ColumnName)


myCheckBoxObject = findTestObject('Page_Earth Sensor Portal/SearchResults/CoveredAreasTab/ColumnCheckbox')
ChkBoxXp = myCheckBoxObject.findPropertyValue('xpath')

myCheckBoxLabelObject = findTestObject('Page_Earth Sensor Portal/SearchResults/CoveredAreasTab/ColumnCheckboxLabel')
ChkBoxLabelXp = myCheckBoxLabelObject.findPropertyValue('xpath')

checkedCount = 0
ndx = 1
colNdx = 0


while (colNdx < 1 && ndx < 11) {

	sndx = ndx.toString()
	Xp = ChkBoxXp.replace('NDX', sndx)
    myObj = WebUI.modifyObjectProperty(myCheckBoxObject, 'xpath', 'equals', Xp, true)
    cName = WebUI.getAttribute (myObj,'name')
	
    if (cName == ColumnName) {
		
		/* check the box */ 
		WebUiBuiltInKeywords.check(myObj)

		colNdx = checkedCount + 1
	}
    else {

		val = WebUI.getAttribute(myObj, 'checked')
		if (val == 'true') {
			checkedCount = checkedCount + 1
		}
	} 
	ndx = ndx + 1
} 

return colNdx
