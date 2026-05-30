package Tests;

import ItemsForUITests.BrowserSettings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static ItemsForUITests.BaskedItems.*;
import static ItemsForUITests.BaskedItems.getCountProductsInBasked;
import static ItemsForUITests.GeneralItems.*;
import static ItemsForUITests.ProductItems.*;
import static org.testng.Assert.assertEquals;

public class AddItemToBaskedTest extends BrowserSettings {

    @Test (description = "Тест добавления товара в корзину")
    public void testAddToBasked() {
        //---Переход на страницу товара
        getDriver().get(productUrl);
        getWait().until(ExpectedConditions.visibilityOf(productPage(productId)));

        //---Убедиться что отображается нужный товар
        getWait().until(ExpectedConditions.visibilityOf(productName(nameOfProduct)));

        //---Получить цену товара
        String price = getProductPriceForAddInBasked();

        //---Добавить товар в корзину и убедиться что добавилась 1 еденица товара
        WebElement addToBaskedButton = addToBaskedButton();
        clickByElement(addToBaskedButton);
        assertEquals(getProductCountForAddInBasked(), 1, "Ожидалась 1 еденица товара, найдено " + getProductCountForAddInBasked());

        //---Убедиться что кнопка исчезла и отображается кнопка "В корзине"
        getWait().until(ExpectedConditions.stalenessOf(addToBaskedButton));
        getWait().until(ExpectedConditions.visibilityOf(productIBaskedButton()));

        //---Перейти в корзину и проверить наличие там товара
        clickByElement(productIBaskedButton());
        getWait().until(ExpectedConditions.visibilityOf(baskedPage()));
        getWait().until(ExpectedConditions.visibilityOf(itemInBasked(nameOfProduct)));

        //---Убелдиться что цена товара не изменилась
        assertEquals(getProductPriceInBasked(), price, "Цена не соответствует цене до добавления в корзину, ожидалось - " + price + " получено - " + getProductPriceInBasked());

        //---Убедиться что в корзине 1 товар
        assertEquals(getCountProductsInBasked(), 1, "Ожидался 1 товар, найдено " + getCountProductsInBasked());

        //---Проверить количество едениц товара
        assertEquals(getProductCountInBasked(nameOfProduct), 1, "Ожидалась 1 еденица товара, найдено " + getProductCountInBasked(nameOfProduct));

        //---Убедиться что итоговая цена соответствует
        assertEquals(getTotalPriceInBasked(), price, "Итоговая цена не соответствует, ожидалось - " + price + " получено - " + getTotalPriceInBasked());
    }
}
