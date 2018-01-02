package caf.Merchants.Hypercity;

import java.io.IOException;

public class MyAccountPage extends LoginPage { // Next extension  MyProfilePage

	private String layout_MyAccount_Android = xpath
			+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";

	public String getText_Username_MyAccountPage() throws IOException {
		String s = super.getText(id + "tvUserName", null);
		return s;
	}

	public void click_MyProfileOption_MyAccountPage() throws IOException {
		super.click(layout_MyAccount_Android + "1" + super.endXpath, null);
	}

	public void click_MyOrdersOption_MyAccountPage() throws IOException {
		super.click(layout_MyAccount_Android + "2" + super.endXpath, null);
	}

	public void click_MyShoppingListOption_MyAccountPage() throws IOException {
		super.click(layout_MyAccount_Android + "3" + super.endXpath, null);
	}

	public void click_MySavedAddressOption_MyAccountPage() throws IOException {
		super.click(layout_MyAccount_Android + "4" + super.endXpath, null);
	}

	public void click_ChangePasswordOption_MyAccountPage() throws IOException {
		super.click(layout_MyAccount_Android + "5" + super.endXpath, null);
	}

	public void Logout_MyAccountPage() throws IOException {
		super.click(layout_MyAccount_Android + "6" + super.endXpath, null);
	}
}
