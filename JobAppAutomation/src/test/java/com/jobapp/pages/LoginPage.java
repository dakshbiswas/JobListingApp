package com.jobapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;

	By username = By.id("userId");
	By password = By.id("password");
	By loginButton = By.xpath(".//*[@type='submit']");
	By logoutButton = By.xpath("/html/body/app-root/app-main-nav/mat-toolbar/button[4]");

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void  userLoginToPage(String userId, String userPassword){
		driver.findElement(username).sendKeys(userId);
		driver.findElement(password).sendKeys(userPassword);		
		driver.findElement(loginButton).click();
	}	
	
	public void respondToAlerts(){
		driver.switchTo().alert().accept();
	}
	
}
