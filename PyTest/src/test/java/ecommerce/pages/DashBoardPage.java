package ecommerce.pages;

import ecommerce.utils.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage extends BasePage {

  By text=By.xpath("//button[@routerlink='/basket']");
  By checkoutButton=By.id("checkoutButton");

  By selectAddress=By.cssSelector("button.mat-button.mat-primary");
  public DashBoardPage(WebDriver driver) {
    super(driver);
  }

  public boolean verifyLogin(){
    return isLoginSuccess();
  }
  public void gotoBasket(){
    click(text);
  }
  public void clickCheckout(){
    click(checkoutButton);
  }

  public boolean payOrder(){
    WebElement h1Element = findElement(By.cssSelector("h1.confirmation"));
    String text = h1Element.getText();
    return text.contains("Thank you for your purchase!");
  }

  public void selectAddress(String nombreDireccion){
    recorrerTabla(nombreDireccion,3);
  }
  public void selectDelivery(String expectedDelivery){
    recorrerTabla(expectedDelivery,3);

  }
  public void selectOptionPayment(String nombreTarjeta){

    recorrerTabla(nombreTarjeta,2);
    runTable();
  }
  public void recorrerTabla(String nameColumna,int valorColumna){
    WebElement table = findElement(By.className("mat-table")  );
    // Obtener todas las filas de la tabla
    List<WebElement> rows = table.findElements(By.tagName("mat-row"));
    // Iterar sobre las filas
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("mat-cell"));
      WebElement combo=cells.get(0);
      WebElement nameCell = cells.get(valorColumna);
      String nameText = nameCell.getText();
      if (nameText.contains(nameColumna)) {
        WebElement radioButton = combo.findElement(By.tagName("mat-radio-button"));
        radioButton.click();
        break;
      }
    }
  }
/*WIth stream*/
  public void runTable(){
    WebElement table = findElement(By.className("mat-table")  );
    table.findElements(By.tagName("mat-row")).stream()
        .map(webElement -> webElement.findElement(By.tagName("mat-cell")))
        .forEach(System.out::println);

  }

  public void clickSelectPayment(){
    WebElement continueButton = findElement(By.cssSelector("button[aria-label='Proceed to review']:not([disabled])"));
    continueButton.click();
  }

  public void clickSelectAddress(){
    WebElement continueButton = findElement(By.cssSelector("button[aria-label='Proceed to payment selection']:not([disabled])"));
    continueButton.click();
  }
  public void clickDelivery(){
    WebElement continueButton = findElement(By.cssSelector("button[aria-label='Proceed to delivery method selection']:not([disabled])"));
    continueButton.click();
  }

  public boolean isLoginSuccess() {
    By errorLocator = By.xpath("//button[@routerlink='/basket']");;
    return isDisplayed(errorLocator);
  }
  public void  clickPayOrder(){
    WebElement continueButton = findElement(By.id("checkoutButton"));
    continueButton.click();
  }

}
