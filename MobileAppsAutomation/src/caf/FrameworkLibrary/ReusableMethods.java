package caf.FrameworkLibrary;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReusableMethods extends CapDriver {

	/*
	 * 
	 * Generic functionalities
	 * 
	 */

	protected void popupAllow() throws IOException {
		super.click("popupAllowBtn");
	}

	public void back() throws InterruptedException, IOException {
		Thread.sleep(1000);
		super.click("back");
	}

	public void back(int NumberOfTimeClickOnBack) throws IOException, InterruptedException {
		for (int i = 0; i < NumberOfTimeClickOnBack; i++) {
			Thread.sleep(1000);
			super.click("back");
		}

	}

	public void addToCart_PDP() throws IOException {
		super.click("addToCartBtn_PDP");
	}

	public int variantCount_PDP() throws IOException {
		WebElement parent = super.waitForElement("VarintFrame_PDP", waitTime);
		List<WebElement> elements = parent.findElements(By.className(super.pvl("variantClassName_PDP")));
		int variantCount = elements.size();
		System.out.println("Variant Count : " + variantCount);
		return variantCount;
	}

	public String productFrame_Showcase(int productIndexValue) {
		String locatorType = "xpath=val=";
		String productFrame = locatorType + this.pvl("frameStart_Showcase") + productIndexValue + "]";
		return productFrame;
	}

	public String productFrame_Wishlist(int productIndexValue) {
		String locatorType = "xpath=val=";
		String productFrame = locatorType + this.pvl("frameStart_Wishlist") + productIndexValue + "]";
		return productFrame;

	}

	public String firstLevelCategory_Menu(int productIndexValue) {
		String locatorType = "xpath=val=";
		String categoryFrame = locatorType + this.pvl("firstLevelCategory_Menu") + productIndexValue + "]";
		return categoryFrame;

	}

	public String secondLevelCategory_Menu(int productIndexValue) {
		String locatorType = "xpath=val=";
		String categoryFrame = locatorType + this.pvl("secondLevelCategory_Menu") + productIndexValue + "]";
		return categoryFrame;

	}

	public String thirdLevelCategory_Menu(int productIndexValue) {
		String locatorType = "xpath=val=";
		String categoryFrame = locatorType + this.pvl("thirdLevelCategory_Menu") + productIndexValue + "]";
		return categoryFrame;

	}

	public void addToCartAllVariants_PDP() throws IOException, InterruptedException {
		// this.clickOnProduct_Showcase(Showcase_Wishlist, productIndexValue);
		Thread.sleep(2000);
		super.scrollDown(2);
		if (super.isEnabledOptional_3Secs("VarintFrame_PDP")) {
			for (int i = 1; i <= this.variantCount_PDP(); i++) {

				if (super.isEnabledDirectOptional_3Secs(
						xpath + super.pvl("variantFrameStart_PDP") + i + super.pvl("variantFrameEnd_PDP"))) {
					super.clickDirectOptional_3Secs(
							xpath + super.pvl("variantFrameStart_PDP") + i + super.pvl("variantFrameEnd_PDP"));
					super.click("addToCartBtn_PDP");
				}
			}
		}
	}

	public void clickOnMyAccountIcon_HomePage() throws IOException {
		super.click("myActIcon_Home");
	}
	
	
	/*
	 * 
	 * ---- Menu List , Showcase , Wishlist and Cart Methods ---- Statrting
	 * 
	 */

	public void navigateToCategoryShowcasePage_Menu(int CategoryIndexValue_1StLevel, int CategoryIndexValue_2ndLevel,
			int CategoryIndexValue_3rdLevel) throws IOException {
		super.click("menuIcon_Home");
		super.clickDirect(this.firstLevelCategory_Menu(CategoryIndexValue_1StLevel));
		super.clickDirectOptional_3Secs(this.secondLevelCategory_Menu(CategoryIndexValue_2ndLevel));
		super.clickDirectOptional_3Secs(this.thirdLevelCategory_Menu(CategoryIndexValue_3rdLevel));

	}

	public void clickOnProduct_Showcase(int productIndexValue) throws IOException {
		super.clickDirect(this.productFrame_Showcase(productIndexValue));
	}

	public String getProductName_Showcase(int productIndexValue) throws IOException, InterruptedException {
		String s = super.getTextDirect(
				this.productFrame_Showcase(productIndexValue) + super.pvl("productName_Showcase"));
		return s;
	}

	public String getProductPrice_Showcase(int productIndexValue) throws IOException, InterruptedException {
		String s = super.getTextDirect(
				this.productFrame_Showcase(productIndexValue) + super.pvl("productPrice_Showcase"));
		return s;
	}

	public void clickOnWishlistIcon_Showcase(int productIndexValue) throws IOException, InterruptedException {
		super.clickDirect(this.productFrame_Showcase(productIndexValue) + super.pvl("wishlistIcon_Showcase"));

	}

	public String getVariantName_Showcase(int productIndexValue) throws IOException, InterruptedException {
		String s = super.getTextDirect(
				this.productFrame_Showcase(productIndexValue) + super.pvl("variantName_Showcase"));
		return s;
	}

	public void clickOnVariantDropDown_Showcase(int productIndexValue) throws IOException, InterruptedException {
		super.clickDirect(this.productFrame_Showcase(productIndexValue) + super.pvl("variantDropDownIcon_Showcase"));

	}

	public void clickOnAddToCart_Showcase(int productIndexValue) throws IOException, InterruptedException {
		super.clickDirect(this.productFrame_Showcase(productIndexValue) + super.pvl("addToCartBtn_Showcase"));

	}

	public void clickOnIncrementButton_Showcase(int productIndexValue) throws IOException, InterruptedException {
		super.clickDirect(this.productFrame_Showcase(productIndexValue) + super.pvl("incrementBtn_Showcase"));

	}

	public void clickOnDecrementButton_Showcase(int productIndexValue) throws IOException, InterruptedException {
		super.clickDirect(this.productFrame_Showcase(productIndexValue) + super.pvl("decrementBtn_Showcase"));

	}

	public String getQuantityValue_Showcase(int productIndexValue) throws IOException, InterruptedException {
		String s = super.getTextDirect(this.productFrame_Showcase(productIndexValue) + super.pvl("quantity_Showcase"));
		return s;
	}

	public void clickOnProduct_Wishlist(int productIndexValue) throws IOException {
		super.clickDirect(this.productFrame_Wishlist(productIndexValue));
	}

	public String getProductName_Wishlist(int productIndexValue) throws IOException, InterruptedException {
		String s = super.getTextDirect(
				this.productFrame_Wishlist(productIndexValue) + super.pvl("productName_Wishlist"));
		return s;
	}

	public String getProductPrice_Wishlist(int productIndexValue) throws IOException, InterruptedException {
		String s = super.getTextDirect(
				this.productFrame_Wishlist(productIndexValue) + super.pvl("productPrice_Wishlist"));
		return s;
	}

	public String getVariantName_Wishlist(int productIndexValue) throws IOException, InterruptedException {
		String s = super.getTextDirect(
				this.productFrame_Wishlist(productIndexValue) + super.pvl("variantName_Wishlist"));
		return s;
	}

	public void clickOnVariantDropDown_Wishlist(int productIndexValue) throws IOException, InterruptedException {
		super.clickDirect(this.productFrame_Wishlist(productIndexValue) + super.pvl("variantDropDownIcon_Wishlist"));

	}

	public void clickOnAddToCart_Wishlist(int productIndexValue) throws IOException, InterruptedException {
		super.clickDirect(this.productFrame_Wishlist(productIndexValue) + super.pvl("addToCartBtn_Wishlist"));

	}

	public void clickOnIncrementButton_Wishlist(int productIndexValue) throws IOException, InterruptedException {
		super.clickDirect(this.productFrame_Wishlist(productIndexValue) + super.pvl("incrementBtn_Wishlist"));

	}

	public void clickOnDecrementButton_Wishlist(int productIndexValue) throws IOException, InterruptedException {
		super.clickDirect(this.productFrame_Wishlist(productIndexValue) + super.pvl("decrementBtn_Wishlist"));

	}

	public String getQuantityValue_Wishlist(int productIndexValue) throws IOException, InterruptedException {
		String s = super.getTextDirect(this.productFrame_Wishlist(productIndexValue) + super.pvl("quantity_Wishlist"));
		return s;
	}

	/*
	 * 
	 * ------ Showcase , Wishlist and Cart Methods ---- End
	 * 
	 */

	public String updateCalenderAndReturnDOB_MyProfile() throws IOException {
		scrollDownUntillElementVisible("DOB_MyProfile", 5);
		super.click("DOB_MyProfile");
		super.click("calenderOkBtn");
		String DOB = super.getText("DOB_MyProfile");
		return DOB;

	}

	public void clearAllWishlistProducts() throws IOException {
		super.click("wishlistIcon_Home");
		if (super.isEnabledOptional_3Secs("clearllBtn_Wishlist")) {
			super.click("clearllBtn_Wishlist");
			this.popupAllow();
			super.click("startShopping_Wishlist");
		} else {
			super.click("startShopping_Wishlist");
		}

	}
}
