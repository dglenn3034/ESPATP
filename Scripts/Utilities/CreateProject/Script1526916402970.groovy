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

WebUI.click(findTestObject('QCAnalyst/QCAnalystProjects_Button'))

WebUI.click(findTestObject('QCAnalyst/Projects/ProjectAddLine'))

WebUI.setText(findTestObject('QCAnalyst/Projects/ProjectFilterProjectName_field'), ProjectName)

WebUI.click(findTestObject('OKButton'))

try {
    WebUI.verifyElementPresent(findTestObject('QCAnalyst/Projects/ProjectsNoRecordsFound'), 2)

    println(ProjectName + ' does not exist, we will create it')

    WebUI.click(findTestObject('QCAnalyst/Projects/ProjectsCloseDialog_Button'))
}
catch (Exception e) {
    println(ProjectName + ' does exist')

    WebUI.click(findTestObject('QCAnalyst/Projects/ProjectsCloseDialog_Button'))

    /*
    WebUI.callTestCase(findTestCase('Utilities/DeleteProject'), [('ProjectName') : ProjectName], FailureHandling.STOP_ON_FAILURE)

    println(ProjectName + ' deleted ')
	*/
    return null
} 

WebUI.delay(2)

WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/CreateProjectButton'))

WebUiBuiltInKeywords.setText(findTestObject('QCAnalyst/CreateProject/CreateProjectInputName'), ProjectName)

WebUiBuiltInKeywords.setText(findTestObject('QCAnalyst/CreateProject/CreateProjectInputPrefix'), ProjectPrefix)

if (MetadataFile) {
    WebUI.setText(findTestObject('QCAnalyst/CreateProject/CreateProjectMetadataFile'), MetadataFile)
}

if (ProductType == 'Lidar') {
    WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/CreateProject/CreateProjectSelectProjectTypeLidar'))
} else {
    WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/CreateProject/CreateProjectSelectProjectTypeOrtho'))
}

WebUiBuiltInKeywords.setText(findTestObject('QCAnalyst/CreateProject/CreateProjectInputDescription'), ('ATP Project for ' + 
    ProductType) + ' Loading')

println('FootprintFile = ' + FootprintFile)

if ((FootprintFile != null) && (FootprintFile.length() > 0)) {
    WebUI.click(findTestObject('QCAnalyst/CreateProject/CreateProjectImportFootprintSingleFile_Tab'))

    WebUI.delay(3)

    WebUiBuiltInKeywords.setText(findTestObject('QCAnalyst/CreateProject/CreateProjectImportFootprint_FileNameField'), FootprintFile)

    WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/CreateProject/CreateProjectFootprintImport_Button'))

    WebUI.click(findTestObject('QCAnalyst/CreateProject/button_OK'))

    WebUI.delay(3)

    WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/CreateProject/CreateProjectSave'))

    WebUI.delay(3)

    WebUiBuiltInKeywords.click(findTestObject('OKButton'))
} else {
    WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/CreateProject/CreateProjectSave'))

    WebUI.delay(3)

    'This OK is to accept that the project is created with no footprint'
    WebUiBuiltInKeywords.click(findTestObject('OKButton'))

    WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

    'This OK is to close the project created confirmation dialog'
    WebUiBuiltInKeywords.click(findTestObject('OKButton'))
}

'Wait on completion message to fade'
WebUI.delay(5)

return null

