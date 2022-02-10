package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{

    @FindBy(partialLinkText = "Add New Payee")
    public WebElement addNewPayeeLink;
}
