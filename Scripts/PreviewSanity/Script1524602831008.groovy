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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.site)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Page_Earth Sensor Portal/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Signin_Button'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Canvas'))

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogAOIImport_Button'))

WebUI.sendKeys(findTestObject('Page_Earth Sensor Portal/AOI/AOIFIlePath_Field'), '\\\\diskstation1\\Data\\esp\\test_data\\miamibeachshapfile.zip')

WebUI.click(findTestObject('Page_Earth Sensor Portal/AOI/AOIExecutetheImport_button'))

WebUI.delay(3, FailureHandling.STOP_ON_FAILURE)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogProducts_Button'))

'Preview for Landsat'
WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductselectionLandsat8NDVI_Checkbox'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelection_OK'))

WebUiBuiltInKeywords.waitForElementVisible(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResults_Grid'), 
    1)

WebUI.click(findTestObject('Page_Earth Sensor Portal/Catalog/MapDataSource_DropDown'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Catalog/MapDataSourceSearch Results_Item'))

'This is filter Icon for  Name column'
WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsNameFilter_Button'))

'This is the pop up box for entering the \'like\' string'
WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsNameFilterLike_Field'))

WebUI.sendKeys(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsNameFilterLike_Field'), 'LC80150422014082LGN00')

'Display the preview of this data item in the map'
WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsFirstRow_Globe'))

'zoom to the item'
WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsFirstRowZoomToItem_Button'))

WebUiBuiltInKeywords.delay(5)

String filelocation = GlobalVariable.ScreenShotFile + '\\miamilidar.png'

'Take a screenshot'
WebUI.takeScreenshot(filelocation)

WebUI.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsClose_Button'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/Catalog/CatalogProducts_Button'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelectionNAIPNDVI_CheckBox'))

WebUI.delay(2)

'Turn Lidar Off'
WebUI.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductselectionLandsat8NDVI_Checkbox'))

WebUI.delay(2)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/ProductSelection/ProductSelection_OK'))

WebUiBuiltInKeywords.waitForElementVisible(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResults_Grid'), 
    1)

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsNameFilter_Button'))

WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsNameFilterLike_Field'))

WebUiBuiltInKeywords.setText(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsNameFilterLike_Field'), 
    'FL_2508007_se_17_1_20131018')

WebUI.delay(1)

'Display the preview of this data item in the map'
WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsFirstRow_Globe'))

'zoom to the item'
WebUiBuiltInKeywords.click(findTestObject('Page_Earth Sensor Portal/SearchResults/SearchResultsFirstRowZoomToItem_Button'))

WebUiBuiltInKeywords.delay(5)

filelocation = (GlobalVariable.ScreenShotFile + '\\miaminaip.png')

'Take a screenshot'
WebUI.takeScreenshot(filelocation)

