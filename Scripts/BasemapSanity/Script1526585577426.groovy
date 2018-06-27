import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
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

/* begin here */
WebUI.callTestCase(findTestCase('Utilities/GetLoginInfo'), [('Site') : 'dummy.com', ('username') : '', ('pwd') : 'pwd'], FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.site)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/Canvas'))

try {
    WebUI.callTestCase(findTestCase('Utilities/NamedSearchExists'), [('NamedSearch') : 'ATPLidarNS'], FailureHandling.STOP_ON_FAILURE)

    println('Named Search is found')
}
catch (Exception e) {
    println(' No such named Search')

    WebUI.callTestCase(findTestCase('Utilities/CreateLidarNamedSearch'), [('NamedSearch') : 'ATPLidarNS'], FailureHandling.STOP_ON_FAILURE)

    println(' Created ATPLidarNS')
} 

WebUI.navigateToUrl(GlobalVariable.AdminSite)

WebUI.waitForPageLoad(10)

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Admin Console/a_ Custom Base Maps'), 20)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/a_ Custom Base Maps'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapsNameFilter_Button'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapsNameFilterInput_Field'), 
    'ATPBasemap')

WebUI.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapsStatusFilter_Button'))

WebUI.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapsStatusFilerInput_Field'), 'COMPLETE')

try {
    WebUiBuiltInKeywords.getText(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/NoRecordsFound_Label'))

    println('Basemap Does not exist')
}
catch (Exception e) {
    println('Basemap does exist, we will delete it')

    WebUI.check(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapsDeleteFirstBasemap_checkbox'))

    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))
} 

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 5)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/CreateBasemap_Button'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapName_Field'), 'ATPBasemap')

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapDescription_Field'), 
    'ATPBasemap for Testing')

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapNamedSearchOption_ATPLidarNS'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapMaxDetailOption_14'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapisPublic_Checkbox'), 
    10)

WebUiBuiltInKeywords.check(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapisPublic_Checkbox'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Basemaps/BasemapCreate_button'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

'Allow completion message to clear'
WebUI.delay(5)

WebUI.callTestCase(findTestCase('Utilities/AdminConsoleSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

