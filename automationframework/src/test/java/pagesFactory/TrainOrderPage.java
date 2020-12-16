package pagesFactory;

import java.util.List;

import javax.annotation.Nullable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Train Order page tiket.com
 */
public class TrainOrderPage extends Page {
  
  public TrainOrderPage(WebDriver webDriver) {
    super(webDriver);
  }  
  
  /**
   * OK button on pop up 
   */
  @FindBy(how = How.XPATH, using = "//button[text()='OK']")  
  public WebElement OkButton; 
  
  /**
   * Depart button on kereta api reservation form 
   */
  @FindBy(how = How.XPATH, using = "//div[@class='part-component part-depart']//input[@class='input-airport ']") 
  public WebElement DepartKeretaInput;
  
  /**
   * Depart city list
   */
  @FindBy(how = How.XPATH, using = "//div[@class='part-component part-depart']//ul/li") 
  public WebElement DepartCity;

  
  /**
   * destination button on kereta api reservation form 
   */
  @FindBy(how = How.XPATH, using = "//div[@class='part-component part-return']//input[@class='input-airport ']") 
  public WebElement DestinationKeretaInput;
  
  /**
   * Dest city list
   */
  @FindBy(how = How.XPATH, using = "//div[@class='part-component part-return']//ul/li") 
  public WebElement DestCity;
  
  /**
   * date go button on kereta api reservation form 
   */
  @FindBy(how = How.XPATH, using = "//div[@class='part-component part-from-date']//input[@class='input-datepicker ']") 
  public WebElement DateGoKeretaInput;
   
  
  /**
   * title pilihan tanggal
   */
  @FindBy(how = How.CSS, using = ".widget-datepicker-title.widget-date-picker-container") 
  public WebElement TitlePilihanTgl;
  
  /**
   * date number go
   */
  @FindBy(how = How.XPATH, using = "//div[@class='widget-date-picker-day'][text()='28']") 
  public WebElement DateNumber;
  
  /**
   * penumpang button on kereta api reservation form 
   */
  @FindBy(how = How.XPATH, using = "//div[@class='part-component part-passenger']//input[@class='input-passengerclass']") 
  public WebElement PenumpangKeretaInput;
  
  /**
   * Dewasa button plus for add dewasa passenger quantity
   */
  @FindBy(how = How.CSS, using = "div[class$='passenger-box'] > .passenger-list-box:nth-child(1)  > .right > .part >button > i.tix.tix-plus")
  public WebElement  PlusDewasaButton;
  
  /**
   * Bayi button plus for add bayi passenger quantity
   */
  @FindBy(how = How.CSS, using = "div[class$='passenger-box'] > .passenger-list-box:nth-child(2)  > .right > .part >button > i.tix.tix-plus")
  public WebElement  PlusBayiButton;
  
  /**
   * Selesai button to close passenger modal
   */
  @FindBy(how = How.CSS, using = ".passenger-action-box > .foot button") 
  public WebElement  SelesaiButton;
  
  /**
   * Cari Kereta button
   */
  @FindBy(how = How.CSS, using = ".footer-part button") 
  public WebElement  CariKeretaButton;
  
}
