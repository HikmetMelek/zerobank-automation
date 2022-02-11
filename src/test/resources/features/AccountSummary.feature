Feature: Account Summary page

  Scenario: Account summary page verification
    Given the user is logged in
    Then The title should be displayed as "Zero - Account Summary"
    And User should see account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And Credit Accounts table should have following columns
      | Account     |
      | Credit Card |
      | Balance     |