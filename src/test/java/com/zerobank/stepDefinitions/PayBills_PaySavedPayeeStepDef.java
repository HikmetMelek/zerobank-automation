package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBills_PaySavedPayeeStepDef {

    PayBillsPage payPage= new PayBillsPage();

    @When("User enters amount {string} and date {string}")
    public void user_enters_amount_and_date(String amount, String date) {
        payPage.amountInPaySaved.sendKeys(amount);
        payPage.dateInputBox.sendKeys(date);
        payPage.payButton.click();

    }

    @Then("User should see success message {string}")
    public void user_should_see_success_message(String expectedMessage) {
        String actualMessage= payPage.message.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Then("User should see warning {string} on amount input box")
    public void user_should_see_warning_on_amount_input_box(String warningMessage) {
        String actualWarningMessage= payPage.amountInPaySaved.getAttribute("validationMessage");
        Assert.assertEquals(warningMessage,actualWarningMessage);

    }

    @Then("User should see warning {string} on date input box")
    public void user_should_see_warning_on_date_input_box(String warningMessage) {
        String actualWarningMessage= payPage.dateInputBox.getAttribute("validationMessage");
        Assert.assertEquals(warningMessage,actualWarningMessage);
    }

}
