package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
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
        Driver.get().get(ConfigurationReader.get("zeroBankUrl"));
        dashboardPage.singInButton.click();
        new LoginPage().login();
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String title) {
      dashboardPage.navigateToModule(title);
      Assert.assertTrue(Driver.get().getTitle().contains(title));
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        select= new Select(new AccountActivityPage().selectLink);
        select.selectByVisibleText(link);
    }

    @And("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String linkText) {
        String expectedLinkText=linkText;
        System.out.println("expectedLinkText = " + expectedLinkText);
        select= new Select(new AccountActivityPage().selectLink);
        String actualLinkText= select.getFirstSelectedOption().getText();
        System.out.println("actualLinkText = " + actualLinkText);

        Assert.assertEquals(expectedLinkText,actualLinkText);
    }

}
