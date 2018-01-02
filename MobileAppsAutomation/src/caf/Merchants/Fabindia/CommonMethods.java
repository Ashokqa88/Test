package caf.Merchants.Fabindia;

import java.io.IOException;

import org.testng.Assert;

import caf.FrameworkLibrary.ReusableMethods;

public class CommonMethods extends ReusableMethods {

	// Data

	private String firstName = randomString(7);
	private String lastName = randomString(7);
	private String emailId = randomString(7) + "@" + randomString(4) + "." + randomString(3);
	private String mobileNumber = String.valueOf(randomNumString(10));
	private String password = randomString(7);
	// private String phoneNumber = String.valueOf(randomNum(10));
	/*
	 * public List<String> inputData() { List<String> myString = new
	 * ArrayList<String>(); myString.add(firstName); //0 myString.add(lastName); //1
	 * myString.add(emailId); //2 myString.add(mobileNumber); //3
	 * myString.add(password); //4 myString.add(phoneNumber); //5
	 * myString.add(super.pvc( "existingUser_firstName")); //6
	 * myString.add(super.pvc( "existingUser_lastName")); //7
	 * myString.add(super.pvc( "existingUser_emailId")); //8 myString.add(super.pvc(
	 * "existingUser_mobileNumber")); //9
	 * 
	 * return (myString); }
	 */

	public void navigateToLoginPage() throws IOException {
		super.click("myActIcon_Home");
		super.popupAllow();
	}

	public void signup_App() throws IOException {

		this.navigateToLoginPage();
		super.click("signupOption");
		super.setText_DirectValue("firstName_Signup", firstName);
		super.keypadNext();
		super.setText_DirectValue("lastName_Signup", lastName);
		super.keypadNext();
		super.setText_DirectValue("emailId_Signup", emailId);
		super.keypadNext();
		super.setText_DirectValue("mobileNumber_Signup", mobileNumber);
		super.keypadNext();
		super.setText_DirectValue("password_Signup", password);
		super.keypadNext();
		super.setText_DirectValue("confirmPassword_Signup", password);
		super.keypadClose();
		super.scrollDownUntillElementVisible("signupSubmitButton", 5);
		super.click("signupSubmitButton");
		super.waitForElement("MyActWaitForElement",waitTime);
		Assert.assertEquals(super.getText("myActUsername"), firstName + " " + lastName);
		Assert.assertEquals(super.getText("myActEmailid"), emailId);
		Assert.assertEquals(super.getText("myActMobileNumber"), mobileNumber);

	}

	// It will use above newly registered user`s credentials.
	public void login_NewUser_App() throws IOException {
		this.navigateToLoginPage();
		super.setText_DirectValue("uid", emailId);
		super.keypadNext();
		super.setText_DirectValue("pwd", password);
		super.keypadClose();
		super.click("loginBtn");
		super.waitForElement("MyActWaitForElement",waitTime);
		Assert.assertEquals(super.getText("myActUsername"), firstName + " " + lastName);
		Assert.assertEquals(super.getText("myActEmailid"), emailId);
		Assert.assertEquals(super.getText("myActMobileNumber"), mobileNumber);
	}

	public void existingUserLogin_App() throws IOException {
		this.navigateToLoginPage();
		super.setText("uid", "uidValid");
		super.keypadNext();
		super.setText("pwd", "pwdValid");
		super.keypadClose();
		super.click("loginBtn");
		super.waitForElement("MyActWaitForElement",waitTime);
		Assert.assertEquals(super.getText("myActUsername"),
				super.pvc("existingUser_firstName") + " " + super.pvc("existingUser_lastName"));
		Assert.assertEquals(super.getText("myActEmailid"), super.pvc("existingUser_emailId"));
		Assert.assertEquals(super.getText("myActMobileNumber"), super.pvc("existingUser_mobileNumber"));
	}

	// It will use above newly registered user`s credentials.
	public void updateProfile_NewUser_App() throws IOException, InterruptedException {
		String firstNameUpdateProfile = randomString(7);
		String lastNameUpdateProfile = randomString(7);
		String mobileNumberUpdateProfile = String.valueOf(randomNumString(10));

		super.click("myActIcon_Home");
		super.click("myActEditIcon");
		super.setText_DirectValue("firstName_MyProfile", firstNameUpdateProfile);
		super.keypadNext();
		super.setText_DirectValue("lastName_MyProfile", lastNameUpdateProfile);
		super.keypadClose();
		super.setText_DirectValue("mobileNumber_MyProfile", mobileNumberUpdateProfile);
		super.keypadClose();
		super.click("gender_MyProfile_female");
		super.scrollDownUntillElementVisible("DOB_MyProfile", 5);
		String DOB = super.updateCalenderAndReturnDOB_MyProfile();
		System.out.println("My profile BOD is" + DOB);
		super.click("save_MyProfile");
		super.click("alertOkBtn");
		if (super.getOS().equals("Android")) {
			super.click("myActEditIcon");
		}
		super.waitForElement("firstName_MyProfile",waitTime);
		Assert.assertEquals(super.getText("firstName_MyProfile"), firstNameUpdateProfile);
		Assert.assertEquals(super.getText("lastName_MyProfile"), lastNameUpdateProfile);
		Assert.assertEquals(super.getText("emailId_MyProfile"), emailId);
		Assert.assertEquals(super.isCheckedRadioButton("gender_MyProfile_female"), true);
		Assert.assertEquals(super.getText("mobileNumber_MyProfile"), mobileNumberUpdateProfile);
		super.scrollDownUntillElementVisible("DOB_MyProfile", 5);
		Assert.assertEquals(super.getText("DOB_MyProfile"), DOB);
		super.click("cancel_MyProfile");
		super.waitForElement("MyActWaitForElement",waitTime);
		Assert.assertEquals(super.getText("myActUsername"), firstNameUpdateProfile + " " + lastNameUpdateProfile);
		Assert.assertEquals(super.getText("myActEmailid"), emailId);
		Assert.assertEquals(super.getText("myActMobileNumber"), mobileNumberUpdateProfile);

	}

	public void addToDefaultWishlist_NewUser_App() throws IOException, InterruptedException {
		// dding from banner showcase page and product details page
		super.click("banner1_Home");
		String productName_Showcase = super.getProductName_Showcase("Showcase", 1);
		String productPrice_Showcase = super.getProductPrice_Showcase("Showcase", 1);
		super.addToWishlist_Showcase("Showcase", 1);
		super.back();
		super.click("wishlistIcon_Home");
		Assert.assertEquals(super.getProductName_Showcase("Wishlist", 1), productName_Showcase);
		Assert.assertEquals(super.getProductPrice_Showcase("Wishlist", 1), productPrice_Showcase);
		super.click("closeIcon_Wishlist");
		super.popupAllow();
		super.click("startShopping_Wishlist");
		super.click("banner1_Home");
		String productName2_Showcase = super.getProductName_Showcase("Showcase", 2);
		String productPrice2_Showcase = super.getProductPrice_Showcase("Showcase", 2);
		super.clickOnProduct_Showcase("Showcase", 2); // Clicking on 2nd product
		super.click("wishlist_PDP");
		super.back();
		super.back();
		super.click("wishlistIcon_Home");
		Assert.assertEquals(super.getProductName_Showcase("Wishlist", 1), productName2_Showcase);
		Assert.assertEquals(super.getProductPrice_Showcase("Wishlist", 1), productPrice2_Showcase);
		super.click("closeIcon_Wishlist");
		super.popupAllow();
		super.click("startShopping_Wishlist");
	}

	public void addToCartFromMultiplePages_NewUser_App() throws IOException, InterruptedException {

		super.click("banner1_Home");
		super.addToCartAllVariants_PDP("Showcase", 1);
		super.back(2);
		super.clearAllWishlistProducts();
		super.click("banner1_Home");
		super.addToWishlist_Showcase("Showcase", 2);
		super.back();
		super.click("wishlistIcon_Home");
		super.addToCartAllVariants_PDP("Wishlist", 1);
		super.back(1);
		super.click("homeIcon_Home");
		super.click("searchIcon_Home");
		super.setText("editSearchField_Search", "text_Search");
		super.click("searchIcon_Search");
		super.addToCartAllVariants_PDP("Showcase", 1);
		super.back();
		super.addToCartAllVariants_PDP("Showcase", 2);
	}

}
