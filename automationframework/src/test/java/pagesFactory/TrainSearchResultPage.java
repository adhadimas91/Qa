package pagesFactory; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class TrainSearchResultPage extends Page {
  
	  public TrainSearchResultPage(WebDriver webDriver) {
	    super(webDriver);
	  }
	  
	  /**
	   * Title text kereta api search result page box 
	   */
	  @FindBy(how = How.CSS, using = ".text-section-title") 
	  public WebElement TitleSearchBox;
	  
	  
	  /**
	   * Checkbox filter for type executive
	   */
	  @FindBy(how = How.CSS, using = "div.category > .filter-category:nth-child(1) >.ReactCollapse--collapse > .ReactCollapse--content > .custom-checkbox:nth-child(3)") 
	  public WebElement ExecutiveChecboxFilter;
	  
	  /**
	   * Checkbox filter for type ekonomi
	   */
	  @FindBy(how = How.CSS, using = "div.category > .filter-category:nth-child(1) >.ReactCollapse--collapse > .ReactCollapse--content > .custom-checkbox:nth-child(1)") 
	  public WebElement EkonomiChecboxFilter;
	  
	  /**
	   * Pilih Button on searching result
	   */
	  @FindBy(how = How.CSS, using = ".search-result > .train-list .row:nth-child(2) .right button") 
	  public WebElement PilihButton;
	  
	  /**
	   * Title Tipe Kereta on searching result
	   */
	  @FindBy(how = How.CSS, using = ".search-result > .train-list .row:nth-child(1) > .col-train-desc.col-4 >.text-train-class") 
	  public WebElement TitleTipeKereta;
	  
	  /**
	   * List on searching result
	   */
	  @FindBy(how = How.CSS, using = ".search-result") 
	  public List<WebElement> DivResult;
	  
	   
}
