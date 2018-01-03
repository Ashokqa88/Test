package caf.Merchants.Fabindia;

import java.io.IOException;

public class SignupPage extends HomePage{ // Next Extension LoginPage
	
	String firstName_Signup = super.randomString(7);
	String lastName_Signup = super.randomString(7);
	String emailID_Signup = super.randomString(4) + "@" + super.randomString(3) + "." + super.randomString(3);
	String mobileNumber_Signup = "5" + super.randomNumString(9);
	String password_Signup = super.randomString(7);
	String confirmPassword_Signup = password_Signup;
	
	public void setText_FirstName_SignupPage(String firstName_Signup) throws IOException {
		super.setText(id + "edtFirstName", null, firstName_Signup);
		super.keypadNext();
		}
	
	public void setText_LastName_SignupPage(String lastName_Signup) throws IOException {
		super.setText(id + "edtLastName", null, lastName_Signup);
		super.keypadNext();
		}
	public void setText_Email_SignupPage(String emailID_Signup) throws IOException {
		super.setText(id + "edtEmail", null, emailID_Signup);
		super.keypadNext();
		}
	
	public void setText_mobileNumber_SignupPage(String emailID_Signup) throws IOException {
		super.setText(id + "edtPhoneNo", null, mobileNumber_Signup);
		super.keypadNext();
		}
	
	public void setText_Password_SignupPage(String password_Signup)throws IOException{
		super.setText(id+"edtPassword", null, password_Signup);
		super.keypadNext();
	}

	public void setText_confirmPassword_SignupPage(String password_Signup)throws IOException{
		super.setText(id+"edtCnfPassword", null,  confirmPassword_Signup);
		super.keypadClose();
	}
	public void click_submitBtn_SignupPage()throws IOException{
		super.click(id+"btnSignUp", null);
	}
	
	
	public void newUserSignup_SignupPage(String firstName_Signup, String lastName_Signup, String emailID_Signup,
	String mobileNumber_Signup, String password_Signup, String confirmPassword_Signup) throws IOException {

	this.setText_FirstName_SignupPage(firstName_Signup);
	this.setText_LastName_SignupPage(lastName_Signup);
	this.setText_Email_SignupPage(emailID_Signup);
	this.setText_mobileNumber_SignupPage(mobileNumber_Signup);
	this.setText_Password_SignupPage(confirmPassword_Signup);
	this.setText_confirmPassword_SignupPage(confirmPassword_Signup);
	this.click_submitBtn_SignupPage();
	}


}
