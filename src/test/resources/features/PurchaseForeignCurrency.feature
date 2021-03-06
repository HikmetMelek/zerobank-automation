Feature: Purchase Foreign Currency

  Background:
    Given the user is logged in
    Then the "Pay Bills" page should be displayed
    Given the user accesses the Purchase foreign currency cash tab

  Scenario: Available currencies
    Then following currencies should be available
      | Select One            |
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |

  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed

  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed




