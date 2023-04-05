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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\'+ GlobalVariable.Data_Path + '\\Create_Work_Order.xlsx')

GlobalVariable.Sheet_Name = 'CWO_Exist_Reserve'

GlobalVariable.OrderID = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
	1, 2)

GlobalVariable.Sheet_Name = 'Order_Status'

GlobalVariable.rowCount = CustomKeywords.'myPack.CountCellLength.rowCount'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name)


GlobalVariable.totalCount = 0

WebUI.delay(2)

while (GlobalVariable.totalCount != GlobalVariable.rowCount) 
{

	GlobalVariable.Field_Type = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
		GlobalVariable.totalCount + 1, 0)

	GlobalVariable.Field_Name = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
		GlobalVariable.totalCount + 1, 1)

	GlobalVariable.New_Field_Value = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
		GlobalVariable.totalCount + 1, 2)	

	// WebUI.callTestCase(findTestCase('Verify_Fields/Label_Display'), [:], FailureHandling.STOP_ON_FAILURE)
	println((('TotalCount = ' + GlobalVariable.totalCount) + ' Field Value = ') + GlobalVariable.Field_Name)

	WebUI.callTestCase(findTestCase('Verify_Fields/Switch_Case'), [:], FailureHandling.STOP_ON_FAILURE)

	GlobalVariable.totalCount = (GlobalVariable.totalCount + 1)
}

String ToOrderStatus = "Release"

WebUI.verifyElementPresent(findTestObject('Page_PM360/Message_Type', [('Msg_Type') : 'Confirmation Message']), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Page_PM360/Fiori_Default_Button', [('Button') : 'No']), FailureHandling.CONTINUE_ON_FAILURE)

SucessMsg = (('Do you want to ' + ToOrderStatus) + ' Work Order '+ GlobalVariable.OrderID + '?')

//WebUI.callTestCase(findTestCase('Fields/Create_Message'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Page_PM360/Other_Confirmation_Msg', [('Msg') : SucessMsg]), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Page_PM360/Fiori_Default_Button', [('Button') : 'Yes']))

SucessMsg = 'Work Order '+ GlobalVariable.OrderID + ' Released Successfully'

WebUI.verifyElementPresent(findTestObject('Page_PM360/Message_Type', [('Msg_Type') : 'Success']), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'OK']))

WebUI.delay(2)

//WebUI.verifyElementPresent(findTestObject('Page_PM360/Button_Name', [('ButtonName') : 'TECO']), 0, FailureHandling.CONTINUE_ON_FAILURE)