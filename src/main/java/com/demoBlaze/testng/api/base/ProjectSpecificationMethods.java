package com.demoBlaze.testng.api.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.demoBlaze.selenium.api.base.SeleniumBase;

import utils.ReadExcel;

public class ProjectSpecificationMethods extends SeleniumBase {

	public String excelfile;
	//@Parameters({"browser", "url"})
	@BeforeMethod
	public void browserLaunch() {
		
		launchBrowser("chrome", "https://demowebshop.tricentis.com/");
	}
	
	@AfterMethod
	public void closeBrowser() {
		close();
	}
	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return ReadExcel.readExcel(excelfile);
		
	}
}
