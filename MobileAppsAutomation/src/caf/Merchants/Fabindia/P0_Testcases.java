package caf.Merchants.Fabindia;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class P0_Testcases extends WalletPage {

	AppiumDriver<?> driver;

	@Parameters({ "Trow" })
	@BeforeTest
	public void AppsInstallation(int Trow) throws InterruptedException, ExecuteException, IOException {
		System.out.println("BeforeTest Executing");
		super.updateTrow(Trow);
		if (super.getOS().equals("Android")) {
			//super.androidAppInstall();
			driver = super.androidAppLaunch();
		} else if (super.getOS().equals("iOS")) {
			driver = super.iOSAppiumSetup();
		}

	}

	/*@Test(description = "new user registration", priority = 1)
	public void usernewsignup() throws InterruptedException, IOException {
		super.resetApp();
		super.click_Permission_Allow_Splash();
		super.click_Permission1_Allow_Splash();
		super.click_MyAccount_HomePage();
		super.click_MyAccount_Popup_HomePage("y");
		super.click_SignUpTab_LoginPage();
		super.newUserSignup_SignupPage(firstName_Signup, lastName_Signup, emailID_Signup, mobileNumber_Signup, password_Signup, confirmPassword_Signup);
		System.out.println("user registration completed");
		super.assertEquals_Text(super.getText_FirstName_MyProfilePage(), firstName_Signup);
		super.assertEquals_Text(super.getText_LastName_MyProfilePage(), lastName_Signup);
		super.assertEquals_Text(super.getText_emailid_MyProfilePage(), emailID_Signup);
		super.assertEquals_Text(super.getText_mobilenumber_MyProfilePage(), mobileNumber_Signup);
		
		
	}
	@Test(description = "existing user login", priority = 1)
	public void existinguserlogin() throws IOException, InterruptedException{
		super.resetApp();
		super.click_Permission_Allow_Splash();
		super.click_Permission1_Allow_Splash();
		super.click_MyAccount_HomePage();
		super.click_MyAccount_Popup_HomePage("y");
		super.login_LoginPage(super.pvData("uidValid"), super.pvData("pwdValid"));
		super.click_editBtn_MyAccount();
		super.assertEquals_Text(super.getText_emailid_MyProfilePage(), super.pvData("uidValid"));
	}*/
	@Test(description="forgot password",priority=1)
	public void forgotpassword() throws IOException, InterruptedException {
		super.resetApp();
		super.click_Permission_Allow_Splash();
		super.click_Permission1_Allow_Splash();
		super.click_MyAccount_HomePage();
		super.click_MyAccount_Popup_HomePage("y");
		super.click_forgotpassword_LoginPage();
		super.setText_forgotPassword_LoginPage(super.pvData("uidValid"));
		super.click_resetlink_Forgotpswd();
		super.assertEquals_Text(forgotpassword_successmessage,super.getText_forgotpasswordmsg_LoginPage());
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
