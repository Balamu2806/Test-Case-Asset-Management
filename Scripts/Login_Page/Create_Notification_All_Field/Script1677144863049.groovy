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

WebUI.callTestCase(findTestCase('Login_Page/Create_Notification_Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

int rowCount

int totalCount

    GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\InputFile\\Create_Notification.xlsx')

    GlobalVariable.Sheet_Name = 'CNO_All Field'

    rowCount = CustomKeywords.'myPack.CountCellLength.rowCount'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name)

    //Display Field and its value validation
    totalCount = 0

    while (totalCount != rowCount) {
        GlobalVariable.Field_Type = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
            totalCount + 1, 0)

        GlobalVariable.Field_Name = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
            totalCount + 1, 1)

        GlobalVariable.New_Field_Value = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
            totalCount + 1, 2)
		
		//println("Field Type is : " + GlobalVariable.Field_Type)
		
		switch (GlobalVariable.Field_Type) {
			case 'Button':
				GlobalVariable.Button_Name = GlobalVariable.Field_Name

				WebUI.callTestCase(findTestCase('Fields/Button'), [:], FailureHandling.STOP_ON_FAILURE)
				
				break
				
			case 'Attach':
				GlobalVariable.Attach_Doc = GlobalVariable.New_Field_Value

				WebUI.callTestCase(findTestCase('Fields/Attach_Posting'), [:], FailureHandling.STOP_ON_FAILURE)
				
				break
				
			case 'Dropdown':
				GlobalVariable.Drop_Name = GlobalVariable.Field_Name

				WebUI.callTestCase(findTestCase('Fields/Dropdown'), [:], FailureHandling.STOP_ON_FAILURE)
				
				break
				
			case 'F4':
				println("Print F4 :" + GlobalVariable.Field_Name )
				GlobalVariable.F4_Name = GlobalVariable.Field_Name

				WebUI.callTestCase(findTestCase('Fields/F4'), [:], FailureHandling.STOP_ON_FAILURE)
				
				break
			case 'FL':
				GlobalVariable.FL_Count = 0
				
				GlobalVariable.F4_Name = GlobalVariable.Field_Name
				
				GlobalVariable.Drop_Name = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
					totalCount + 1, 3)

				WebUI.callTestCase(findTestCase('Fields/FL_Eq'), [:], FailureHandling.STOP_ON_FAILURE)
				
				break
				
			case 'EQ':
				GlobalVariable.FL_Count = 1
				
				GlobalVariable.F4_Name = GlobalVariable.Field_Name
				
				GlobalVariable.Drop_Name = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
					totalCount , 3)

				WebUI.callTestCase(findTestCase('Fields/FL_Eq'), [:], FailureHandling.STOP_ON_FAILURE)
				
				break
				
			case 'Tab':
				GlobalVariable.Tab_Name = GlobalVariable.Field_Name

				WebUI.callTestCase(findTestCase('Fields/Tab'), [:], FailureHandling.STOP_ON_FAILURE)
				
				break
				
			case 'TextBox':
				GlobalVariable.Field_Value = GlobalVariable.New_Field_Value

				WebUI.callTestCase(findTestCase('Fields/TextBox'), [:], FailureHandling.STOP_ON_FAILURE)
				
				break
		}      
        
        totalCount = (totalCount + 1)		
    }
	
	WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Yes']))
	
	GlobalVariable.Success_Type =  'Notification'
	
	WebUI.callTestCase(findTestCase('Fields/Create_Message'), [:], FailureHandling.STOP_ON_FAILURE)
	
	CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name, totalCount, 2)

	WebUI.verifyElementPresent(findTestObject('Page_PM360/Pop_Up_Success_Msg',[('Success_Type') : 'Document']), totalCount, FailureHandling.STOP_ON_FAILURE)
		
	WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Ok']))
	


