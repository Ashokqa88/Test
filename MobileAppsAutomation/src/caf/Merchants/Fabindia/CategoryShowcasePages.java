package caf.Merchants.Fabindia;
import java.io.IOException;		

		public class CategoryShowcasePages extends MyOrdersPage { // Next extension FilterPage


			private String frameStart_Showcase_Android = xpath

					+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";

			private String productName_Showcase_Android = "/android.widget.LinearLayout/android.widget.TextView";

			private String productPrice_Showcase_Android = "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView";

			private String addToCart_Showcase_Android = "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView";

			private String incrementQuantity_Showcase_Android = "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.ImageView";

			private String decrementQuantity_Showcase_Android = "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.ImageView";

			private String variantDropDownBtn_Showcase_Android = "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Spinner";

			private String variantValue_Showcase_Android = "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Spinner/android.widget.TextView";

			private String quantityValue_Showcase_Android = "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView";

			private String variantFrameStart_Showcase_Android = xpath

					+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[";


			public void clickOnProduct_Showcase(int productIndexValue) throws IOException {

				String locator_Android = frameStart_Showcase_Android + productIndexValue + super.endXpath;

				String locator_iOS = null;


				super.click(locator_Android, locator_iOS);

			}


			public String getProductName_Showcase(int productIndexValue) throws IOException, InterruptedException {

				String locator_Android = frameStart_Showcase_Android + productIndexValue + super.endXpath

						+ productName_Showcase_Android;

				String locator_iOS = null;

				String s = super.getText(locator_Android, locator_iOS);

				return s;

			}


			public String getProductPrice_Showcase(int productIndexValue) throws IOException, InterruptedException {

				String locator_Android = frameStart_Showcase_Android + productIndexValue + super.endXpath

						+ productPrice_Showcase_Android;

				String locator_iOS = null;

				String s = super.getText(locator_Android, locator_iOS);

				return s;

			}


			public String getVariantValue_Showcase(int productIndexValue) throws IOException, InterruptedException {

				String locator_Android = frameStart_Showcase_Android + productIndexValue + super.endXpath

						+ variantValue_Showcase_Android;

				String locator_iOS = null;

				String s = super.getText(locator_Android, locator_iOS);

				return s;

			}


			public String getQuantityValue_Showcase(int productIndexValue) throws IOException, InterruptedException {

				String locator_Android = frameStart_Showcase_Android + productIndexValue + super.endXpath

						+ quantityValue_Showcase_Android;

				String locator_iOS = null;

				String s = super.getText(locator_Android, locator_iOS);

				return s;

			}


			public void click_VariantDropDown_Showcase(int productIndexValue) throws IOException, InterruptedException {

				String locator_Android = frameStart_Showcase_Android + productIndexValue + super.endXpath

						+ variantDropDownBtn_Showcase_Android;

				String locator_iOS = null;

				super.click(locator_Android, locator_iOS);

			}


			public void click_AddToCart_Showcase(int productIndexValue) throws IOException, InterruptedException {

				String locator_Android = frameStart_Showcase_Android + productIndexValue + super.endXpath

						+ addToCart_Showcase_Android;

				String locator_iOS = null;

				super.click(locator_Android, locator_iOS);

			}


			public void click_IncrementButton_Showcase(int productIndexValue) throws IOException, InterruptedException {

				String locator_Android = frameStart_Showcase_Android + productIndexValue + super.endXpath

						+ incrementQuantity_Showcase_Android;

				String locator_iOS = null;

				super.click(locator_Android, locator_iOS);

			}


			public void click_DecrementButton_Showcase(int productIndexValue) throws IOException, InterruptedException {

				String locator_Android = frameStart_Showcase_Android + productIndexValue + super.endXpath

						+ decrementQuantity_Showcase_Android;

				String locator_iOS = null;

				super.click(locator_Android, locator_iOS);

			}


			public void click_VariantFromVariantDropDown_Showcase(int productIndexValue) throws IOException, InterruptedException {

				String locator_Android = variantFrameStart_Showcase_Android + productIndexValue + super.endXpath;

				String locator_iOS = null;

				super.click(locator_Android, locator_iOS);

			}


	
		

	}

