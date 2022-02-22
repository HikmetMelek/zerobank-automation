
Feature: Add new payee under pay bills
  Background:
    Given the user is logged in
    Then the "Pay Bills" page should be displayed

  Scenario: Add a new payee
    Given Add New Payee tab
    And create new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message The new payee "The Law Offices of Hyde, Price & Scharks" was successfully created. should be displayed