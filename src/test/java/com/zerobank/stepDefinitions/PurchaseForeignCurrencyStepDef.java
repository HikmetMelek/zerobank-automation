package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDef {
    PayBillsPage page = new PayBillsPage();

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
       page.purchaseForeignLink.click();
    }


    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencies) {
        String expectedText="";
        String actualText="";

        List<WebElement> select= new Select(page.selectedCurrency).getOptions();
        for (int i=1; i<select.size();i++) {
            actualText = select.get(i).getText();
        }

        for (int i=0; i< expectedCurrencies.size();i++) {
            expectedText = expectedCurrencies.get(i);
        }

        Assert.assertEquals(expectedText,actualText);

    }



}
