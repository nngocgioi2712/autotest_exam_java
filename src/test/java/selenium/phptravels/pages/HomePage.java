package selenium.phptravels.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
  private WebDriver driver;

  @FindBy(xpath = "//img[@alt = 'logo']")
  private List<WebElement> logo;

  public HomePage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
  public boolean verifyHomepagePresent(){
    return logo.size()>0;
  }
}
