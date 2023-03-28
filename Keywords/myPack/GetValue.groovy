package myPack
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class GetValue {

	@Keyword
	public TestObject tableGetValue() {

		GlobalVariable.xPath = "//*[@title = '"+GlobalVariable.Button_Name+"']"

		TestObject Button = new TestObject("objectName")


		//WebUI.callTestCase(findTestCase('Verify_Fields/Elements_Count'), [:], FailureHandling.STOP_ON_FAILURE)

		GlobalVariable.index = indexCount()

		if (GlobalVariable.index > 1)
		{

			GlobalVariable.xPath = "(//*[@title = '"+ GlobalVariable.Button_Name + "'])["+GlobalVariable.index + "]"
		}


		println(GlobalVariable.xPath)

		Button.addProperty('xpath', ConditionType.EQUALS, GlobalVariable.xPath)

		return Button
	}

	@Keyword
	public int indexCount()
	{

		WebDriver driver = DriverFactory.getWebDriver()

		//String XPath = "//*[@title = "+"'"+"Time Sheet"+"']"

		println("Element Count Function : " + GlobalVariable.xPath)

		List<WebElement> elements = driver.findElements(By.xpath(GlobalVariable.xPath))

		GlobalVariable.index = elements.size();

		println('No of Element : ' + GlobalVariable.index)

	}

}