package ecommerce.tests;

import static ecommerce.utils.Variable.EXPECTED_DELIVERY;
import static ecommerce.utils.Variable.NOMBRE_DIRECCION;
import static ecommerce.utils.Variable.NOMBRE_TARGETA;
import static org.testng.Assert.assertTrue;

import ecommerce.utils.Log;
import org.testng.annotations.Test;

public class DashBoardTest extends LoginTest{


  @Test(dependsOnMethods = {"loginSuccess"})
  public void verifyLogin() throws InterruptedException {
    System.out.println("Realizando el pago");
    dashBoardPage.gotoBasket();
    Thread.sleep(2000);
    dashBoardPage.clickCheckout();
    Thread.sleep(2000);
    dashBoardPage.selectAddress(NOMBRE_DIRECCION);
    Thread.sleep(2000);
    dashBoardPage.clickSelectAddress();
    dashBoardPage.selectDelivery(EXPECTED_DELIVERY);
    dashBoardPage.clickDelivery();
    dashBoardPage.selectOptionPayment(NOMBRE_TARGETA);
    dashBoardPage.clickSelectPayment();
    dashBoardPage.clickPayOrder();
    Thread.sleep(2000);
    boolean result= dashBoardPage.payOrder();
    assertTrue(result, "Order paid successfully");
    Log.info("Order paid successfully");
  }


}
