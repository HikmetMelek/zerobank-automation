
Feature: Find Transactions in Account Activity
  Description: The purpose of this feature is to test the Find Transactions functionality on Accounts Activity
  Background:
    Given the user is logged in
    Then the "Account Activity" page should be displayed
    Given the user accesses the Find Transactions tab

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
    Then results table should not show any descriptions containing "ONLINE"

  Scenario: Check Type tab with Any
    When user selects type "Any"
    And clicks search
    Then results table should show at least one result based on "Any"

  Scenario Outline: Check Type tab with <Type>
    When user selects type "<Type>"
    And clicks search
    Then results table should show at least one result based on "<Type>"
    But results table should show no result under outside of "<Type>"
    Examples:
      | Type       |
      | Deposit    |
      | Withdrawal |



