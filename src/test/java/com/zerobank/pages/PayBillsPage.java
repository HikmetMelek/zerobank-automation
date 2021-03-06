package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

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

    @FindBy(id = "pc_amount")
    public WebElement amountInputBox;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsButton;

    @FindBy(id = "pc_inDollars_false")
    public WebElement selectedRadioButton;

    @FindBy(id = "pc_inDollars_true")
    public WebElement dollarRadioButton;

    @FindBy(xpath = "//button[@data-dismiss='alert']/../div[@id='alert_content']")
    public WebElement message;

    @FindBy(id = "sp_amount")
    public WebElement amountInPaySaved;

    @FindBy(id = "sp_date")
    public WebElement dateInputBox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    public void fillForm(Map<String,String> list){
        payeeNameInputBoxes.sendKeys(list.get("Payee Name"));
        payeeAddressInputBoxes.sendKeys(list.get("Payee Address"));
        payeeAccountInputBoxes.sendKeys(list.get("Account"));
        payeeDetailsInputBoxes.sendKeys(list.get("Payee details"));
        addButton.click();
    }

}
