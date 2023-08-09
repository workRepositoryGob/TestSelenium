package ecommerce.tests;

import static ecommerce.utils.Variable.EMAIL;
import static ecommerce.utils.Variable.PASS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.opencsv.CSVReader;
import ecommerce.listeners.CustomerListener;
import ecommerce.pages.LoginPage;
import ecommerce.utils.BaseTest;
import ecommerce.utils.Log;
import ecommerce.utils.Variable;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomerListener.class)
public class LoginTest extends BaseTest {

  @Test//(dataProvider = "dataLogin")
  public void loginSuccess(/*String user, String password*/) {
    Log.info("Starting getLogin test");
    test = extent.createTest("getLogin", "test verifies the login");
    test.assignAuthor("Willian");
    test.assignCategory("Regression Testing");
    test.assignDevice("Windows 10 - Chrome");

    Log.info("Iniciando el test");
    System.out.println("Logeandose con: " + EMAIL + " ");
    homePage.goToHomePage();
    loginPage.fillOutLogin(EMAIL, PASS);
    assertTrue(dashBoardPage.verifyLogin(), "Login success: The credentials provided are correct");
    System.out.println("Login exitoso");
    Log.info("Login exitoso");
  }




  @DataProvider(name = "loginDataCsv")
  public Object[][] readCSVData() {
    String csvPath = getClass().getClassLoader().getResource("login.csv").getFile();
    List<Object[]> dataList = new ArrayList<>();

    try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
      String[] line;
      while ((line = reader.readNext()) != null) {
        Object[] record = { line[0]};
        dataList.add(record);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return dataList.toArray(new Object[dataList.size()][]);
  }

}
