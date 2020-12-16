package pagesFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TrainSeatPage  extends Page {
	  
	  public TrainSeatPage(WebDriver webDriver) {
	    super(webDriver);
	  }  
	  
	  /**
	   * OK button on pop up 
	   */
	  @FindBy(how = How.CSS, using = ".action-area button")  
	  public WebElement PembayaranButton; 

}
