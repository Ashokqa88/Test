package caf.Merchants.Lulu;

import java.io.IOException;

public class HomePage extends LocationSelectionPage { // Next Extension SignupPage

	// private String categorySelection_menu =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";

	String frame_CategorySelection_Android = xpath
			+ "	/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[";

	
	public void click_TutorialScreen_HomePage() throws IOException {
		super.click(id + "img_tutorial_home", null);
	}

	
	
	public void click_MyAccountBtn_HomePage() throws IOException {
		super.click(id + "ivProfile", null);
	}

	public void click_WishlistBtn_HomePage() throws IOException {
		super.click(id + "ivFavourite", null);
	}

	public void click_SearchBtn_HomePage() throws IOException {
		super.click(id + "ivSearch", null);
	}

	public void click_HomeBtn_HomePage() throws IOException {
		super.click(id + "ivHome", null);
	}

	public void click_MenuIcon_HomePage() throws IOException {
		super.click(id + "llicons", locator_iOS);
	}

	
	public void click_CartIcon_HomePage() throws IOException {
		super.click(id + "cartbutton", locator_iOS);
	}

	
	
	
	
	public void selectCategory_HomePage(Integer IndexValue_1stLevelCategory, Integer IndexValue_2ndLevelCategory) throws IOException {
	String android_1stLevelCategory = frame_CategorySelection_Android + IndexValue_1stLevelCategory + super.endXpath;
	String android_2ndLevelCategory = frame_CategorySelection_Android + IndexValue_2ndLevelCategory + super.endXpath;

	super.click(android_1stLevelCategory, null);
	super.clickOptional_3Secs(android_2ndLevelCategory, null);

	}

	
}
