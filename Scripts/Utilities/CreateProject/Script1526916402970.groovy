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

    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProjectButton'))

    WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectInputName'), 
        ProjectName)

    WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectInputPrefix'), 
        'ATP' + ProductType)

    if (ProductType == 'Lidar') {
        WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectSelectProjectTypeLidar'))
    } else {
        WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectSelectProjectTypeOrtho'))
    }
    
    WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectInputDescription'), 
        ('ATP Project for ' + ProductType) + ' Loading')

    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/CreateProject/CreateProjectSave'))

    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

    WebUI.delay(2)

    WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))
}
catch (Exception e) {
    println(ProjectName + ' exists, we are done')
} 

