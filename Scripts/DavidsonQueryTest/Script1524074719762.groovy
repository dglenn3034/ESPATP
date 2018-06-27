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

WebUI.callTestCase(findTestCase('Utilities/GetLoginInfo'), [('Site') : 'dummy.com', ('username') : '', ('pwd') : 'pwd'], FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.QCSite)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/canvas'), 5)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Canvas'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/QCAnalystProjects_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectAddLine'))

WebUI.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectFilterProjectName_field'), 'Davidson')

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.check(findTestObject('Page_Earth Sensor Portal/QCAnalyst/Projects/ProjectsOpenFirstItem'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectItems/ProjectItemsCountLabel'), 'Displaying 1072 of 1072 Item(s)')

WebUI.callTestCase(findTestCase('Utilities/QCAnalystSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

