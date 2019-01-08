import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.eclipse.persistence.jpa.jpql.Assert as Assert
import org.eclipse.persistence.jpa.jpql.Assert.AssertException as AssertException
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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'QC Analyst', ('Company') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.QCSite)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

'Click here to get Cesium Help to disappear'
WebUI.click(findTestObject('Cesium/canvas'))

WebUI.click(findTestObject('QCAnalyst/QCAnalystProjects_Button'))

WebUI.click(findTestObject('QCAnalyst/Projects/ProjectAddLine'))

WebUI.click(findTestObject('QCAnalyst/Projects/ProjectFilterAttributeName_Dropdown'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('QCAnalyst/Projects/ProjectFilterProjectName_field'), 'Davidson')

WebUI.click(findTestObject('OKButton'))

CustomKeywords.'genericGrid.gridOperations.ExecuteGridFunction'(1, 'Open')

WebUI.verifyElementText(findTestObject('QCAnalyst/ProjectItems/DisplayCount'), 'Displaying 999 of 999 Item(s)')

WebUI.callTestCase(findTestCase('Utilities/QCAnalystSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

