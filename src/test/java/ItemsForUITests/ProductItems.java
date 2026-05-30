package ItemsForUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ItemsForUITests.BrowserSettings.getWait;

public class ProductItems {

    public static WebElement productPage(String id) {
        return  getWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@data-testid='" + id + "']")));
    }

    public static WebElement addToBaskedButton() {
        return  getWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[@aria-label='Добавить в корзину']")));
    }

    public static WebElement productIBaskedButton() {
        return  getWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[contains(@class, 'actionsBlockMain')]//button[@aria-label='В корзине']")));
    }

    public static int getProductCountForAddInBasked() {
        return Integer.parseInt(getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'counter--EUS0T']//span"))
        ).getText());
    }

    public static String getProductPriceForAddInBasked() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'priceBlockPrice')]//ins"))
        ).getText();
    }
}
