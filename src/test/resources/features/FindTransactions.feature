
Feature: Find Transactions in Account Activity
  Description: The purpose of this feature is to test the Find Transactions functionality on Accounts Activity
  Background:
    Given the user is logged in
    When the "Account Activity" page should be displayed
    Then the user accesses the Find Transactions tab
@wip
  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"

  Scenario Outline: Search description
    When the user enters description "<Search Word>"
    And clicks search
    Then results table should only show descriptions containing "<Search Word>"
    But results table should not show descriptions containing "<Other Word>"
    Examples:
      | Search Word | Other Word |
      | ONLINE      | OFFICE     |
      | OFFICE      | ONLINE     |

  Scenario: Search description case insensitive
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "online"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"

  Scenario: Check Type tab
    And clicks search
    Then results table should show at least one result based on "Deposit"
    Then results table should show at least one result based on "Withdrawal"
    When user selects type "Deposit"
    And clicks search
    Then results table should show at least one result based on "Deposit"
    But results table should show no result under outside of "Withdrawal"
    When user selects type "Withdrawal"
    And clicks search
    Then results table should show at least one result based on "Withdrawal"
    But results table should show no result under outside of "Deposit"





