package caf.Merchants.Fabindia;

import java.io.IOException;

import caf.FrameworkLibrary.*;


public class SplashScreen extends CapDriver { // Next extension  LocationSelectionPage

	public void click_Permission_Allow_Splash() throws IOException {
		super.click(id+"com.android.packageinstaller:id/permission_allow_button", null);
		
	}
	public void click_Permission1_Allow_Splash() throws IOException{
		super.click(id+"com.android.packageinstaller:id/permission_allow_button", null);
	}



}
