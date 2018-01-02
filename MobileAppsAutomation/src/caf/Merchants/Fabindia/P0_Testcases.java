package caf.Merchants.Fabindia;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.ExecuteException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class P0_Testcases extends CommonMethods {

	AndroidDriver<AndroidElement> aDriver;
	IOSDriver<IOSElement> iDriver;
	

	@Parameters({ "Trow" })
	@BeforeClass
	public void runServer(int Trow) throws InterruptedException, ExecuteException, IOException {
		super.updateTrow(Trow);
		if (super.getOS().equals("Android")) {
			super.androidAppInstall();
			aDriver = super.androidAppLaunch();
		} else if (super.getOS().equals("iOS")) {
			iDriver = super.iOSAppiumSetup();
		}
		
	}
	
	//@Parameters({ "Trow" })
	@Test(description = "New user`s Signup verification", priority = 0)
	public void signUp() throws InterruptedException, IOException {
		super.resetApp();
		super.signup_App();
		System.out.println("New user`s Signup verification done");

	}

	//@Parameters({ "Trow" })
	@Test(description = "New user`s login verification", priority = 1, dependsOnMethods = { "signUp" })
	public void login() throws InterruptedException, IOException {
		super.resetApp();
		super.login_NewUser_App();

		System.out.println("New user`s login verification done");
	}

	// , dependsOnMethods = { "login" }
	//@Parameters({ "Trow" })
	@Test(description = "New user`s my profile update verification", priority =2, dependsOnMethods = { "login" })
	public void addToDefaultWishlist() throws InterruptedException, IOException {
		super.launchApp();
		super.addToDefaultWishlist_NewUser_App();

		System.out.println("New user`s My Profile Update Verification");

	}

	// , dependsOnMethods = { "login" }
	//@Parameters({ "Trow" })
	@Test(description = "Add To Cart From Multiple Showcases", priority = 3, dependsOnMethods = { "login" })
	public void addToCart() throws InterruptedException, IOException {
		super.launchApp();
		super.addToCartFromMultiplePages_NewUser_App();
		System.out.println("New user`s My Profile Update Verification");

	}


	// , dependsOnMethods = { "login" }
	//@Parameters({ "Trow" })
	 @Test(description = "New user`s my profile update verification", priority =4, dependsOnMethods = { "login" })
	public void updateProfile() throws InterruptedException, IOException {
		super.launchApp();
		super.updateProfile_NewUser_App();

		System.out.println("New user`s My Profile Update Verification");

	}

	//@Parameters({ "Trow" })
	@Test(description = "Existing user login verification", priority = 5, dependsOnMethods = { "login" })
	public void existingUserLogin() throws InterruptedException, IOException {
		super.resetApp();
		super.existingUserLogin_App();

		System.out.println("Existing user login verification done");
	}
	// @Parameters({ "TSrow" })
	// @Test(description = "My Profile Update Verification", priority =
	// 2,dependsOnMethods = { "login" })
	public void updateCart() throws InterruptedException, IOException {

		launchApp();

	}

	@AfterMethod
	public void results(ITestResult testResult) throws IOException {

		testResult(testResult);
	}

	/*
	 * @Parameters({ "TSrow" })
	 * 
	 * @AfterClass public void Quit(int TSrow) throws InterruptedException,
	 * IOException { super.stopServer(TSrow); Thread.sleep(5000);
	 * System.out.println("Stopped"); }
	 */
}
