package selenium.phptravels.testcases;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.phptravels.common.SetupDriver;
import selenium.phptravels.pages.HomePage;
import selenium.phptravels.pages.LoginPage;

public class Login extends SetupDriver {
  private LoginPage loginPage;
  @Test
  public void loginSuccess(){
    loginPage = new LoginPage(driver);
    loginPage.login("gioi@phptravels.com", "demouser");
  }
}
