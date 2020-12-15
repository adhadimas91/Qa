package pagesFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Home page tiket.com
 */
public class HomePage extends Page {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }
  
  /**
   * Login button 
   */
  @FindBy(how = How.LINK_TEXT, using = "Login")
  @CacheLookup
  public WebElement LoginButton;
  
  /**
   * Tiket Kereta api button on top menu navigation 
   */
  @FindBy(how = How.LINK_TEXT, using = "Tiket Kereta Api")
  @CacheLookup
  public WebElement MenuKeretaApiButton;
 
}
