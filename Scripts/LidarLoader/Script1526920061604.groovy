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

WebUI.callTestCase(findTestCase('Utilities/LogMeIn'), [('Role') : 'QC Analyst'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.navigateToUrl(GlobalVariable.QCSite)

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.click(findTestObject('Cesium/canvas'))

WebUI.callTestCase(findTestCase('Utilities/CreateProject'), [('ProjectName') : 'ATPLidarProject', ('ProjectPrefix') : 'ATPLidar'
        , ('ProductType') : 'Lidar', ('FootprintFile') : '', ('Description') : 'ATP Lidar Test Project'], FailureHandling.STOP_ON_FAILURE)

WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/LidarLoaderButton'))

'2 laz files from swfwmd/Hernando'
WebUiBuiltInKeywords.setText(findTestObject('QCAnalyst/LidarLoader/LidarLoaderInputBucketName'), GlobalVariable.S3SourceLidarBucket)

WebUiBuiltInKeywords.setText(findTestObject('QCAnalyst/LidarLoader/LidarLoaderIInputS3Prefix'), GlobalVariable.S3SourceLidarPrefix)

WebUiBuiltInKeywords.selectOptionByLabel(findTestObject('QCAnalyst/LidarLoader/LidarLoaderSelectProject'), 'ATPLidarProject', 
    false)

WebUiBuiltInKeywords.selectOptionByValue(findTestObject('QCAnalyst/LidarLoader/LidarLoaderSelectHillshade'), '2', false)

WebUI.check(findTestObject('QCAnalyst/LidarLoader/LidarLoaderCopytoESPCheckbox'))

WebUI.sendKeys(findTestObject('QCAnalyst/LidarLoader/LidarLoaderSRSFilename'), 'Z:\\ESP\\Test_data\\swfwmd\\Hernando\\stplanFLWest.srs')

try {
    notPresent = WebUiBuiltInKeywords.verifyElementNotPresent(findTestObject('QCAnalyst/LidarLoader/LidarLoaderFailedToReadTheFile'), 
        2)

    if (notPresent) {
        println('No problem with the SRS/PRJ file')

        WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/LidarLoader/LidarLoaderExecute'))

        WebUI.click(findTestObject('OKButton'))
    } else {
        throw new com.kms.katalon.core.exception.StepFailedException('Failed to read SRS/PRJ file')
    }
}
catch (Exception e) {
    println('Problem reading the SRS/PRJ file')

    WebUI.click(findTestObject('QCAnalyst/LidarLoader/LidarLoaderCancel'))

    throw new com.kms.katalon.core.exception.StepFailedException('Failed to read SRS/PRJ file')
} 
finally { 
    WebUI.callTestCase(findTestCase('Utilities/QCAnalystSignOut'), [:], FailureHandling.STOP_ON_FAILURE)
}

