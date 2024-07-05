package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(tagName = "button")
    List<WebElement> homePageButtons;

    @CacheLookup
    @FindBy(xpath = "//strong[@class='mainHeading']")
    WebElement mainHeading;


    public void clickingOnButton(String link){
        for(WebElement ele : homePageButtons){
            if(getTextFromElement(ele).trim().contains(link)){
                clickOnElement(ele);
                log.info("Click on "+link+" button");
                break;
            }
        }
    }

    public String getMainHeading(){
        String mainHeadingText = getTextFromElement(mainHeading);
        log.info("Getting main heading: "+mainHeadingText);
        return mainHeadingText;
    }


}