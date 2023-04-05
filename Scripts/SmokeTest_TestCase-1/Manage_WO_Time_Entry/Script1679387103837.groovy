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

int rowCount

//GlobalVariable.Data_Path = "Data_QAS"

//GlobalVariable.OrderID = "913616"

GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\'+ GlobalVariable.Data_Path + '\\Create_Work_Order.xlsx')

GlobalVariable.Sheet_Name = 'Time_Sheet'

CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.OrderID, GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 1, 2)

rowCount = CustomKeywords.'myPack.CountCellLength.rowCount'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name)

GlobalVariable.OrderID = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
    1, 2)

GlobalVariable.Field_Name ="Manage Work Order"

WebUI.callTestCase(findTestCase('Fields/Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.totalCount = 1

while (GlobalVariable.totalCount != rowCount) {
	
	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	
    GlobalVariable.Field_Type = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
        GlobalVariable.totalCount + 1, 0)

    GlobalVariable.Field_Name = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
        GlobalVariable.totalCount + 1, 1)

    GlobalVariable.New_Field_Value = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
        GlobalVariable.totalCount + 1, 2)

    
    WebUI.callTestCase(findTestCase('Verify_Fields/Switch_Case'), [:], FailureHandling.STOP_ON_FAILURE)

    GlobalVariable.totalCount = (GlobalVariable.totalCount + 1)
}

WebUI.click(findTestObject('Page_PM360/Plant_ID', [('PlantID') : GlobalVariable.New_Field_Value]))

WebUI.click(findTestObject('Page_PM360/Button_Name', [('ButtonName') : 'Save']))

WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Yes']))

GlobalVariable.Success_Type = 'Information'

String Required_Msg = ('Confirmation of Order ' + GlobalVariable.OrderID) + ' Saved'

WebUI.verifyElementPresent(findTestObject('Page_PM360/Pop_Up_Success_Msg', [('Success_Type') : Required_Msg]), 0)

WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Ok']))

GlobalVariable.xPath = '(//span[text()=\'System Status\']//following::span[contains(@id,\'text\')])[1]'

TestObject getValue = new TestObject('objectName')

println(GlobalVariable.xPath)

getValue.addProperty('xpath', ConditionType.EQUALS, GlobalVariable.xPath)

WebUI.verifyElementText(getValue, 'Partially Confirmed', FailureHandling.STOP_ON_FAILURE)

GlobalVariable.Button_Name = 'Time Sheet'

WebUI.callTestCase(findTestCase('Fields/Button'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.Button_Name = 'Edit'

WebUI.callTestCase(findTestCase('Fields/Button'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.xPath = '(//span[text()=\'0010\']//following::span[contains(@id,\'text\')])[2]'

TestObject FieldValue = new TestObject('objectName')

println(GlobalVariable.xPath)

FieldValue.addProperty('xpath', ConditionType.EQUALS, GlobalVariable.xPath)

GlobalVariable.Ref_No = WebUI.getText(FieldValue)

GlobalVariable.Ref_No = GlobalVariable.Ref_No 

GlobalVariable.Sheet_Name = 'Time_Sheet_Summary'



CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
    2, 2)

///

WebUI.callTestCase(findTestCase('Login_Page/Time_Sheet_Summary'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.Tab_Name = "Operations"

WebUI.callTestCase(findTestCase('Fields/Tab'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Login_Page/Time_Sheet_Operation'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.Button_Name = 'Save'

WebUI.callTestCase(findTestCase('Fields/Button'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Yes']))

GlobalVariable.Success_Type = 'Success'

Required_Msg = ('Confirmation of Order ' + GlobalVariable.OrderID) + ' Saved'

WebUI.verifyElementPresent(findTestObject('Page_PM360/Pop_Up_Success_Msg', [('Success_Type') : Required_Msg]), 0)


WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Ok']))

GlobalVariable.Tab_Name = "Summary"

WebUI.callTestCase(findTestCase('Fields/Tab'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Login_Page/Time_Sheet_Summary'), [:], FailureHandling.STOP_ON_FAILURE)


