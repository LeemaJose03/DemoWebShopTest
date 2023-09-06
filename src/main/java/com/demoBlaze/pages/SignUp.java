package com.demoBlaze.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.demoBlaze.testng.api.base.ProjectSpecificationMethods;

public class SignUp extends ProjectSpecificationMethods{

	@SuppressWarnings("static-access")
	public SignUp(RemoteWebDriver driver) {
		
		this.driver= driver;
	}

	public SignUp signUpGender() {
		
		click(locateElement("xpath", "//label[text()='Female']"));
		return this;
	}
	
	public SignUp signUpFirstname(String firstname) {
		
		sendKeys(locateElement("id", "FirstName"), firstname);
		return this;
	}
	
	public SignUp signUpLastname(String lastname) {
		
		sendKeys(locateElement("id", "LastName"), lastname);
		return this;
	}
	
	public SignUp signUpEmail(String email) {
		sendKeys(locateElement("id", "Email"), email);
		return this;
	}
	
	public SignUp signUpPassword(String pwd) {
		sendKeys(locateElement("id", "Password"), pwd);
		return this;
	}
	
	public SignUp signUpConfirmPassword(String conpwd) {
		sendKeys(locateElement("id", "ConfirmPassword"), conpwd);
		return this;
	}
	
	public ProductSelection signUpRegisterButton() {
		click(locateElement("id", "register-button"));
		return new ProductSelection(driver);
	}

	
	
}
