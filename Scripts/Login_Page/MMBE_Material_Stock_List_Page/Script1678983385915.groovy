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

GlobalVariable.Field_Name = 'MMBE'

GlobalVariable.File_Name = (RunConfiguration.getProjectDir() + '\\'+ GlobalVariable.Data_Path + '\\MM_Application.xlsx')

GlobalVariable.Sheet_Name = 'MMBE_Before'

WebUI.callTestCase(findTestCase('Fields/Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_PM360/F4_Button', [('F4_Name') : 'Material']))

WebUI.setText(findTestObject('Page_PM360/Fragment_Dropdown', [('DropdownName') : 'plant']), 'VL01 MOB OIL REFINERY PLANT')

WebUI.sendKeys(findTestObject('Page_PM360/Fragment_Dropdown', [('DropdownName') : 'plant']), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)

GlobalVariable.Field_Value = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name,
	1, 2)

WebUI.click(findTestObject('Page_PM360/Order_ID', [('OrderID') : GlobalVariable.Field_Value]))

WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Ok']))

WebUI.click(findTestObject('Page_PM360/Button_Name', [('ButtonName') : 'Go']))

GlobalVariable.Exit = true

GlobalVariable.Count_Index = 1

while (GlobalVariable.Exit)
{
	
	WebUI.callTestCase(findTestCase('Fields/Tree_Expand'), [:], FailureHandling.STOP_ON_FAILURE)
	
}


