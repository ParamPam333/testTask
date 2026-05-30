package Tests;

import ItemsForUITests.BrowserSettings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static ItemsForUITests.BaskedItems.baskedPage;
import static ItemsForUITests.BaskedItems.itemInBasked;
import static ItemsForUITests.GeneralItems.*;
import static ItemsForUITests.ProductItems.*;

public class AddItemToCartTest extends BrowserSettings {

    @Test
    public void testAddToCart() {
        //---Переход на страницу товара
        getDriver().get(productUrl);
        getWait().until(ExpectedConditions.visibilityOf(itemsPage(productId)));

        //---Добавить товар в корзину и убедиться что кнопка "Добавить" пропала
        WebElement addToBaskedButton = addToBaskedButton();
        clickByElement(addToBaskedButton());
        getWait().until(ExpectedConditions.stalenessOf(addToBaskedButton));

        //---Перейти в карзину и проверить наличия там элемента
        clickByElement(itemIBaskedButton());
        getWait().until(ExpectedConditions.visibilityOf(baskedPage()));

        getWait().until(ExpectedConditions.visibilityOf(itemInBasked(productName)));
    }
}
