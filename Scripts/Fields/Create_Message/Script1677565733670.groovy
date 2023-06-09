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


GlobalVariable.Ref_No = WebUI.getText(findTestObject('Page_PM360/Pop_Up_Success_Msg',[('Success_Type') : GlobalVariable.Success_Type]))

//GlobalVariable.Ref_No = "Work Order 940493 Created Successfully with Notification 10046617"
//
//GlobalVariable.Ref_No = GlobalVariable.Ref_No.replace(GlobalVariable.Success_Type, '')
//
////GlobalVariable.Ref_No = GlobalVariable.Ref_No.replace("Notification", '')
//
//GlobalVariable.Ref_No = GlobalVariable.Ref_No.replace(' Created Successfully', '')
//
//GlobalVariable.Ref_No = GlobalVariable.Ref_No.trim()

String regex = "[^\\d]+";

String[] str = GlobalVariable.Ref_No.split(regex);

GlobalVariable.Ref_No = str[1]

println(GlobalVariable.Ref_No)
