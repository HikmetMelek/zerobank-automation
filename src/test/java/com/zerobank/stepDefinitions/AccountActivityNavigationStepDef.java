package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepDef {

    DashboardPage dashboardPage=new DashboardPage();
    Select select;

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        dashboardPage.singInButton.click();
        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        new LoginPage().login(username,password);
        Driver.get().get("http://zero.webappsecurity.com/bank/account-summary.html");
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String title) {
      dashboardPage.navigateToModule(title);
      Assert.assertTrue(Driver.get().getTitle().contains(title));
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        dashboardPage.accountsType(link).click();
    }

    @And("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedLinkText) {
        select= new Select(new AccountActivityPage().selectLink);
        String actualLinkText= select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedLinkText,actualLinkText);
    }

}
