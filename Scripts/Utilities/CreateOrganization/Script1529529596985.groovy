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

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Organizations/a_Organizations'))

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Name')

WebUI.setText(findTestObject('Grid/LikeFilter'), Name)

try {
    WebUI.verifyElementPresent(findTestObject('Grid/NoRecordsExist'), 2)

    println(Name + 'does not exist, will create')
}
catch (Exception e) {
    println(Name + ' already exists deleting...')

    /* todo: add code to delete it */
    WebUiBuiltInKeywords.click(findTestObject('Admin Console/AdminDeleteRowOne'))

    WebUiBuiltInKeywords.click(findTestObject('OKButton'))

    WebUI.delay(5)
} 
finally { 
}

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Organizations/AddOrganizationButton'))

WebUiBuiltInKeywords.setText(findTestObject('Admin Console/Organizations/OrganizationName'), Name)

WebUiBuiltInKeywords.setText(findTestObject('Admin Console/Organizations/OrganizationDescription'), Description)

not_run: WebUiBuiltInKeywords.setText(findTestObject('Admin Console/Organizations/OrganizationDeliveryBucket'), GlobalVariable.GeoCueDeliveryBucket)

WebUiBuiltInKeywords.setText(findTestObject('Admin Console/Organizations/OrganizationDeliveryPrefix'), GlobalVariable.GeoCueDeliveryPrefix)

/* set default group */
TestObject myObject = findTestObject('Admin Console/Organizations/OrganizationGroupPulldown')

String Xp = myObject.findPropertyValue('xpath')

println('Xp = ' + Xp)

Xp = Xp.replace('GROUP', Group)

TestObject tmpObject = WebUI.modifyObjectProperty(myObject, 'xpath', 'equals', Xp, true)

WebUiBuiltInKeywords.click(tmpObject, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Admin Console/Organizations/OrganizationDomain'), Domain)

WebUI.setText(findTestObject('Admin Console/Organizations/OrganizationQuota'), '5368709120')

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Organizations/OrganizationSaveButton'))

'Wait on success message to clear'
WebUI.delay(2)

WebUI.click(findTestObject('Admin Console/Organizations/OrganizationRefresh_Button'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

