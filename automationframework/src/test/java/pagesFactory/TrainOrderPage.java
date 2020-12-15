package pagesFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Train Order page tiket.com
 */
public class TrainOrderPage extends Page {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  public TrainOrderPage(WebDriver webDriver) {
    super(webDriver);
  } 

  /**
   * Depart button on kereta api reservation form 
   */
  @FindBy(how = How.CSS, using = "part-depart") 
  @CacheLookup
  public WebElement DepartKeretaButton;
  
  /**
   * Return button on kereta api reservation form 
   */
  @FindBy(how = How.CSS, using = "part-return")
  @CacheLookup
  public WebElement ReturnKeretaButton;
  
  /**
   * Passenger button on kereta api reservation form 
   */
  @FindBy(how = How.CSS, using = "input-passengerclass")
  @CacheLookup
  public WebElement PassengerKeretaButton;
  
  /**
   * box passenger when click passenger button 
   */
  @FindBy(how = How.CSS, using = "passenger-action-box")
  @CacheLookup
  public WebElement PassengerBox;
  
  /**
   * Dewasa button plus for add dewasa passenger quantity
   */
  @FindBy(how = How.CSS, using = "div[class$='passenger-box'] > .passenger-list-box:nth-child(1)  > .right > .part >button > i.tix.tix-plus")
  @CacheLookup
  public WebElement  PlusDewasaButton;
  
  /**
   * Bayi button plus for add bayi passenger quantity
   */
  @FindBy(how = How.CSS, using = "div[class$='passenger-box'] > .passenger-list-box:nth-child(2)  > .right > .part >button > i.tix.tix-plus")
  @CacheLookup
  public WebElement  PlusBayiButton;
  
  /**
   * Selesai button to close passenger modal
   */
  @FindBy(how = How.CSS, using = ".passenger-action-box > .foot button")
  @CacheLookup
  public WebElement  SelesaiButton;
  
  /**
   * Cari Kereta button
   */
  @FindBy(how = How.CSS, using = ".footer-part button")
  @CacheLookup
  public WebElement  CariKeretaButton;
  
}
