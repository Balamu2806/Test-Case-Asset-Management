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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

GlobalVariable.Field_Name = 'Goods Issue'

GlobalVariable.Data_Path = 'Data_QAS'

WebUI.callTestCase(findTestCase('Fields/Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\'+ GlobalVariable.Data_Path + '\\Create_Work_Order.xlsx')

GlobalVariable.Sheet_Name = 'CWO_Exist_Reserve'

String Result = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
1, 2)

Result = Result + " " +CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
2, 2)

Result = Result.substring(0,27)



GlobalVariable.Ref_No = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
34, 2)

println(GlobalVariable.Ref_No)

WebUI.delay(2)

WebUI.setText(findTestObject('Page_PM360/Text_Box',[('Text') : 'Select Document' ]),'Reservation')

//WebUI.sendKeys(findTestObject('Page_PM360/Text_Box',[('Text') : 'Select Document' ]), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Page_PM360/Text_Box',[('Text') : 'Reference Number' ]),GlobalVariable.Ref_No)

GlobalVariable.Button_Name = 'Go'

GlobalVariable.Sheet_Name = 'CWO_Reverse'

GlobalVariable.Ref_No = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
27, 2)


GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\'+ GlobalVariable.Data_Path + '\\MM_Application.xlsx')

GlobalVariable.Sheet_Name = 'MIGO-Reservation'

GlobalVariable.Ref_No = GlobalVariable.Ref_No + ".0"

CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 7, 2)

CustomKeywords.'myPack.WriteExcel.writeRowCol'(Result, GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 18, 2)

WebUI.callTestCase(findTestCase('Fields/Button'), [:], FailureHandling.STOP_ON_FAILURE)

rowCount = CustomKeywords.'myPack.CountCellLength.rowCount'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name)

println('Row Count is : ' + rowCount)

//Display Field and its value validation
WebUI.delay(5)

GlobalVariable.totalCount = 0

while (GlobalVariable.totalCount != rowCount) {
	GlobalVariable.Field_Type = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
		GlobalVariable.totalCount + 1, 0)

	GlobalVariable.Field_Name = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
		GlobalVariable.totalCount + 1, 1)

	GlobalVariable.New_Field_Value = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
		GlobalVariable.totalCount + 1, 2)

	//println("Field Type is : " + GlobalVariable.Field_Type)
	WebUI.callTestCase(findTestCase('Verify_Fields/Switch_Case'), [:], FailureHandling.CONTINUE_ON_FAILURE)

	GlobalVariable.totalCount = (GlobalVariable.totalCount + 1)
}

GlobalVariable.Button_Name = "Post"

WebUI.callTestCase(findTestCase('Fields/Button'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Yes']))

GlobalVariable.Success_Type = 'Document'

WebUI.callTestCase(findTestCase('Fields/Create_Message'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
	GlobalVariable.totalCount, 2)

WebUI.delay(2)

WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Ok']))