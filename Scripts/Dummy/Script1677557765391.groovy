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

GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\InputFile\\Create_Notification.xlsx')

	GlobalVariable.Sheet_Name = 'CNO_All Field'
	
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
			
			
			
			
			
			totalCount = (totalCount + 1)
		}
		
		println("Field Type is : " + GlobalVariable.Field_Type)
		
		//WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Yes']))
		
		Notification_NO = "Notification 10046601 Created Successfully" //WebUI.getText(findTestObject('Page_PM360/Pop_Up_Success_Msg',[('Success_Type') : 'Notification']))
		
		Notification_NO = Notification_NO.replace('Notification ', '')
		
		Notification_NO = Notification_NO.replace(' Created Successfully', '')
		
		CustomKeywords.'myPack.WriteExcel.writeRowCol'(Notification_NO, GlobalVariable.File_Name, GlobalVariable.Sheet_Name, totalCount, 2)
		
		//WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Ok']))
		
	