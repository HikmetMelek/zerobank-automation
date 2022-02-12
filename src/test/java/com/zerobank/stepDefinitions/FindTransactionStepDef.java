package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


public class FindTransactionStepDef {

    AccountActivityPage input= new AccountActivityPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        input.findTransactionsLink.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String startedDate, String endedDate) {
        input.fromDate.clear();
        input.fromDate.sendKeys(startedDate);
        input.toDate.clear();
        input.toDate.sendKeys(endedDate);
    }

    @When("clicks search")
    public void clicks_search() {
        input.findButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startedDate, String endedDate) {
        LocalDate started=LocalDate.parse(startedDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate ended=LocalDate.parse(endedDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        for (WebElement each : input.dates) {
            LocalDate dateTime=LocalDate.parse(each.getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Assert.assertTrue((dateTime.isAfter(started) || dateTime.isEqual(started))
                    && (dateTime.isBefore(ended) || dateTime.isEqual(ended)));
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        for (WebElement each : input.dates) {
            LocalDate dateTime=LocalDate.parse(each.getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println("dateTimeEach = " + dateTime+"  ");
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String dateOutOfList) {
        LocalDate time= LocalDate.parse(dateOutOfList,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        for (WebElement each : input.dates) {
            LocalDate dateTime=LocalDate.parse(each.getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Assert.assertTrue(time.isBefore(dateTime) || time.isAfter(dateTime));
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        input.descriptionInputBox.clear();
        input.descriptionInputBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        for (WebElement each : input.descriptions) {
            Assert.assertTrue(each.getText().contains(description));
        }
    }

    @But("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        for (WebElement each : input.descriptions) {
            Assert.assertFalse(each.getText().contains(description));
        }
    }

    @Then("results table should not show any descriptions containing {string}")
    public void results_table_should_not_show_any_descriptions_containing(String caseSensitive) {
        Assert.assertFalse(input.noDescription.getText().contains(caseSensitive));
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        Select select= new Select(input.typeSelectButton);
        select.selectByVisibleText(type);
    }

    @Then("results table should show at least one result based on {string}")
    public void results_table_should_show_at_least_one_result_under_based_on(String type) {
        Assert.assertTrue(input.getType(type));
    }

    @Then("results table should show no result under outside of {string}")
    public void results_table_should_show_no_result_under_outside_of(String type) {
        Assert.assertTrue(input.typeElementIsEmpty(type));
   }




}
