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

import internal.GlobalVariable
import java.text.SimpleDateFormat

public class DateTime {

	@Keyword
	public String ESTDate() throws IOException {
		SimpleDateFormat etDate = new SimpleDateFormat("MM-dd-YYYY");

		TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York");

		Date NewDate = new Date();

		Calendar NewCal = Calendar.getInstance();

		String currentDate = etDate.format(NewDate.getTime());

		return currentDate;
	}


	@Keyword
	public String ESTTime() throws IOException {
		SimpleDateFormat etTime = new SimpleDateFormat("HH:mm:ss");

		TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York");

		etTime.setTimeZone( etTimeZone );

		Date NewDate = new Date();

		Calendar NewCal = Calendar.getInstance();

		String currentTime = etTime.format(NewDate.getTime());

		return currentTime;
	}
}
