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
import com.kms.katalon.core.testobject.ConditionType


GlobalVariable.Title = WebUI.getWindowTitle()

println(GlobalVariable.Title)

if (GlobalVariable.Title.equals('Goods Issue'))
{
	
	GlobalVariable.Table_Name =  (GlobalVariable.Title).substring(0,4)
	
	GlobalVariable.Table_Name = GlobalVariable.Table_Name.toLowerCase();
	
}else
{
	GlobalVariable.Table_Name =  (GlobalVariable.Tab_Name).substring(0,4)
}	

println(GlobalVariable.Table_Name)

GlobalVariable.Table_Row = 1

GlobalVariable.Table_Col = 2
		
GlobalVariable.Table_Start_Point = null



//if (GlobalVariable.index <= 1)
//	
//{
//	
//	WebUI.click(findTestObject('Page_PM360/Tabs', [('Tab') : GlobalVariable.Tab_Name]))
//
//}else
//{
//	
//	
//	WebUI.click(findTestObject('Page_PM360/Tabs_Index', [('Tab') : GlobalVariable.Tab_Name, ('index') : GlobalVariable.index]))
//	
//	GlobalVariable.index = 0
//	
//}

//bdi[(text() = '${Tab}')]

GlobalVariable.xPath = "//bdi[text() = '" + GlobalVariable.Tab_Name + "']"
 
 TestObject Tab = new TestObject("objectName")
 
 
 WebUI.callTestCase(findTestCase('Verify_Fields/Elements_Count'), [:], FailureHandling.STOP_ON_FAILURE)
 
 
 if (GlobalVariable.index > 1)
 {
	 
	 GlobalVariable.xPath = "(//bdi[text() = '" + GlobalVariable.Tab_Name + "'])[" + GlobalVariable.index  +  "]"
 }
 
 
 println(GlobalVariable.xPath)
 
 Tab.addProperty('xpath', ConditionType.EQUALS, GlobalVariable.xPath)
 
 WebUI.click(Tab)