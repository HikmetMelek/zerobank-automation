package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(partialLinkText = "Account Summary")
    public WebElement accountSummaryLink;

    @FindBy(partialLinkText = "Account Activity")
    public WebElement accountActivityLink;

    @FindBy(partialLinkText = "Pay Bills")
    public WebElement payBillsLink;


    public void navigateToModule(String moduleTitle){
        switch (moduleTitle){
            case "Account Summary":
                accountSummaryLink.click();
                break;
            case "Account Activity":
                accountActivityLink.click();
                break;
            case "Pay Bills":
                payBillsLink.click();
                break;
        }

    }





}
