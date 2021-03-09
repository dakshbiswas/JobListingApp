package com.jobapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewMoreDetailPage {

	WebDriver driver;
	By selectJobCardButton = By.xpath("/html/body/app-root/app-protected/div/app-search-bar/div/div/app-job-search-item[1]/div/div");
	By viewMoreButton = By.xpath("/html/body/app-root/app-protected/div/app-job-card/div[2]/ul/li[6]/a");

	public ViewMoreDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openViewMoreDetailPage() {
		driver.findElement(selectJobCardButton).click();
		driver.findElement(viewMoreButton).click();
	}
	
	public void respondToAlerts(){
		driver.switchTo().alert().accept();
	}
	
}
