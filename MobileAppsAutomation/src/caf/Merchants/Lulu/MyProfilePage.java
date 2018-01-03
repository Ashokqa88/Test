package caf.Merchants.Lulu;

import java.io.IOException;

public class MyProfilePage extends MyAccountPage{ // Next extension  MyAddressesPage

	
	public String getText_UserName_MyProfilePage() throws IOException {
		String s = super.getText(id + "edtFirstName", null);
		return s;
	}
	
	
	
	public String getText_EmailId_MyProfilePage() throws IOException {
		String s = super.getText(id + "edtEmail", null);
		return s;
	}
	
	
	public String getText_PhoneNum_MyProfilePage() throws IOException {
		String s = super.getText(id + "edtPhoneNo", null);
		return s;
	}
	
	public void setText_PhoneNum_MyProfilePage(String PhoneNum) throws IOException {
		super.click(id+"ivEditMob", PhoneNum);
		super.setText(id+"edtPhoneNo", null, PhoneNum);
	}
	
	
	
}
