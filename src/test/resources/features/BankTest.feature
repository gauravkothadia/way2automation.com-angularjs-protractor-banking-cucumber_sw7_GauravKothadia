Feature: Bank Testing functionality

  Background:
    Given I am on homepage

  @smoke @sanity @regression
  Scenario Outline: Bank Manager should be able to add customer successfully
    When I click on "Bank Manager Login" Tab
    And I click on "Add Customer" Tab
    And I enter "First Name" as "<firstName>"
    And I enter "Last Name" as "<lastName>"
    And I enter "Post Code" as "<postCode>"
    And I click on "Add Customer" button
    Then A popup displays a message as "Customer added successfully"
    And I click the OK button on popup
    Examples:
      | firstName | lastName | postCode |
      | Donald    | Jackson  | AB014JS  |

  @sanity @regression
  Scenario: Bank Manager should be able to open account successfully
    When I click on "Bank Manager Login" Tab
    And I click on "Open Account" Tab
    And I select the customer name as "Hermoine Granger" from dropdown
    And I select the currency as "Pound"
    And I click on "Process" button
    Then A popup displays a message as "Account created successfully"
    And I click the OK button on popup

  @regression
  Scenario: Customer should login and logout successfully
    When I click on "Customer Login" Tab
    And I select the customer name as "Hermoine Granger" from dropdown
    And I click on "Login" button
    Then verify that "Logout" tab is displayed
    When I click on "Logout" Tab
    Then verify that "Your Name :" tab is displayed

  @regression
  Scenario: Customer should be able to deposit money successfully
    When I click on "Customer Login" Tab
    And I select the customer name as "Hermoine Granger" from dropdown
    And I click on "Login" button
    And I click on "Deposit" Tab
    And I enter amount to be deposited as "100"
    And I click on "Deposit" button
    Then verify message "Deposit Successful" is displayed after "Deposit" process


  @regression
  Scenario: Customer should be able to withdraw money successfully
    When I click on "Customer Login" Tab
    And I select the customer name as "Hermoine Granger" from dropdown
    And I click on "Login" button
    And I click on "Withdrawl" Tab
    And I enter amount to be withdraw as "50"
    And I click on "Withdrawl" button
    Then verify message "Transaction successful" is displayed after "Withdrawl" process