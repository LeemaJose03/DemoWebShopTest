package com.demoBlaze.selenium.api.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoBlaze.selenium.api.design.Browser;
import com.demoBlaze.selenium.api.design.Element;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Reporter;

public class SeleniumBase extends Reporter implements Browser, Element{

	public static RemoteWebDriver driver;
	public WebDriverWait wait;
	
	
	public void launchBrowser(String browser, String URL) {
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			} else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			} else {
			System.out.println("Opening Chrome browser as Default browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.navigate().to(URL);
		
	}
	
	public void click(WebElement ele) {
		String text="";
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The Element "+text+" clicked", "pass"); 
		} catch (StaleElementReferenceException e) {
			reportStep("The Element "+text+" could not be clicked", "fail");
			throw new RuntimeException();
		} 
	}
	
	public String takeSnap(String screenshotName) throws IOException{
		
		
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir")+"/reports/images/"+screenshotName+".png";
			//String path="./reports/images/"+screenshotName+".png";
			File destination = new File(path);
			FileUtils.copyFile(source, destination);
			return path;
	}

	public void close() {
		driver.close();
		
	}

	public void quit() {
		driver.quit();
		
	}

	public WebElement locateElement(String locatorType, String value) {
		try {
			switch(locatorType.toLowerCase()) {
			case "id": return driver.findElement(By.id(value));
			case "name": return driver.findElement(By.name(value));
			case "class": return driver.findElement(By.className(value));
			case "link": return driver.findElement(By.linkText(value));
			case "xpath": return driver.findElement(By.xpath(value));
			}
		} catch (NoSuchElementException e) {
			reportStep("The Element with locator:"+locatorType+" Not Found with value: "+value, "fail");
			throw new RuntimeException();
		}catch (Exception e) {
			reportStep("The Element with locator:"+locatorType+" Not Found with value: "+value, "fail");
		}
		return null;
		
	}


	@Override
	public void sendKeys(WebElement ele, String value) {
		
		try {
			ele.clear();
			ele.sendKeys(value);
			reportStep("The Data :"+value+" entered Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The Element "+ele+" is not Interactable", "fail");
			throw new RuntimeException();
		}
	}

	public void switchToAlert() {
		driver.switchTo().alert();
	}

	@Override
	public void acceptAlert() {
		String text = "";		
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.", "pass");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.", "fail");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}  

	}

	@Override
	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			System.out.println("The alert "+text+" is accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}  


	}

	@Override
	public void select(WebElement ele, String value) {
		
		Select select = new Select(ele);
		select.selectByVisibleText(value);
		
	}

	@Override
	public void jsScroll(WebElement ele) {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		
	}

	@Override
	public void webdriverWait(WebElement ele) {
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}


	


	
	
	

	
}
