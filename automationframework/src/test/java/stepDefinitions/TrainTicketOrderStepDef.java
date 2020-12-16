package stepDefinitions;

import io.cucumber.java.en.*;
import junit.framework.Assert;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

import framework.BaseClass;
import pagesFactory.*;

public class TrainTicketOrderStepDef extends BaseClass {

	private BaseClass base;

	public TrainTicketOrderStepDef(BaseClass base) {
		this.base = base;
	}

	private HomePage homepage;
	private TrainOrderPage trainorderpage;
	private TrainSearchResultPage trainsearchresultpage;
	private TrainOrderDetailPage trainorderdetailpage;
	private TrainSeatPage trainseatpage;
	
	@Given("User go to tiket website")
	public void user_go_to_tiketcom() {
		homepage = PageFactory.initElements(base.driver, HomePage.class);
		base.driver.get(base.baseUrl);
		Assertions.assertFalse("".equals(homepage.header.getText())); 
	}

	@And("Choose Kereta api menu")
	public void choose_kereta_api_menu() {
		homepage.MenuKeretaApiButton.click();
		JavascriptExecutor js = (JavascriptExecutor)base.driver;
		js.executeScript("window.scrollTo(0, 400)");	
	}

	@And("Select departure")
	public void select_departure() {
		trainorderpage = PageFactory.initElements(base.driver, TrainOrderPage.class);
		trainorderpage.OkButton.click();
		WebDriverWait wait = new WebDriverWait(base.driver, 10); 
		wait.until(ExpectedConditions.elementToBeClickable(trainorderpage.DepartKeretaInput));
		
		trainorderpage.DepartKeretaInput.sendKeys("Jakarta");
		trainorderpage.DepartCity.click();
	}

	@And("Select destination")
	public void select_destination() {
		trainorderpage.DestinationKeretaInput.sendKeys("Bandung");
		trainorderpage.DestCity.click(); 
	}
	
	@And("Select date")
	public void select_date() { 
		//trainorderpage.DateGoKeretaInput.click(); 
		WebDriverWait wait = new WebDriverWait(base.driver, 10); 
		wait.until(ExpectedConditions.visibilityOf(trainorderpage.TitlePilihanTgl));
		
		WebElement date = trainorderpage.DateNumber; 
	    
	    	((JavascriptExecutor) base.driver).executeScript("arguments[0].scrollIntoView(true);", date);

	    	Actions build = new Actions(base.driver);
			Actions act = build.moveToElement(date)
					.click(); 
			act.perform();
		  
	}

	@And("Add Dewasa passanger {int}")
	public void add_dewasa_passanger(int dewasa) {
		trainorderpage.PenumpangKeretaInput.click();
		if(dewasa > 1) {
			for(int i=1; i<=dewasa-1; i++)
			{
				trainorderpage.PlusDewasaButton.click();
			}
		}
		 
	}

	@And("Add Bayi passanger {int}")
	public void add_bayi_passanger(int bayi) {
		  
			for(int i=1; i<=bayi; i++)
			{
				trainorderpage.PlusBayiButton.click();
			}
			trainorderpage.SelesaiButton.click(); 
	}

	@When("User Click Cari Kereta Api")
	public void user_click_cari_kereta_api() {
		WebDriverWait wait = new WebDriverWait(base.driver, 10); 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(trainorderpage.CariKeretaButton));
		element.click(); 
	}

	@Then("User Can see list of kereta api that available")
	public void user_can_see_list_of_kereta_api_that_available() {
		trainsearchresultpage = PageFactory.initElements(base.driver, TrainSearchResultPage.class);
		Assertions.assertEquals("Pilih Kereta Pergi", trainsearchresultpage.TitleSearchBox.getText()); 
	}

	@When("User Filter Kereta Api Eksekutif")
	public void user_filter_kereta_api_eksekutif() {
		WebDriverWait wait = new WebDriverWait(base.driver, 10); 
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".search-result"), 2));
		trainsearchresultpage.EkonomiChecboxFilter.click();
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".search-result"), 2));
	}

	@Then("User Can see only Ekonomi list of kereta api")
	public void user_can_see_only_eksekutif_list_of_kereta_api() { 
		String tipeTrain = trainsearchresultpage.TitleTipeKereta.getText();  
		Assertions.assertTrue(tipeTrain.contains("Ekonomi")); 
	}

	@When("User Choose kereta api")
	public void user_choose_kereta_api() {
		 trainsearchresultpage.PilihButton.click();
	}

	@Then("Fill Detail Pemesanan {string} and {string} and {string} and {string}")
	public void fill_detail_pemesanan(String email, String nama, String ktp, String phone) {
		trainorderdetailpage = PageFactory.initElements(base.driver, TrainOrderDetailPage.class);
		WebDriverWait wait = new WebDriverWait(base.driver, 10); 
		wait.until(ExpectedConditions.visibilityOf(trainorderdetailpage.TitlePemesananBox));
		Assertions.assertEquals("Detail Pemesan", trainorderdetailpage.TitlePemesananBox.getText());
		
		trainorderdetailpage.InputEmail.sendKeys(email);
		trainorderdetailpage.InputPhone.sendKeys(phone);
		
		List<WebElement> allNama = trainorderdetailpage.InputNama;
	    for ( WebElement we: allNama) { 
	        we.sendKeys(nama); 	     
	    }
	    List<WebElement> ktps = trainorderdetailpage.InputIdentityNumber;
	    int unik = 1;
	    for ( WebElement we: ktps) { 
	        we.sendKeys(ktp+unik); 	 
	        unik++;
	    }
	    
	    List<WebElement> date = trainorderdetailpage.InputDate; 
	    for ( WebElement we: date) {  
	    	((JavascriptExecutor) base.driver).executeScript("arguments[0].scrollIntoView(true);", we);

	    	Actions build = new Actions(base.driver);
			Actions act = build.moveToElement(we)
					.click(); 
			act.perform();
			WebDriverWait waitdate = new WebDriverWait(base.driver, 10);  
			WebElement element = waitdate.until(ExpectedConditions.elementToBeClickable(trainorderdetailpage.DateButton));
			element.click(); 
	    }
	    List<WebElement> month = trainorderdetailpage.InputMonth; 
	    for ( WebElement we: month) {  
	    	((JavascriptExecutor) base.driver).executeScript("arguments[0].scrollIntoView(true);", we);

	    	Actions build = new Actions(base.driver);
			Actions act = build.moveToElement(we)
					.click(); 
			act.perform();
			WebDriverWait waitdate = new WebDriverWait(base.driver, 10);  
			WebElement element = waitdate.until(ExpectedConditions.elementToBeClickable(trainorderdetailpage.MonthButton));
			element.click(); 
	    }
	    
	    List<WebElement> year = trainorderdetailpage.InputYear; 
	    for ( WebElement we: year) {  
	    	((JavascriptExecutor) base.driver).executeScript("arguments[0].scrollIntoView(true);", we);

	    	Actions build = new Actions(base.driver);
			Actions act = build.moveToElement(we)
					.click(); 
			act.perform();
			WebDriverWait waitdate = new WebDriverWait(base.driver, 10);  
			WebElement element = waitdate.until(ExpectedConditions.elementToBeClickable(trainorderdetailpage.YearButton));
			element.click(); 
	    }
	    
	}

	@And("User Pilih kursi")
	public void user_pilih_kursi() {  
		trainorderdetailpage.SeatButton.click(); 
	}

	@When("User click lanjutkan pembayaran")
	public void user_click_lanjutkan_pembayaran() {
		trainseatpage = PageFactory.initElements(base.driver, TrainSeatPage.class);
		WebDriverWait waitdate = new WebDriverWait(base.driver, 10);  
		WebElement element = waitdate.until(ExpectedConditions.elementToBeClickable(trainseatpage.PembayaranButton));
		element.click();  
	}

	@Then("Payment page show")
	public void payment_page_show() {
		System.out.println("13");
	}

	@When("User select payment transfer bank bca")
	public void user_select_payment_transfer_bank_bca() {
		System.out.println("14");
	}

	@Then("Order Created")
	public void order_created() {
		System.out.println("15");
	}

}
