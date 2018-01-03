package caf.Merchants.Craftroots;

import java.io.IOException;

public class HomePage extends LocationSelectionPage { // Next Extension SignupPage

	// private String categorySelection_menu =
	// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";

	String categorySelection_1stLevel_Menu_Android = xpath
			+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[";

	String categorySelection_2ndLevel_Menu_Android = xpath
			+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[";

	public void click_MyAccountBtn_MenuPage() throws IOException {
		super.click(id + "btn_my_account", null);
	}

	public void click_MenuIcon_HomePage() throws IOException {
		super.click(xpath + "//android.widget.ImageButton[@content-desc=\'Open navigation drawer\']", locator_iOS);
	}

	public void click_Search_HomePage() throws IOException {
		super.click(id + "img_search", locator_iOS);
	}

	public void click_CartIcon_HomePage() throws IOException {
		super.click(id + "img_cart", locator_iOS);
	}

	public void click_CategorySelection_MenuPage(int Category_IndexValue) throws IOException {
		String locator_Android = categorySelection_1stLevel_Menu_Android + Category_IndexValue + super.endXpath;
		super.click(locator_Android, locator_iOS);
	}

	public void click_SubcategorySelection_Menupage(int Subcategory_Indexvalue) throws IOException {
		String locator_Android = categorySelection_1stLevel_Menu_Android + Subcategory_Indexvalue + super.endXpath;
		super.click(locator_Android, locator_iOS);
	}

	public void click_childcategorySelection_Menupage(int Childcategory_Indexvalue) throws IOException {
		String locator_Android = categorySelection_2ndLevel_Menu_Android + Childcategory_Indexvalue + super.endXpath;
		super.click(locator_Android, locator_iOS);
	}
	
	public void click_childcategoryBackbtn_MenuPage() throws IOException {
		super.click(id + "img_back", locator_iOS);
	}
	
	

	public void selectCategory_MenuPage(Integer IndexValue_1stLevelCategory, Integer IndexValue_2ndLevelCategory,
			Integer IndexValue_3rdLevelCategory) throws IOException {
	String android_1stLevelCategory = categorySelection_1stLevel_Menu_Android + IndexValue_1stLevelCategory + super.endXpath;
	String android_2ndLevelCategory = categorySelection_1stLevel_Menu_Android + IndexValue_2ndLevelCategory + super.endXpath;
	String android_3rdLevelCategory = categorySelection_2ndLevel_Menu_Android + IndexValue_3rdLevelCategory + super.endXpath;

	super.click(android_1stLevelCategory, null);
	super.clickOptional_3Secs(android_2ndLevelCategory, null);
	super.clickOptional_3Secs(android_3rdLevelCategory, null);

	}

	/*
	 * public void selectCategory_MenuPage(int IndexValue_1stLevelCategory, int
	 * IndexValue_2ndLevelCategory, int IndexValue_3rdLevelCategory) throws
	 * IOException { String android_1stLevelCategory = xpath +
	 * categorySelection_menu + IndexValue_1stLevelCategory + super.endXpath; String
	 * android_2ndLevelCategory = xpath + categorySelection_menu +
	 * IndexValue_2ndLevelCategory + super.endXpath; String android_3rdLevelCategory
	 * = xpath + categorySelection_menu + IndexValue_3rdLevelCategory +
	 * super.endXpath;
	 * 
	 * super.click(android_1stLevelCategory, null);
	 * super.clickOptional_3Secs(android_2ndLevelCategory, null);
	 * super.clickOptional_3Secs(android_3rdLevelCategory, null);
	 * 
	 * }
	 */

	/*
	 * public void clcik_Home_MenuPage() throws IOException { String locator_Android
	 * = xpath + categorySelection_menu + 1 + super.endXpath; String locator_iOS =
	 * null; super.click(locator_Android, locator_iOS); }
	 */
}
