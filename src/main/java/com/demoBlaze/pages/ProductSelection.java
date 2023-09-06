package com.demoBlaze.pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.demoBlaze.testng.api.base.ProjectSpecificationMethods;

public class ProductSelection extends ProjectSpecificationMethods{

	@SuppressWarnings("static-access")
	public ProductSelection(RemoteWebDriver driver) {
		 this.driver=driver;
	}

	public ProductSelection computers() {
		
		click(locateElement("xpath", "(//a[contains(text(),'Computers')])[3]"));
		return this;
	}
	
	public ProductSelection desktops() {
		click(locateElement("xpath", "(//a[contains(text(),'Desktops')])[4]"));
		return this;
	}
	
	public ProductSelection sortBy() {
		
		select(locateElement("xpath", "//select[@id='products-orderby']"), "Price: High to Low");
		return this;
	}
	
	public ProductSelection display() {
		select(locateElement("xpath", "//select[@id='products-pagesize']"), "4");
		return this;
		
	}
	
	public ProductSelection list() throws IOException {
		
		select(locateElement("xpath", "//select[@id='products-viewmode']"), "List");
		extentTest.addScreenCaptureFromPath(takeSnap("Product sorted"));
		return this;
	}

	
	public ProductSelection selectItem() throws IOException {
		
		jsScroll(locateElement("xpath", "(//input[@value='Add to cart'])[3]"));
		webdriverWait(locateElement("xpath", "(//input[@value='Add to cart'])[3]"));
		extentTest.addScreenCaptureFromPath(takeSnap("Scrolled to last item"));
		click(locateElement("xpath", "(//input[@value='Add to cart'])[3]"));
		return this;
	}
	
	 

}
