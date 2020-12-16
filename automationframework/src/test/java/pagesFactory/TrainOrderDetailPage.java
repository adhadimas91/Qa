package pagesFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class TrainOrderDetailPage extends Page {
	  
	  public TrainOrderDetailPage(WebDriver webDriver) {
	    super(webDriver);
	  }  
	   
	  /**
	   * Title pemesanan detail
	   */
	  @FindBy(how = How.CSS, using = "div#contact-form > .content-with-title-template:nth-child(1) > .template-title > p")
	  public WebElement  TitlePemesananBox;
	  
	  /**
	   * nama form 
	   */
	  @FindBy(how = How.XPATH, using = "//input[@name='fullName']") 
	  public List<WebElement> InputNama;
	  
	  /**
	   * phone form 
	   */
	  @FindBy(how = How.XPATH, using = "//input[@name='phone']") 
	  public WebElement InputPhone;
	  
	  /**
	   * email form 
	   */
	  @FindBy(how = How.XPATH, using = "//input[@name='emailAddress']") 
	  public WebElement InputEmail;
	 
	  /**
	   * nama form 
	   */
	  @FindBy(how = How.XPATH, using = "//input[@name='identityNumber']") 
	  public List<WebElement> InputIdentityNumber;
	  
	  /**
	   * date form 
	   */
	  @FindBy(how = How.XPATH, using = "//input[@class='input-date']") 
	  public List<WebElement> InputDate;
	  
	  /**
	   * month form 
	   */
	  @FindBy(how = How.XPATH, using = "//input[@class='input-month']") 
	  public List<WebElement> InputMonth;
	   
	  /**
	   * year form 
	   */
	  @FindBy(how = How.XPATH, using = "//input[@class='input-year']") 
	  public List<WebElement> InputYear;
	   
	  /**
	   * Date number button
	   */
	  @FindBy(how = How.CSS, using = "div.autocomplete-list.autocomplete-date.alert-enter-done > .option-list:nth-child(2)")
	  public WebElement  DateButton;
	  
	  /**
	   * Month button
	   */
	  @FindBy(how = How.CSS, using = "div.autocomplete-list.autocomplete-month.alert-enter-done > .option-list:nth-child(2)")
	  public WebElement  MonthButton;
	  
	  
	  /**
	   * year button
	   */
	  @FindBy(how = How.CSS, using = "div.autocomplete-list.autocomplete-year.alert-enter-done > .option-list:nth-child(4)")
	  public WebElement  YearButton;
	  
	  /**
	   * Seat button
	   */
	  @FindBy(how = How.CSS, using = ".btn-choose-seat")
	  public WebElement  SeatButton;
	  
}

 
