package selenium.phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
  private WebDriverWait wait;
  @FindBy(xpath = "//input[@name = 'email']")
  private WebElement input_email;
  @FindBy(xpath = "//input[@name = 'password']")
  private WebElement input_password;
  @FindBy(xpath = "//button//span[text() = 'Login']")
  private WebElement btn_login;
  @FindBy(xpath = "//label[@for = 'rememberchb']")
  private WebElement chb_remember;
  @FindBy(xpath = "//input[@id = 'rememberchb']")
  private WebElement in_chb_remember;
  public LoginPage(WebDriver driver, WebDriverWait wait){
    this.wait = wait;
    PageFactory.initElements(driver, this);
  }
  public void login(String email, String password) {
    input_email.sendKeys(email);
    input_password.sendKeys(password);
    btn_login.click();
  }
  public boolean verifyPlaceHolderEmail(String p_email){
    return input_email.getAttribute("placeholder").equals(p_email);
  }
  public boolean verifyPlaceHolderPassword(String p_password){
    return  input_password.getAttribute("placeholder").equals(p_password);
  }
  public void clickRemember(){
    wait.until(ExpectedConditions.elementToBeClickable(chb_remember));
    chb_remember.click();
  }
  public boolean verifyRememberChecked(){
    return in_chb_remember.isSelected();
  }
}
