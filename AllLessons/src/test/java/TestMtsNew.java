import io.qameta.allure.*;
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

import static org.junit.jupiter.api.Assertions.*;

public class TestMtsNew {

    private static WebDriverWait wait;
    private ChromeDriver driver;

    private HomePageMTS homePage;

    private PaymentPage paymentPage;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        homePage = new HomePageMTS(driver);
        paymentPage = new PaymentPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4).toMillis());
    }


    @AfterEach
    void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Epic("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка названия указанного блока")
    @Test
    @DisplayName("Проверка названия указанного блока")
    void checkTitle() {
        checkTitle(driver);
    }

    @Epic("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка логотипов")
    @Test
    @DisplayName("Проверка логотипов")
    void checkLogos() {
        checkLogos(driver);
    }

    @Epic("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнения поля и работы кнопки")
    @Test
    @DisplayName("Проверка заполнения поля и работы кнопки")
    void checkContinueButton() {
        checkContinueButton(driver);
    }

    @Epic("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка <Домашний Интернет>")
    @Test
    @DisplayName("Проверка <Домашний Интернет>")
    void checkHomeInternet() {
        checkHomeInternet(driver);
    }

    @Epic("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка <Рассрочка>")
    @Test
    @DisplayName("Проверка <Рассрочка>")
    void checkInstallmentPlan() {
        checkInstallmentPlan(driver);
    }

    @Epic("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка <Задолженности>")
    @Test
    @DisplayName("Проверка <Задолженности>")
    void checkDebt() {
        checkDebt(driver);
    }

    @Epic("Главная страница")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка <Услуги Связи>")
    @Test
    @DisplayName("Проверка <Услуги Связи>")
    void checkCommunicationServices() {
        checkCommunicationServices(driver);
    }

    @Epic("Страница оплаты")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка передаваемых данных и плейсхолдеров")
    @Test
    @DisplayName("Проверка передаваемых данных и плейсхолдеров")
    void checkInfoInNewWindow() throws InterruptedException {
        checkInfoInNewWindow(driver);
    }


    void checkTitle(WebDriver driver) {
        homePage.acceptCookies();
        String expectedTextPart1 = "Онлайн пополнение";
        String expectedTextPart2 = "без комиссии";
        String actualText = homePage.getBlockTitleText();
        assertTrue(actualText.contains(expectedTextPart1), "Заголовок блока не содержит текст 'Онлайн пополнение'");
        assertTrue(actualText.contains(expectedTextPart2), "Заголовок блока не содержит текст 'без комиссии'");
        System.out.println("TEST: PASS " + actualText);
    }

    public void checkLogos(WebDriver driver) {
        homePage.acceptCookies();
        List<String> EXPECTED_LOGOS = Arrays.asList(
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        );
        List<WebElement> logos = homePage.getLogos();
        Assert.assertEquals(logos.size(), EXPECTED_LOGOS.size(), "Количество логотипов не соответствует ожидаемому!");

        for (int i = 0; i < logos.size(); i++) {
            String expectedLogo = EXPECTED_LOGOS.get(i);
            WebElement logo = logos.get(i);
            String actualLogoAlt = logo.getAttribute("alt");
            Assert.assertEquals(actualLogoAlt, expectedLogo, "Логотип в позиции " + (i + 1) + " не соответствует ожидаемому!");
        }
        System.out.println("TEST: PASS");
    }

    public void checkContinueButton(WebDriver driver) {
        homePage.acceptCookies();
        WebElement service = homePage.selectService();
        Actions actions = new Actions(driver);
        actions.moveToElement(service).perform();
        homePage.setPhoneNumber();
        homePage.setAmountMoney();
        homePage.continueClick();
        String currentUrl = paymentPage.getCurrentUrl();
        assertNotEquals("https://mts.by", currentUrl, "TEST: FAIL - Переход не произошел");
        System.out.println("TEST: PASS");
    }

    void checkHomeInternet(WebDriver driver) {
        homePage.acceptCookies();
        WebElement service = homePage.selectService();
        service.click();
        WebElement switchToHomeInternet = homePage.selectHomeInternet();
        switchToHomeInternet.click();
        String expectedTextPart1 = "Номер абонента";
        WebElement inputField = homePage.inputInternetPhone();
        String actualText = inputField.getAttribute("placeholder");
        assertTrue(actualText.contains(expectedTextPart1), "Текст заголовка не содержит '" + expectedTextPart1 + "'");
        System.out.println("TEST: PASS - Текст заголовка: " + actualText);
    }

    void checkInstallmentPlan(WebDriver driver) {
        homePage.acceptCookies();
        WebElement service = homePage.selectService();
        service.click();
        WebElement switchToInstallmentPlan = homePage.selectInstallmentPlan();
        switchToInstallmentPlan.click();
        String expectedTextPart1 = "Номер счета на 44";
        WebElement inputField = homePage.inputInstallment();
        String actualText = inputField.getAttribute("placeholder");
        assertTrue(actualText.contains(expectedTextPart1), "Текст заголовка не содержит '" + expectedTextPart1 + "'");
        System.out.println("TEST: PASS - Текст заголовка: " + actualText);
    }

    void checkDebt(WebDriver driver) {
        homePage.acceptCookies();
        WebElement service = homePage.selectService();
        service.click();
        WebElement switchToDebt = homePage.selectDebt();
        switchToDebt.click();
        String expectedTextPart1 = "Номер счета на 2073";
        WebElement inputField = homePage.inputAccountNumber();
        String actualText = inputField.getAttribute("placeholder");
        assertTrue(actualText.contains(expectedTextPart1), "Текст заголовка не содержит '" + expectedTextPart1 + "'");
        System.out.println("TEST: PASS - Текст заголовка: " + actualText);
    }

    void checkCommunicationServices(WebDriver driver) {
        homePage.acceptCookies();
        WebElement service = homePage.selectService();
        service.click();
        WebElement switchToCommunicationServices = homePage.selectCommunicationServices();
        switchToCommunicationServices.click();
        String expectedTextPart1 = "Номер телефона";
        WebElement inputField = homePage.inputCommunicationNumber();
        String actualText = inputField.getAttribute("placeholder");
        assertTrue(actualText.contains(expectedTextPart1), "Текст заголовка не содержит '" + expectedTextPart1 + "'");
        System.out.println("TEST: PASS - Текст заголовка: " + actualText);
    }

    void checkInfoInNewWindow(WebDriver driver) throws InterruptedException {
        homePage.acceptCookies();
        WebElement service = homePage.selectService();
        Actions actions = new Actions(driver);
        actions.moveToElement(service).click().perform();
        homePage.setPhoneNumber();
        homePage.setAmountMoney();
        homePage.continueClick();
        System.out.println("homePage.continueClick()");
        Thread.sleep(2000);

        new WebDriverWait(driver, Duration.ofSeconds(5).toMillis())
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='https://checkout.bepaid.by/widget_v2/index.html']")));

        Thread.sleep(2000);
        WebElement summa = paymentPage.moneyInfo();
        Assert.assertTrue(summa.isDisplayed(), "Сумма оплаты не соответствует введенной");

        WebElement telephone = paymentPage.telephoneInfo();
        Assert.assertTrue(telephone.isDisplayed(), "Телефон на странице не соответствует введенному ранее");

        WebElement numberOfCart = paymentPage.numberOfCardInfo();
        Assert.assertTrue(numberOfCart.isDisplayed(), "Плэйсхолдер: <Номер карты> отсутствует");

        WebElement validityPeriod = paymentPage.validityPeriodInfo();
        Assert.assertTrue(validityPeriod.isDisplayed(), "Плэйсхолдер: <Срок действия> отсутствует");

        WebElement cardholderName = paymentPage.cardholderNameInfo();
        Assert.assertTrue(cardholderName.isDisplayed(), "Плэйсхолдер: <Имя держателя (как на карте)> отсутствует");

        WebElement cvcPlaceholder = paymentPage.cvcPlaceholderInfo();
        Assert.assertTrue(cvcPlaceholder.isDisplayed(), "Плэйсхолдер: <CVC> отсутствует");

        WebElement summaButton = paymentPage.summaButtonInfo();
        Assert.assertTrue(summaButton.isDisplayed(), "Сумма на кнопке не соответствует введенной");

        WebElement visaImg = paymentPage.visaImgInfo();
        Assert.assertTrue(visaImg.isDisplayed(), "Иконка Visa отсутствует");

        WebElement mastercardImg = paymentPage.mastercardImgInfo();
        Assert.assertTrue(mastercardImg.isDisplayed(), "Иконка MasterCard отсутствует");

        WebElement belcardImg = paymentPage.belcardImgInfo();
        Assert.assertTrue(belcardImg.isDisplayed(), "Иконка MasterCard отсутствует");

        System.out.println("TEST: PASS - Проверка передаваемых данных и плейсхолдеров");
    }
}
