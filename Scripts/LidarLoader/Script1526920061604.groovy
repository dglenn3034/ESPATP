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

WebUI.waitForElementClickable(findTestObject('Page_Earth Sensor Portal/canvas'), 10)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Canvas'))

WebUI.callTestCase(findTestCase('Utilities/CreateProject'), [('ProjectName') : 'ATPLidarProject', ('ProjectPrefix') : 'ATPLidar'
        , ('ProductType') : 'Lidar', ('FootprintFile') : ''], FailureHandling.STOP_ON_FAILURE)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/LidarLoaderButton'))

'2 laz files from swfwmd/Hernando'
WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/LidarLoader/LidarLoaderInputBucketName'), 
    GlobalVariable.S3SourceLidarBucket)

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/LidarLoader/LidarLoaderIInputS3Prefix'), 
    GlobalVariable.S3SourceLidarPrefix)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/LidarLoader/LidarLoaderSelectATPProject'))

WebUiBuiltInKeywords.selectOptionByValue(findTestObject('Page_Earth Sensor Portal/QCAnalyst/LidarLoader/LidarLoaderSelectHillshade'), 
    '2', false)

WebUI.sendKeys(findTestObject('Page_Earth Sensor Portal/QCAnalyst/LidarLoader/LidarLoaderSRSFilename'), 'Z:\\ESP\\Test_data\\swfwmd\\Hernando\\stplanFLWest.srs')

try {
    notPresent = WebUiBuiltInKeywords.verifyElementNotPresent(findTestObject('Page_Earth Sensor Portal/QCAnalyst/LidarLoader/LidarLoaderFailedToReadTheFile'), 
        2)

    if (notPresent) {
        println('No problem with the SRS/PRJ file')

        WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/LidarLoader/LidarLoaderExecute'))

        WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))
    } else {
        throw new com.kms.katalon.core.exception.StepFailedException('Failed to read SRS/PRJ file')
    }
}
catch (Exception e) {
    println('Problem reading the SRS/PRJ file')

    WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/LidarLoader/LidarLoaderCancel'))

    throw new com.kms.katalon.core.exception.StepFailedException('Failed to read SRS/PRJ file')
} 
finally { 
    WebUI.callTestCase(findTestCase('Utilities/QCAnalystSignOut'), [:], FailureHandling.STOP_ON_FAILURE)
}

