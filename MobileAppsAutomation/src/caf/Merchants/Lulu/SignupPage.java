package caf.Merchants.Lulu;

import java.io.IOException;

public class SignupPage extends HomePage { // Next Extension LoginPage

	protected String firstName_Signup = super.randomString(7);
	protected String lastName_Signup = super.randomString(7);
	protected String emailID_Signup = super.randomString(4) + "@" + super.randomString(3) + "." + super.randomString(3);
	protected String mobileNumber_Signup = "2" + super.randomNumString(8);
	protected String password_Signup = super.randomString(7);
	protected String confirmPassword_Signup = password_Signup;

	public void setText_FirstName_SignupPage(String firstName_Signup) throws IOException {
		super.setText(id + "firstNameEntry", locator_iOS, firstName_Signup);
		super.keypadNext();
	}

	public void setText_LastName_SignupPage(String lastName_Signup) throws IOException {
		super.setText(id + "lastNameEntry", locator_iOS, lastName_Signup);
		super.keypadNext();
	}

	public void setText_Email_SignupPage(String emailID_Signup) throws IOException {
		super.setText(id + "emailIdEntry", locator_iOS, emailID_Signup);
		super.keypadNext();
	}

	public void selectCountry_UAE_SignupPage() throws IOException {
		super.click(id + "countryEntry", locator_iOS);
		super.click(id + "tvName", locator_iOS);
	}

	public void setText_MobileNumber_SignupPage(String mobileNumber_Signup) throws IOException {
		super.setText(id + "edtMobileNumber", locator_iOS, mobileNumber_Signup);
		super.keypadClose();
	}

	public void setText_Password_SignupPage(String password_Signup) throws IOException {
		super.setText(id + "PasswordEntry", locator_iOS, password_Signup);
		super.keypadNext();
	}

	public void setText_ConfirmPassword_SignupPage(String confirmPassword_Signup) throws IOException {
		super.setText(id + "ConfirmPasswordEntry", locator_iOS, confirmPassword_Signup);
		super.keypadClose();
	}

	public void click_SubmitBtn_SignupPage() throws IOException {
		super.click(id + "submitButton", locator_iOS);
	}

	public void newUserSignup_SignupPage(String firstName_Signup, String lastName_Signup, String emailID_Signup,
			String mobileNumber_Signup, String password_Signup, String confirmPassword_Signup) throws IOException {

		this.setText_FirstName_SignupPage(firstName_Signup);
		this.setText_LastName_SignupPage(lastName_Signup);
		this.setText_Email_SignupPage(emailID_Signup);
		this.setText_Password_SignupPage(confirmPassword_Signup);
		this.setText_ConfirmPassword_SignupPage(confirmPassword_Signup);
		this.selectCountry_UAE_SignupPage();
		this.setText_MobileNumber_SignupPage(mobileNumber_Signup);

		this.click_SubmitBtn_SignupPage();
	}

}
