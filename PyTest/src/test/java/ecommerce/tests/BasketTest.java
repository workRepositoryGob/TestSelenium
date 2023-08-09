package ecommerce.tests;

import static org.testng.Assert.assertTrue;

import ecommerce.utils.Log;
import org.testng.annotations.Test;

public class BasketTest extends LoginTest{

  @Test(dependsOnMethods = {"loginSuccess"})
  public void addProductToBasket() throws InterruptedException {
    Log.info("Starting addProductToBasket test");
    boolean result= basketPage.addProductsToBasket();
    assertTrue(result, "Products added successfully");
    Log.info("Product added successfully");
  }

}
