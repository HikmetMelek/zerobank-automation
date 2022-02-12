package com.zerobank.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement selectLink;

    @FindBy(partialLinkText = "Find Transactions")
    public WebElement findTransactionsLink;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(css = "button[type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    public List<WebElement> dates;

    @FindBy(id = "aa_description")
    public WebElement descriptionInputBox;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[2]")
    public List<WebElement> descriptions;

    @FindBy(xpath = "//*[@id=\"filtered_transactions_for_account\"]/*[@class='well']")
    public WebElement noDescription;

    @FindBy(id = "aa_type")
    public WebElement typeSelectButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[3]")
    public List<WebElement>  depositList;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[4]")
    public List<WebElement>  withdrawalList;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> transactionsColumns;

    public boolean getType(String type){
        boolean flag = false;
        switch (type){
            case "Deposit":
                for (WebElement each : depositList ) {
                        if(!each.getText().isEmpty())
                            flag=true;
                }
                break;
            case "Withdrawal":
                for (WebElement each : withdrawalList ) {
                    if(!each.getText().isEmpty())
                        flag=true;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return flag;
    }

    public boolean typeElementIsEmpty(String type){
        boolean flag = false;
        switch (type){
            case "Deposit":
                for (WebElement each : withdrawalList ) {
                    if(each.getText().isEmpty());
                    flag=true;
                }
                break;
            case "Withdrawal":
                for (WebElement each : depositList ) {
                    if(each.getText().isEmpty());
                    flag=true;
                }
                break;
        }
        return flag;
    }


}
