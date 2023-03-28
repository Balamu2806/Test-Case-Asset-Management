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

WebUI.callTestCase(findTestCase('Login_Page/MMBE_Material_Stock_List_Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

println(" GlobalVariable.Reserved_Stock : " + GlobalVariable.Reserved_Stock)

//GlobalVariable.Required_Qty = "10"
//GlobalVariable.Required_Qty = "2"

int Req_Qty = Integer.parseInt(GlobalVariable.Required_Qty)

int UnrestrictedStock = GlobalVariable.Unrestricted_Stock - Req_Qty


GlobalVariable.Ref_No = CustomKeywords.'myPack.Convert.toString'(UnrestrictedStock, 3)

println("Current Reserved value : "  + GlobalVariable.Ref_No)


WebUI.verifyElementText(findTestObject('Page_PM360/Table_Data_Display_Field', [('tableName') : 'worklist', ('row') : 3
            , ('col') : 2]), GlobalVariable.Ref_No, FailureHandling.STOP_ON_FAILURE)


GlobalVariable.Ref_No = CustomKeywords.'myPack.Convert.toString'(GlobalVariable.Reserved_Stock, 3)

WebUI.verifyElementText(findTestObject('Page_PM360/Table_Data_Display_Field', [('tableName') : 'worklist', ('row') : 3
	, ('col') : 4]), GlobalVariable.Ref_No, FailureHandling.STOP_ON_FAILURE)




