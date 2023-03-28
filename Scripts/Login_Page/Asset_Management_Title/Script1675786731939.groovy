import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

String fileName = RunConfiguration.getProjectDir() + '\\InputFile\\Application_Name.xlsx'

String sheetName = 'AppNavigation'

//GlobalVariable.Role = "Admin"

WebUI.callTestCase(findTestCase('Login_Page/Login _Valid_User ID_Password'), [('ScreenShot_Name') : ''], FailureHandling.STOP_ON_FAILURE)

StrApp_Name = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, 10, 0)

println(StrApp_Name)

WebUI.click(findTestObject('Page_Home/Application_Name', [('App_Name') : StrApp_Name]))

WebUI.waitForPageLoad(2)

//String fileName = 'D:\\PM360_Upgrade\\InputFile\\Application_Name.xlsx'
//String sheetName = 'AppNavigation'
String Result = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, 10, 1)

WebUI.switchToWindowTitle(Result)

