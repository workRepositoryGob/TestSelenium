package ecommerce.tests;

import com.github.javafaker.Faker;
import ecommerce.listeners.CustomerListener;
import ecommerce.pages.LoginPage;
import ecommerce.utils.BaseTest;
import ecommerce.utils.Log;
import java.util.Locale;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomerListener.class)
public class RegisterTest extends BaseTest {
  Faker faker = new Faker(new Locale("en-US"));

  @Test
  public void registerWithParams() throws InterruptedException {

    Log.info("Starting register test with params");
    test = extent.createTest("getRegister With Params", "test verifies the register with params");
    test.assignAuthor("Willian");
    test.assignCategory("Regression Testing");
    test.assignDevice("Windows 10 - Chrome");

    String email = faker.internet().emailAddress();
    String password = faker.internet().password();

    homePage.goToHomePage();
    registerPage.goToRegisterPage();
    boolean registrationResult = registerPage.registerWithParams(faker.name().firstName(),email,password,password);
    Assert.assertTrue(registrationResult, "Registration success: Your registration completed");
    System.out.println("email: " + email + " password: " + password);
    Log.info("Se registro correctamente");
  }

  @DataProvider
  public Object[][] dataLogin() {
    return new Object[][] {
        new Object[] { "Admin", "admin123" },
        // new Object[] { "Admin2", "admin123" },
        // new Object[] { "Admin3", "admin123" },

    };
  }

}
