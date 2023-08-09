package ecommerce.pages;

import static ecommerce.utils.Variable.URL;

import ecommerce.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

  By registerLink = By.id("navbarAccount");
  By popUp = By.cssSelector("div.cc-compliance");
  By btnDismiss= By.cssSelector("button.mat-raised-button");
  By btnLogin=    By.cssSelector("button[aria-label='Go to login page'] span");
  By linkRegister=By.linkText("Not yet a customer?");

  By popUpLink=By.linkText("Me want it!");
  public HomePage(WebDriver driver) {
    super(driver);
    visit(URL);
  }

  public void goToHomePage() {
    if (isDisplayPopUp()){
      findElement(btnDismiss).click();
      findElement(popUpLink).click();
      findElement(registerLink).click();
      findElement(btnLogin).click();
      //findElement(linkRegister).click();
    }
  }
  public boolean isDisplayPopUp() {
    return isDisplayed(popUp);
  }

}
