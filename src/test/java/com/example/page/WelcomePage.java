package com.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	@FindBy(xpath = "//h1")
	public WebElement header; 
	
	@FindBy(xpath = "//*[@id ='sign-in-button']")
	public WebElement signInButton;
	
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}