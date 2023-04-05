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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.util.CryptoUtil
import com.kms.katalon.core.configuration.RunConfiguration

WebUI.openBrowser('')

WebUI.deleteAllCookies()


String fileName = RunConfiguration.getProjectDir() + '//Environment//URL_ID_PWD.xlsx'

String sheetName = 'ENV'

int row

GlobalVariable.Environment = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, 1, 0)

sheetName = 'URL'

String URL

if (GlobalVariable.Environment == "DEV")
{
	
	GlobalVariable.Data_Path = "Data_DEV"
	
	row = 1
	
	URL = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, 1, 1)
	
	
}else if (GlobalVariable.Environment=="QAS")
		{
			
			GlobalVariable.Data_Path = "Data_QAS"
			
			row = 1
			
			URL = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, 2, 1)
			
			
		}else if (GlobalVariable.Environment == "PRD" )
		{
			
			GlobalVariable.Data_Path = "Data_PRD"
			
			row = 1
			
			URL = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, 3, 1)
			
		}	

WebUI.navigateToUrl(URL)

WebUI.maximizeWindow()

sheetName = "ID_PWD"

String UserID, PWD

//GlobalVariable.Role = "Admin"

switch (GlobalVariable.Role){
	case 'Admin' :
	
		UserID = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, row, 1)
	
		PWD = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, row, 2)
		
		println(UserID +">>>>>>>>>"+PWD)
		
		break
		
	case 'Technician' :
	
		UserID = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, row, 3)
	
		PWD = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, row, 4)
		
		break
		
	case 'Manager' :	
		
		UserID = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, row, 5)
	
		PWD = CustomKeywords.'myPack.ReadExcel.readExcel'(fileName, sheetName, row, 6)
		
		break
}

PWD = CryptoUtil.encode(CryptoUtil.getDefault(PWD))

WebUI.setText(findTestObject('Page_Logon/User_ID'), UserID)

WebUI.setEncryptedText(findTestObject('Page_Logon/User_Password'), PWD)

WebUI.click(findTestObject('Page_Logon/Login_Button'))

WebUI.waitForPageLoad(2)
