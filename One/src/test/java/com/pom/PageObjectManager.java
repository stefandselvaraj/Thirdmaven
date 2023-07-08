package com.pom;

public class PageObjectManager {
	
	private LoginPage loginpage;
	private SearchHotel searchhotel;
	
	
	public SearchHotel getSearchhotel() {
		return (searchhotel==null)?searchhotel=new SearchHotel(): searchhotel;
	}


	public LoginPage getLoginpage() {
		return (loginpage==null)?loginpage= new LoginPage(): loginpage;
	}

	
	
	

}
