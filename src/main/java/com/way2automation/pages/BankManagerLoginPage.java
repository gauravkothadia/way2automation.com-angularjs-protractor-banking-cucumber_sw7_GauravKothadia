package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BankManagerLoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(BankManagerLoginPage.class.getName());


    @FindBy(xpath = "//div[@class='center']//button")
    List<WebElement> buttons;

    public void clickingOnButtons(String link) {
        waitCurrentURLContainsWith("manager",5);//----waiting and checking we are on correct page.
        for (WebElement ele : buttons) {
            if (getTextFromElement(ele).contains(link)) {
                clickOnElement(ele);
                log.info("Click on " + link + " button");
                break;
            }
        }
    }
}
