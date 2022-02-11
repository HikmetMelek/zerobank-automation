Feature: account Activity page

  Scenario: Account activity page verification
    Given the user is logged in
    When User navigates to "Account Activity"
    Then The title should be displayed as "Zero - Account Activity"
    And User should see account option as "Savings"
    And Account drop down should have the options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then Transactions table should have columns
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |