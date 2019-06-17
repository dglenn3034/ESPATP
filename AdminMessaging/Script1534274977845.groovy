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

'Tests Sending Messages from Admin Console'
WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'Company Admin', ('Company') : 'GeoCue'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.AdminSite)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/a_Message'), FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Admin Console/Message/MessageRecipientDropdown'), 'allUsers', false)

WebUI.verifyElementPresent(findTestObject('Admin Console/Message/MessageLeftSideList'), 0)

WebUiBuiltInKeywords.verifyElementNotPresent(findTestObject('Admin Console/Message/MessageRightSideList'), 3)

WebUI.selectOptionByValue(findTestObject('Admin Console/Message/MessageRecipientDropdown'), 'organizations', false)

WebUI.verifyElementPresent(findTestObject('Admin Console/Message/MessageLeftSideList'), 0)

WebUiBuiltInKeywords.verifyElementPresent(findTestObject('Admin Console/Message/MessageRightSideList'), 0)

WebUI.selectOptionByValue(findTestObject('Admin Console/Message/MessageRecipientDropdown'), 'allUsers', false)

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Email')

WebUI.setText(findTestObject('Grid/LikeFilter'), 'dglenn@geocue.com')

WebUI.check(findTestObject('Admin Console/Message/MessageLeftTableFirstCheckbox'))

WebUI.verifyElementText(findTestObject('Admin Console/Message/MessageToList'), 'dglenn@geocue.com')

WebUI.click(findTestObject('Admin Console/Message/MessageSendButton'))

WebUI.verifyElementPresent(findTestObject('Admin Console/Message/MessageSendWithNoSubject'), 1)

WebUI.click(findTestObject('Admin Console/Message/MessageModalDialogCancelButton'))

WebUI.setText(findTestObject('Admin Console/Message/MessageSubjectLine'), 'ATP AdminMessaging ')

WebUI.setText(findTestObject('Admin Console/Message/MessageMessageContent'), 'Message from ATP AdminMessage')

WebUiBuiltInKeywords.click(findTestObject('Admin Console/Message/MessageSendButton'))

'Check that we don\'t have an error'
WebUI.verifyElementNotPresent(findTestObject('Admin Console/Message/ErrorPopup'), 2)

WebUI.delay(2)

WebUiBuiltInKeywords.click(findTestObject('Admin Console/a_ Custom Base Maps'))

WebUiBuiltInKeywords.click(findTestObject('Admin Console/a_Message'))

WebUI.selectOptionByValue(findTestObject('Admin Console/Message/MessageRecipientDropdown'), 'organizations', false)

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Organizations')

WebUI.setText(findTestObject('Grid/LikeFilter'), 'geocue')

WebUI.check(findTestObject('Admin Console/Message/MessageLeftTableFirstCheckbox'))

CustomKeywords.'genericGrid.gridOperations.ColumnFilter'('Email')

WebUI.setText(findTestObject('Grid/LikeFilter'), 'dglenn@geocue.com')

WebUiBuiltInKeywords.check(findTestObject('Admin Console/Message/MessageRightSideFirstCheckbox'))

WebUI.verifyElementText(findTestObject('Admin Console/Message/MessageToList'), 'dglenn@geocue.com')

WebUI.callTestCase(findTestCase('Utilities/AdminConsoleSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

