package com.jobapp.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jobapp.pages.LoginPage;
import com.jobapp.pages.ProfilePage;

public class VerifyProfilePage {

	WebDriver driver;
	LoginPage loginPage;
	ProfilePage profilePage;
	
	@BeforeTest
	public void setUpTest() {
		
		String nameOfTheSystemProperty  = "webdriver.chrome.driver";
		String valueOfTheSystemProperty = "C:\\Users\\mohan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		System.setProperty( nameOfTheSystemProperty , valueOfTheSystemProperty);
		ChromeOptions chromeOptions = new ChromeOptions();

		driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/login");
		
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        
	}
	
	@Test(description="Test Case to verify Profile page working")
	public void verifyValidUserLogin() throws InterruptedException {

        loginPage.userLoginToPage("m1@gmail.com", "1234");
        profilePage.userLoginToProfilePage();
        
	}
	

	@AfterTest
	public void tearDownTest() throws InterruptedException {
		
		Thread.sleep(1000);
	    driver.quit();

	}

	
}
