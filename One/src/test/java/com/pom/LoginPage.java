package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);}
	
	
	@FindBy(id = "username")
	private WebElement userName;


	public WebElement getUserName() {
		return userName;
	}


	public void setUserName(WebElement userName) {
		this.userName = userName;
	}
	
	@FindBy(id = "password")
	private WebElement password;


	public WebElement getPassword() {
		return password;
	}


	public void setPassword(WebElement password) {
		this.password = password;
	}
		

}


