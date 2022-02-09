package com.zerobank.stepDefinitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Hook {
    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final  byte[] screenshot= ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        BrowserUtils.waitFor(2);
        Driver.closeDriver();
    }





}
