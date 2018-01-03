package caf.Merchants.Craftroots;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class P0_TestcasesDelete extends WalletPage {

	AppiumDriver<?> driver;

	@Parameters({ "Trow" })
	@BeforeTest
	public void AppsInstallation(int Trow) throws InterruptedException, ExecuteException, IOException {
		System.out.println("BeforeTest Executing");
		super.updateTrow(Trow);
		if (super.getOS().equals("Android")) {
			super.androidAppInstall();
			driver = super.androidAppLaunch();
		} else if (super.getOS().equals("iOS")) {
			driver = super.iOSAppiumSetup();
		}

	}

	@Test(description = "New User Registration Verification", priority = 1)
	public void Signup() throws InterruptedException, IOException {
		super.resetApp();
		super.click_SignupLink_LoginPage();
		super.newUserSignup_SignupPage(firstName_Signup, lastName_Signup, emailID_Signup, mobileNumber_Signup,
				password_Signup, confirmPassword_Signup, pincode_Signup, "f");
		//super.clcik_Home_MenuPage();
		super.click_MenuIcon_HomePage();
		super.click_MyAccountBtn_MenuPage();
		super.assertEquals_Text(super.getText_FirstName_MyAccountPage(), firstName_Signup);
		super.assertEquals_Text(super.getText_LastName_MyAccountPage(), lastName_Signup);
		super.assertEquals_Text(super.getText_EmailId_MyAccountPage(), emailID_Signup);
		super.assertEquals_Text(super.getText_PhoneNum_MyAccountPage(), mobileNumber_Signup);
		super.click_backbtn_MyAccountPage();

		System.out.println("New User Registration Verification Done");
	}
	
	@Test(description = "New User login Verification ", priority = 3)
	public void Login() throws IOException, InterruptedException {
		super.resetApp();
		super.loginBtn_LoginPage();
		super.click_MenuIcon_HomePage();
		super.click_MyAccountBtn_MenuPage();
		super.assertEquals_Text(super.getText_EmailId_MyAccountPage(), super.pvData("uidValid"));
		
		System.out.println("New User Registration Verification done");
	}
	
	@Test(description = "Forgot password link Verification", priority = 4)
	public void forgotPwd() throws IOException, InterruptedException {
		super.resetApp();
		super.click_ForgotPwdLink_LoginPage();
		super.setText_EmailId_ForgotPwdWindow();
		super.click_EmailResetLink_ForgotPwdWindow();
		super.assertEquals_Text(super.getText_forgotPwd_Success_Text_ForgotPwdWindow(), ForgotPwd_Success_Text);
	

	}
	
	@Test(description = "Add products to Cart from Category Showcase, Wishlist, Search", priority = 2)
	public void addToCart() throws IOException, InterruptedException {
		//super.click_MenuIcon_HomePage();
		super.click_CategorySelection_MenuPage(super.pvData("Category_IndexValue"));
		super.click_SubcategorySelection_Menupage(super.pvData("Subcategory_Indexvalue"));
		super.click_childcategorySelection_Menupage(super.pvData("Childcategory_Indexvalue"));
		super.click_Product_CategoryShowcasePages(super.pvData("productIndexValue"));
		super.scrollDown(1);
		super.click_AddToCartBtn_PDP();
		super.click_CartIcon_PDP();
		
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
