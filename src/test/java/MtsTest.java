import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {
    @Test
    void mtsPayTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement cookieId = driver.findElement(By.id("cookie-agree"));
        if (cookieId.isDisplayed()) {
            cookieId.click();
        }
        String payHeaderExpected = "ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ";
        String payHeaderActual = driver.findElement(By.cssSelector(".pay__wrapper h2")).getText();
        Assertions.assertEquals(payHeaderExpected, payHeaderActual);

        WebElement partners = driver.findElement(By.cssSelector(".pay__partners"));

        List<String> actualLogos = partners.findElements(By.tagName("img"))
                .stream()
                .map(img -> img.getAttribute("alt"))
                .collect(Collectors.toList());

        List<String> expectedLogos = List.of(
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        );

        assertTrue(actualLogos.containsAll(expectedLogos));

        WebElement detailsLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        detailsLink.click();
        assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        driver.navigate().back();

        Assertions.assertEquals("Услуги связи", driver.findElement(By.className("select__now")).getText());
        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        phoneField.click();
        phoneField.sendKeys("297777777");
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        sumField.click();
        sumField.sendKeys("1");
        WebElement payButton = driver.findElement(By.cssSelector("#pay-connection button[type='submit']"));
        payButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement paymentWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-widget-iframe")));
        Assertions.assertTrue(paymentWidget.isDisplayed());

        driver.quit();
    }
}
