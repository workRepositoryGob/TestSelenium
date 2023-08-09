package ecommerce.factory;

import static ecommerce.utils.Variable.*;

import ecommerce.utils.PropertiesLoader;
import ecommerce.utils.Variable;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

  static PageLoadStrategy strategy;
  public static WebDriver createDriver() {
    ChromeOptions options = new ChromeOptions();
    strategy = PageLoadStrategy.NORMAL;
    options.setPageLoadStrategy(strategy);
    PropertiesLoader properties= PropertiesLoader.getInstance();
    Properties prop=properties.getProperties();
    String browser = prop.getProperty("browser");

    WebDriver driver=null;
    if (browser.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver(options);
    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
      driver = new EdgeDriver();
    }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    return driver;
  }
}
