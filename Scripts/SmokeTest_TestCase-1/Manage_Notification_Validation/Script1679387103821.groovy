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

//WebUI.callTestCase(findTestCase('SmokeTest_TestCase-1/Create_Notification_All_Field'), [('Notification_NO') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)
int rowCount

//GlobalVariable.Data_Path = "Data_PRD"

GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\'+ GlobalVariable.Data_Path + '\\Create_Notification.xlsx')

GlobalVariable.Sheet_Name = 'CNO_Exist'

//CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
//   1, 2)
rowCount = CustomKeywords.'myPack.CountCellLength.rowCount'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name)

//GlobalVariable.New_Field_Value = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
//	1, 2)
//println(rowCount)
////
//WebUI.setText(findTestObject('Page_PM360/Search_Box_Input'), GlobalVariable.New_Field_Value)
//
////WebUI.click(findTestObject('Object Repository/Page_PM360/Search_Box_Button'))
//
//WebUI.click(findTestObject('Page_PM360/Order_ID', [('OrderID') : GlobalVariable.New_Field_Value]))
////
//WebUI.click(findTestObject('Page_PM360/MasterLayout_Edit_Button'))
//Display Field and its value validation
GlobalVariable.totalCount = 0

while (GlobalVariable.totalCount != rowCount) 
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
    
    GlobalVariable.totalCount = GlobalVariable.totalCount + 1
}

