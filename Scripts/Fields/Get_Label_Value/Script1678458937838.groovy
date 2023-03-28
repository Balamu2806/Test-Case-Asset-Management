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



GlobalVariable.xPath = "(//span[text()='" + GlobalVariable.Field_Name + "']//following::span[contains(@id,'text')])[1]"


TestObject FieldValue = new TestObject("objectName")


println(GlobalVariable.xPath)


FieldValue.addProperty('xpath', ConditionType.EQUALS, GlobalVariable.xPath)


GlobalVariable.Ref_No = WebUI.getText(FieldValue)                      //getAttribute(FieldValue, 'value')

GlobalVariable.Current_Value = GlobalVariable.Ref_No
  

println (GlobalVariable.File_Name + "--------" + GlobalVariable.Sheet_Name + "............"+GlobalVariable.Ref_No)

CustomKeywords.'myPack.WriteExcel.writeRowCol'(GlobalVariable.Ref_No, GlobalVariable.File_Name, GlobalVariable.Sheet_Name, GlobalVariable.totalCount+1, 2)

