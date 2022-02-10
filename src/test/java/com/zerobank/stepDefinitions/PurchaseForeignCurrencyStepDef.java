package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyStepDef {
    PayBillsPage page = new PayBillsPage();

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
       page.purchaseForeignLink.click();
    }


    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencies) {
        List<String> actualCurrencies = new ArrayList<>();
        List<WebElement> select= new Select(page.selectedCurrency).getOptions();
        for (WebElement each : select) {
            actualCurrencies.add(each.getText());
        }
        Assert.assertEquals(expectedCurrencies, actualCurrencies);

    }



}
