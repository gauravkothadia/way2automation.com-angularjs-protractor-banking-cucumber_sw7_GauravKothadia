package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends Utility {
    private static final Logger log = LogManager.getLogger(OpenAccountPage.class.getName());

    @CacheLookup
    @FindBy(xpath="//select[@id='userSelect']")
    WebElement selectCustomerName;

    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Process')]")
    WebElement processButton;

    @CacheLookup
    @FindBy(xpath="//select[@id='currency']")
    WebElement currencySelection;

    public void setSelectCustomerName(String fullName){
        clickOnElement(selectCustomerName);
        selectByVisibleTextFromDropDown(selectCustomerName, fullName);
        log.info("Selecting "+fullName+" from the dropdown.");
    }

    public void setSelectCurrency(String currencyName){
        clickOnElement(currencySelection);
        selectByVisibleTextFromDropDown(currencySelection, currencyName);
        log.info("Selecting "+currencyName+" as a currency");
    }

    public void clickingOnProcessButton(){
        clickOnElement(processButton);
        log.info("Click on Process button");
    }
    public String getPopUpMessage(){
        String popUpMessage = getTextFromAlert();
        log.info("Getting popup message: "+popUpMessage);
        return popUpMessage;
    }

    public void clickingOnOKButtonOfPopup(){
        acceptAlert();
        log.info("Clicking on OK button on pop up window");
    }
}
