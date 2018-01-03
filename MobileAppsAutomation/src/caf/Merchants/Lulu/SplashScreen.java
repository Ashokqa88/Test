package caf.Merchants.Lulu;

import java.io.IOException;

import caf.FrameworkLibrary.*;

public class SplashScreen extends CapDriver { // Next extension LocationSelectionPage

	
	
	public void click_Allowlocation_SplashScreen() throws IOException {
		super.click(id + "com.android.packageinstaller:id/permission_allow_button", null);
	}

	public void click_Denylocation_SplashScreen() throws IOException {
		super.click(id + "com.android.packageinstaller:id/permission_deny_button", null);
	}
	public void resetApp_SplashScreen() throws IOException, InterruptedException {
		super.resetApp();
this.click_Allowlocation_SplashScreen();	}
}
