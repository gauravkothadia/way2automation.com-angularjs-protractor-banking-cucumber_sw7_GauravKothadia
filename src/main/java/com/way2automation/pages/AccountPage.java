package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(AddCustomerPage.class.getName());

    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Logout')]")
    WebElement logoutButton;

    public boolean isLogoutTabDisplayed(){
        waitCurrentURLContainsWith("account",5);
        return verifyThatElementIsDisplayed(logoutButton);
    }

    @CacheLookup
    @FindBy(xpath="//button")
    List<WebElement> buttons;

    public void clickOnNamedButton(String buttonName){
        waitCurrentURLContainsWith("account",5);
        for(WebElement ele : buttons){
            if(getTextFromElement(ele).trim().equalsIgnoreCase(buttonName)){
            //if(getTextFromElement(ele).trim().contains(buttonName)){
                clickOnElement(ele);
                log.info("Click on button "+buttonName);
                break;
            }
        }
    }

    @CacheLookup
    @FindBy(xpath="//label[contains(text(),'Amount to be Deposited :')]/following-sibling::input")
    WebElement amountToBeDeposited;

    public void setAmountToBeDeposited(String depositAmount){
        sendTextToElement(amountToBeDeposited,depositAmount);
        log.info("Amount to be deposited: "+depositAmount);
    }

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositAndWithdrawlButton;

    public void clickDepositButton(){
        clickOnElement(depositAndWithdrawlButton);
        log.info("Click on the Deposit button");
    }

    public void clickWithdrawlButton(){
        clickOnElement(depositAndWithdrawlButton);
        log.info("Click on the Withdrawl button");
    }

    @CacheLookup @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessfulMessage;

    @CacheLookup @FindBy(xpath = "//label[contains(text(),'Amount to be Withdrawn :')]/following-sibling::input")
    WebElement amountToBeWithdrawl;

    public void setAmountToBeWithdrawl(String withdrawlAmount){
        sendTextToElement(amountToBeWithdrawl,withdrawlAmount);
        log.info("Amount to be withdrawn: "+withdrawlAmount);
    }

    @CacheLookup @FindBy(xpath="//span[contains(text(),'Transaction successful')]")
    WebElement transactionSuccessfulMessage;

    public String getDepositSuccessfulMessage(){
        String depositMessage =getTextFromElement(depositSuccessfulMessage);
        log.info("Getting deposit success message: "+depositMessage);
        return depositMessage;
    }

    public String getTransactionSuccessfulMessage(){
        String withdrawMessage = getTextFromElement(transactionSuccessfulMessage);
        log.info("Getting withdraw success message: "+withdrawMessage);
        return withdrawMessage;
    }
}
