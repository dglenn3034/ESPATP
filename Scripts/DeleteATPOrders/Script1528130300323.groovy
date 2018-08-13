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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'System Admin'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.AdminSite)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/a_ System Information'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Order Name')

WebUiBuiltInKeywords.setText(findTestObject('Grid/LikeFilter'), 'ATP')

'Added to allow first Like box to be removed'
WebUI.delay(2)

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Company Name')

WebUiBuiltInKeywords.setText(findTestObject('Grid/LikeFilter'), 'GeoCue')

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Status')

WebUI.waitForElementClickable(findTestObject('Admin Console/SystemInformation/Status_CREATEDCheckbox'), 3)

WebUI.uncheck(findTestObject('Admin Console/SystemInformation/Status_CREATEDCheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Admin Console/SystemInformation/Status_STARTEDCheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Admin Console/SystemInformation/Status_SUBMITTEDCheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Admin Console/SystemInformation/Status_FAILURECheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Admin Console/SystemInformation/Status_WARNINGCheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Admin Console/SystemInformation/Status_CANCELEDCheckbox'))

WebUiBuiltInKeywords.uncheck(findTestObject('Admin Console/SystemInformation/Status_REJECTEDCheckbox'))

countOrders = WebUI.getText(findTestObject('Admin Console/SystemInformation/TotalOrders_Field'))

CustomKeywords.'genericGrid.gridOperations.AddOneColumn'('Order Name', true)

int iCountOrders = Integer.parseInt(countOrders)

while (iCountOrders > 0) {
    println('Number of Orders = ' + countOrders)

    WebUI.callTestCase(findTestCase('Utilities/JustDeleteOneATPOrder'), [:], FailureHandling.STOP_ON_FAILURE)

    countOrders2 = WebUI.getText(findTestObject('Admin Console/SystemInformation/TotalOrders_Field'))

    int iCountOrders2 = Integer.parseInt(countOrders2)

    println('Number of Orders after delete = ' + countOrders2)

    if (iCountOrders == iCountOrders2) {
		throw new com.kms.katalon.core.exception.StepFailedException ('Delete Order failed - ')
		println ('failed to delete order')
    }
	else {
        iCountOrders = iCountOrders2
        countOrders = countOrders2
    }
}

WebUI.callTestCase(findTestCase('Utilities/AdminConsoleSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

