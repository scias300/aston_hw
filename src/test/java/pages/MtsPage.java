package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MtsPage {
    private WebDriver driver;

    private By cookieAgree = By.id("cookie-agree");
    private By payHeader = By.cssSelector(".pay__wrapper h2");
    private By partners = By.cssSelector(".pay__partners");
    private By detailsLink = By.linkText("Подробнее о сервисе");
    private By currentSelect = By.className("select__now");
    private By phoneField = By.id("connection-phone");
    private By sum = By.id("connection-sum");
    private By payButton = By.cssSelector("#pay-connection button[type='submit']");
    private By paymentWidget = By.className("payment-widget-iframe");
    private By selectOption = By.cssSelector("#pay option");
    private By payDescriptionCost = By.cssSelector(".pay-description__cost span");
    private By buttonSum = By.cssSelector(".card-page__card button span");
    private By cardPageAgreementCost = By.cssSelector(".card-page__agreement span");
    private By payDescriptionText = By.cssSelector(".pay-description__text span");
    private By cardNumberPlaceholder = By.cssSelector(".card-number label");
    private By expirationDatePlaceholder = By.cssSelector(".expires-input label");
    private By cvcPlaceholder = By.cssSelector(".cvc label");
    private By cardNamePlaceholder = By.xpath("//input[@autocomplete='cc-name']/following-sibling::label");
    private By cardBrandsImg = By.cssSelector(".cards-brands img");

    public MtsPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get("https://www.mts.by/");
    }

    public void acceptCookies(){
        WebElement cookieAgree = driver.findElement(this.cookieAgree);
        if (cookieAgree.isDisplayed()){
            cookieAgree.click();
        }
    }

    public String getPayHeader(){
        return driver.findElement(payHeader).getText();
    }

    public List<String> getPartnersLogos(){
        return driver.findElement(partners).findElements(By.tagName("img"))
                .stream()
                .map(img -> img.getAttribute("alt"))
                .collect(Collectors.toList());
    }

    public void openDetailsLink(){
        driver.findElement(detailsLink).click();
    }

    public String getCurrentSelectText(){
        return driver.findElement(currentSelect).getText();
    }

    public void enterPhoneNumber(String number){
        WebElement phoneField = driver.findElement(this.phoneField);
        phoneField.click();
        phoneField.sendKeys(number);
    }

    public void enterSum(String number){
        WebElement sum = driver.findElement(this.sum);
        sum.click();
        sum.sendKeys(number);
    }

    public void clickPay (){
        driver.findElement(payButton).click();
    }

    public WebElement getPaymentWidget(){
        return waitElement(paymentWidget);
    }

    public List<String> getSelectOptions(){
        return driver.findElements(selectOption)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getPayDescriptionCost(){
        return getSum(payDescriptionCost);
    }

    public String getButtonSum(){
        return getSum(buttonSum);
    }

    public String getAgreementSum(){
        return getSum(cardPageAgreementCost);
    }

    public String getPhoneNumber(){
        String number = waitElement(payDescriptionText).getText();
        return number.replaceAll("[^0-9]", "");
    }

    public List<String> getCardPlaceholders(){
        return List.of(
                driver.findElement(cardNumberPlaceholder).getText(),
                driver.findElement(expirationDatePlaceholder).getText(),
                driver.findElement(cvcPlaceholder).getText(),
                driver.findElement(cardNamePlaceholder).getText()
        );
    }

    public List<WebElement> getCardBrandsImg(){
        return driver.findElements(cardBrandsImg);
    }

    private String getSum(By costElement){
        String sum = waitElement(costElement).getText();
        return sum.replaceAll(".*?(\\d+\\.\\d{2}).*", "$1");
    }

    private WebElement waitElement(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
