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


public class FindTransactionStepDef {

    AccountActivityPage page = new AccountActivityPage();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        page.findTransactionsLink.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        page.clearFromDateInputBox();
        page.fromDate.sendKeys(fromDate);
        page.clearToDateInputBox();
        page.toDate.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        page.findButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startedDate, String endedDate) {
        LocalDate started=LocalDate.parse(startedDate,formatter);
        LocalDate ended=LocalDate.parse(endedDate,formatter);
        for (WebElement each : page.dates) {
            LocalDate dateTime=LocalDate.parse(each.getText(),formatter);
            Assert.assertTrue((dateTime.isAfter(started) || dateTime.isEqual(started))
                    && (dateTime.isBefore(ended) || dateTime.isEqual(ended)));
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        for (int i = 0; i< page.dates.size()-1; i++) {
            LocalDate dateTime1=LocalDate.parse(page.dates.get(i).getText(),formatter);
            LocalDate dateTime2=LocalDate.parse(page.dates.get(i+1).getText(),formatter);
            Assert.assertTrue(dateTime1.isAfter(dateTime2));
            //Assert.assertTrue(dateTime1.compareTo(dateTime2)>0);
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String dateOutOfList) {
        LocalDate time= LocalDate.parse(dateOutOfList,formatter);
        for (WebElement each : page.dates) {
            LocalDate dateTime=LocalDate.parse(each.getText(),formatter);
            Assert.assertTrue(time.isBefore(dateTime) || time.isAfter(dateTime));
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        page.clearDescriptionInputBox();
        page.descriptionInputBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        for (WebElement each : page.descriptions) {
            Assert.assertTrue(each.getText().contains(description));
        }
    }

    @But("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        for (WebElement each : page.descriptions) {
            Assert.assertFalse(each.getText().contains(description));
        }
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        Select select= new Select(page.typeSelectButton);
        select.selectByVisibleText(type);
    }

    @Then("results table should show at least one result based on {string}")
    public void results_table_should_show_at_least_one_result_under_based_on(String type) {
        Assert.assertTrue(page.getType(type));
    }

    @Then("results table should show no result under outside of {string}")
    public void results_table_should_show_no_result_under_outside_of(String type) {
        Assert.assertTrue(page.typeElementIsEmpty(type));
   }




}
