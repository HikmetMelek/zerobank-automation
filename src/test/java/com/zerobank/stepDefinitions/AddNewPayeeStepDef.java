package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Map;

public class AddNewPayeeStepDef {
    PayBillsPage page = new PayBillsPage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        page.addNewPayeeLink.click();
    }

    @And("create new payee using following information")
    public void create_new_payee_using_following_information(Map<String,String> expectedInputs) {




    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
