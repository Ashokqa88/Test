package caf.Merchants.Lulu;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends SearchPage { // Next extension CartPage

	public String get_ProductName_ProductDetailsPage() throws IOException {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[2]";
		String locator_iOS = null;
		String s = super.getText(locator_Android, locator_iOS);
		return s;
	}

	public String get_ProductPrice_ProductDetailsPage() throws IOException {
		String price = null;
		String locator_Android1 = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]";
		String locator_iOS1 = null;
		String locator_Android2 = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
		String locator_iOS2 = null;
		if (super.isEnabledOptional_3Secs(locator_Android1, locator_iOS1)) {
			price = super.getText(locator_Android1, locator_iOS1);
		} else {
			price = super.getText(locator_Android2, locator_iOS2);
		}
		return price;
	}

	public void click_AddToCart_ProductDetailsPage() throws IOException {
		String locator_Android = xpath +"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[contains(@resource-id,'tvCountIncrement') and @index='2']/android.widget.ImageView";
		String locator_iOS = null;
		super.click(locator_Android, locator_iOS);
	}

	public void click_DecrementButton_ProductDetailsPage() throws IOException {
		super.click(id + "tvCountDecrement", null);
	}

	public void click_IncrementButton_ProductDetailsPage() throws IOException {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[contains(@resource-id,'tvCountIncrement') and @index='4']/android.widget.ImageView";
		String locator_iOS = null;
		super.click(locator_Android, locator_iOS);
	}

	public String get_QuantityValue_ProductDetailsPage() throws IOException {
		String s = super.getText(id + "tvCount", null);
		return s;
	}

	public void click_VariantDropDownBtn_ProductDetailsPage() throws IOException {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Spinner";
		String locator_iOS = null;
		super.click(locator_Android, locator_iOS);
	}

	public String get_VariantValue_ProductDetailsPage() throws IOException {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Spinner/android.widget.TextView";
		String locator_iOS = null;
		String s = super.getText(locator_Android, locator_iOS);
		return s;
	}

	public void click_WishlistOption_ProductDetailsPage() throws IOException {
		super.click(id + "tvAddToShoppingList", null);
	}

	public String addProductToExistingWishlist_ProductDetailsPage() throws IOException {
		click_WishlistOption_ProductDetailsPage();
		String existingWishlistName = super.getText(id + "text1", null);
		super.click(id + "bSaveList", null);
		super.click(id + "android:id/button1", null);
		return existingWishlistName;
	}

	public String addProductToNewWishlist_ProductDetailsPage() throws IOException {
		click_WishlistOption_ProductDetailsPage();
		String newWishlistName = super.randomString(7);
		super.click(id + "createNewListBtn", null);
		super.setText(id + "etShoppingListName", null, newWishlistName);
		super.keypadClose();
		super.click(id + "rbPublic", null);
		super.click("bCreateShoppingList", null);
		super.click(id + "android:id/button1", null);
		return newWishlistName;
	}

	public int variantCount_ProductDetailsPage() throws IOException {
		String parent_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView";
		String parent_iOS = null;
		WebElement parent = super.waitForElementPresence(parent_Android, parent_iOS, waitTime);
		List<WebElement> elements = parent.findElements(By.className("android.widget.CheckedTextView"));
		int variantCount = elements.size();
		System.out.println("Variant Count : " + variantCount);
		return variantCount;
	}

	public void addToCart_AllVariantsOrNonVaraintProduct_ProductDetailsPage() throws IOException {
		String variantSelection_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[";

		String variantDropDown_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Spinner";
		String locator_iOS = null;
		if (super.isEnabledOptional_3Secs(variantDropDown_Android, locator_iOS)) {
			this.click_VariantDropDownBtn_ProductDetailsPage();
			int variantCount = this.variantCount_ProductDetailsPage();
			for (int i = 1; i <= variantCount; i++) {
				super.click(variantSelection_Android + i + super.endXpath, null);
				this.click_AddToCart_ProductDetailsPage();
				if (i != variantCount) {
					this.click_VariantDropDownBtn_ProductDetailsPage();
				}
			}
		} else {
			this.click_AddToCart_ProductDetailsPage();
		}

	}

	public void click_CartIcon_ProductDetailsPage() throws IOException {
		super.click(id + "ivCartIcon", null);
	}

	public void click_CheckoutBtn_ProductDetailsPage() throws IOException {
		super.click(id + "bCheckout", null);
	}
}
