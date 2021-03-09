package com.jobapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobCardDetailPage {

	WebDriver driver;
	By selectJobCardButton = By.xpath("/html/body/app-root/app-protected/div/app-search-bar/div/div/app-job-search-item[1]/div/div");

	public JobCardDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openViewMoreDetailPage() {
		driver.findElement(selectJobCardButton).click();
	}
	
	public void respondToAlerts(){
		driver.switchTo().alert().accept();
	}
}
