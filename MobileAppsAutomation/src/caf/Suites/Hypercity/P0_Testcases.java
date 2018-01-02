package caf.Suites.Hypercity;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import caf.Merchants.Hypercity.WalletPage;
import io.appium.java_client.AppiumDriver;

public class P0_Testcases extends WalletPage {

	AppiumDriver<?> driver;

	@Parameters({ "Trow" })
	@BeforeTest
	public void AppsInstallation(int Trow) throws InterruptedException, ExecuteException, IOException {
		System.out.println("BeforeTest Executing");
		super.updateTrow(Trow);
		if (super.getOS().equals("Android")) {
			// super.androidAppInstall();
			driver = super.androidAppLaunch();
		} else if (super.getOS().equals("iOS")) {
			driver = super.iOSAppiumSetup();
		}

	}

	// @Test(description = "Existing user login verification", priority = 1)
	public void existingUserLogin() throws InterruptedException, IOException {
		super.resetApp_SplashScreen();
		super.navigateToHomePage_By_LocationSearchAndSelect_LocationSelectionPage(1);
		super.click_MyAccountIcon_HomePage();
		super.existingUserLogin_App();
		super.assertEquals_Text(super.getText_Username_MyAccountPage(),
				super.pvData("existingUser_firstName") + " " + super.pvData("existingUser_lastName"));
		System.out.println("Existing user login verification done");
	}

	@Test(description = "Existing user login verification", priority = 2)
	public void addToCart() throws InterruptedException, IOException {
		super.launchApp();
		super.selectCategory_MenuPage(2, 1, 1);
		super.addToCart_AllVariantsOrNonVaraintProduct_CategoryShowcasePages(1);
		
super.click_Product_CategoryShowcasePages(2);
super.addToCart_AllVariantsOrNonVaraintProduct_ProductDetailsPage();
super.selectCategory_MenuPage(2, 1, 1);


super.click_Product_CategoryShowcasePages(3);

super.addToCart_AllVariantsOrNonVaraintProduct_ProductDetailsPage();
System.out.println("addToCart_AllVariantsOrNonVaraintProduct_ProductDetailsPage 4");
super.selectCategory_MenuPage(2, 1, 1);


super.click_Product_CategoryShowcasePages(4);

super.addToCart_AllVariantsOrNonVaraintProduct_ProductDetailsPage();
//String wishlistName= super.addProductToExistingWishlist_ProductDetailsPage();
		// super.assertEquals_Text(super.getText_Username_MyAccountPage(),
		// super.pvData("existingUser_firstName")+"
		// "+super.pvData("existingUser_lastName"));
//System.out.println("wishlistName name is :" + wishlistName);

		System.out.println("Existing user login verification done");
	}

	@AfterMethod
	public void results(ITestResult testResult) throws IOException {

		super.testResult(testResult);
	}

	@AfterTest
	public void Quit() throws InterruptedException, IOException {
		super.stopServer();
		Thread.sleep(5000);
		System.out.println("Stopped");
	}

}
