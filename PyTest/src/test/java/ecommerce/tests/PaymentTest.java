package ecommerce.tests;

import static org.testng.Assert.assertTrue;

import com.github.javafaker.Faker;
import ecommerce.utils.Log;
import org.testng.annotations.Test;

public class PaymentTest extends LoginTest {

  Faker faker = new Faker();
  @Test(dependsOnMethods = {"loginSuccess"})
  public void addNewCard() {
    Log.info("Starting addNewCard test");
    paymentPage.goToPaymentPage();
    boolean result= paymentPage.addNewCard(faker.name().fullName(), faker.number().digits(16), "12", "2084");
    assertTrue(result, "Card added successfully");
    Log.info("Card added successfully");
  }

}
