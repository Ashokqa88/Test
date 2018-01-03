package caf.Suites.Craftroots;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import caf.Merchants.Craftroots.WalletPage;
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

	/*@Test(description = "New User Registration Verification", priority = 1)
	public void Signup() throws InterruptedException, IOException {
		super.resetApp();
		super.click_SignupLink_LoginPage();
		super.newUserSignup_SignupPage(firstName_Signup, lastName_Signup, emailID_Signup, mobileNumber_Signup,
				password_Signup, confirmPassword_Signup, pincode_Signup, "f"); // super.clcik_Home_MenuPage();
		super.click_MenuIcon_HomePage();
		super.click_MyAccountBtn_MenuPage();
		super.assertEquals_Text(super.getText_FirstName_MyAccountPage(), firstName_Signup);
		super.assertEquals_Text(super.getText_LastName_MyAccountPage(), lastName_Signup);
		super.assertEquals_Text(super.getText_EmailId_MyAccountPage(), emailID_Signup);
		super.assertEquals_Text(super.getText_PhoneNum_MyAccountPage(), mobileNumber_Signup);
		super.click_backbtn_MyAccountPage();

		System.out.println("New User Registration Verification Done");
	}

	@Test(description = "New User login Verification ", priority = 4)
	public void Login() throws IOException, InterruptedException {
		super.resetApp();
		super.loginBtn_LoginPage();
		super.click_MenuIcon_HomePage();
		super.click_MyAccountBtn_MenuPage();
		super.assertEquals_Text(super.getText_EmailId_MyAccountPage(), super.pvData("uidValid"));

		System.out.println("New User Registration Verification done");
	}

	@Test(description = "Forgot password link Verification", priority = 5)
	public void forgotPwd() throws IOException, InterruptedException {
		super.resetApp();
		super.click_ForgotPwdLink_LoginPage();
		super.setText_EmailId_ForgotPwdWindow();
		super.click_EmailResetLink_ForgotPwdWindow();
		super.assertEquals_Text(super.getText_forgotPwd_Success_Text_ForgotPwdWindow(), ForgotPwd_Success_Text);
	}

	@Test(description = "Add products to Cart from Category Showcase, Wishlist, Search", priority = 3)
	public void addToCart() throws IOException, InterruptedException {
		// super.click_MenuIcon_HomePage();
		// super.selectCategory_MenuPage(5,6,4);
		super.click_SubcategorySelection_Menupage(6);
		super.click_childcategorySelection_Menupage(4);
		super.click_Product_CategoryShowcasePages(1);
		String ProductName_Showcase = super.getProductName_PDP();

		super.scrollUp(1);
		super.click_AddToCartBtn_PDP();
		super.click_backbtn_PDP();
		super.click_Backbtn_CategoryShowcasePages();
		super.click_childcategoryBackbtn_MenuPage();

		super.click_MyWishlist_Menu();
		super.click_ProductFrame_MyWishlistPage(1);
		String ProductName_Wishlist = super.getProductName_PDP();
		super.scrollUp(1);
		super.click_AddToCartBtn_PDP();
		super.click_CartIcon_PDP();
		super.assertEquals_True(super.compareVal_CartPage(ProductName_Showcase, 2));
		super.assertEquals_True(super.compareVal_CartPage(ProductName_Wishlist, 2));
		
	}

	@Test(description = "Add products to Wishlist from Showcase, PDP", priority = 2)
	public void addToWishlist() throws IOException {
		super.click_MenuIcon_HomePage();
		super.selectCategory_MenuPage(5, 6, 4);

		String ProductName_CategoryShowcasePage = super.getProductName_CategoryShowcasePages(1);
		// int ProductPrice_CategoryShowcasePage =
		// super.getProductPrice_CategoryShowcasePages(1);
		super.click_WishlistIcon_CategoryShowcasePages(1);

		super.click_Product_CategoryShowcasePages(2);
		String ProductName_PDP = super.getProductName_PDP();
		// int ProductPrice_PDP = super.getProductPrice_PDP();
		super.click_WishlistIcon_PDP();
		super.click_backbtn_PDP();

		super.click_Backbtn_CategoryShowcasePages();
		super.click_childcategoryBackbtn_MenuPage();
		super.click_MyWishlist_Menu();

		super.assertEquals_True(super.compareVal(ProductName_CategoryShowcasePage, 2));
		// super.assertEquals_True(super.compareVal(ProductPrice_CategoryShowcasePage,
		// 2));

		super.assertEquals_True(super.compareVal(ProductName_PDP, 2));
		// super.assertEquals_True(super.compareVal(ProductPrice_PDP, 2));
		super.click_Backbtn_MyWishlistPage();

	}*/

	@Test(description = "Add new address, select the added address and proceed to checkout", priority = 4)
	public void addNewAddress() throws IOException {
		super.click_CartIcon_HomePage();
		super.click_ProceedToCheckout_CartPage();
		super.click_addNewAddress_MyAddressesPage();
	    super.setText_firstName_MyAddressesPage(firstName_NewAddress);
	    super.setText_lastName_MyAddressesPage(lastName_NewAddress);
	    super.setText_Phone_MyAddressesPage(PhoneNum_NewAddress);
	    super.setText_Pincode_MyAddressesPage(Pincode_NewAddress);
	    super.click_AddressType_MyAddressesPage();
	    super.click_SelectAddressType_MyAddressesPage(2);
	    
	    super.scrollDown(2);
	    super.setText_Address_MyAddressesPage(Address_NewAddress);
	    super.click_State_MyAddressesPage();
	    super.click_SelectState_MyAddressesPage(2);
	    
	    super.click_City_MyAddressesPage();
	    super.click_SelectCity_MyAddressesPage(2);
	    super.click_Save_MyAddressesPage();
	    String SuccessMessage = super.getText_SuccessfulMessage_MyAddressesPage();
	    super.assertEquals_Text(Successful_Message, SuccessMessage);
	    super.click_OkBtn_MyAddressesPage();
	    
	    
	  
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
