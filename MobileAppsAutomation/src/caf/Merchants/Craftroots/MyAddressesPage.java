package caf.Merchants.Craftroots;

import java.io.IOException;

public class MyAddressesPage extends MyProfilePage { // Next extension MyOrdersPage

	protected String firstName_NewAddress = super.randomString(6);
	protected String lastName_NewAddress = super.randomString(6);
	protected String PhoneNum_NewAddress = super.randomNumString(10);
	protected String Pincode_NewAddress = super.randomNumString(6);
	protected String Address_NewAddress = super.randomString(6);
	protected String Successful_Message = "Successful";

	public void click_addNewAddress_MyAddressesPage() throws IOException {
		super.click(id + "addAdresssLayout", locator_iOS);
	}

	public void click_continueBtn_MyAddressesPage() throws IOException {
		super.click(id + "btn_continue", locator_iOS);
	}

	public void setText_firstName_MyAddressesPage(String firstName) throws IOException {
		super.setText(id + "et_name", locator_iOS, firstName);
		super.keypadNext();
	}

	public void setText_lastName_MyAddressesPage(String lastName) throws IOException {
		super.setText(id + "et_last_name", locator_iOS, lastName);
		super.keypadNext();
	}

	public void setText_Phone_MyAddressesPage(String PhoneNum) throws IOException {
		super.setText(id + "et_phone", locator_iOS, PhoneNum);
		super.keypadNext();
	}

	public void setText_Pincode_MyAddressesPage(String Pincode) throws IOException {
		super.setText(id + "et_pinCode", locator_iOS, Pincode);
		super.keypadClose();
	}

	public void click_AddressType_MyAddressesPage() throws IOException {
		super.click(id + "llAddressType", locator_iOS);
	}

	public void click_SelectAddressType_MyAddressesPage(int AddressType) throws IOException {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView["
				+ AddressType + super.endXpath;
		super.click(locator_Android, locator_iOS);
	}

	public void setText_Address_MyAddressesPage(String Address) throws IOException {
		super.setText(id + "et_address", locator_iOS, Address);
		super.keypadClose();
	}

	public void click_State_MyAddressesPage() throws IOException {
		super.click(id + "llState", locator_iOS);
	}

	public void click_SelectState_MyAddressesPage(int State) throws IOException {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView["
				+ State + super.endXpath;
		super.click(locator_Android, locator_iOS);
	}

	public void click_City_MyAddressesPage() throws IOException {
		super.click(id + "llCity", locator_iOS);
	}

	public void click_SelectCity_MyAddressesPage(int City) throws IOException {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView["
				+ City + super.endXpath;
		super.click(locator_Android, locator_iOS);
	}

	public void click_Cancel_MyAddressesPage() throws IOException {
		super.click(id + "btn_cancel", locator_iOS);
	}

	public void click_Save_MyAddressesPage() throws IOException {
		super.click(id + "btn_save", locator_iOS);
	}

	public void click_BackBtn_MyAddressesPage() throws IOException {
		super.click(xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton",
				locator_iOS);
	}

	public String getText_SuccessfulMessage_MyAddressesPage() throws IOException {
		String s = super.getText(id + "body", locator_iOS);
		return s;
	}
	
	public void click_OkBtn_MyAddressesPage() throws IOException {
		super.click(id + "singleBtn", locator_iOS);
	}

}
