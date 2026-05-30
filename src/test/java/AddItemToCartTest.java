import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddItemToCartTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void openBrowser() {
        // Создаем драйвер
        driver = new ChromeDriver();

        // Максимизируем окно
        driver.manage().window().maximize();

        // Создаем явное ожидание (10 секунд)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Открываем страницу логина
        driver.get("https://www.wildberries.by/catalog/264220770/detail.aspx");
    }

    @Test
    public void testAddToCart() {
        String id = "264220770";
        String itemName = "Щелкунчик по балету Чайковского. Книги для детей";

        By itemsPage = By.xpath("//div[@data-testid='"+ id +"']");
        By addToCartButton = By.xpath("//button[@aria-label='Добавить в корзину']");
        By itemInCartButton = By.xpath("//div[contains(@class, 'actionsBlockMain')]//button[@aria-label='В корзине']");
        By baskedPage = By.xpath("//div[@class='basket-page__main']");
        By itemInCart = By.xpath("//span[@class='good-info__good-name' and text()='"+itemName+"']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(itemsPage));
        driver.findElement(addToCartButton).click();

        driver.findElement(itemInCartButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(baskedPage));

        wait.until(ExpectedConditions.visibilityOfElementLocated(itemInCart));
    }

    @AfterMethod
    public void closeBrowser() {
        // Закрываем браузер после каждого теста
        if (driver != null) {
            driver.quit();
        }
    }
}
