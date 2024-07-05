package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(CustomerLoginPage.class.getName());

    @CacheLookup
    @FindBy(xpath="//select[@id='userSelect']")
    WebElement selectCustomerName;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Your Name :']")
    WebElement yourNameText;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    public String getYourNameText(){
        String yourName =getTextFromElement(yourNameText);
        log.info("Getting the "+yourName+" text verification");
        return yourName;
    }

    public void clickLoginButton(){
        clickOnElement(loginButton);
        log.info("Click on Login button");
    }
}
