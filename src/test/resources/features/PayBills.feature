
Feature: Pay Saved Payee function in Pay Bills page
  Background:
    Given the user is logged in
    When User navigates to "Pay Bills"

  Scenario: User should make successfully payment by Pay Saved Payee
    Then The title should be displayed as "Zero - Pay Bills"
    When User enters amount "500" and date "2022-02-11"
    Then User should see success message "The payment was successfully submitted."

  Scenario: User should not make payment by Pay Saved Payee with blank amount
    And User enters amount "" and date "2022-02-11"
    Then User should see warning "Please fill out this field." on amount input box

  Scenario: User should not make payment by Pay Saved Payee with blank date
    And User enters amount "500" and date ""
    Then User should see warning "Please fill out this field." on date input box


