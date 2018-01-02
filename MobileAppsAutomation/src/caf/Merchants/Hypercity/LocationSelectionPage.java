package caf.Merchants.Hypercity;

import java.io.IOException;



public class LocationSelectionPage extends SplashScreen { // Next extension  HomePage

	public void click_searchField_LocationSelectionPage() throws IOException {
		super.click(id + "bSearchLocation", null);
	}

	public void click_detectLocation_LocationSelectionPage() throws IOException {
		super.click(id + "bDetectLocation", null);
	}

	public void setLocation_SelectLocation_LocationSelectionPage(int IndexValue_LocationList_Android) throws IOException {
		String selectLocation_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView[";
		String selectLocation_iOS = null;
		String locationName = super.pvData("locationName_LocationSelectionPage");

		super.setText(id + "com.google.android.gms:id/edit_text", selectLocation_iOS, locationName);
		super.click(selectLocation_Android+ IndexValue_LocationList_Android + endXpath,null);
	}

	public void navigateToHomePage_By_LocationSearchAndSelect_LocationSelectionPage(int IndexValue_LocationList_Android)
			throws IOException {
		this.click_searchField_LocationSelectionPage();
		this.setLocation_SelectLocation_LocationSelectionPage(IndexValue_LocationList_Android);
	}

}
