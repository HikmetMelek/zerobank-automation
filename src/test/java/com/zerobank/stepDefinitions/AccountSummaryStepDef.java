package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDef {

    AccountSummaryPage summaryPage= new AccountSummaryPage();

    @Then("The title should be displayed as {string}")
    public void the_title_should_be_displayed_as(String module) {
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(module, actualTitle);

    }

    @And("User should see account types")
    public void user_should_see_account_types(List<String> expectedTable) {
        List<String> actualTable= BrowserUtils.getElementsText(summaryPage.accountTypeList);
        Assert.assertEquals(expectedTable,actualTable);
    }

    @And("Credit Accounts table should have following columns")
    public void credit_Accounts_table_should_have_following_columns(List<String> expectedColumnList) {
        List<String> actualColumnList= BrowserUtils.getElementsText(summaryPage.creditAccountColumns);
        Assert.assertEquals(expectedColumnList,actualColumnList);
    }

}
