package pagesFactory; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class TrainSearchResultPage extends Page {
  
	  public TrainSearchResultPage(WebDriver webDriver) {
	    super(webDriver);
	  }
	  
	  /**
	   * Title text kereta api search result page box 
	   */
	  @FindBy(how = How.CSS, using = "text-section-title")
	  @CacheLookup
	  public WebElement TitleSearchBox;
	  
	  
	  /**
	   * Checkbox filter for type executive
	   */
	  @FindBy(how = How.NAME, using = "Eksekutif")
	  @CacheLookup
	  public WebElement ExecutiveChecboxFilter;
	   
	  /**
	   * Pilih Button on searching result
	   */
	  @FindBy(how = How.CSS, using = ".search-result > .train-list .row:nth-child(2) .right button")
	  @CacheLookup
	  public WebElement PilihButton;
	  
	   
}
