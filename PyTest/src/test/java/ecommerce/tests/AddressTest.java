package ecommerce.tests;

import static org.testng.Assert.assertTrue;

import com.github.javafaker.Faker;
import ecommerce.pages.AddressPage;
import ecommerce.utils.Log;
import org.testng.annotations.Test;

public class AddressTest extends LoginTest{


  Faker faker = new Faker();
  @Test(dependsOnMethods = {"loginSuccess"})
  public void testAddress() {
    Log.info("Starting testAddress test");
    addressPage.gotoAddressPage();
    boolean registro= addressPage.registerFormAddress(faker.country().name(),faker.name().firstName(),faker.number().digits(10)
    ,"12",faker.address().streetAddress(),faker.address().streetAddress(),faker.address().city());
    assertTrue(registro, "Registration success: Your registration completed");
    Log.info("Address se registro correctamente");
  }


}
