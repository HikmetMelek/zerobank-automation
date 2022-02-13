@asx
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is logged in
    Then the "Account Summary" page should be displayed

  Scenario Outline: <selectedAccount> account redirect
    When the user clicks on "<selectedAccount>" link on the Account Summary page
    And Account drop down should have "<selectedAccount>" selected
    Examples:
      | selectedAccount |
      | Savings         |
      | Brokerage       |
      | Checking        |
      | Credit Card     |
      | Loan            |




#  Scenario: Brokerage account redirect
#    When the user clicks on "Brokerage" link on the Account Summary page
#    And Account drop down should have "Brokerage" selected
#
#  Scenario: Checking account redirect
#    When the user clicks on "Checking" link on the Account Summary page
#    And Account drop down should have "Checking" selected
#
#  Scenario: Credit Card account redirect
#    When the user clicks on "Credit Card" link on the Account Summary page
#    And Account drop down should have "Credit Card" selected
#
#  Scenario: Loan account redirect
#    When the user clicks on "Loan" link on the Account Summary page
#    And Account drop down should have "Loan" selected