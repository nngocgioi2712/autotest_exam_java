package selenium.phptravels.testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium.phptravels.common.SetupDriver;
import selenium.phptravels.pages.DashboardPage;
import selenium.phptravels.pages.LoginPage;

public class Login extends SetupDriver {
  private LoginPage loginPage;
  private DashboardPage dashboardPage;
  @Test
  @Parameters({"email", "password", "username"})
  public void loginSuccess(String email, String password, String username){
    loginPage = new LoginPage(driver, wait);
    loginPage.login(email, password);
    dashboardPage = new DashboardPage(driver, wait);
    Assert.assertTrue(dashboardPage.verifyLoginSuccess(username));
  }
  @Test
  public void verifyPlaceholder(){
    loginPage = new LoginPage(driver, wait);
    Assert.assertTrue(loginPage.verifyPlaceHolderEmail("Email"));
    Assert.assertTrue(loginPage.verifyPlaceHolderPassword("Password"));
    loginPage.clickRemember();
    Assert.assertTrue(loginPage.verifyRememberChecked());
  }
}
