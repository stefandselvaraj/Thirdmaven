package com.definition;

import com.base.BaseClass;
import com.pom.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageOne extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	@Given("User is on the Adactin Page")
	public void userIsOnTheAdactinPage() {
	   
		getDriver("chrome");
		getUrl("https://adactinhotelapp.com/");
		
	}

	@When("User should enter {string}, {string}")
	public void userShouldEnter(String username, String password) {

		
		setValue(pom.getLoginpage().getUserName(), username);
		setValue(pom.getLoginpage().getPassword(), password);
	}

	@Then("User should verify after login{string}")
	public void userShouldVerifyAfterLogin(String string) {
	    
	}

	
	
}
