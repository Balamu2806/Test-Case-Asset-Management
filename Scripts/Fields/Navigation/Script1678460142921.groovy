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


switch (GlobalVariable.Field_Name)
{
	
	case 'Create Notification':
			
		GlobalVariable.Menu_Name= 'Notification'
		
		GlobalVariable.Search   = "No"

		WebUI.click(findTestObject('Page_PM360/Menu_Name',[('MenuName') : GlobalVariable.Menu_Name]))

		WebUI.click(findTestObject('Page_Home/Application_Name', [('App_Name') : GlobalVariable.Field_Name]))

	break
		
	case 'Manage Notification':
	
		GlobalVariable.Menu_Name= 'Notification'
		
		GlobalVariable.Search   = "Yes"

		WebUI.click(findTestObject('Page_PM360/Menu_Name',[('MenuName') : GlobalVariable.Menu_Name]))

		WebUI.click(findTestObject('Page_Home/Application_Name', [('App_Name') : GlobalVariable.Field_Name]))

	break
		
	case 'Create Work Order':
	
		GlobalVariable.Menu_Name= 'Work Order'
		
		GlobalVariable.Search   = "No"	

		WebUI.click(findTestObject('Page_PM360/Menu_Name',[('MenuName') : GlobalVariable.Menu_Name]))

		WebUI.click(findTestObject('Page_Home/Application_Name', [('App_Name') : GlobalVariable.Field_Name]))

	break
		
	case 'Manage Work Order': 	
		
		GlobalVariable.Menu_Name= 'Work Order'
		
		GlobalVariable.Search   = "Yes"
	
		WebUI.click(findTestObject('Page_PM360/Menu_Name',[('MenuName') : GlobalVariable.Menu_Name]))
	
		WebUI.click(findTestObject('Page_Home/Application_Name', [('App_Name') : GlobalVariable.Field_Name]))
	
	break
	
		
	case 'Time Sheet':
		
		GlobalVariable.Menu_Name= 'Time Sheet'
		
		GlobalVariable.Search   = "Yes"
	
		WebUI.click(findTestObject('Page_PM360/Menu_Name',[('MenuName') : GlobalVariable.Menu_Name]))
	
		//WebUI.click(findTestObject('Page_Home/Application_Name', [('App_Name') : GlobalVariable.Field_Name]))
	
	break
		
	case 'Goods Issue':
		
		GlobalVariable.Menu_Name= 'MIGO'
		
		GlobalVariable.Search   = "No"
	
		WebUI.click(findTestObject('Page_PM360/Menu_Name',[('MenuName') : GlobalVariable.Menu_Name]))
	
		WebUI.click(findTestObject('Page_Home/Application_Name', [('App_Name') : GlobalVariable.Field_Name]))
	
	break
	
	case 'Goods Receipt':
	
		GlobalVariable.Menu_Name= 'MIGO'
	
		GlobalVariable.Search   = "No"
		
		WebUI.click(findTestObject('Page_PM360/Menu_Name',[('MenuName') : GlobalVariable.Menu_Name]))

		WebUI.click(findTestObject('Page_Home/Application_Name', [('App_Name') : GlobalVariable.Field_Name]))

	break
	
	case 'MMBE':
	
	GlobalVariable.Menu_Name= 'MMBE'
	
	GlobalVariable.Search   = "No"

	WebUI.click(findTestObject('Page_PM360/Menu_Name',[('MenuName') : GlobalVariable.Menu_Name]))

	//WebUI.click(findTestObject('Page_Home/Application_Name', [('App_Name') : GlobalVariable.Field_Name]))

	break
}	


if (GlobalVariable.Search.equals("Yes"))
{	
		
	WebUI.callTestCase(findTestCase('Fields/Search_Box'), [:], FailureHandling.STOP_ON_FAILURE)
		
}		