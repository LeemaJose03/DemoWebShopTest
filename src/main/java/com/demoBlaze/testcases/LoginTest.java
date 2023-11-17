package com.demoBlaze.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demoBlaze.pages.Home;
import com.demoBlaze.testng.api.base.ProjectSpecificationMethods;

public class LoginTest extends ProjectSpecificationMethods{

	@BeforeTest
	public void setValues() {
		excelfile="TC001_LoginWithValidAndInvalid.xlsx";
		testName="Login Test";
		testDescription="Login Test with valid and invalid inputs";
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
		.loginSubmitButton();
		
	}
}


