package caf.Merchants.Lulu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends ProductDetailsPage { // Next extension DeliveryAddressSelectionPage

	public List<String> cartPageElements(int productIndex) {
		List<String> CartElements = new ArrayList<String>();

		String CartProduct = null;
		String ProductName_Cart_Page = null;
		String Increment_ProductCount = null;
		String Decrement_ProductCount = null;
		String ProductQty = null;

		if (super.getOS().equals("Android")) {
			CartProduct = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout["
					+ productIndex + super.endXpath;
			ProductName_Cart_Page = CartProduct
					+ "/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView";
			Increment_ProductCount = CartProduct
					+ "/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ImageButton[2]";
			Decrement_ProductCount = CartProduct
					+ "/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ImageButton[1]";
			ProductQty = CartProduct
					+ "/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText";

		} else if (super.getOS().equals("iOS")) {

		}

		CartElements.add(CartProduct); // 0
		CartElements.add(ProductName_Cart_Page); // 1
		CartElements.add(Increment_ProductCount); // 2
		CartElements.add(Decrement_ProductCount); // 3
		CartElements.add(ProductQty); // 4

		return CartElements;

	}

	public void click_Backbtn_CartPage() throws IOException {

		super.click(xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton",
				locator_iOS);
	}

	public void click_ProceedToCheckout_CartPage() throws IOException {
		super.click(id + "btn_checkout", locator_iOS);
	}

	public void click_ClearCart_CartPage() throws IOException {
		super.click(id + "txt_clear_cart", locator_iOS);
	}

	public String getProductName_CartPage(int productIndex) throws IOException {
		String s = super.getText(this.cartPageElements(productIndex).get(1));
		return s;
	}

	public void clickOnProduct_CartPage(int productIndex) throws IOException {
		super.click(this.cartPageElements(productIndex).get(0));
	}

	public void click_Decrease_Product_Count_CartPage(int productIndex) throws IOException {
		super.click(this.cartPageElements(productIndex).get(3));
	}

	public void click_Increase_Product_Count_CartPage(int productIndex) throws IOException {
		super.click(this.cartPageElements(productIndex).get(2));
	}

	public String getQty_Product_CartPage(int productIndex) throws IOException {
		String s = super.getText(this.cartPageElements(productIndex).get(4));
		return s;
	}
	
	public boolean compareVal_CartPage(String actualValue, int LoopCount) throws IOException {
		boolean val = false;

		for (int i = 1; i <= LoopCount; i++) {
			String expectedValue = getProductName_CartPage(i);
			System.out.println(expectedValue);
			if (actualValue.equals(expectedValue)) {
				val = true;
				break;
			}
		}
		return val;
	}

}
