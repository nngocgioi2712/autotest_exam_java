package selenium.phptravels.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Locale;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetupDriver {
  protected WebDriver driver;
  protected WebDriverWait wait;
  public void setDriver(String browser) {
    switch (browser.toLowerCase(Locale.ROOT)) {
      case "chrome":
        driver = initChromeDriver();
        break;
      case "firefox":
        driver = initFireFoxDriver();
        break;
      default:
        System.out.println("Browser " + browser + "is invalid. Launching Chrome ...");
        driver = initChromeDriver();
    }
    driver.manage().window().maximize();
    driver.get("https://www.phptravels.net/login");
  }

  public WebDriver getDriver() {
    return driver;
  }

  public WebDriver initChromeDriver() {
    //WebDriverManager.chromedriver().setup();
    System.setProperty("webdriver.chrome.driver", "C:\\tools\\Katalon_Studio_Windows_64-8.5.2\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
    return new ChromeDriver();
  }

  public WebDriver initFireFoxDriver() {
    //WebDriverManager.firefoxdriver().setup();
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver.exe");
    return new FirefoxDriver();
  }

  //@BeforeMethod
  public void setUp() {
    setDriver("chrome");
    wait = new WebDriverWait(driver, 10);
  }
  public void setUp(String driverName) {
    setDriver(driverName);
    wait = new WebDriverWait(driver, 10);
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
