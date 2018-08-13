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

def String Ordername
def String Fieldname

Fieldname = WebUI.getText(findTestObject('Admin Console/SystemInformation/NameofFirstDataColumn'))

if (Fieldname.startsWith('Order Name')) {
	println ('Grid already set with Order Name first')
}
else {
	println ('Need to set Order Name as first in Grid')
	CustomKeywords.'genericGrid.gridOperations.SetGridJustOneColumn'('Order Name')
}

ordername = WebUI.getText(findTestObject('Admin Console/SystemInformation/NameofFirstOrder'))

CustomKeywords.'genericGrid.gridOperations.ExecuteGridFunction'(1, 'Delete')

WebUiBuiltInKeywords.check(findTestObject('Admin Console/SystemInformation/DeleteFromBucket_CheckBox'))

WebUiBuiltInKeywords.check(findTestObject('Admin Console/SystemInformation/SubtractFromQuota_CheckBox'))

WebUiBuiltInKeywords.click(findTestObject('Admin Console/SystemInformation/DeleteOrderContinue_Button'))

WebUiBuiltInKeywords.setText(findTestObject('Admin Console/SystemInformation/input_orderName'), ordername)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/SystemInformation/button_Confirm'))

WebUiBuiltInKeywords.click(findTestObject('OKButton'))

println('Deleted ' + ordername)

