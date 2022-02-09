package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

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
//        List<LocalDate> dateList = input.dates.stream()
//                .map(each -> LocalDate.parse(each.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
//                .collect(Collectors.toList());
//
        for (WebElement each : input.dates) {
            LocalDate dateTime=LocalDate.parse(each.getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println("dateTimeEach = " + dateTime);
            Assert.assertTrue((!dateTime.isAfter(started) || !dateTime.isEqual(started)) && (!dateTime.isBefore(ended) || !dateTime.isEqual(ended)));
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

    }

}
