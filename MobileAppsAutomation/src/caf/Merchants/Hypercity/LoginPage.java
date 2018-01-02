package caf.Merchants.Hypercity;

import java.io.IOException;

public class LoginPage extends SignupPage { // Next extension  MyAccountPage
	
	public void setText_UserId_LoginPage(String UserId_Value) throws IOException {
		String uid_Android=xpath+"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText";
		String uid_iOS="null";
		super.setText(uid_Android, uid_iOS, UserId_Value);
	}
	public void click_PasswordRadioBtn_LoginPage() throws IOException {
		super.click(id+"rbHavePassword", null);
	}
	
	public void setText_Password_LoginPage(String Password_Value) throws IOException {
		String pwd_Android=xpath+"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText";
		String pwd_iOS="null";
		super.setText(pwd_Android, pwd_iOS ,Password_Value);
	}
	
	public void click_LoginBtn_LoginPage() throws IOException {
		super.click(id+"bContinue", null);
	}
	
	public void login_App(String UserId_Value,String Password_Value) throws IOException {
		this.setText_UserId_LoginPage(UserId_Value);
		this.click_PasswordRadioBtn_LoginPage();
		this.setText_Password_LoginPage(Password_Value);
		super.keypadClose();
		this.click_LoginBtn_LoginPage();
	}
	
	public void existingUserLogin_App() throws IOException {
		this.login_App(super.pvData("uidValid"), super.pvData("pwdValid"));
	}
	
}
