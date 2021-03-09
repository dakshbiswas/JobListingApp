package com.jobapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

	WebDriver driver;

	By ProfilePageButton = By.xpath("/html/body/app-root/app-main-nav/mat-toolbar/button[1]/span[1]/mat-icon");

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void userLoginToProfilePage(){
		driver.findElement(ProfilePageButton).click();
	}	

}
