package com.demoBlaze.pages;

import java.io.IOException;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.demoBlaze.testng.api.base.ProjectSpecificationMethods;

public class LogIn extends ProjectSpecificationMethods{

	
	
	@SuppressWarnings("static-access")
	public LogIn(RemoteWebDriver driver) {
		 this.driver=driver;
		 
	}
	
	public LogIn loginUsername(String email) throws IOException {
		
			sendKeys(locateElement("id", "Email"), email);
			return this;
		
	}
	
	public LogIn loginPassword(String password) throws IOException {
		
			sendKeys(locateElement("id", "Password"), password);
			return this;
		
	}
	
	public LogIn loginRember() {
		click(locateElement("id", "RememberMe"));
		return this;
	}
	
	public ProductSelection loginSubmitButton() throws IOException {
		click(locateElement("xpath", "//input[@value='Log in']"));
		extentTest.addScreenCaptureFromPath(takeSnap("Login Snap"));
		return new ProductSelection(driver);
		
	}
	
}
