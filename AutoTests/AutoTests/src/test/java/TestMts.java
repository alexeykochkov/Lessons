import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestMts {

    private WebDriver driver;
    private static WebDriverWait wait;

    @BeforeEach
    void initialDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2).toMillis());
    }

    @AfterEach
    void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверка названия указанного блока")
    void checkTitle() {
        checkTitle(driver);
    }

    @Test
    @DisplayName("Проверка работы ссылки: Подробнее о сервисе")
    void checkLink() {
        checkLink(driver);
    }

    @Test
    @DisplayName("Проверка заполнения поля и работы кнопки")
    void checkContinueButton() {
        checkContinueButton(driver);
    }

    @Test
    @DisplayName("Проверка логотипов")
    void checkLogos() {
        checkLogos(driver);
    }

    void checkTitle(WebDriver driver) {
        acceptCookies(driver);

        WebElement blockTitle = driver.findElement(By.xpath("//div[contains(@class, 'pay__wrapper')]//h2"));
        if (blockTitle != null) {

            String expectedTextPart1 = "Онлайн пополнение";
            String expectedTextPart2 = "без комиссии";
            String actualText = blockTitle.getText().replace("\n", " ");

            assertTrue(actualText.contains(expectedTextPart1), "Заголовок блока не содержит текст 'Онлайн пополнение'");
            assertTrue(actualText.contains(expectedTextPart2), "Заголовок блока не содержит текст 'без комиссии'");

            System.out.println("TEST: PASS " + actualText);

        } else {
            System.err.println("TEST: FAIL");
            fail("TEST: FAIL");
        }
    }

    public static void checkLink(WebDriver driver) {
        acceptCookies(driver);
        By moreInfoLinkLocator = By.xpath("//div[contains(@class, 'pay__partners')]/following-sibling::a[contains(text(), 'Подробнее о сервисе')]");
        WebElement moreInfoLink = driver.findElement(moreInfoLinkLocator);

        if (moreInfoLink != null && moreInfoLink.isDisplayed()) {
            moreInfoLink.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2).toMillis());
            wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"), "Страница не перешла на 'Подробнее о сервисе'. Текущий URL: " + currentUrl);

            System.out.println("TEST: PASS");
        } else {
            System.err.println("TEST: FAIL - Ссылка не рабочая");
            fail("TEST: FAIL - Ссылка не рабочая");
        }
    }

    public static void checkContinueButton(WebDriver driver) {
        acceptCookies(driver);

        WebElement service = driver.findElement(By.xpath("//span[text()='Услуги связи']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(service).perform();

        WebElement phoneField = driver.findElement(By.xpath("//form[@id='pay-connection']//input[@id='connection-phone']"));
        WebElement sumField = driver.findElement(By.xpath("//form[@id='pay-connection']//input[@id='connection-sum']"));

        phoneField.sendKeys("297777777");
        sumField.sendKeys("20");

        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[@type='submit']"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2).toMillis());

        String currentUrl = driver.getCurrentUrl();
        assertNotEquals("https://mts.by", currentUrl, "TEST: FAIL - Переход не произошел");
        System.out.println("TEST: PASS");
    }

    public static void checkLogos(WebDriver driver) {
        acceptCookies(driver);

        List<String> EXPECTED_LOGOS = Arrays.asList(
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        );

        List<WebElement> logos = driver.findElements(By.xpath("//div[contains(@class, 'pay__partners')]//img"));

        Assert.assertEquals(logos.size(), EXPECTED_LOGOS.size(), "Количество логотипов не соответствует ожидаемому!");

        for (int i = 0; i < logos.size(); i++) {
            String expectedLogo = EXPECTED_LOGOS.get(i);
            WebElement logo = logos.get(i);
            String actualLogoAlt = logo.getAttribute("alt");

            Assert.assertEquals(actualLogoAlt, expectedLogo, "Логотип в позиции " + (i + 1) + " не соответствует ожидаемому!");
        }

        System.out.println("TEST: PASS");
    }

    private static void acceptCookies(WebDriver driver) {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]")));
            acceptCookiesButton.click();

            wait.until(ExpectedConditions.invisibilityOf(acceptCookiesButton));

            assertFalse(acceptCookiesButton.isDisplayed(), "Кнопка 'Принять' все еще видима после клика.");

            System.out.println("Куки приняты");

        } catch (NoSuchElementException e) {
            System.err.println("Кнопка 'Принять' не найдена: " + e.getMessage());
            fail("Кнопка 'Принять' не найдена.");
        }
    }
}