package caf.Merchants.Fabindia;

import java.io.File;
import java.io.IOException;
import org.apache.commons.exec.ExecuteException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class P1_Testcases extends CommonMethods {
	
	
	AndroidDriver<AndroidElement> aDriver;
	IOSDriver<IOSElement> iDriver;
	File appDir = new File(pvPaths("AppsPath"));
	@Parameters({ "TSrow" })
	@BeforeClass
	public void runServer(int TSrow) throws InterruptedException, ExecuteException, IOException {
		//super.startServer(TSrow);
		if (getOS(TSrow).equals("Android")) {
			aDriver = super.androidAppiumSetup(TSrow);
		} else if (getOS(TSrow).equals("iOS")) {
			iDriver = super.iOSAppiumSetup(TSrow);
		}
	}
	@Parameters({ "TSrow" })
	@Test(description = "Existing user login verification", priority = 50)
	public void existingUserLogin(int TSrow) throws InterruptedException, IOException {
		//super.resetApp(TSrow);
		super.existingUserLogin_App(TSrow);
		
		System.out.println("Existing user login verification done");
	}
	
	
	
	@AfterMethod
	public void results(ITestResult testResult) throws IOException {

		testResult(testResult);
	}

	@Parameters({ "TSrow" })
	@AfterClass
	public void Quit(int TSrow) throws InterruptedException, IOException {
		stopServer(TSrow);
		System.out.println("Stopped");
	}

}
