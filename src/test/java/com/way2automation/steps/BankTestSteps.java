package com.way2automation.steps;

import com.way2automation.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BankTestSteps {
    @Given("I am on homepage")
    public void iAmOnHomepage() {
    }

    @When("I click on {string} Tab")
    public void iClickOnTab(String tabName) {
        switch (tabName) {
            case "Bank Manager Login": {
                new HomePage().clickingOnButton(tabName);
                break;
            }
            case "Add Customer": {
                new BankManagerLoginPage().clickingOnButtons(tabName);
                break;
            }
            case "Open Account": {
                new BankManagerLoginPage().clickingOnButtons(tabName);
                break;
            }
            case "Customer Login": {
                new HomePage().clickingOnButton(tabName);
                break;
            }
            case "Logout":{
                new AccountPage().clickOnNamedButton(tabName);
                break;
            }
            case "Deposit":{
                new AccountPage().clickOnNamedButton(tabName);
                break;
            }
            case "Withdrawl":{
                new AccountPage().clickOnNamedButton(tabName);
                break;
            }
            default: {

            }
        }
    }

    @And("I click on {string} button")
    public void iClickOnButton(String formButton) {
        switch (formButton) {
            case "Add Customer": {
                new AddCustomerPage().clickAddCustomerButton(formButton);
                break;
            }
            case "Process": {
                new OpenAccountPage().clickingOnProcessButton();
                break;
            }
            case "Login": {
                new CustomerLoginPage().clickLoginButton();
                break;
            }
            case "Deposit":{
                new AccountPage().clickDepositButton();
                break;
            }
            case "Withdrawl":{
                new AccountPage().clickWithdrawlButton();
                break;
            }
        }
    }

    @Then("A popup displays a message as {string}")
    public void aPopupDisplaysAMessageAs(String expectedMessage) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(new AddCustomerPage().getPopUpMessage().trim().contains(expectedMessage));
    }

    @And("I click the OK button on popup")
    public void iClickTheOKButtonOnPopup() {
        new AddCustomerPage().clickingOnOKButtonOfPopup();
    }

    @And("I enter {string} as {string}")
    public void iEnterAs(String contentType, String customerData) {
        new AddCustomerPage().inputCustomerData(contentType, customerData);
    }

    @And("I select the customer name as {string} from dropdown")
    public void iSelectTheCustomerNameAsFromDropdown(String customerName) {
        new OpenAccountPage().setSelectCustomerName(customerName);
    }

    @And("I select the currency as {string}")
    public void iSelectTheCurrencyAs(String currency) {
        new OpenAccountPage().setSelectCurrency(currency);
    }

    @Then("verify that {string} tab is displayed")
    public void verifyThatTabIsDisplayed(String tabName) {
        switch (tabName){
            case "Logout":{
                Assert.assertTrue(new AccountPage().isLogoutTabDisplayed());
                break;
            }
            case "Your Name :":{
                Assert.assertEquals(new CustomerLoginPage().getYourNameText(),tabName);
            }
        }
    }

    @And("I enter amount to be deposited as {string}")
    public void iEnterAmountToBeDepositedAs(String depositAmount) {
        new AccountPage().setAmountToBeDeposited(depositAmount);
    }

    @Then("verify message {string} is displayed")
    public void verifyMessageIsDisplayed(String messageText) {

    }

    @Then("verify message {string} is displayed after {string} process")
    public void verifyMessageIsDisplayedAfterProcess(String messageText, String processName) {
        switch (processName){
            case "Deposit":{
                Assert.assertEquals(new AccountPage().getDepositSuccessfulMessage(),messageText);
                break;
            }
            case "Withdrawl":{
                Assert.assertEquals(new AccountPage().getTransactionSuccessfulMessage(),messageText);
                break;
            }
        }
    }

    @And("I enter amount to be withdraw as {string}")
    public void iEnterAmountToBeWithdrawAs(String withdrawAmount) {
        new AccountPage().setAmountToBeWithdrawl(withdrawAmount);
    }
}
