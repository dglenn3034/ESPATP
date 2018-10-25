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
WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'Company Admin'], FailureHandling.STOP_ON_FAILURE)

boolean found = false

found = WebUI.callTestCase(findTestCase('Utilities/NamedSearchExists'), [('NamedSearch') : 'ATPLidarNS'], FailureHandling.STOP_ON_FAILURE)

if (found == true) {
    println('Named Search is found')

    WebUI.click(findTestObject('Catalog/NamedSearch/NamedSearchesCancel_Button'))
} else {
    println(' No such named Search')

    WebUI.click(findTestObject('Catalog/NamedSearch/NamedSearchesCancel_Button'))

    WebUI.callTestCase(findTestCase('Utilities/CreateLidarNamedSearch'), [('NamedSearch') : 'ATPLidarNS'], FailureHandling.STOP_ON_FAILURE)

    println(' Created ATPLidarNS')
}

WebUI.navigateToUrl(GlobalVariable.AdminSite)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/a_ Custom Base Maps'))

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Name')

WebUiBuiltInKeywords.setText(findTestObject('Grid/LikeFilter'), 'ATPBasemap')

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Status')

'Wait until there is only one LIKE box in the DOM'
WebUI.delay(3, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Grid/LikeFilter'), 'COMPLETE')

try {
    WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Grid/NoRecordsExist'), 1)

    println('Basemap Does not exist')
}
catch (Exception e) {
    println('Basemap does exist, we will delete it')

    CustomKeywords.'genericGrid.gridOperations.ExecuteGridFunction'(1, 'Delete')

    WebUiBuiltInKeywords.click(findTestObject('OKButton'))

    WebUI.verifyElementNotPresent(findTestObject('Admin Console/ErrorPopup'), 2)
} 

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 5)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Basemaps/CreateBasemap_Button'))

WebUiBuiltInKeywords.setText(findTestObject('Admin Console/Basemaps/BasemapName_Field'), 'ATPBasemap')

WebUiBuiltInKeywords.setText(findTestObject('Admin Console/Basemaps/BasemapDescription_Field'), 'ATPBasemap for Testing')

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Basemaps/BasemapNamedSearchOption_ATPLidarNS'))

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Basemaps/BasemapMaxDetailOption_14'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Admin Console/Basemaps/BasemapisPublic_Checkbox'), 10)

WebUiBuiltInKeywords.check(findTestObject('Admin Console/Basemaps/BasemapisPublic_Checkbox'))

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Basemaps/BasemapCreate_button'))

WebUiBuiltInKeywords.click(findTestObject('OKButton'))

'Allow completion message to clear'
WebUI.delay(5)

WebUI.callTestCase(findTestCase('Utilities/AdminConsoleSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

