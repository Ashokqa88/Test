package caf.Merchants.Lulu;

import java.io.IOException;

public class MyAddressesPage extends MyProfilePage{  // Next extension  MyOrdersPage

	public void click_addNewAddress_MyAddressesPage() throws IOException {
		super.click(id + "addAdresssLayout", locator_iOS);
	}
	
	public void click_continueBtn_MyAddressesPage() throws IOException {
		super.click(id + "btn_continue", locator_iOS);
	}
	
	public void setText_firstName_MyAddressesPage(String firstName) throws IOException {
		super.setText(id + "et_name", locator_iOS, firstName);
	}
	
	public void setText_lastName_MyAddressesPage(String lastName) throws IOException {
		super.setText(id + "et_last_name", locator_iOS, lastName);
	}
	
	public void setText_Phone_MyAddressesPage(String PhoneNum) throws IOException {
		super.setText(id + "et_phone", locator_iOS, PhoneNum);
	}
	
	public void setText_Pincode_MyAddressesPage(String Pincode) throws IOException {
		super.setText(id + "et_pinCode", locator_iOS, Pincode);
	}
	
	public void click_AddressType_MyAddressesPage() throws IOException {
		super.click(id + "llAddressType", locator_iOS);
	}
}
