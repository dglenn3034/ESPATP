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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.QCSite)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/canvas'), 5)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Canvas'))

WebUI.callTestCase(findTestCase('Utilities/CreateProject'), [('ProjectName') : 'ATPOrthoProject', ('ProductType') : 'Orthos'
        , ('ProjectPrefix') : 'ATPOrthos'], FailureHandling.STOP_ON_FAILURE)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/OrthoLoaderButton'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/OrthoLoader/OrthoLoaderInputBucketName'), 
    GlobalVariable.S3SourceOrthoBucket)

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/OrthoLoader/OrthoLoaderInputS3Prefix'), 
    GlobalVariable.S3SourceOrthoPrefix)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/OrthoLoader/OrthoLoaderSelectATPProject'))

not_run: WebUI.sendKeys(findTestObject('Page_Earth Sensor Portal/QCAnalyst/OrthoLoader/OrthoLoaderSRSFilename'), 'Z:\\ESP\\Test_data\\swfwmd\\Hernando\\stplanFLWest.srs')

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/OrthoLoader/OrthoLoaderExecute'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.callTestCase(findTestCase('Utilities/QCAnalystSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

