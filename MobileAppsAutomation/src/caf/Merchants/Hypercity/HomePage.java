package caf.Merchants.Hypercity;

import java.io.IOException;

public class HomePage extends LocationSelectionPage { // Next Extension SignupPage

	private String categorySelection_menu = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";

	public void click_MyAccountIcon_HomePage() throws IOException {
		super.click(id + "action_notification", null);
	}

	public void click_CartIcon_HomePage() throws IOException {
		super.click(id + "rlCart", null);

	}

	public void click_CheckoutIcon_HomePage() throws IOException {
		super.click(id + "bCheckout", null);

	}

	public void click_MenuIcon_HomePage() throws IOException {
		super.click(xpath + "//android.widget.ImageButton[@content-desc='Navigate up']", null);
	}

	public void selectCategory_MenuPage(int IndexValue_1stLevelCategory, int IndexValue_2ndLevelCategory,
			int IndexValue_3rdLevelCategory) throws IOException {
		click_MenuIcon_HomePage();
		String android_1stLevelCategory = xpath + categorySelection_menu + IndexValue_1stLevelCategory + super.endXpath;
		String android_2ndLevelCategory = xpath + categorySelection_menu + IndexValue_2ndLevelCategory + super.endXpath;
		String android_3rdLevelCategory = xpath + categorySelection_menu + IndexValue_3rdLevelCategory + super.endXpath;

		super.click(android_1stLevelCategory, null);
		super.clickOptional_3Secs(android_2ndLevelCategory, null);
		super.clickOptional_3Secs(android_3rdLevelCategory, null);

	}

	public void clcik_Home_MenuPage() throws IOException {
		String locator_Android = xpath + categorySelection_menu + 1 + super.endXpath;
		String locator_iOS = null;
		super.click(locator_Android, locator_iOS);
	}
}
