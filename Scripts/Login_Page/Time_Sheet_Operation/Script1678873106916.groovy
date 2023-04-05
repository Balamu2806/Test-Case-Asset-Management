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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


GlobalVariable.Tab_Name = "Operations"


WebUI.callTestCase(findTestCase('Fields/Tab'), [:], FailureHandling.STOP_ON_FAILURE)


GlobalVariable.New_Field_Value= "Check"


WebUI.callTestCase(findTestCase('Fields/Table_Data_Posting'), [:], FailureHandling.STOP_ON_FAILURE)

//GlobalVariable.Ref_No = CustomKeywords.'myPack.DateTime.ESTTime'()


GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\'+ GlobalVariable.Data_Path + '\\Create_Work_Order.xlsx')


GlobalVariable.Sheet_Name = "Time_Sheet_Operation"

GlobalVariable.Ref_No = WebUI.getText(findTestObject('Page_PM360/Table_Data_Display_Field_Index', [('tableName') : GlobalVariable.Table_Name,
	('row') : 1, ('col') : 3, ('srow') : 3 ]), FailureHandling.STOP_ON_FAILURE)
	
	
	CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
	2, 2)
	

GlobalVariable.Button_Name = "Start"


WebUI.callTestCase(findTestCase('Fields/Button'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Yes']))


WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'OK']))

WebUI.delay(2)

GlobalVariable.Ref_No = WebUI.getText(findTestObject('Page_PM360/Table_Data_Display_Field_Index', [('tableName') : GlobalVariable.Table_Name,
	('row') : 1, ('col') : 5, ('srow') : 1 ]), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
4, 2)


//GlobalVariable.Ref_No = CustomKeywords.'myPack.DateTime.ESTDate'()

GlobalVariable.Ref_No = WebUI.getText(findTestObject('Page_PM360/Table_Data_Display_Field_Index', [('tableName') : GlobalVariable.Table_Name,
('row') : 1, ('col') : 5, ('srow') : 2 ]), FailureHandling.STOP_ON_FAILURE)


CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
5, 2)


WebUI.delay(30)


GlobalVariable.Table_Start_Point = null


GlobalVariable.Table_Col = GlobalVariable.Table_Col - 1


WebUI.callTestCase(findTestCase('Fields/Table_Data_Posting'), [:], FailureHandling.STOP_ON_FAILURE)



GlobalVariable.Button_Name = "Stop"


WebUI.callTestCase(findTestCase('Fields/Button'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Yes']))


WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'OK']))

	
WebUI.delay(2)

GlobalVariable.Ref_No = WebUI.getText(findTestObject('Page_PM360/Table_Data_Display_Field_Index', [('tableName') : GlobalVariable.Table_Name,
	('row') : 1, ('col') : 6, ('srow') : 1 ]), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
6, 2)


//GlobalVariable.Ref_No = CustomKeywords.'myPack.DateTime.ESTDate'()

GlobalVariable.Ref_No = WebUI.getText(findTestObject('Page_PM360/Table_Data_Display_Field_Index', [('tableName') : GlobalVariable.Table_Name,
('row') : 1, ('col') : 6, ('srow') : 2 ]), FailureHandling.STOP_ON_FAILURE)


CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
7, 2)


GlobalVariable.Ref_No = WebUI.getText(findTestObject('Page_PM360/Table_Data_Display_Field', [('tableName') : GlobalVariable.Table_Name,
	('row') : 1, ('col') : 7]), FailureHandling.STOP_ON_FAILURE)


CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
	8, 2)


WebUI.check(findTestObject('Page_PM360/Table_Data_Check', [('tableName') : GlobalVariable.Table_Name,
	('row') : 1, ('col') : 2]), FailureHandling.STOP_ON_FAILURE)


WebUI.check(findTestObject('Page_PM360/Table_Data_Check', [('tableName') : GlobalVariable.Table_Name,
	('row') : 1, ('col') : 8]), FailureHandling.STOP_ON_FAILURE)


