package ecommerce.pages;

import ecommerce.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

  By account= By.id("navbarAccount") ;
  By orders= By.cssSelector("button[aria-label='Show Orders and Payment Menu']") ;
  By card=  By.cssSelector("button[routerlink='/saved-payment-methods']");
  By newCard=By.id("mat-expansion-panel-header-0");

  By nameCard=By.cssSelector("input#mat-input-1");
  By numberCard=By.cssSelector("input#mat-input-2");
  By expirationMonth=By.cssSelector("select#mat-input-3");

  By expirationYear=By.cssSelector("select#mat-input-4");

  By saveCard=By.id("submitButton");


  public PaymentPage(WebDriver driver) {
    super(driver);
  }

  public void goToPaymentPage() {
    findElement(account).click();
    findElement(orders).click();
    findElement(card).click();
    findElement(newCard).click();
  }

  public boolean addNewCard(String name,String number,String month,String year){
    type(nameCard, name);
    type(numberCard, number);
    type(expirationMonth, month);
    type(expirationYear, year);
    findElement(saveCard).click();
    return isAddCardSuccess();
  }

public boolean isAddCardSuccess() {
    By validLocator = By.cssSelector("snack-bar-container.mat-snack-bar-container");
    return isDisplayed(validLocator);
  }
}
