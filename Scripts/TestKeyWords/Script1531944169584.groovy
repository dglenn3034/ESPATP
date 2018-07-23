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

WebUI.callTestCase(findTestCase('Utilities/GetLoginInfo'), [('Site') : 'dummy.com', ('username') : '', ('pwd') : 'pwd'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.site)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/Canvas'))

WebUI.verifyElementClickable(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogProducts_Button'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogProducts_Button'))

not_run: CustomKeywords.'productSelection.productSelection.SelectProduct'('OrthoImages')

not_run: CustomKeywords.'productSelection.productSelection.SelectChildProduct'('Landsat8', 'NDVI')

CustomKeywords.'productSelection.productSelection.SelectChildProduct'('NAIP', 'NDVI')

not_run: CustomKeywords.'productSelection.productSelection.SelectProduct'('Airborne LIDAR')

not_run: CustomKeywords.'productAttributeFiltering.attributeFiltering.SetAttributeFilter'('Landsat8', 'Like', 'Name', 'LC', 
    false)

CustomKeywords.'productAttributeFiltering.attributeFiltering.SetAttributeFilter'('NAIP', '>=', 'Date Acquired', '01/01/2015', 
    true)

not_run: CustomKeywords.'productAttributeFiltering.attributeFiltering.SetAttributeFilter'('Airborne LIDAR', '>=', 'Total Number Of Points', 
    '3500000', false)

not_run: CustomKeywords.'productAttributeFiltering.attributeFiltering.SetAttributeFilter'('Airborne LIDAR', '<=', 'Total Number Of Points', 
    '4000000', false)

