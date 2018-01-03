package caf.Merchants.Craftroots;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;

public class WishlistPage extends DeliveryAddressSelectionPage { // Next extension OrderSummaryPage

	public List<String> wishlistPageElements(int productIndex) {
		List<String> WishlistElements = new ArrayList<String>();

		String Product_Frame = null;
		String ProductName = null;
		String ProductPrice = null;
		String Checkbox = null;
		String Products_Layout = null;

		if (super.getOS().equals("Android")) {
			Product_Frame = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout["
					+ productIndex + super.endXpath;
			ProductName = Product_Frame
					+ "/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
			ProductPrice = Product_Frame + "/android.widget.LinearLayout[2]";
			Checkbox = Product_Frame + "/android.widget.FrameLayout/android.widget.CheckBox";
			Products_Layout = xpath + "//android.support.v7.widget.RecyclerView";

		} else if (super.getOS().equals("iOS")) {

		}

		WishlistElements.add(Product_Frame);
		WishlistElements.add(ProductName);
		WishlistElements.add(ProductPrice);
		WishlistElements.add(Checkbox);
		WishlistElements.add(Products_Layout);

		return WishlistElements;

	}

	public void click_ProductFrame_MyWishlistPage(int productIndex) throws IOException {
		super.click(this.wishlistPageElements(productIndex).get(0));
	}

	public String getProductName_MyWishlistPage(int productIndex) throws IOException {
		String s = super.getText(this.wishlistPageElements(productIndex).get(1));
		return s;
	}

	public int getProductPrice_MyWishlistPage(int productIndex) throws IOException {
		String s = super.getText(this.wishlistPageElements(productIndex).get(2));
		int s1 = Integer.parseInt(s);
		return s1;
	}

	public void click_Checkbox_MyWishlistPage(int productIndex) throws IOException {
		super.click(this.wishlistPageElements(productIndex).get(3));
	}

	public void click_MyWishlist_Menu() throws IOException {
		super.click(id + "txt_my_wish_list", locator_iOS);
	}

	public void click_Backbtn_MyWishlistPage() throws IOException {
		super.click(xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton",
				locator_iOS);
	}

	public void click_CartIcon_MyWishlistPage() throws IOException {
		super.click(id + "img_cart", locator_iOS);
	}

	public void click_RemoveFromList_MyWishlistPage() throws IOException {
		super.click(id + "btnRemoveFromList", locator_iOS);
	}

	public void click_AddToCart_MyWishlistPage() throws IOException {
		super.click(id + "btnAddToCart", locator_iOS);
	}

	public List<String> WishlistPage_Products() {

		return null;

	}

	
	public boolean compareVal(String actualValue, int LoopCount) throws IOException {
		boolean val = false;

		for (int i = 1; i <= LoopCount; i++) {
			String expectedValue = getProductName_MyWishlistPage(i);
			System.out.println(expectedValue);
			if (actualValue.equals(expectedValue)) {
				val = true;
				break;
			}
		}
		return val;
	}
	
	public boolean compareVal(int actualValue, int LoopCount) throws IOException {
		boolean val = false;

		for (int i = 1; i <= LoopCount; i++) {
			int expectedValue = getProductPrice_MyWishlistPage(i);
			System.out.println(expectedValue);
			if (actualValue == expectedValue) {
				val = true;
				break;
			}
		}
		return val;
	}
	
	

}
