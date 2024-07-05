package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddCustomerPage extends Utility {

    private static final Logger log = LogManager.getLogger(AddCustomerPage.class.getName());

    @CacheLookup
    @FindBy(tagName = "label")
    List<WebElement> fieldLabels;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'First Name :')]/following-sibling::input")
    WebElement firstNameData;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Last Name :')]/following-sibling::input")
    WebElement lastNameData;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Post Code :')]/following-sibling::input")
    WebElement postCodeData;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;


    public void inputCustomerData(String contentType, String data) {
        switch (contentType) {
            case "First Name": {
                sendTextToElement(firstNameData, data);
                log.info("First Name entered : " + data);
                break;
            }
            case "Last Name": {
                sendTextToElement(lastNameData, data);
                log.info("Last Name entered : " + data);
                break;
            }
            case "Post Code": {
                sendTextToElement(postCodeData, data);
                log.info("Post code entered : " + data);
                break;
            }
            default: {
                log.error("Error of missmatch: " + contentType);
            }
        }
    }

    public void clickAddCustomerButton(String buttonText) {
        if (buttonText.contains("Add Customer")) {
            clickOnElement(waitForElementWithFluentWait(submitButton, 5, 1));
            log.info("Click on "+buttonText+" button");
        }
    }

    public String getPopUpMessage() {
        switchToAlert();
        String popUpMessage = getTextFromAlert();
        log.info("Getting popup message: " + popUpMessage);
        return popUpMessage;
    }

    public void clickingOnOKButtonOfPopup() {
        acceptAlert();
        log.info("Clicking OK on pop up window.");
    }
}
