package com.demoBlaze.selenium.api.design;

import org.openqa.selenium.WebElement;

public interface Browser {

	public void launchBrowser(String browser, String URL);
	
	public WebElement locateElement(String locatorType, String value);
	
	public void close();
	
	public void quit();
	
	public void switchToAlert();
	
	public void acceptAlert();
	
	public void dismissAlert();
	
}
