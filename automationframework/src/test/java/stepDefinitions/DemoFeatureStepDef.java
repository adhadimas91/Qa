package stepDefinitions;
 
import io.cucumber.java.en.*; 
import org.junit.jupiter.api.Assertions; 
import org.openqa.selenium.support.PageFactory;

import framework.BaseClass; 
import pagesFactory.HomePage; 

public class DemoFeatureStepDef extends BaseClass{

	private BaseClass base;
	public DemoFeatureStepDef(BaseClass base) {
		this.base = base;
	}

	private HomePage homepage; 

	@Given("Precondition is given")
	public void precondition_is_given() { 
		homepage =  PageFactory.initElements(base.driver, HomePage.class);
		System.out.println("Precondition is given");
	}

	@When("Something is done")
	public void something_is_done() {
		
		base.driver.get(base.baseUrl);
		  Assertions.assertFalse("".equals(homepage.header.getText())); 
		  homepage.LoginButton.click();
		 
		System.out.println("Something is done");
	}

	@Then("Something is expected")
	public void something_is_expected() {
		System.out.println("Something is expected");
	}

	@Given("Another precondition is given")
	public void another_precondition_is_given() {
		System.out.println("Another precondition is given");
	}

	@When("Something is done again")
	public void something_is_done_again() {
		System.out.println("Something is done again");
	}

	@Then("Something is expected again")
	public void something_is_expected_again() {
		System.out.println("Something is expected again");
	}
  
}
