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

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/a_ Organizations'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/OrganizationNameFilterButton'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/OrganizationNameFilterLikeBox'), 
    Name)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/OrganizationDeleteRow1Button'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Organizations/OrganizationDeleteOKButton'))

WebUiBuiltInKeywords.delay(2)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Admin Console/Users/UsersRefresh_Button'))

WebUiBuiltInKeywords.delay(2)

