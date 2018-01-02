package caf.Merchants.Hypercity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryShowcasePages extends MyOrdersPage { // Next extension FilterPage

	public List<String> showcasePage_Elements(int productIndexValue) {
		List<String> myString = new ArrayList<String>();
		String productFrame = null; // 0
		String productName = null;// 1
		String productPrice = null;// 2
		String addToCart = null;// 3
		String incrementQuantity = null;// 4
		String decrementQuantity = null;// 5
		String variantDropDownBtn = null;// 6
		String variantValue = null;// 7
		String quantityValue = null;// 8
		String variantSelection = null;// 9
		String variantFrame = null;// 10
		String variantClass = null;// 11
		if (super.getOS().equals("Android")) {
			productFrame = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout["
					+ productIndexValue + super.endXpath;
			productName = productFrame + "/android.widget.LinearLayout/android.widget.TextView";
			productPrice = productFrame
					+ "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView";
			addToCart = productFrame
					+ "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView";
			incrementQuantity = productFrame
					+ "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.ImageView";
			decrementQuantity = productFrame
					+ "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.ImageView";
			variantDropDownBtn = productFrame
					+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Spinner";
			variantValue = productFrame
					+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Spinner/android.widget.TextView";
			quantityValue = productFrame
					+ "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView";
			variantSelection = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView["
					+ productIndexValue + super.endXpath;
			variantFrame = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView";
			variantClass = "android.widget.CheckedTextView";

		} else if (super.getOS().equals("iOS")) {

		}
		myString.add(productFrame);// 0
		myString.add(productName);// 1
		myString.add(productPrice);// 2
		myString.add(addToCart);// 3
		myString.add(incrementQuantity);// 4
		myString.add(decrementQuantity);// 5
		myString.add(variantDropDownBtn);// 6
		myString.add(variantValue);// 7
		myString.add(quantityValue);// 8
		myString.add(variantSelection);// 9
		myString.add(variantFrame);// 10
		myString.add(variantClass);// 11
		return (myString);
	}

	public void click_Product_CategoryShowcasePages(int productIndexValue) throws IOException {
		super.click(this.showcasePage_Elements(productIndexValue).get(0));
	}

	public String get_ProductName_CategoryShowcasePages(int productIndexValue) throws IOException {
		String s = super.getText(this.showcasePage_Elements(productIndexValue).get(1));
		return s;
	}

	public String get_ProductPrice_CategoryShowcasePages(int productIndexValue) throws IOException {
		String s = super.getText(this.showcasePage_Elements(productIndexValue).get(2));
		return s;
	}

	public String get_VariantValue_CategoryShowcasePages(int productIndexValue) throws IOException {
		String s=null;
		 s = super.getText(this.showcasePage_Elements(productIndexValue).get(7));
		return s;
	}

	public String get_QuantityValue_CategoryShowcasePages(int productIndexValue) throws IOException {
		String s = super.getText(this.showcasePage_Elements(productIndexValue).get(8));
		return s;
	}

	public void click_VariantDropDownBtn_CategoryShowcasePages(int productIndexValue) throws IOException {
		super.click(this.showcasePage_Elements(productIndexValue).get(6));
	}

	public void click_AddToCart_CategoryShowcasePages(int productIndexValue) throws IOException {
		super.click(this.showcasePage_Elements(productIndexValue).get(3));
	}

	public void click_IncrementButton_CategoryShowcasePages(int productIndexValue) throws IOException {
		super.click(this.showcasePage_Elements(productIndexValue).get(4));
	}

	public void click_DecrementButton_CategoryShowcasePages(int productIndexValue) throws IOException {
		super.click(this.showcasePage_Elements(productIndexValue).get(5));
	}

	public void selectVariant_FromVariantDropDown_CategoryShowcasePages(int productIndexValue) throws IOException {
		super.click(this.showcasePage_Elements(productIndexValue).get(9));
	}

	public int variantCount_CategoryShowcasePages(int productIndexValue) throws IOException {
		WebElement parent = super.waitForElementPresence(this.showcasePage_Elements(productIndexValue).get(10),
				waitTime);
		List<WebElement> elements = parent
				.findElements(By.className(this.showcasePage_Elements(productIndexValue).get(11)));
		int variantCount = elements.size();
		System.out.println("Variant Count : " + variantCount);
		return variantCount;
	}

	public void addToCart_AllVariantsOrNonVaraintProduct_CategoryShowcasePages(int productIndexValue) throws IOException {
		super.waitForElementPresence(this.showcasePage_Elements(productIndexValue).get(0), waitTime);
		if (super.isEnabledOptional_3Secs(this.showcasePage_Elements(productIndexValue).get(6))) {
			this.click_VariantDropDownBtn_CategoryShowcasePages(productIndexValue);
			int variantCount = this.variantCount_CategoryShowcasePages(productIndexValue);
			for (int i = 1; i <= variantCount; i++) {
				if (super.isEnabledOptional_3Secs(this.showcasePage_Elements(i).get(9))) {
					this.selectVariant_FromVariantDropDown_CategoryShowcasePages(i);
					this.click_AddToCart_CategoryShowcasePages(productIndexValue);
					if(i != variantCount) {
					this.click_VariantDropDownBtn_CategoryShowcasePages(productIndexValue);
					}
				}
			}
		}
		else {
			this.click_AddToCart_CategoryShowcasePages(productIndexValue);
		}
	}

}
