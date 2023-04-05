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

WebUI.click(findTestObject('Page_PM360/F4_Button', [('F4_Name') : GlobalVariable.F4_Name]))

if (GlobalVariable.FL_Count == 0) {
	
	//WebUI.click(findTestObject('Page_PM360/Search_Box_Reset_Button'))

	WebUI.click(findTestObject('Page_PM360/Functional_Dropdown_Button',[('index') : 1 ]))
	
	//WebUI.click(findTestObject('Page_PM360/Dropdown_Value', [('Dropdown') : GlobalVariable.Drop_Name,('index') : 1 ]))
	
	WebUI.setText(findTestObject('Page_PM360/Text_Box',[('Text') : GlobalVariable.Field_Name ]),GlobalVariable.Drop_Name)
	
	WebUI.sendKeys(findTestObject('Page_PM360/Text_Box',[('Text') : GlobalVariable.Field_Name ]), Keys.chord(Keys.ENTER), FailureHandling.STOP_ON_FAILURE)
	
}

GlobalVariable.New_Field_Value = "("+GlobalVariable.New_Field_Value+")"

println(GlobalVariable.New_Field_Value)

WebUI.check(findTestObject('Page_PM360/Radio_Buttons',[('FLocation') : GlobalVariable.New_Field_Value]))

WebUI.click(findTestObject('Page_PM360/Pop_Up_Button', [('PopName') : 'Ok' ]))
