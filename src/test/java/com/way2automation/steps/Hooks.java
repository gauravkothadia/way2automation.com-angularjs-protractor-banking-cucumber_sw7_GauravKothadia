package com.way2automation.steps;

import com.way2automation.propertyreader.PropertyReader;
import com.way2automation.utility.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utility { //----Hooks is the BaseTest.java file
    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    @After
    public void tearDown(Scenario scenario){ //---the method always runs, hence it is good place to catch the screenshot of failed tests
        if(scenario.isFailed()){
            final byte[] screenshot = getScreenShot();
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        closeBrowser();
    }
}
