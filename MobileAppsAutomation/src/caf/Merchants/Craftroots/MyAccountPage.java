package caf.Merchants.Craftroots;

import java.io.IOException;

public class MyAccountPage extends LoginPage { // Next extension MyProfilePage

	// private String layout_MyAccount_Android = xpath
	// +
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";

	

	public void click_backbtn_MyAccountPage() throws IOException {
		super.click(xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.ImageButton",
				locator_iOS);
	}
	
	public void click_search_MyAccountPage() throws IOException {
		super.click(id+"img_search", locator_iOS);
	}
	
	public void click_cartIcon_MyAccountPage() throws IOException {
		super.click(id+"img_cart", locator_iOS);
	}
	
	public void click_profilebtn_MyAccountPage() throws IOException {
		super.click(id+"btn_profile", locator_iOS);
	}
	
	public void click_myOrdersbtn_MyAccountPage() throws IOException {
		super.click(id+"btn_my_orders", locator_iOS);
	}
	
	public void click_myAddressesbtn_MyAccountPage() throws IOException {
		super.click(id+"btn_my_address", locator_iOS);
	}
}
