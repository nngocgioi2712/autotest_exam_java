package selenium.phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  private WebDriver driver;
  @FindBy(xpath = "//input[@name = 'email']")
  private WebElement input_email;
  @FindBy(xpath = "//input[@name = 'password']")
  private WebElement input_password;
  @FindBy(xpath = "//button//span[text() = 'Login']")
  private WebElement btn_login;

  public LoginPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
  public void login(String email, String password){
    input_email.sendKeys(email);
    input_password.sendKeys(password);
    btn_login.click();
  }
}
