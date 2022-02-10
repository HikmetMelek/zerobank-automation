package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy(partialLinkText = "Add New Payee")
    public WebElement addNewPayeeLink;

    @FindBy(xpath = "(//div[@class='board-content'])[2]//div[@class='control-group']")
    public List<WebElement> inputBoxes;



    @FindBy(xpath = "//button[@data-dismiss='alert']/../div[@id='alert_content']")
    public WebElement message;



}
