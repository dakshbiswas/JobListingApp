package com.jobapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	WebDriver driver;

	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By userId = By.id("userId");
	By password = By.id("password");
	By registerButton = By.xpath("//button[@type='submit']");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void userRegisterToPage(String firstname,String lastname,String userid, String pass){
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);	
		driver.findElement(userId).sendKeys(userid);	
		driver.findElement(password).sendKeys(pass);	
		driver.findElement(registerButton).click();
	}

	
}
