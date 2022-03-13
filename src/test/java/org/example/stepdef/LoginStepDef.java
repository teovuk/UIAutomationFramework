package org.example.stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

    @When("^I enter invalid username \"([^\"]*)\"$")
    public void iEnterInvalidUsername(String username) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("^I enter valid password \"([^\"]*)\"$")
    public void iEnterValidPassword(String password) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("^click on the login button$")
    public void clickOnTheLoginButton() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("^I should see error message \"([^\"]*)\"$")
    public void iShouldSeeErrorMessage(String error) {
        // Write code here that turns the phrase above into concrete actions

    }


}
