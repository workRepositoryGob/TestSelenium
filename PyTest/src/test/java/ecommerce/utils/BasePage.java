package ecommerce.utils;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  WebDriver driver;
   WebDriverWait wait;
  int timeOutSec = 10;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSec));
  }

  public void setTimeOutSec(int timeOutSec) {
    this.timeOutSec = timeOutSec;
  }

  public void visit(String url) {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutSec));
    driver.get(url);
  }

  public WebElement findElement(By element) {
    return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    //return driver.findElement(element);
  }
  public List<WebElement> findElementList(By element) {
    return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
  }
  public void click(By element) {
    findElement(element).click();
  }

  public void type(By element, String text) {
    findElement(element).sendKeys(text);

  }

  public boolean isDisplayed(By element) {
    try {
      //esperar hasta que el elemento sea visible
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Ajusta el tiempo máximo de espera según sea necesario
      wait.until(ExpectedConditions.visibilityOfElementLocated(element));
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  public boolean isClickable(By element){
    try {
      WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
      clickableElement.click();
      return true;
    }catch (Exception e){
      System.out.println("No se puede hacer click");
      return false;
    }
  }
  public void isPresent(By element){
    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }catch (Exception e){
      System.out.println("No se encuentra el elemento");
    }
  }
  public void selectRadioButton(By locator) {
    WebElement radioButton = findElement(locator);
    radioButton.click();
  }

  public void selectDropdown(By locator, String option) {
    WebElement dropdown = findElement(locator);
    Select dropdownSelect = new Select(dropdown);
    dropdownSelect.selectByVisibleText(option);
  }

}
