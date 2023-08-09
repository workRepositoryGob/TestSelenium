package ecommerce.pages;

import static ecommerce.utils.Variable.EMAIL;

import ecommerce.utils.BasePage;
import ecommerce.utils.Variable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage extends BasePage {

  By linkRegister=By.linkText("Not yet a customer?");
  By email = By.id("emailControl");
  By pass = By.id("passwordControl");
  By conPass = By.id("repeatPasswordControl");
  By btnRegister =By.cssSelector("button[aria-label='Button to complete the registration']")
      ;
  By option=By.xpath("//mat-option[contains(., 'Maternal grandmother')]") ;
  By comboBoxSelected= By.cssSelector("mat-select[name='securityQuestion']");
  By anwerInput=By.id("securityAnswerControl");
  By popUpFailer=By.xpath("//div[contains(text(), '×')]");
  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  public boolean fillOutRegisterAdvance() {
    //combox

    type(email, EMAIL);
    type(pass, EMAIL);
    type(conPass, EMAIL);
    click(btnRegister);

    return !isRegisterSuccess();
  }


  public void goToRegisterPage() {
    findElement(linkRegister).click();
  }
  public boolean registerWithParams(String firstName, String xemail, String xpass, String xxpass)
      throws InterruptedException {
    if (isPopUp()) {
      findElement(popUpFailer).click();
    }
    type(email,xemail);
    type(pass,xpass);
    type(conPass,xxpass);
    findElement(comboBoxSelected).click();
    findElement(option).click();
    type(anwerInput,firstName);
    Thread.sleep(2000);
   return isClickable(btnRegister)&&isDisplayed(btnRegister);

  }
  public boolean isRegisterSuccess() {
      By validLocator = By.cssSelector("span.mat-simple-snack-bar-content");
      return isDisplayed(validLocator);
  }

  public boolean isPopUp() {
    By validLocator = By.id("hacking-instructor");
    return isDisplayed(validLocator);
  }


}
