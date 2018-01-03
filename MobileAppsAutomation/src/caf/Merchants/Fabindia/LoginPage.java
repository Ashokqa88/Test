package caf.Merchants.Fabindia;

import java.io.IOException;

public class LoginPage extends SignupPage { // Next extension MyAccountPage
	String forgotpassword_successmessage="A reset link has been sent to your mail.";

	public void click_UserId_LoginPage() throws IOException {
		super.click(id + "edtEmail", null);
	}

	public void setText_UserId_LoginPage(String UserId_Value) throws IOException {
		String uid_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText[1]\n";
		String uid_iOS = "null";
		super.setText(uid_Android, uid_iOS, UserId_Value);
	}

	public void click_Password_LoginPage() throws IOException {
		super.click(id + "edtPassword", null);
	}

	public void setText_Password_LoginPage(String Password_Value) throws IOException {
		String pwd_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText[2]";
		String pwd_iOS = "null";
		super.setText(pwd_Android, pwd_iOS, Password_Value);
	}

	public void click_LoginBtn_LoginPage() throws IOException {
		super.click(id + "btnSignIn", null);
	}

	public void click_SignUpTab_LoginPage() throws IOException {
		
		super.click( xpath+"//*[@text='Sign Up']", null);
	}
	
	public void click_forgotpassword_LoginPage() throws IOException {
		super.click(id+"tvForgotPwd", null);
	}
	public void setText_forgotPassword_LoginPage(String UserId_Value) throws IOException {
		String uid_Android = xpath
				+ "	/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText";
		String uid_iOS = "null";
		super.setText(uid_Android, uid_iOS, UserId_Value);
		super.keypadClose();
	}
	public void click_resetlink_Forgotpswd() throws IOException {
		super.click(id+"btnPwdResetLink", null);
	}
	public String getText_forgotpasswordmsg_LoginPage() throws IOException {
		String s = super.getText(xpath + "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]", null);
		return s;
		
	}
	public void login_LoginPage(String UserId_Value, String Password_Value) throws IOException {
		this.setText_UserId_LoginPage(UserId_Value);
		this.click_Password_LoginPage();
		this.setText_Password_LoginPage(Password_Value);
		super.keypadClose();
		this.click_LoginBtn_LoginPage();
	}

	public void login_LoginPage() throws IOException {
		this.login_LoginPage(super.pvData("uidValid"), super.pvData("pwdValid"));
	}

}
