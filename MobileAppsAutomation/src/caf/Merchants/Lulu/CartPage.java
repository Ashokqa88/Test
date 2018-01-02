package caf.Merchants.Lulu;

public class CartPage extends ProductDetailsPage{  // Next extension  DeliveryAddressSelectionPage

	private String swipeBtn = null;

	//@BeforeClass
	public void elements_CartPage() {
		if (OS.equals("Android")) {
			swipeBtn = id + "tutorialNextButton";
		} else if (OS.equals("iOS")) {
			swipeBtn = id + "tutorialNextButton";
		}

	}
	
}
