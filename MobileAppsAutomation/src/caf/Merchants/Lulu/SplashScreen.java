package caf.Merchants.Lulu;

import java.io.IOException;

import caf.FrameworkLibrary.*;


public class SplashScreen extends CapDriver { // Next extension  LocationSelectionPage

	public void click_SwipeBtn_SplashScreen(int NumberOfSwipes) throws IOException {
		//String swipeBtn = this.locatorByOS(id+"tutorialNextButton", null);
		for(int i=1;i<=NumberOfSwipes;i++) {
		super.click(id+"tutorialNextButton", null);
		}
	}

	public void resetApp_SplashScreen() throws IOException, InterruptedException {
		super.resetApp();
		this.click_SwipeBtn_SplashScreen(3);
	}

}
