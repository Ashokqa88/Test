package caf.Merchants.Lulu;

import java.io.IOException;

public class LocationSelectionPage extends SplashScreen { // Next extension HomePage

	public void select_CountryUAE_LocationSelectionPage() throws IOException {
		super.clickOptional(id + "llcountry", null);
	}

	public String select_DeliveryLocation_LocationSelectionPage(int deliveryLocationIndex) throws IOException {

		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.ListView/android.widget.LinearLayout["
				+ deliveryLocationIndex + super.endXpath;
		String locator_iOS = null;
		String s = super.getText(locator_Android, locator_iOS);
		super.click(locator_Android, locator_iOS);
		super.click(id + "btncontinue", locator_iOS);
		return s;
	}

	
}
