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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'QC Analyst', ('Company') : 'GeoCue'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.QCSite)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

'Click here to get Cesium Canvas to disappear'
not_run: WebUI.click(findTestObject('Cesium/canvas'))

WebUI.callTestCase(findTestCase('Utilities/CreateProject'), [('ProjectName') : 'ATPProjectWithFootprint', ('FootprintFile') : '\\\\diskstation1\\Data\\esp\\test_data\\shapefiles\\HoustonBayArea.zip'
        , ('ProductType') : 'Lidar', ('ProjectPrefix') : 'ATPFoot', ('Public') : true, ('StartDate') : '01/01/2019', ('DeleteIfExists') : true], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Utilities/QCAnalystSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

