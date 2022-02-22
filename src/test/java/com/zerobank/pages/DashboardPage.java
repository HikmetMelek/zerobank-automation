package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{


    public void navigateToModule(String moduleTitle){
       Driver.get().findElement(By.linkText(moduleTitle)).click();
    }

    public WebElement accountsType(String accounts){
        return Driver.get().findElement(By.linkText(accounts));
    }





}
