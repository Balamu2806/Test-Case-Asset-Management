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


GlobalVariable.xPath = "(//span[@title='Expand/Collapse Node'])"

TestObject Expand = new TestObject("objectName")


WebUI.callTestCase(findTestCase('Verify_Fields/Elements_Count'), [:], FailureHandling.STOP_ON_FAILURE)


if (GlobalVariable.index == GlobalVariable.Count_Index)
{
	
	GlobalVariable.xPath = "(//span[@title='Expand/Collapse Node'])["+GlobalVariable.index + "]"
	
	println(GlobalVariable.xPath)
	
	Expand.addProperty('xpath', ConditionType.EQUALS, GlobalVariable.xPath)
	
	WebUI.click(Expand)
	
	GlobalVariable.Count_Index = GlobalVariable.Count_Index + 1
	println(GlobalVariable.index +" >>>>>>>Count Index : " + GlobalVariable.Count_Index )
	
}else
{
	GlobalVariable.Exit = false
}	



