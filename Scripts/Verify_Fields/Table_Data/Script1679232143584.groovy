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

String Text, Text1



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

TestObject tableText = CustomKeywords.'myPack.Objects.tableText'(GlobalVariable.Table_Name, GlobalVariable.Table_Row,
	GlobalVariable.Table_Col)

TestObject tableText1 = CustomKeywords.'myPack.Objects.tableVal'(GlobalVariable.Table_Name, GlobalVariable.Table_Row,
	GlobalVariable.Table_Col)

//Text = WebUI.getText(tableText, FailureHandling.CONTINUE_ON_FAILURE)
//
//if (Text !=null)
//{
//	
//	Text1 = WebUI.getAttribute(tableText1, 'value', FailureHandling.STOP_ON_FAILURE)
//	
//	if (Text1 != null)
//	{	
//			GlobalVariable.Result = WebUI.verifyElementText(tableText, GlobalVariable.New_Field_Value, FailureHandling.CONTINUE_ON_FAILURE)
//	}else
//	{	
//	
//		GlobalVariable.Result = WebUI.verifyElementAttributeValue(tableText1, 'value', GlobalVariable.New_Field_Value, 0, FailureHandling.CONTINUE_ON_FAILURE)
//	
//	}	
//
//}	


GlobalVariable.Result = WebUI.verifyElementText(tableText, GlobalVariable.New_Field_Value, FailureHandling.OPTIONAL)

if (GlobalVariable.Result)
{
	
	WebUI.callTestCase(findTestCase('Verify_Fields/Result_Excel_Write'), [:], FailureHandling.OPTIONAL)
	
}else
{
	GlobalVariable.Result = WebUI.verifyElementAttributeValue(tableText1, 'value', GlobalVariable.New_Field_Value, 0, FailureHandling.OPTIONAL)
	
	WebUI.callTestCase(findTestCase('Verify_Fields/Result_Excel_Write'), [:], FailureHandling.CONTINUE_ON_FAILURE)
}		



GlobalVariable.Table_Col = GlobalVariable.Table_Col + 1

//WebUI.callTestCase(findTestCase('Verify_Fields/Result_Excel_Write'), [:], FailureHandling.STOP_ON_FAILURE)





