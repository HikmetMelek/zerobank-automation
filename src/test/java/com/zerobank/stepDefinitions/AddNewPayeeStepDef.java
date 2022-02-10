package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDef {
    PayBillsPage page = new PayBillsPage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        page.addNewPayeeLink.click();
    }

    @And("create new payee using following information")
    public void create_new_payee_using_following_information(Map<String,String> expectedInputs) {
        page.payeeNameInputBoxes.sendKeys(expectedInputs.get("Payee Name"));
        page.payeeAddressInputBoxes.sendKeys(expectedInputs.get("Payee Address"));
        page.payeeAccountInputBoxes.sendKeys(expectedInputs.get("Account"));
        page.payeeDetailsInputBoxes.sendKeys(expectedInputs.get("Payee details"));
        page.addButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String messageTitle) {
        Assert.assertEquals(messageTitle.trim(),page.message.getText().trim());
    }

}
