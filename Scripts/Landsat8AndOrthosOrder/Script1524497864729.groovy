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
import java.text.SimpleDateFormat as SimpleDateFormat

myColumnSortObject = findTestObject('Page_Earth Sensor Portal/SearchResults/CoveredAreasTab/ColumnSort')

ColumnSortXp = myColumnSortObject.findPropertyValue('xpath')

WebUI.callTestCase(findTestCase('Utilities/GetLoginInfo'), [('Site') : 'dummy.com', ('username') : '', ('pwd') : 'pwd'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.GeoCueCompanySite)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUI.setText(findTestObject('Page_Earth Sensor Portal/CesiumSearchField'), 'Houston')

WebUI.click(findTestObject('Page_Earth Sensor Portal/CesiumSearchButton'))

//zoom time
Thread.sleep(4000)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogAOIAsView_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogProducts_Button'))

CustomKeywords.'productSelection.productSelection.SelectChildProduct'('Landsat8', 'NDVI')

not_run: WebUI.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductselectionLandsat8NDVI_Checkbox'))

CustomKeywords.'productSelection.productSelection.SelectProduct'('OrthoImages')

not_run: WebUI.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelectionOrthoImages_Checkbox'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelection_OK'))

Thread.sleep(4000)

Xp = ColumnSortXp.replace('Column', 'Name')

println('Column Sort Xp = ' + Xp)

tmpObject = WebUI.modifyObjectProperty(myColumnSortObject, 'xpath', 'equals', Xp, true)

WebUiBuiltInKeywords.click(tmpObject)

WebUI.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResults_SelectFirstRow'))

WebUiBuiltInKeywords.click(tmpObject)

WebUI.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResults_SelectFirstRow'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsAddSelectedToCart_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCart_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartCheckout_Button'))

def date = new Date()

SimpleDateFormat sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

String aDate = sdf.format(new Date())

String OName = 'ATPLSandOrthoOrder-' + aDate

WebUI.setText(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartOrderName_Field'), OName)

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartPreviewOrder_Button'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/OrderCart/OrderCartPlaceOrder_Button'))

WebUI.delay(3)

WebUI.click(findTestObject('Page_Earth Sensor Portal/OKButton'))

WebUI.callTestCase(findTestCase('Utilities/CatalogSignOut'), [:], FailureHandling.STOP_ON_FAILURE)

