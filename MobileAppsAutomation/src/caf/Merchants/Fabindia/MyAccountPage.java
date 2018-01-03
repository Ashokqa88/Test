package caf.Merchants.Fabindia;

import java.io.IOException;

public class MyAccountPage extends LoginPage { // Next extension  MyProfilePage
	
	public void click_editBtn_MyAccount() throws IOException {
		super.click(id+"ivEdit", null);
	}

		public String getText_FirstName_MyProfilePage() throws IOException {
		String s = super.getText(id + "edtFirstName", null);
		return s;
		}

		public void setText_FirstName_MyProfilePage(String fName) throws IOException {
		String fName_Android=id+"edtFirstName";
		String fName_iOS="null";
		super.setText(fName_Android, fName_iOS, fName);
		}
		public String getText_LastName_MyProfilePage() throws IOException {
		String s = super.getText(id + "edtLastName", null);
		return s;
		}

		public void setText_LastName_MyProfilePage(String fName) throws IOException {
		String fName_Android=id+"edtLastName";
		String fName_iOS="null";
		super.setText(fName_Android, fName_iOS, fName);
		}

		public String getText_emailid_MyProfilePage() throws IOException {
		String s = super.getText(id + "edtEmail", null);
		return s;
		}
		public void setText_emailid_MyProfilePage(String fName) throws IOException {
		String fName_Android=id+"edtEmail";
		String fName_iOS="null";
		super.setText(fName_Android, fName_iOS, fName);
		}
		public String getText_mobilenumber_MyProfilePage() throws IOException {
		String s = super.getText(id + "edtMobileNumber", null);
		return s;
		}
		public void setText_mobilenumber_MyProfilePage(String fName) throws IOException {
		String fName_Android=id+"edtMobileNumber";
		String fName_iOS="null";
		super.setText(fName_Android, fName_iOS, fName);
		}

	
	}
