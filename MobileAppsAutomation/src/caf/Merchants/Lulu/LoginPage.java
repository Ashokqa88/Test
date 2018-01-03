package caf.Merchants.Lulu;

import java.io.IOException;

public class LoginPage extends SignupPage { // Next extension MyAccountPage

	protected String ForgotPwd_Success_Text = "A password reset link has been sent to your Mail.";
	
	
	public void click_SkipBtn_LoginPage() throws IOException {
		super.click(id + "tvSkipLogin", null);
	}

	public void click_ForgotPwdLink_LoginPage() throws IOException {
		super.click(id + "forgotPassword", null);
	}

	public void click_SignupTab_LoginPage() throws IOException {
		String locator_Android=xpath+"//*[@text='Sign Up']";  
		super.click(locator_Android, null);
	}

	public void setText_UserId_LoginPage(String UserId_Value) throws IOException {
		String uid_Android = id + "usernameText";
		String uid_iOS = "null";
		super.setText(uid_Android, uid_iOS, UserId_Value);
	}

	public void setText_Password_LoginPage(String Password_Value) throws IOException {
		String pwd_Android = id + "passwordText";
		String pwd_iOS = "null";
		super.setText(pwd_Android, pwd_iOS, Password_Value);
	}

	public void click_LoginBtn_LoginPage() throws IOException {
		super.click(id + "loginbutton", null);
	}

	public void login_LoginPage(String UserId_Value, String Password_Value) throws IOException {
		this.setText_UserId_LoginPage(UserId_Value);
		this.setText_Password_LoginPage(Password_Value);
		super.keypadClose();
		this.click_LoginBtn_LoginPage();
	}

	public void loginBtn_LoginPage() throws IOException {
		this.login_LoginPage(super.pvData("uidValid"), super.pvData("pwdValid"));
	}

	public void setText_EmailId_ForgotPwdWindow() throws IOException {
		String EmailId_Android = id + "et_emailId";
		String EmailId_iOS = "null";
		super.setText(EmailId_Android, EmailId_iOS, super.pvData("uidValid"));
	}

	public void click_EmailResetLink_ForgotPwdWindow() throws IOException {
		super.click(id + "btn_email_link", locator_iOS);
	}

	public void click_BacktoLogin_ForgotPwdWindow() throws IOException {
		super.click(id + "txt_back_to_login", locator_iOS);
	}

	public String getText_forgotPwd_Success_Text_ForgotPwdWindow() throws IOException {
		String s = super.getText(xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]",
				null);
		return s;
	}
}
