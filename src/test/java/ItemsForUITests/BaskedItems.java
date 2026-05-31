package ItemsForUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

import static ItemsForUITests.BrowserSettings.getDriver;
import static ItemsForUITests.BrowserSettings.getWait;
import static org.testng.Assert.assertEquals;

public class BaskedItems {

    public static WebElement baskedPage() {
        return getWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@class='basket-page__main']")));
    }

    public static WebElement productName(String name) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//h2[text()='" + name + "']")));
    }

    public static WebElement itemInBasked(String itemName) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//span[@class='good-info__good-name' and text()='" + itemName + "']")));
    }

    public static int getCountProductsInBasked() {
        return getDriver().findElements(By.xpath("//div[@class = 'accordion__list']//div[@class = 'list-item__good']")).size();
    }

    public static int getProductCountInBasked(String productName) {
        WebElement count = getWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//span[text()='"+ productName +"']/ancestor::div[@class='list-item__wrap']//div[@class='count__wrap']//input")));
        return Integer.parseInt(count.getAttribute("value"));
    }

    public static String getProductPriceInBasked() throws InterruptedException {
        String price = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'list-item__price']//div[contains(@class, 'new')]"))
        ).getText();
        String newPrice = "";

        for (int i=0; i<10; i++) {
            newPrice = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'list-item__price']//div[contains(@class, 'new')]"))
            ).getText();
            if (!Objects.equals(price, newPrice)) {
                price=newPrice;
                Thread.sleep(50);
            }
            else {
                break;
            }
        }
        assertEquals(price, newPrice, "Анимация цены товара не прогрузилась за 500 мс");
        return newPrice;
    }

    public static String getTotalPriceInBasked() throws InterruptedException {
        String price = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //p[@class= 'b-top__total line']//span//span"))
        ).getText();
        String newPrice = "";

        for (int i=0; i<10; i++) {
            newPrice = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //p[@class= 'b-top__total line']//span//span"))
            ).getText();
            if (!Objects.equals(price, newPrice)) {
                price=newPrice;
                Thread.sleep(50);
            }
            else {
                break;
            }
        }
        assertEquals(price, newPrice, "Анимация итоговой цены не прогрузилась за 500 мс");
        return newPrice;
    }
}
