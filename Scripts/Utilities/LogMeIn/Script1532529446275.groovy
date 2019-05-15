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
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

ExcelData envData = findTestData('LoginData')

Integer rowNdx = 1

GlobalVariable.NewUser = envData.getValue(2, 6)

KeywordLogger log = new KeywordLogger()

log.logInfo('Role = ' + Role)

log.logInfo('Company  = ' + Company)

log.logInfo('Global Site   = ' + GlobalVariable.site)


if (Role == 'Company Admin') {
    rowNdx = 1
} else if (Role == 'User') {
    rowNdx = 2
} else if (Role == 'System Admin') {
    rowNdx = 3
} else if (Role == 'Organization Admin') {
    rowNdx = 4
} else if (Role == 'QC Analyst') {
    rowNdx = 5
} else if (Role == 'New User') {
    rowNdx = 6
} else {
    rowNdx = 1
}

log.logInfo('rowNdx = ' + rowNdx.toString())

GlobalVariable.User = envData.getValue(2, rowNdx)

GlobalVariable.pwd = envData.getValue(3, rowNdx)

println('User = ' + GlobalVariable.User)

GlobalVariable.ScreenShotFile = envData.getValue(4, rowNdx)

String theSite = GlobalVariable.site

if (Company) {
    println('Company is specified = ' + Company)

    String replaceString = ('//' + Company) + '.'

    theSite = theSite.replace('//', replaceString) // GlobalVariable.site = theSite
    // GlobalVariable.site = theSite
} else {
    if (GlobalVariable.DefaultCompany) {
        String replaceString = ('//' + GlobalVariable.DefaultCompany) + '.'

        theSite = theSite.replace('//', replaceString)
    }
}

println('The site =  ' + theSite)

log.logInfo('Site = ' + theSite)

GlobalVariable.AdminSite = (theSite + '/admin#')

GlobalVariable.QCSite = (theSite + '/qc#')

println('Admin site =  ' + GlobalVariable.AdminSite)

println('QC site =  ' + GlobalVariable.QCSite)

/* if site is get3di then we have to go through the landing page */
if (GlobalVariable.site.indexOf('get3di') > -1) {
    WebUI.openBrowser(GlobalVariable.site)

    WebUI.maximizeWindow() /* click on login */

    WebUI.click(findTestObject('LoginFromGet3di'))
	
	/* navigate to login url */
	if (GlobalVariable.site != theSite) {
	    WebUI.navigateToUrl(theSite)
	}
} 
else {
	WebUI.openBrowser(theSite)

	WebUI.maximizeWindow()
}


WebUI.setText(findTestObject('Catalog/input_Email'), GlobalVariable.User)

WebUI.setText(findTestObject('Catalog/input_Password'), GlobalVariable.pwd)

WebUI.click(findTestObject('Catalog/Signin_Button'))

WebUI.waitForElementNotPresent(findTestObject('LoadingMask'), 0)

WebUI.click(findTestObject('Cesium/canvas'))

return null

