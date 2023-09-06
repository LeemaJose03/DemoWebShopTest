package com.demoBlaze.selenium.api.design;

import org.openqa.selenium.WebElement;

public interface Element {


	
	public void click(WebElement ele);
	
	public void sendKeys(WebElement ele, String value);
	
	public void select(WebElement ele, String value);
	
	public void jsScroll(WebElement ele);
	
	public void webdriverWait(WebElement ele);
}
