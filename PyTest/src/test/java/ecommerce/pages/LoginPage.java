package ecommerce.pages;

import ecommerce.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  By loginLink = By.linkText("Log in");
  //email
  By emailField = By.id("email");
  //password
  By passwordField = By.id("password");

  //login button
  By loginButton = By.id("loginButton");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void fillOutLogin(String username, String password) {
    type(emailField, username);
    type(passwordField, password);
    isClickable(loginButton);

    //return isLoginSuccess();
  }

  public boolean isLoginFailed() {
    By errorLocator = By.cssSelector("div.message-error.validation-summary-errors");
    return isDisplayed(errorLocator);
  }

  public boolean isLoginSuccess() {
      By errorLocator = By.xpath("//button[@routerlink='/basket']");;
      return isDisplayed(errorLocator);
    }

}
