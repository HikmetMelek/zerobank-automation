package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
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

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
       page.amountInputBox.sendKeys("120");
       page.dollarRadioButton.click();
       page.calculateCostsButton.click();
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedText) {
        Alert alert= Driver.get().switchTo().alert();
        String actualText= alert.getText();
        Assert.assertEquals(expectedText,actualText);
    }


    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Select select= new Select(page.selectedCurrency);
        select.selectByVisibleText("Mexico (peso)");
        page.selectedRadioButton.click();
        page.calculateCostsButton.click();
    }



}
