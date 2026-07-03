package tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MtsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    @Test
    void mtsPayTest() {
        WebDriver driver = new ChromeDriver();
        MtsPage page = new MtsPage(driver);
        String phoneNumber = "297777777";
        String sum = "11.1";
        Allure.step("Открытие страницы и принятие cookies", () -> {
            page.open();
            page.acceptCookies();
        });


        Allure.step("Проверка названия блока", () -> {
            String payHeaderExpected = "ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ";
            String payHeaderActual = page.getPayHeader();
            Assertions.assertEquals(payHeaderExpected, payHeaderActual);
        });

        Allure.step("Проверка логотипов платежных систем", () -> {
            List<String> expectedLogos = List.of(
                    "Visa",
                    "Verified By Visa",
                    "MasterCard",
                    "MasterCard Secure Code",
                    "Белкарт"
            );
            List<String> actualLogos = page.getPartnersLogos();
            Assertions.assertEquals(expectedLogos, actualLogos);
        });

        Allure.step("Проверка ссылки 'Подробнее о сервисе'", () -> {
            page.openDetailsLink();
            assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
            driver.navigate().back();
        });


        Allure.step("Проверка выпадающего меню с типами услуг", () -> {
            List<String> expectedSelectOptions = List.of(
                    "Услуги связи",
                    "Домашний интернет",
                    "Рассрочка",
                    "Задолженность"
            );
            List<String> actualSelectOptions = page.getSelectOptions();
            assertTrue(actualSelectOptions.containsAll(expectedSelectOptions));
        });


        Allure.step("Проверка заполнения полей оплаты и кнопки 'Продолжить'", () -> {
            Assertions.assertEquals("Услуги связи", page.getCurrentSelectText());
            page.enterPhoneNumber(phoneNumber);
            page.enterSum(sum);
            page.clickPay();
        });

        Allure.step("Проверка открытия нового окна и отображения суммы", () -> {
            WebElement paymentWidget = page.getPaymentWidget();
            assertTrue(paymentWidget.isDisplayed());
            driver.switchTo().frame(paymentWidget);

            Assertions.assertEquals(
                    Double.parseDouble(sum),
                    Double.parseDouble(page.getPayDescriptionCost())
            );
            Assertions.assertEquals(
                    Double.parseDouble(sum),
                    Double.parseDouble(page.getButtonSum())
            );
            Assertions.assertEquals(
                    Double.parseDouble(sum),
                    Double.parseDouble(page.getAgreementSum())
            );
        });

        Allure.step("Проверка отображения номера телефона", () -> {
            String expectedPhoneNumber = "375" + phoneNumber;
            String actualPhoneNumber = page.getPhoneNumber();
            Assertions.assertEquals(expectedPhoneNumber, actualPhoneNumber);
        });

        Allure.step("Проверка полей для ввода реквизитов карты", () -> {
            List<String> expectedCardPlaceholders = List.of(
                    "Номер карты",
                    "Срок действия",
                    "CVC",
                    "Имя и фамилия на карте"
            );
            List<String> actualCardPlaceholders = page.getCardPlaceholders();
            assertEquals(expectedCardPlaceholders, actualCardPlaceholders);
        });

        Allure.step("Проверка отображения платежных систем", () -> {
            List<WebElement> cardBrandsImg = page.getCardBrandsImg();
            assertFalse(cardBrandsImg.isEmpty());

            for (WebElement image : cardBrandsImg) {
                assertFalse(image.getAttribute("src").isBlank());
            }
        });

        driver.quit();
    }

}
