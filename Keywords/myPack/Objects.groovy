package myPack

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testobject.ConditionType

import internal.GlobalVariable

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory

public class Objects {

	@Keyword
	public TestObject tableText(String idName, int row, int col) throws IOException{

		String xPath = "(//table[contains(@id,'" +idName+ "')])//tr[" +row +"]//td["+col+"]"

		TestObject Table_Data = new TestObject("objectName")

		Table_Data.addProperty('xpath', ConditionType.EQUALS, xPath)

		return Table_Data;
	}

	@Keyword
	public TestObject tableVal(String idName, int row, int col) throws IOException{

		String xPath = "((//table[contains(@id,'" +idName+ "')])//tr[" +row +"]//td["+col+"])//input"

		TestObject Table_Data = new TestObject("objectName")

		Table_Data.addProperty('xpath', ConditionType.EQUALS, xPath)

		return Table_Data;
	}

	@Keyword
	public TestObject subTab(String idName, String txt) throws IOException{

		String xPath = "(//bdi[text()='"+ txt +"']//following::div[contains(@id,'"+idName+"')]//input)[1]"

		TestObject Sub_Tab = new TestObject("objectName")

		Sub_Tab.addProperty('xpath', ConditionType.EQUALS, xPath)

		return Sub_Tab;
	}

	@Keyword
	public int elementCount(String xPath) throws IOException{

		WebDriver driver = DriverFactory.getWebDriver()

		//String XPath = "//*[@title = "+"'"+"Time Sheet"+"']"

		println("Element Count Function : " + GlobalVariable.xPath)

		List<WebElement> elements = driver.findElements(By.xpath(xPath))

		int Count = elements.size();

		return Count

	}
}
