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
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('QCAnalyst/QCAnalystProjects_Button'))

try {
    WebUI.verifyElementPresent(findTestObject('QCAnalyst/Projects/ProjectFilterDeleteLine1'), 1)

    WebUI.click(findTestObject('QCAnalyst/Projects/ProjectFilterDeleteLine1'))
}
catch (Exception e) {
} 

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

    if (DeleteIfExists) {
        WebUI.callTestCase(findTestCase('Utilities/DeleteProject'), [('ProjectName') : ProjectName], FailureHandling.STOP_ON_FAILURE)

        println(ProjectName + ' deleted ')
    } else {
    }
} 

WebUI.delay(2)

WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/CreateProjectButton'))

WebUiBuiltInKeywords.setText(findTestObject('QCAnalyst/CreateProject/CreateProjectInputName'), ProjectName)

WebUiBuiltInKeywords.setText(findTestObject('QCAnalyst/CreateProject/CreateProjectInputPrefix'), ProjectPrefix)

WebUI.setText(findTestObject('QCAnalyst/CreateProject/CreateProjectInputDescription'), Description)

if (Public) {
    WebUI.click(findTestObject('QCAnalyst/CreateProject/CreateProjectPublicAccessCheckBox'), FailureHandling.STOP_ON_FAILURE)
}

if (MetadataFile) {
    WebUI.setText(findTestObject('QCAnalyst/CreateProject/CreateProjectMetadataFile'), MetadataFile)
}

if (ProductType == 'Lidar') {
    WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/CreateProject/CreateProjectSelectProjectTypeLidar'))
} else {
    WebUiBuiltInKeywords.click(findTestObject('QCAnalyst/CreateProject/CreateProjectSelectProjectTypeOrtho'))
}

WebUI.click(findTestObject('QCAnalyst/CreateProject/CreateProjectStartDateField'))

if (StartDate) {
    WebUI.sendKeys(findTestObject('QCAnalyst/CreateProject/CreateProjectStartDatePicker'), Keys.chord(Keys.CONTROL, 'a'))

    WebUI.sendKeys(findTestObject('QCAnalyst/CreateProject/CreateProjectStartDatePicker'), Keys.chord(Keys.BACK_SPACE))

    WebUI.setText(findTestObject('QCAnalyst/CreateProject/CreateProjectStartDatePicker'), StartDate)
}

println('FootprintFile = ' + FootprintFile)

WebUI.click(findTestObject('QCAnalyst/CreateProject/CreateProjectSave'))

WebUI.click(findTestObject('OKButton' /* OK off confirmation message */ ))

'Wait on completion message to fade'
WebUI.delay(5)

WebUI.click(findTestObject('OKButton' /* ok off completion message */ ))

return null

