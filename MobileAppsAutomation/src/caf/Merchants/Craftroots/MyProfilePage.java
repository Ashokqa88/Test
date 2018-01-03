package caf.Merchants.Craftroots;

import java.io.IOException;

public class MyProfilePage extends MyAccountPage{ // Next extension  MyAddressesPage

	
	public String getText_FirstName_MyAccountPage() throws IOException {
		String s = super.getText(id + "et_firstName", null);
		return s;
	}
	
	public void setText_firstNAme_MyProfilePage(String fName) throws IOException {
		String fName_Android=id+"et_firstName";
		String fName_iOS="null";
		super.setText(fName_Android, fName_iOS, fName);
	}
	
	public String getText_LastName_MyAccountPage() throws IOException {
		String s = super.getText(id + "et_last_name", null);
		return s;
	}
	
	public void setText_LastNAme_MyProfilePage(String lName) throws IOException {
		String lName_Android=id+"et_last_name";
		String lName_iOS="null";
		super.setText(lName_Android, lName_iOS, lName);
	}
	
	public String getText_EmailId_MyAccountPage() throws IOException {
		String s = super.getText(id + "et_email", null);
		return s;
	}
	
	public void setText_EmailId_MyProfilePage(String EmailId) throws IOException {
		String EmailId_Android=id+"et_email";
		String EmailId_iOS="null";
		super.setText(EmailId_Android, EmailId_iOS, EmailId);
	}
	
	public String getText_PhoneNum_MyAccountPage() throws IOException {
		String s = super.getText(id + "et_phone", null);
		return s;
	}
	
	public void setText_PhoneNum_MyProfilePage(String PhoneNum) throws IOException {
		String PhoneNum_Android=id+"et_phone";
		String PhoneNum_iOS="null";
		super.setText(PhoneNum_Android, PhoneNum_iOS, PhoneNum);
	}
	
	
	
}
