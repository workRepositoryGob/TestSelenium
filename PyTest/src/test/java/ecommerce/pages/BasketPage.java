package ecommerce.pages;

import static java.lang.Thread.sleep;

import ecommerce.utils.BasePage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends BasePage {


  By itemsBasket = By.className("mat-grid-tile-content");

  public BasketPage(WebDriver driver) {
    super(driver);
  }



  public boolean addProductsToBasket() throws InterruptedException {
    Map<String, Integer> productCounts = new HashMap<>();
    productCounts.put("Apple Juice (1000ml)", 2);
    productCounts.put("Apple Pomace", 1);

    List<WebElement> cards = findElementList(By.tagName("mat-card"));


    for (WebElement card : cards) {
      String productName = card.findElement(By.className("item-name")).getText();

      if (!productCounts.containsKey(productName)) {
        continue;
      }
      int count = productCounts.get(productName);
      for (int i = 0; i < count; i++) {
        card.findElement(By.xpath(".//button[@aria-label='Add to Basket']")).click();
        sleep(2000);
        boolean isConfirmationVisible = findElement(
            By.className("mat-snack-bar-container")).getText().contains(productName);
        if (!isConfirmationVisible) {
          return false;
        }
      }

    }
    return true;
  }


}
