package caf.Merchants.Lulu;

import java.io.IOException;

public class ProductDetailsPage extends SearchPage{   // Next extension  CartPage

	public void click_backbtn_PDP() throws IOException {
		String locator_Android=xpath+"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton";
		super.click(locator_Android, locator_iOS);
	}
	
	public void click_Search_PDP() throws IOException {
		String locator_Android=id+"img_search";
		super.click(locator_Android, locator_iOS);
	}
	
	public void click_CartIcon_PDP() throws IOException {
		String locator_Android=id+"img_cart";
		super.click(locator_Android, locator_iOS);
	}
	
	public void click_WishlistIcon_PDP() throws IOException {
		String locator_Android=id+"img_favourite";
		super.click(locator_Android, locator_iOS);
	}
	
	public void click_Minusbtn_PDP() throws IOException {
		String locator_Android=id+"img_btn_minus";
		super.click(locator_Android, locator_iOS);
	}
	
	public void click_Plusbtn_PDP() throws IOException {
		String locator_Android=id+"img_btn_plus";
		super.click(locator_Android, locator_iOS);
	}
	
	public void setText_Pincode_PDP(String pincode) throws IOException {
		super.setText(id + "et_pincode", locator_iOS, pincode);
	}
	
	public String getText_Qty_PDP() throws IOException {
		String s = super.getText(id + "et_qty", null);
		return s;
	}
	
	public void click_AddToCartBtn_PDP() throws IOException {
		String locator_Android=id+"add_to_cart_layout";
		super.click(locator_Android, locator_iOS);
	}
	
	public void click_BuyNowBtn_PDP() throws IOException {
		String locator_Android=id+"buy_layout";
		super.click(locator_Android, locator_iOS);
	}
	
	public String getProductName_PDP() throws IOException {
		String s = super.getText(id+"txt_product_title", locator_iOS);
		return s;
	}
	
	public int getProductPrice_PDP() throws IOException {
		String s = super.getText(id + "txt_price", locator_iOS);
		int s1 = Integer.parseInt(s);
		return s1;
	}

}
