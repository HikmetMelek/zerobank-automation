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
      page.fillForm(expectedInputs);
    }

    @Then("message The new payee {string} was successfully created. should be displayed")
    public void message_The_new_payee_was_successfully_created_should_be_displayed(String messageTitle) {
        String expectedMessageTitle="The new payee "+messageTitle+" was successfully created.";
        String actualMessageTitle= page.message.getText();
        Assert.assertEquals(expectedMessageTitle,actualMessageTitle);
    }


}
