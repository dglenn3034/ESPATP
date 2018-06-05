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

WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/QCAnalystProjects_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectAddLine'))

WebUI.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectFilterProjectName_field'), ProjectName)

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

try {
    WebUI.verifyElementPresent(findTestObject('Page_Earth Sensor Portal/QCAnalyst/Projects/ProjectsNoRecordsFound'), 2)

    println(ProjectName + ' does not exist, we will create it')
}
catch (Exception e) {
    println(ProjectName + ' does exist, we will delete it and recreate it')

    WebUI.callTestCase(findTestCase('Utilities/DeleteProject'), [('ProjectName') : ProjectName], FailureHandling.STOP_ON_FAILURE)

    println(ProjectName + ' deleted ')
} 

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProjectButton'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectInputName'), 
    ProjectName)

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectInputPrefix'), 
    ProjectPrefix)

if (ProductType == 'Lidar') {
    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectSelectProjectTypeLidar'))
} else {
    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectSelectProjectTypeOrtho'))
}

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectInputDescription'), 
    ('ATP Project for ' + ProductType) + ' Loading')

println('FootprintFile = ' + FootprintFile)

if ((FootprintFile != null) && (FootprintFile.length() > 0)) {
    WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectImportFootprintSingleFile_Tab'))

    WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectImportFootprint_FileNameField'), 
        FootprintFile)

    WebUI.delay(2)

    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectFootprintImport_Button'))

    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectFootprintImport_Button'))

    WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/button_OK'))

    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectSave'))

    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))
} else {
    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectSave'))

    'This OK is to accept that the project is created with no footprint'
    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

    'This OK is to close the project created confirmation dialog'
    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))
}

'Wait on completion message to fade'
WebUI.delay(5)

