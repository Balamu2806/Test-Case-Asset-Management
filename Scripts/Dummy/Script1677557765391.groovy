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
import java.text.SimpleDateFormat


////
////strDatenew = strDateTimenew.substring(0,8)
//
////strTimenew = strDateTimenew.substring(9,14)
////System.out.println(strDateTimenew)
////System.out.println(strDatenew)
////System.out.println(strTimenew)
////Add to the body of test case
////SimpleDateFormat date = new SimpleDateFormat("MM-dd-YYYY");
////SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
////println(SimpleTimeZone.getTimeZone("EST"))
////println(SimpleTimeZone.getTimeZone("GMT"))
//
////String tzid = "EST";
////TimeZone tz = TimeZone.getTimeZone(tzid)
////
////println("User value : "+tz)
////
////date.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, 'EST'))
////time.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, 'EST'))
////
////Calendar c = Calendar.getInstance();
////
////String Str = c.getTimeZone()

String[] str = "940524 Break Down - D-MOB-P"

int count = str.length

println("Length of the String is : " + count)

String Result = ""

for (int i = count-1; i>=0 ;i--)
	
{
	Result =  Result + str[i]
	
}

println("Reverse of the String is : "+Result)
	
	


	
	

		

//////c.setTime(new Date()); //Use today’s date
////c.add(Calendar.DATE, 0); //Adds # of days
////c.add(Calendar.YEAR, 0); //Adds years
////
////String currentDate = date.format(c.getTime());
////
////String currentTime = time.format(c.getTime());
////
////System.out.println("Current Date (MM-DD-YYYY) : " + currentDate);
////
////System.out.println("Current Time (HH:mm:ss) : " + currentTime);
//
//
////SimpleDateFormat etTime = new SimpleDateFormat("HH:mm:ss");
////SimpleDateFormat etDate = new SimpleDateFormat("MM-dd-YYYY");
////TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York");
////etTime.setTimeZone( etTimeZone );
////etDate.setTimeZone( etTimeZone );
////
////Date NewDate = new Date();
////Calendar NewCal = Calendar.getInstance();
////
////String currentDate = etDate.format(NewDate.getTime());
////
////String currentTime = etTime.format(NewDate.getTime());
////
//////In ET Time
////System.out.println("Current Date is : " + currentDate);
////
////System.out.println("Current Time is : " + currentTime);
//////System.out.println(etDf.format(currentTime.getTimeInMillis()));
//
//
//int xy = 10
//
//////GlobalVariable.Ref_No = GlobalVariable.Ref_No.split(".")
////
////GlobalVariable.Ref_No = GlobalVariable.Ref_No.substring(0, GlobalVariable.Ref_No.length() - 4)
////
////GlobalVariable.Reserved_Stock = Integer.parseInt(GlobalVariable.Ref_No)
////
////
////println ("Reserved Stock = " + GlobalVariable.Reserved_Stock)
//
//
//String x = CustomKeywords.'myPack.Convert.toString'(xy,3)
//
//println("String  value : " + x)
//
//
//int k = CustomKeywords.'myPack.Convert.toInteger'("10.000", 4)
//
//println ("Integer value : " + k)