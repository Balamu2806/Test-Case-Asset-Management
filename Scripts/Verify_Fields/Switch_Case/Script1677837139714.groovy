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

switch (GlobalVariable.Field_Type) {
    case 'DropdownDisplay':
        WebUI.callTestCase(findTestCase('Verify_Fields/Dropdown_Display'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'Button':
        GlobalVariable.Button_Name = GlobalVariable.Field_Name

        WebUI.callTestCase(findTestCase('Fields/Button'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'Attach':
        
        WebUI.callTestCase(findTestCase('Fields/Attach_Posting'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'Dropdown':
        GlobalVariable.Drop_Name = GlobalVariable.Field_Name

        WebUI.callTestCase(findTestCase('Fields/Dropdown'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'F4':
        println('Print F4 :' + GlobalVariable.Field_Name)

        GlobalVariable.F4_Name = GlobalVariable.Field_Name

        WebUI.callTestCase(findTestCase('Fields/F4'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'FL':
        GlobalVariable.FL_Count = 0

        GlobalVariable.F4_Name = GlobalVariable.Field_Name

        GlobalVariable.Drop_Name = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
            GlobalVariable.totalCount + 1, 3)

        WebUI.callTestCase(findTestCase('Fields/FL_Eq'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'EQ':
        GlobalVariable.FL_Count = 1

        GlobalVariable.F4_Name = GlobalVariable.Field_Name

        GlobalVariable.Drop_Name = CustomKeywords.'myPack.ReadExcel.readExcel'(GlobalVariable.File_Name, GlobalVariable.Sheet_Name, 
            GlobalVariable.totalCount + 1, 3)

        WebUI.callTestCase(findTestCase('Fields/FL_Eq'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'Tab':
        GlobalVariable.Tab_Name = GlobalVariable.Field_Name

        WebUI.callTestCase(findTestCase('Fields/Tab'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'TextAreaBox':
        GlobalVariable.Field_Value = GlobalVariable.New_Field_Value

        WebUI.callTestCase(findTestCase('Fields/TextArea_Input'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'FragmentButton':
        WebUI.callTestCase(findTestCase('Fields/Fragment_Button'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'DropdownDisplay':
        WebUI.callTestCase(findTestCase('Verify_Fields/Dropdown_Display'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'TextBoxDisplay':
        WebUI.callTestCase(findTestCase('Verify_Fields/TextBox_Display'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'LongTextBox':
        WebUI.callTestCase(findTestCase('Verify_Fields/Long_Text_Display'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'Display':
        WebUI.callTestCase(findTestCase('Verify_Fields/Label_Display'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'TextBox':
        GlobalVariable.Field_Value = GlobalVariable.New_Field_Value

        WebUI.callTestCase(findTestCase('Fields/TextBox_Input'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'FragDropdown':
        GlobalVariable.Drop_Name = GlobalVariable.Field_Name

        WebUI.callTestCase(findTestCase('Fields/Dropdown'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'Wait':
        WebUI.delay(2)

        break
    case 'LongTextIcon':
        println('Not Required as now')

        break
    case 'GetTexBoxValue':
        WebUI.callTestCase(findTestCase('Fields/Get_TextBox_Value'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'TableDisplay':
        WebUI.callTestCase(findTestCase('Verify_Fields/Table_Data'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'Button_Disable':
        WebUI.callTestCase(findTestCase('Verify_Fields/Button_Disable'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'Navigate':
        WebUI.callTestCase(findTestCase('Fields/Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'GetValue':
        WebUI.callTestCase(findTestCase('Fields/Get_Label_Value'), [:], FailureHandling.STOP_ON_FAILURE)

        break
    case 'TablePost':
	
        WebUI.callTestCase(findTestCase('Fields/Table_Data_Posting'), [:], FailureHandling.STOP_ON_FAILURE)

        break
		
	case 'SubTabDisplay' :
	
		WebUI.callTestCase(findTestCase('Verify_Fields/Sub_Tab'), [:], FailureHandling.STOP_ON_FAILURE)
		
		break
		
	case 'FragTextBox'	:
	
		GlobalVariable.Table_Name = "account"
	
		WebUI.callTestCase(findTestCase('Verify_Fields/Sub_Tab'), [:], FailureHandling.STOP_ON_FAILURE)
	
		break
}

