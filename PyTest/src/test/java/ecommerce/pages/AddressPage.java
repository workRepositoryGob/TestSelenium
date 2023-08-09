package ecommerce.pages;

import com.github.javafaker.Country;
import com.github.javafaker.Number;
import ecommerce.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BasePage {
  By account= By.id("navbarAccount") ;
  By orders= By.cssSelector("button[aria-label='Show Orders and Payment Menu']") ;
  By address=By.cssSelector("button[routerlink='/address/saved'][aria-label='Go to saved address page']");

  By buttonAddAddress=By.cssSelector("button.mat-raised-button");
  By country=By.cssSelector("input[placeholder='Please provide a country.']");
  By name=By.cssSelector("input[placeholder='Please provide a name.']");
  By mobile = By.cssSelector("input[placeholder='Please provide a mobile number.']");
  By code=By.cssSelector(".mat-input-element[placeholder='Please provide a ZIP code.']");
  By textAddress=By.id("address");
  By city=By.cssSelector(".mat-input-element[placeholder='Please provide a city.']");
  By state=By.cssSelector(".mat-input-element[placeholder='Please provide a state.']") ;
  By buttonSave=By.id("submitButton");
  public AddressPage(WebDriver driver) {
    super(driver);
  }

  public  void gotoAddressPage() {
    findElement(account).click();
    findElement(orders).click();
    findElement(address).click();
    findElement(buttonAddAddress).click();
  }

  public boolean registerFormAddress(String pais,String nombre, String numero, String codigo, String direccion, String ciudad, String estado){
    type(country, pais);
    type(name, nombre);
    type(mobile, numero);
    type(code, codigo);
    type(textAddress, direccion);
    type(city, ciudad);
    type(state, estado);
    isClickable(buttonSave);
    return isRegisterSuccess();
  }


  public boolean isRegisterSuccess() {
    By errorLocator = By.cssSelector("simple-snack-bar button.mat-button");;
    return isDisplayed(errorLocator);
  }

}
