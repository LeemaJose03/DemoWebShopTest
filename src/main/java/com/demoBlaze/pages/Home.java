package com.demoBlaze.pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.demoBlaze.testng.api.base.ProjectSpecificationMethods;

public class Home extends ProjectSpecificationMethods {
	
	@SuppressWarnings("static-access")
	public Home (RemoteWebDriver driver) {
		
		this.driver=driver;
	}
	
	public LogIn clickLogin() throws IOException {
		
			click(locateElement("xpath", "//a[text()='Log in']"));
			return new LogIn(driver);
		
	}
	
	public SignUp clickSignup() throws IOException {
		
		
			click(locateElement("xpath", "//a[text()='Register']"));
			return new SignUp(driver);
		
	}

}
