package com.zerobank.stepDefinitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage=new LoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        new DashboardPage().singInButton.click();
    }

    @When("User enters the valid credentials")
    public void user_enters_the_valid_credentials() {
        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        loginPage.login(username,password);
        BrowserUtils.waitFor(1);
        Driver.get().get("http://zero.webappsecurity.com/bank/account-summary.html");
    }

    @Then("Account Summary page should be displayed")
    public void account_Summary_page_should_be_displayed() {
        Assert.assertTrue(Driver.get().getTitle().contains("Account Summary"));
    }

    @When("User logs in using {string} and {string}")
    public void user_logs_in_using_and(String username, String password) {
        BrowserUtils.waitFor(1);
        loginPage.login(username,password);
    }

    @Then("User should see error message")
    public void user_should_see_error_message() {
        String expectedMessage="Login and/or password are wrong.";
        String actualMessage=loginPage.alertMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }


}
