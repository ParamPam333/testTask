package ItemsForUITests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GeneralItems extends BrowserSettings{
    public static String productUrl = "https://www.wildberries.by/catalog/264220770/detail.aspx";
    public static String productId = "264220770";
    public static String nameOfProduct = "Щелкунчик по балету Чайковского. Книги для детей";

    public static String getProductUrl (String id) {
        return "https://www.wildberries.by/catalog/"+ id +"/detail.aspx";
    }

    public static void clickByElement (WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
