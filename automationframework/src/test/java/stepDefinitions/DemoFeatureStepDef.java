package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory; 
import framework.JUnitTestBase;
import framework.SuiteConfiguration;
import pagesFactory.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities; 
import ru.stqa.selenium.factory.WebDriverPool; 
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DemoFeatureStepDef {
	private HomePage homepage;
	private WebDriver driver;
	protected static URL gridHubUrl;
	  protected static String baseUrl;
	  protected static Capabilities capabilities;
 
	  public static void loadConfig() throws Throwable {
	    SuiteConfiguration config = new SuiteConfiguration();
	    baseUrl = config.getProperty("site.url");
	    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
	      gridHubUrl = new URL(config.getProperty("grid.url"));
	    }
	    capabilities = config.getCapabilities();
	  };
	  
	@Given("Precondition is given")
	public void precondition_is_given() { 
		DemoFeatureStepDef test = new DemoFeatureStepDef();
		try {
			test.loadConfig();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities); 
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		homepage = PageFactory.initElements(driver, HomePage.class);
		System.out.println("Precondition is given");
	}

	@When("Something is done")
	public void something_is_done() {
		driver.get(baseUrl);
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
