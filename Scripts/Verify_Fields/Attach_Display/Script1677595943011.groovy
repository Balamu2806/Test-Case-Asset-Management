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


 GlobalVariable.Result = WebUI.verifyElementClickable(findTestObject('Page_PM360/Fiori_Default_Button', [('Button') : GlobalVariable.New_Field_Value]), 
        FailureHandling.CONTINUE_ON_FAILURE)

    println('...........................' + GlobalVariable.New_Field_Value)

    if (GlobalVariable.Result == false) {
		
		CustomKeywords.'myPack.WriteExcel.writeRowCol'("Fail", GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
			GlobalVariable.totalCount+1, 4)
        KeywordUtil.markFailed(GlobalVariable.New_Field_Value + ' its Not Clickable in Master Layout Display Page')
    }else
    {
		CustomKeywords.'myPack.WriteExcel.writeRowCol'("Pass", GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
			GlobalVariable.totalCount+1, 4)		
	}
    
    WebUI.click(findTestObject('Page_PM360/Fiori_Default_Button', [('Button') : GlobalVariable.New_Field_Value]))

    GlobalVariable.Result = WebUI.verifyElementText(findTestObject('Page_PM360/Confirmation_Msg_Text'), 'Do you want to Download the Attachment?', 
        FailureHandling.CONTINUE_ON_FAILURE)

    if (GlobalVariable.Result == false) {
		
		CustomKeywords.'myPack.WriteExcel.writeRowCol'("Fail", GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
			GlobalVariable.totalCount+1, 4)
        KeywordUtil.markFailed(' Not a Valid confirmation Message !!! ')
		
		
    }else
    {
		
		CustomKeywords.'myPack.WriteExcel.writeRowCol'("Pass", GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
			GlobalVariable.totalCount+1, 4)
	}	
	
    
    WebUI.verifyElementClickable(findTestObject('Page_PM360/Fiori_Default_Button', [('Button') : 'Yes']), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementClickable(findTestObject('Page_PM360/Fiori_Default_Button', [('Button') : 'No']), FailureHandling.CONTINUE_ON_FAILURE)

  
	WebUI.click(findTestObject('Page_PM360/Fiori_Default_Button', [('Button') : 'No']))
	
	


