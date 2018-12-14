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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'QC Analyst'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.QCSite)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

not_run: WebUI.click(findTestObject('Cesium/canvas'))

WebUI.click(findTestObject('QCAnalyst/QCAnalystProjects_Button'))

WebUI.click(findTestObject('QCAnalyst/Projects/ProjectAddLine'))

WebUI.setText(findTestObject('QCAnalyst/Projects/ProjectFilterProjectName_field'), 'Davidson')

WebUI.click(findTestObject('OKButton'))

CustomKeywords.'genericGrid.gridOperations.ExecuteGridFunction'(1, 'Open')

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

try {
    WebUI.click(findTestObject('QCAnalyst/WorkingSet/WorkingSetCountBadge'))

    WebUI.click(findTestObject('QCAnalyst/WorkingSet/WorkingSetClearSet_Button'))

    WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

    WebUI.click(findTestObject('QCAnalyst/WorkingSet/WorkingSetDismiss_Button'))
}
catch (Exception e) {
    /* do nothing if working set is empty */
    println('working set is empty to start with')
} 

CustomKeywords.'genericGrid.gridOperations.AddOneColumn'('Name', true)

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Name')

WebUiBuiltInKeywords.setText(findTestObject('Grid/LikeFilter'), 'DavCo_AA')

WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/ProjectItems/ProjectItemsSelectAll'))

WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/ProjectItems/ProjectItemsAddtoWorkingSet'))

WebUI.waitForElementVisible(findTestObject('QCAnalyst/WorkingSet/WorkingSetCountBadge'), 3)

WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/WorkingSet/WorkingSetCountBadge'))

WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/WorkingSet/WorkingSetSelectProcess'))

WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/WorkingSet/WorkingSetGeneratePyramidsRadio'))

WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/WorkingSet/WorkingSetExecuteProcess'))

WebUiBuiltInKeywords.click(findTestObject('OKButton'))

WebUI.waitForElementClickable(findTestObject('QCAnalyst/WorkingSet/ReadyToExecuteOKButton'), 5)

WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/WorkingSet/ReadyToExecuteOKButton'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.click(findTestObject('OKButton'))

WebUI.callTestCase(findTestCase('Utilities/QCAnalystSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

