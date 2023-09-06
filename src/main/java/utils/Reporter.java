package utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter {

	// This class is used for generating the HTML report
	public static ExtentSparkReporter sparkReporter;

	// This class is used for generating the tests
	public static ExtentReports extentReports;

	// This class is used for generating the logs for each test case
	public static ExtentTest extentTest;

	public String testName,testDescription,testCategory,testAuthor;
	
	@BeforeSuite
	public void startReport() {
		try {
			sparkReporter = new ExtentSparkReporter("./reports/result.html");
			extentReports = new ExtentReports();

			sparkReporter.config().setDocumentTitle("W3Schools Automation Report");
			sparkReporter.config().setReportName("W3Schools Web Automation Results");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setTimeStampFormat("EEEE, MMM dd, yyyy, hh:mm a '('zzz')'"); // Thursday, April 13,
																								// 2023, 11:13 AM (IST)

			extentReports.attachReporter(sparkReporter);

		} catch (Exception ex) {
			System.out.println("Problem while generating HTML report");
			ex.printStackTrace();
		}
	}

	
	@BeforeClass
	public void setTCDesc() {
		try {
			extentTest = extentReports.createTest(testName,testDescription);
			extentTest.assignCategory(testCategory);
			extentTest.assignAuthor(testAuthor);
		} catch (Exception ex) {
			System.out.println("Problem while creating the test case ");
			ex.printStackTrace();
		}
	} 

	public static void reportStep(String desc, String status) {
		try {
			if (status.toUpperCase().equals("PASS")) {
				extentTest.log(Status.PASS, desc);
			} else if (status.toUpperCase().equals("FAIL")) {
				extentTest.log(Status.FAIL, desc);
			} else if (status.toUpperCase().equals("SKIP")) {
				extentTest.log(Status.SKIP, desc);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

	
	@AfterSuite
	public void endReport() {
		try {
			extentReports.flush();
		} catch (Exception ex) {
			System.out.println("Problem while generating the report");
			ex.printStackTrace();
		}
	}

}

