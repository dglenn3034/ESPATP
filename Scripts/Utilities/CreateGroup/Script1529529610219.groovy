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

WebUI.click(findTestObject('Admin Console/Groups/a_ Groups'))

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Name')

WebUI.setText(findTestObject('Grid/LikeFilter'), Name)

try {
    WebUI.verifyElementPresent(findTestObject('Grid/NoRecordsExist'), 2)

    println(Name + 'does not exist, will create')
}
catch (Exception e) {
    println(Name + ' already exists skipping creation')

    return null
} 
finally { 
}

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Groups/GroupsAddGroup_Button'))

WebUiBuiltInKeywords.setText(findTestObject('Admin Console/Groups/GroupsName_Field'), Name)

WebUiBuiltInKeywords.setText(findTestObject('Admin Console/Groups/GroupsDescription_Field'), Description)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Groups/GroupsCopyfromUserGroup_Option'), FailureHandling.STOP_ON_FAILURE)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Groups/GroupsAddGroupSave_Button'))

WebUiBuiltInKeywords.delay(2)

WebUI.click(findTestObject('Admin Console/Groups/GroupsRefresh_Button'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

