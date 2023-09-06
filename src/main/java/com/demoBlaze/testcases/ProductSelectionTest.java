package com.demoBlaze.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demoBlaze.pages.Home;
import com.demoBlaze.testng.api.base.ProjectSpecificationMethods;

public class ProductSelectionTest extends ProjectSpecificationMethods {

	
	@BeforeTest
	public void setValues() {
		excelfile="TC002_LoginCredentials";
		testName="Product selection";
		testDescription="Product selection test";
		testCategory="Regression";
		testAuthor="Leema Josephine";
		//dataSheetName = "TC001";
	}
	
	@Test(dataProvider = "fetchData")
	public void loginTest(String email, String password) throws IOException {
		new Home(driver)
		.clickLogin()
		.loginUsername(email)
		.loginPassword(password)
		.loginRember()
		.loginSubmitButton()
		.computers()
		.desktops()
		.sortBy()
		.display()
		.list()
		.selectItem();
	}
	
}
