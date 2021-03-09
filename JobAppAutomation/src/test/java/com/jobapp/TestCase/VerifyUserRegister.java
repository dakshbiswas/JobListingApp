package com.jobapp.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jobapp.pages.RegisterPage;

public class VerifyUserRegister {


	WebDriver driver;
	RegisterPage register;
	
	@BeforeTest
	public void setUpTest() {
		
		String nameOfTheSystemProperty  = "webdriver.chrome.driver";
		String valueOfTheSystemProperty = "C:\\Users\\mohan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe";
		System.setProperty( nameOfTheSystemProperty , valueOfTheSystemProperty);
		ChromeOptions chromeOptions = new ChromeOptions();

		driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/registration");
		
        register = new RegisterPage(driver);
	}
	
	@Test(description="Test Case for valid user register")
	public void verifyValidUserRegister() throws InterruptedException {

        register.userRegisterToPage("Mohan", "Rohankar", "m2@gmail.com", "1234");
        
	}
	

	@AfterTest
	public void tearDownTest() throws InterruptedException {
		
		Thread.sleep(1000);
	    driver.quit();

	}

}
