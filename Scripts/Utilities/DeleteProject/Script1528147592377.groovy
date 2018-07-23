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

/* check to see if Name filter field is already open , if so delete it*/
try {
    WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectFilterDeleteLine1'))
}
catch (Exception e) {
} 

WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectAddLine'))

/* assuming that the first line added is the Name field... Not good */
WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectFilterAttributeName_Dropdown'))

WebUI.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectFilterProjectName_field'), ProjectName)

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

/* 
'If filter is already set, skip to delete, otherwise create filter'
try {
    WebUI.verifyElementVisible(findTestObject('Page_Earth Sensor Portal/QCAnalyst/Projects/ProjectsDeleteFirstFilterRow_Button'))

    WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))
}
catch (Exception e) {
    WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectAddLine'))

    WebUI.setText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/ProjectFilterProjectName_field'), ProjectName)

    WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))
} 
*/
try {
    WebUI.verifyElementText(findTestObject('Page_Earth Sensor Portal/QCAnalyst/NoRecordsExist'), 'No Records found.')

    println(ProjectName + 'does not exist')

    WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/Projects/ProjectsCloseDialog_Button'))

    /* dismiss projects grid */
    return null
}
catch (Exception e) {
    println(ProjectName + ' exists ')
} 
finally { 
}

WebUI.delay(2)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/Projects/ProjectsGridRow1DeleteButton'))

WebUI.check(findTestObject('Page_Earth Sensor Portal/QCAnalyst/Projects/input_isDeleteFromCatalog'))

WebUiBuiltInKeywords.check(findTestObject('Page_Earth Sensor Portal/QCAnalyst/Projects/input_isDeleteFromS3Source'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/Projects/button_Delete'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUiBuiltInKeywords.delay(5)

WebUI.click(findTestObject('Page_Earth Sensor Portal/QCAnalyst/Projects/ProjectsCloseDialog_Button'))

return
