package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityStepDef {

    AccountActivityPage activityPage=new AccountActivityPage();

    @When("User navigates to {string}")
    public void user_navigates_to(String module) {
        new DashboardPage().navigateToModule(module);
    }

    @And("User should see account option as {string}")
    public void user_should_see_account_option_as(String expectedSelected) {
        Select select= new Select(activityPage.selectLink);
        String actualSelected= select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedSelected,actualSelected);
    }

    @And("Account drop down should have the options")
    public void account_drop_down_should_have_the_options(List<String> expectedList) {
        List<WebElement> select= new Select(activityPage.selectLink).getOptions();
        List<String> actualList= BrowserUtils.getElementsText(select);
        Assert.assertEquals(expectedList,actualList);
    }

    @Then("Transactions table should have columns")
    public void transactions_table_should_have_columns(List<String> expectedColumns) {
        List<String> actualColumns= BrowserUtils.getElementsText(activityPage.transactionsColumns);
        Assert.assertEquals(expectedColumns,actualColumns);

    }
}
