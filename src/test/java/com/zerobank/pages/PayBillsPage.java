package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy(partialLinkText = "Add New Payee")
    public WebElement addNewPayeeLink;

    @FindBy(partialLinkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignLink;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInputBoxes;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressInputBoxes;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccountInputBoxes;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsInputBoxes;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "pc_currency")
    public WebElement selectedCurrency;



    @FindBy(xpath = "//button[@data-dismiss='alert']/../div[@id='alert_content']")
    public WebElement message;



}
