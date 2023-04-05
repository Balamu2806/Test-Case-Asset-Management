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

GlobalVariable.Role = "Admin"

WebUI.callTestCase(findTestCase('Login_Page/Create_Notification_Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

int rowCount

GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\'+ GlobalVariable.Data_Path + '\\Create_Notification.xlsx')

GlobalVariable.Sheet_Name = 'CNO_All_Field'

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
    WebUI.callTestCase(findTestCase('Verify_Fields/Switch_Case'), [:], FailureHandling.STOP_ON_FAILURE)

    GlobalVariable.totalCount = (GlobalVariable.totalCount + 1)
}

WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Yes']))

GlobalVariable.Success_Type = 'Notification'

WebUI.callTestCase(findTestCase('Fields/Create_Message'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
    GlobalVariable.totalCount, 2)

GlobalVariable.Sheet_Name = 'CNO_Exist'

CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
    1, 2)

GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\'+ GlobalVariable.Data_Path + '\\Create_WorK_Order.xlsx')

CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, 'CWO_Reverse', 9, 2)

//WebUI.verifyElementPresent(findTestObject('Page_PM360/Pop_Up_Success_Msg',[('Success_Type') : 'Document']), totalCount, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, 'CWO_Exist_Reserve', 10, 
    2)

WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Ok']))

