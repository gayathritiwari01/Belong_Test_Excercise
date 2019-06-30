package project.stepdefs;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jcucumberng.api.Selenium;
import project.dataobjects.Item;
import project.hooks.ScenarioHook;

public class MegamenuCartSteps {
	private static final Logger LOGGER = LoggerFactory.getLogger(MegamenuCartSteps.class);
	private Selenium selenium = null;

	public MegamenuCartSteps(ScenarioHook scenarioHook) {
		selenium = scenarioHook.getSelenium();
	}

	@Given("^I am at the megamenu page$")
	public void I_Am_At_megamenu_Page() throws Throwable {
		String baseUrl = selenium.navigate("megamenu.url");
		LOGGER.debug("Base URL={}", baseUrl);
	}
	
	@When("^I navigate to Summer Dresses via megamenu Dresses$")
	public void I_navigate_to_Summer_Dresses_via_megamenu_Dresses() throws Throwable {
		Thread.sleep(3000);
		selenium.click("summerdresses.element");
	}
	
	@And("^I should be able to add a dress to the cart$")
	public void I_should_be_able_to_add_a_dress_to_the_cart() throws Throwable {
		selenium.click("firstsummerdress.element");
		Thread.sleep(3000);
		selenium.click("addtocart.element");
		selenium.click("proceedcheckout.element");
	}
	
	@And("^I navigate to the Cart Summary page$")
	public void I_navigate_to_the_Cart_Summary_page() throws Throwable {
		selenium.getVisibleElements("orderdetail.element");
	}
	
	@Then("^I should see product details$")
	public void I_should_see_product_details(@Transpose Item item) throws Throwable {
		Thread.sleep(4000);
		selenium.getVisibleElements("productname.element");
		selenium.getVisibleElements("productcolor.element");
		selenium.getVisibleElements("productqty.element");
		
		WebElement productname = selenium.getVisibleElement("productname.element");
		String actualname = productname.getText();
		WebElement productcolor = selenium.getVisibleElement("productcolor.element");
		String actualcolor = productcolor.getText();
		WebElement productqty = selenium.getVisibleElement("productqty.element");
		String actualqty = productqty.getAttribute("value");
		
		Assertions.assertThat(actualname).isEqualToIgnoringCase(item.getproductname());
//		boolean flag = item.getproductcolor().contains(actualcolor);
//		Assertions.assertThat(flag).isTrue();
		Assertions.assertThat(actualcolor).contains(item.getproductcolor());
		Assertions.assertThat(actualqty).isEqualToIgnoringCase(String.valueOf(item.getproductqty()));
	}

}
