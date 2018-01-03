package caf.Merchants.Craftroots;

import java.io.IOException;

public class SignupPage extends HomePage { // Next Extension LoginPage

	protected String firstName_Signup = super.randomString(7);
	protected String lastName_Signup = super.randomString(7);
	protected String emailID_Signup = super.randomString(4) + "@" + super.randomString(3) + "." + super.randomString(3);
	protected String mobileNumber_Signup = "5" + super.randomNumString(9);
	protected String password_Signup = super.randomString(7);
	protected String confirmPassword_Signup = password_Signup;
	protected String pincode_Signup = super.randomNumString(6);

	
	
	public void setText_FirstName_SignupPage(String firstName_Signup) throws IOException {
		super.setText(id + "et_firstName", locator_iOS, firstName_Signup);
		super.keypadNext();
	}

	public void setText_LastName_SignupPage(String lastName_Signup) throws IOException {
		super.setText(id + "et_lastName", locator_iOS, lastName_Signup);
		super.keypadNext();
	}

	public void setText_Email_SignupPage(String emailID_Signup) throws IOException {
		super.setText(id + "et_emailId", locator_iOS, emailID_Signup);
		super.keypadNext();
	}

	public void setText_MobileNumber_SignupPage(String mobileNumber_Signup) throws IOException {
		super.setText(id + "et_PhoneNumber", locator_iOS, mobileNumber_Signup);
		super.keypadNext();
	}

	public void setText_Password_SignupPage(String password_Signup) throws IOException {
		super.setText(id + "et_Password", locator_iOS, password_Signup);
		super.keypadNext();
	}

	public void setText_ConfirmPassword_SignupPage(String confirmPassword_Signup) throws IOException {
		super.setText(id + "et_ConfirmPassword", locator_iOS, confirmPassword_Signup);
		super.keypadNext();
	}

	public void setText_Pincode_SignupPage(String pincode_Signup) throws IOException {
		super.setText(id + "et_Pincode", locator_iOS, pincode_Signup);
		super.keypadClose();
	}

	public void selectGender_SignupPage(String f_m) throws IOException {
		if (f_m.equals("m")) {
			super.click(id + "radioM", locator_iOS);
		} else if (f_m.equals("f")) {
			super.click(id + "radioF", locator_iOS);
		}
	}

	public void click_SignupBtn_SignupPage() throws IOException {
		super.click(id + "btn_signup", locator_iOS);
	}

	public void newUserSignup_SignupPage(String firstName_Signup, String lastName_Signup, String emailID_Signup,
			String mobileNumber_Signup, String password_Signup, String confirmPassword_Signup, String pincode_Signup,
			String f_m) throws IOException {

		this.setText_FirstName_SignupPage(firstName_Signup);
		this.setText_LastName_SignupPage(lastName_Signup);
		this.setText_Email_SignupPage(emailID_Signup);
		this.setText_MobileNumber_SignupPage(mobileNumber_Signup);
		this.setText_Password_SignupPage(confirmPassword_Signup);
		this.setText_ConfirmPassword_SignupPage(confirmPassword_Signup);
		this.setText_Pincode_SignupPage(pincode_Signup);
		this.selectGender_SignupPage(f_m);
		this.click_SignupBtn_SignupPage();
	}

}
