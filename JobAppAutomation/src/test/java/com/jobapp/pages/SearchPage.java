package com.jobapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	WebDriver driver;

	By searchBar = By.xpath("/html/body/app-root/app-protected/div/app-search-bar/div/form/div/div/input");
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getSearchPage(String search){
		driver.findElement(searchBar).click();
		driver.findElement(searchBar).sendKeys(search);
	}	

}
