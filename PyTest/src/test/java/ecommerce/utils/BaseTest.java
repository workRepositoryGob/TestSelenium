package ecommerce.utils;

import static ecommerce.utils.Variable.fechaCreacion;
import static org.openqa.selenium.OutputType.FILE;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import ecommerce.factory.DriverFactory;
import ecommerce.pages.AddressPage;
import ecommerce.pages.BasketPage;
import ecommerce.pages.DashBoardPage;
import ecommerce.pages.HomePage;
import ecommerce.pages.LoginPage;
import ecommerce.pages.PaymentPage;
import ecommerce.pages.RegisterPage;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

  protected WebDriver driver;
  protected HomePage homePage;
  protected RegisterPage registerPage;
  protected AddressPage addressPage;
  ExtentSparkReporter sparkReporter;
  public ExtentReports extent;
  public ExtentTest test;

  protected LoginPage loginPage;
  protected DashBoardPage dashBoardPage;
  protected PaymentPage paymentPage;
  protected BasketPage basketPage;

  @BeforeTest
  public void startReport() {
    Log.info("Starting Extent Report");
    sparkReporter = new ExtentSparkReporter(
        System.getProperty("user.dir") + "/extentReport/" + fechaCreacion() + ".html");
    extent = new ExtentReports();
    extent.attachReporter(sparkReporter);

    //config user, devices and enviroment
    extent.setSystemInfo("User Name", "Juan");
    extent.setSystemInfo("Device", "Windows 10");
    extent.setSystemInfo("Enviroment", "QA");

    sparkReporter.config().setDocumentTitle("Ecommerce Report");
    sparkReporter.config().setReportName("Ecommerce Functional Testing");
    sparkReporter.config().setTheme(Theme.DARK);
  }


  @BeforeClass
  public void setUp() {
    Log.info("Load Driver before test");
    driver = DriverFactory.createDriver();

  }

  @BeforeMethod
  public void methodLevelSetup(){
    homePage = new HomePage(driver);
    registerPage = new RegisterPage(driver);
    addressPage = new AddressPage(driver);
    loginPage = new LoginPage(driver);
    dashBoardPage = new DashBoardPage(driver);
    paymentPage = new PaymentPage(driver);
    basketPage = new BasketPage(driver);
  }

  @AfterClass
  public void tearDown()  {

    /*int idStatus= result.getStatus();
    switch (idStatus) {
      case FAILURE:
        test.log(FAIL, createLabel(result.getTestName() + " - TEST CASE FAIL", RED));
        test.log(FAIL, createLabel(result.getThrowable().toString() + " - TEST CASE FAIL", RED));
        String screenshotPath = "." + captureScreenshot(result.getName(), "failure");
        test.fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        break;

      case SUCCESS:
        test.log(PASS, createLabel(result.getTestName() + " - TEST CASE PASS", GREEN));
        test.log(PASS, createLabel("Test passed", GREEN));
        captureScreenshot(result.getName(), "success");
        break;

      case ITestResult.SKIP:
        test.log(SKIP, createLabel(result.getTestName() + " - TEST CASE SKIP", ORANGE));
        test.log(SKIP, createLabel("Test Skipped", ORANGE));
        break;}*/
    captureScreenshot("test", "success");

    driver.quit();
  }

  @AfterTest
  public void makeReport() {
    Log.info("Closing Extent Report");
    extent.flush();
  }

  public String captureScreenshot(String testName, String carpeta) {
    try {
      Log.info("Taking Screenshot");
      File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(FILE);
      String timestamp = fechaCreacion();
      String screenshotDirectory = "./screenshots/" + carpeta + "/";
      String screenshotPath = screenshotDirectory + testName + "_" + timestamp + ".png";
      //FileHandler.copy(screenshotFile, new File(screenshotPath));
      File finalDestination = new File(screenshotPath);
      FileUtils.copyFile(screenshotFile, finalDestination);

      System.out.println("Screenshot captured: " + screenshotPath);
      return screenshotPath;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
