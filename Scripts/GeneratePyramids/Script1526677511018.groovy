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

WebUI.callTestCase(findTestCase('GetLoginInfo'), [('Site') : 'dummy.com', ('username') : '', ('pwd') : 'pwd'], FailureHandling.STOP_ON_FAILURE)

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

WebUI.waitForElementVisible(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectItems/ProjectItemsCountLabel'), 5)

try {
    WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/WorkingSetCountBadge'))

    WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/WorkingSet/WorkingSetClearSet_Button'))

    WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/WorkingSet/WorkingSetDismiss_Button'))
}
catch (Exception e) {
    /* do nothing if working set is empty */
    println('working set is empty to start with')
} 

WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectItems/ProjectItemsNameFilter_Button'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectItems/ProjectItemsNameLike_Field'), 
    'DavCo_AA')

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectItems/ProjectItemsSelectAll'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectItems/ProjectItemsAddtoWorkingSet'))

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/QCAnalyst/WorkingSetCountBadge'), 3)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/WorkingSetCountBadge'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/WorkingSet/WorkingSetSelectProcess'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/WorkingSet/WorkingSetGeneratePyramidsRadio'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/WorkingSet/WorkingSetExecuteProcess'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/QCAnalyst/WorkingSet/ReadyToExecuteOKButton'), 5)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/WorkingSet/ReadyToExecuteOKButton'))

WebUI.delay(2)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.callTestCase(findTestCase('Utilities/QCAnalystSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

