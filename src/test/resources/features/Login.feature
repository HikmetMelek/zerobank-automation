
Feature: Login

 Background:
   Given User is on the login page

  Scenario: User should be able to login with valid credentials
     When User enters the valid credentials
     Then Account Summary page should be displayed
  @login
  Scenario Outline: User should be able to login with invalid credentials
    When User logs in using "<username>" and "<password>"
    Then User should see error message
    Examples:
      | username    | password    |
      | username123 | password    |
      | username    | password123 |
      |             | password    |
      | username    |             |
      | Username    | password    |
