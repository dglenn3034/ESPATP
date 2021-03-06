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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'Company Admin', ('Company') : 'GeoCue'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.AdminSite)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

' Add Group'
WebUI.callTestCase(findTestCase('Utilities/CreateGroup'), [('Name') : 'ATPUser2', ('Description') : 'Test Group for ATP based on User'
        , ('defaultGroup') : 'User'], FailureHandling.STOP_ON_FAILURE)

'Add Organization'
WebUI.callTestCase(findTestCase('Utilities/CreateOrganization'), [('Description') : 'ATP Test Organization', ('Group') : 'ATPUser2'
        , ('Name') : 'ATPOrganization', ('Domain') : 'airgon.com'], FailureHandling.STOP_ON_FAILURE)

'Add user'
WebUI.callTestCase(findTestCase('Utilities/CreateUser'), [('email') : GlobalVariable.NewUser, ('organization') : 'ATPOrganization'], 
    FailureHandling.STOP_ON_FAILURE)

'delete User'
WebUI.callTestCase(findTestCase('Utilities/DeleteUser'), [('UserId') : GlobalVariable.NewUser], FailureHandling.STOP_ON_FAILURE)

'Delete Organization'
WebUI.callTestCase(findTestCase('Utilities/DeleteOrganization'), [('Name') : 'ATPOrganization'], FailureHandling.STOP_ON_FAILURE)

'delete group'
WebUI.callTestCase(findTestCase('Utilities/DeleteGroup'), [('Name') : 'ATPUser2'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Utilities/AdminConsoleSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

