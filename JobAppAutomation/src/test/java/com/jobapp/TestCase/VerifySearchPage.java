package com.jobapp.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jobapp.pages.LoginPage;
import com.jobapp.pages.SearchPage;

public class VerifySearchPage {

	WebDriver driver;
	SearchPage searchPage;
	LoginPage login;
	
	@BeforeTest
	public void setUpTest() {
		
		String nameOfTheSystemProperty  = "webdriver.chrome.driver";
		String valueOfTheSystemProperty = "C:\\Users\\mohan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		System.setProperty( nameOfTheSystemProperty , valueOfTheSystemProperty);
		ChromeOptions chromeOptions = new ChromeOptions();

		driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/login");
		
        login = new LoginPage(driver);
        searchPage = new SearchPage(driver);
	}
	
	@Test(description="Test Case to verify search page working")
	public void verifySearchFunctionality() throws InterruptedException {

        login.userLoginToPage("m1@gmail.com", "1234");	
    	Thread.sleep(1000);
   	    searchPage.getSearchPage("IT");
   		Thread.sleep(2000);
   	 }
	
	@AfterTest
	public void tearDownTest() throws InterruptedException {
		
		Thread.sleep(1000);
	    driver.quit();

	}

}
