package project.stepdefs;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jcucumberng.api.Configuration;
import jcucumberng.api.Selenium;
import project.dataobjects.Transaction;
import project.hooks.ScenarioHook;

public class RegisterSteps {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterSteps.class);
	private Selenium selenium = null;

	public RegisterSteps(ScenarioHook scenarioHook) {
		selenium = scenarioHook.getSelenium();
	}

	@Given("^I am at the Authentication page$")
	public void I_Am_At_The_Authentication_Page() throws Throwable {
		String baseUrl = selenium.navigate("authentication.url");
		LOGGER.debug("Base URL={}", baseUrl);
	}
	
	@When("^enter a valid email address: (.*)$")
	public void enter_a_valid_email_address(String email) throws Throwable {
		selenium.type(email, "email.address");
		selenium.click("create.account");
		Thread.sleep(3500);
	}
	
	@Then("^I should be able to proceed with Registeration: (.*)$")
	public void I_should_be_able_to_proceed_with_Registeration(String expected) throws Throwable {
		WebElement pageHeading = selenium.getVisibleElement("page.heading");
		String actual = pageHeading.getText();
		Assertions.assertThat(actual).isEqualToIgnoringCase(expected);
	}
	
	@When("^enter an invalid email address$")
	public void enter_an_invalid_email_address() throws Throwable {
		String invalidEmail = Configuration.project("invalid.email");
		selenium.type(invalidEmail, "email.address");
		selenium.click("create.account");
		Thread.sleep(3500);
	}
	
	@Then("^I should see error message: (.*)$")
	public void I_should_see_error_message(String expected) throws Throwable {
		WebElement errorElement = selenium.getVisibleElement("error.element");
		String actual = errorElement.getText();
		Assertions.assertThat(actual).isEqualToIgnoringCase(expected);
	}

}
