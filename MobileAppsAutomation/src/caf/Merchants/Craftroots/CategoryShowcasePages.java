package caf.Merchants.Craftroots;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryShowcasePages extends MyOrdersPage { // Next extension FilterPage

	public List<String> showcaseElements(int productIndex) {
		List<String> ShowcasePageElements = new ArrayList<String>();

		String Product_Frame = null;
		String ProductName = null;
		String ProductPrice = null;
		String WishlistIcon = null;

		if (super.getOS().equals("Android")) {
			Product_Frame = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout["
					+ productIndex + super.endXpath;
			ProductName = Product_Frame
					+ "/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
			ProductPrice = Product_Frame + "/android.widget.LinearLayout[2]/android.widget.TextView";
			WishlistIcon = Product_Frame + "/android.widget.FrameLayout/android.widget.ImageView[2]";
		} else if (super.getOS().equals("iOS")) {

		}

		ShowcasePageElements.add(Product_Frame);
		ShowcasePageElements.add(ProductName);
		ShowcasePageElements.add(ProductPrice);
		ShowcasePageElements.add(WishlistIcon);

		return ShowcasePageElements;

	}

	/*
	 * private String layout_ShowcasePage_Android = xpath +
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";
	 * private String productName_ShowcasePage_Android =
	 * "/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView";
	 * private String productPrice_ShowcasePage_Android =
	 * "/android.widget.LinearLayout[2]/android.widget.TextView";
	 */

	public void click_Product_CategoryShowcasePages(int productIndexValue) throws IOException {

		super.click(this.showcaseElements(productIndexValue).get(0));
	}

	public String getProductName_CategoryShowcasePages(int productIndexValue) throws IOException {

		String s = super.getText(this.showcaseElements(productIndexValue).get(1));
		return s;
	}

	public int getProductPrice_CategoryShowcasePages(int productIndexValue) throws IOException {

		String s = super.getText(this.showcaseElements(productIndexValue).get(2));
		int s1 = Integer.parseInt(s);
		return s1;
	}

	public void click_WishlistIcon_CategoryShowcasePages(int productIndexValue) throws IOException {
		super.click(this.showcaseElements(productIndexValue).get(3));
	}

	public void click_Backbtn_CategoryShowcasePages() throws IOException {
		super.click(xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.ImageButton",
				locator_iOS);
	}

	
	
}
