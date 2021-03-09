package com.jobapp.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jobapp.pages.LoginPage;

public class VerifyUserLogin {

	WebDriver driver;
	LoginPage login;
	
	@BeforeTest
	public void setUpTest() {
		
		String nameOfTheSystemProperty  = "webdriver.chrome.driver";
		String valueOfTheSystemProperty = "C:\\Users\\mohan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		System.setProperty( nameOfTheSystemProperty , valueOfTheSystemProperty);
		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.addArguments("--disable-notifications");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
        driver.get("http://localhost:4200/login");
		
        login = new LoginPage(driver);
	}
	
	@Test(description="Test Case for invalid user login")
	public void verifyInValidUserLogin() throws InterruptedException {
		login.userLoginToPage("m1@gmail.com", "12345");	
		Thread.sleep(2000);
		login.respondToAlerts();
	}

	@Test(description="Test Case for valid user login")
	public void verifyValidUserLogin() throws InterruptedException {
        login.userLoginToPage("m1@gmail.com", "12345");	
    }
	

	@AfterTest
	public void tearDownTest() throws InterruptedException {
		
		Thread.sleep(1000);
	    driver.quit();

	}

}
