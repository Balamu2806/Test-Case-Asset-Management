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

String Text

if (GlobalVariable.Table_Start_Point.equals(GlobalVariable.Field_Name))
{
	
	GlobalVariable.Table_Row = GlobalVariable.Table_Row + 1
	
}	


if (GlobalVariable.Table_Row == 1)  
{
	
	if (GlobalVariable.Table_Start_Point != null)
	{
		
		GlobalVariable.Table_Start_Point =  GlobalVariable.Field_Name
		
	}
		
}

Text = WebUI.getText(findTestObject('Page_PM360/Table_Data', [('tableName') : GlobalVariable.Table_Name,
	('row') : GlobalVariable.Table_Row, ('col') : GlobalVariable.Table_Col]), FailureHandling.CONTINUE_ON_FAILURE)

if (Text !=null)
{
	
	GlobalVariable.Result = WebUI.verifyElementText(findTestObject('Page_PM360/Table_Data', [('tableName') : GlobalVariable.Table_Name,
	('row') : GlobalVariable.Table_Row, ('col') : GlobalVariable.Table_Col]), GlobalVariable.New_Field_Value, FailureHandling.CONTINUE_ON_FAILURE)
	
	
	
}else
{	
	
	GlobalVariable.Result = WebUI.verifyElementAttributeValue(findTestObject('Page_PM360/Table_Data', [('tableName') : GlobalVariable.Table_Name,
	('row') : GlobalVariable.Table_Row, ('col') : GlobalVariable.Table_Col]), 'value', GlobalVariable.New_Field_Value, 0, FailureHandling.CONTINUE_ON_FAILURE)

}	
GlobalVariable.Table_Col = GlobalVariable.Table_Col + 1

WebUI.callTestCase(findTestCase('Verify_Fields/Result_Excel_Write'), [:], FailureHandling.STOP_ON_FAILURE)





