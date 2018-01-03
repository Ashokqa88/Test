package caf.Merchants.Fabindia;

import java.io.IOException;

public class HomePage extends LocationSelectionPage { // Next Extension SignupPage

	private String categorySelection_menu = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[";

	public void click_Menu_HomePage() throws IOException {
		super.click(id + "fMenu", null);
	}

	public void click_Search_HomePage() throws IOException {
		super.click(id + "ivSearch", null);

	}

	public void click_Home_HomePage() throws IOException {
		super.click(id + "ivHome", null);

	}

	public void click_Wishlist_HomePage() throws IOException {
		super.click(id + "ivFavourites", null);
	}

	public void click_Stores_HomePage()throws IOException{
		super.click(id+"ivStores", null);
	}
	
	public void click_Cart_HomePage()throws IOException{
		super.click(id+"ivCart", null);
	}
	
	public void click_MyAccount_HomePage()throws IOException {
		super.click(id+"ivAccount", null);
	}
	
	public void click_MyAccount_Popup_HomePage(String y_n)throws IOException{
		
		if(y_n.equals("y"))
		{
			super.click(id+"okBtn", null);
		}
		else
		{
			super.click(id+"cancelBtn", null);
		}
	}
	
	
	
}
