package selenium.phptravels.pages;

import java.util.Locale;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
  private WebDriverWait wait;
  @FindBy(xpath = "//h2[contains(text(), 'Hi,')]")
  private WebElement txt_hiUser;
  public DashboardPage(WebDriver driver, WebDriverWait wait){
    this.wait = wait;
    PageFactory.initElements(driver, this);
  }

  public boolean verifyLoginSuccess(String username){
    wait.until(ExpectedConditions.visibilityOf(txt_hiUser));
    System.out.println(txt_hiUser.getText());
    return txt_hiUser.getText().equals("Hi, " + username.substring(0, 1).toUpperCase(Locale.ROOT) + username.substring(1) + " Welcome Back");
  }
}
