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
import com.kms.katalon.core.testobject.ConditionType


//if (GlobalVariable.index <=1)
//{
//	println("Button Index = 0")
//	WebUI.click(findTestObject('Page_PM360/Button_Name', [('ButtonName') : GlobalVariable.Button_Name]))
//	
//}else
//{
//	
//	WebUI.click(findTestObject('Page_PM360/Button_Name_Index', [('ButtonName') : GlobalVariable.Button_Name, ('index') : GlobalVariable.index]))
//
//	println("Button Index Greater than 0")
//	
//	GlobalVariable.index = 0
//}



GlobalVariable.xPath = "//*[@title = '"+GlobalVariable.Button_Name+"']"

TestObject Button = new TestObject("objectName")


WebUI.callTestCase(findTestCase('Verify_Fields/Elements_Count'), [:], FailureHandling.STOP_ON_FAILURE)


if (GlobalVariable.index > 1)
{
	if (GlobalVariable.Button_Name.equals("TECO"))
	{
		GlobalVariable.index = 1
	}	
	GlobalVariable.xPath = "(//*[@title = '"+ GlobalVariable.Button_Name + "'])["+GlobalVariable.index + "]"
}	


println(GlobalVariable.xPath)

Button.addProperty('xpath', ConditionType.EQUALS, GlobalVariable.xPath)

WebUI.click(Button)

