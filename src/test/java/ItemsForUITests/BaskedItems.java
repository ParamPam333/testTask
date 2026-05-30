package ItemsForUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ItemsForUITests.BrowserSettings.getWait;

public class BaskedItems {

    public static WebElement baskedPage() {
        return  getWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@class='basket-page__main']")));
    }

    public static WebElement itemInBasked(String itemName) {
        return  getWait().until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//span[@class='good-info__good-name' and text()='" + itemName + "']")));
    }
}
