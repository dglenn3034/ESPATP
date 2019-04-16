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

WebUI.click(findTestObject('QCAnalyst/QCAnalystProjects_Button'))

try {
    WebUI.verifyElementPresent(findTestObject('QCAnalyst/Projects/ProjectFilterDeleteLine1'), 1)

    WebUI.click(findTestObject('QCAnalyst/Projects/ProjectFilterDeleteLine1'))
}
catch (Exception e) {
} 

WebUI.click(findTestObject('QCAnalyst/Projects/ProjectAddLine'))

/* assuming that the first line added is the Name field... Not good */
WebUI.click(findTestObject('QCAnalyst/Projects/ProjectFilterAttributeName_Dropdown'))

WebUI.setText(findTestObject('QCAnalyst/Projects/ProjectFilterProjectName_field'), ProjectName)

WebUI.click(findTestObject('QCAnalyst/Projects/ProjectsFilterOKBtn'))

/* 
'If filter is already set, skip to delete, otherwise create filter'
try {
    WebUI.verifyElementVisible(findTestObject('QCAnalyst/Projects/ProjectsDeleteFirstFilterRow_Button'))

    WebUI.click(findTestObject('OKButton'))
}
catch (Exception e) {
    WebUI.click(findTestObject('QCAnalyst/Projects/ProjectAddLine'))

    WebUI.setText(findTestObject('QCAnalyst/Projects/ProjectFilterProjectName_field'), ProjectName)

    WebUI.click(findTestObject('OKButton'))
} 
*/
try {
    WebUI.verifyElementText(findTestObject('Grid/NoRecordsExist'), 'No Records found.')

    println(ProjectName + 'does not exist')

    WebUI.click(findTestObject('QCAnalyst/Projects/ProjectsCloseDialog_Button'))

    /* dismiss projects grid */
    return null
}
catch (Exception e) {
    println(ProjectName + ' exists ')
} 
finally { 
}

WebUI.delay(2)

CustomKeywords.'genericGrid.gridOperations.ExecuteGridFunction'(1, 'Delete')

WebUI.check(findTestObject('QCAnalyst/Projects/input_isDeleteFromCatalog'))

if (DeleteSource) {
    WebUiBuiltInKeywords.check(findTestObject('QCAnalyst/Projects/input_isDeleteFromS3Source'))
}

WebUI.click(findTestObject('QCAnalyst/Projects/button_Delete'))

WebUiBuiltInKeywords.click(findTestObject('OKButton'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.click(findTestObject('OKButton'))

WebUiBuiltInKeywords.delay(5)

WebUI.click(findTestObject('QCAnalyst/Projects/ProjectsCloseDialog_Button'))

return null

