import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class HomePageMTS {

    WebDriver driver;

    public HomePageMTS(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[contains(text(), 'Принять')]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//div[contains(@class, 'pay__wrapper')]//h2")
    private WebElement blockTitle;

    @FindBy(xpath = "//div[contains(@class, 'pay__partners')]//img")
    private List<WebElement> logos;

    @FindBy(xpath = "//form[@id='pay-connection']//input[@id='connection-phone']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//form[@id='pay-connection']//input[@id='connection-sum']")
    private WebElement amountMoney;

    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='submit']")
    private WebElement continueButton;

    @FindBy(xpath = "//span[text()='Услуги связи']")
    private WebElement service;

    @FindBy(xpath = "//input[@id='internet-phone']")
    private WebElement internetPhone;

    @FindBy(xpath = "//p[contains(text(),'Домашний интернет')]")
    private WebElement homeInternet;

    @FindBy(xpath = "//p[contains(text(),'Рассрочка')]")
    private WebElement installmentPlan;

    @FindBy(xpath = "//input[@id='score-instalment']")
    private WebElement inputInstallment;

    @FindBy(xpath = "//p[contains(text(),'Задолженность')]")
    private WebElement selectDebt;

    @FindBy(xpath = "//input[@id='score-arrears']")
    private WebElement inputAccountNumber;

    @FindBy(xpath = "//p[contains(text(),'Услуги связи')]")
    private WebElement communicationServices;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement communicationNumber;

    public void acceptCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4).toMillis());
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(this.acceptCookiesButton));
            acceptCookiesButton.click();
            System.out.println("Куки приняты");
        } catch (NoSuchElementException e) {
            System.out.println("Кнопка не появилась, куки не приняты.");
        }
    }

    public String getBlockTitleText() {
        return blockTitle.getText().replace("\n", " ");
    }

    public List<WebElement> getLogos() {
        return logos;
    }

    public void setPhoneNumber() {
        phoneNumber.sendKeys("297777777");
    }

    public void setAmountMoney() {
        amountMoney.sendKeys("20");
    }

    public void continueClick() {
        continueButton.click();
    }

    public WebElement selectService() {
        return service;
    }

    public WebElement inputInternetPhone() {
        return internetPhone;
    }

    public WebElement selectHomeInternet() {
        return homeInternet;
    }

    public WebElement selectInstallmentPlan() {
        return installmentPlan;
    }

    public WebElement inputInstallment() {
        return inputInstallment;
    }

    public WebElement selectDebt() {
        return selectDebt;
    }

    public WebElement inputAccountNumber() {
        return inputAccountNumber;
    }

    public WebElement selectCommunicationServices() {
        return communicationServices;
    }

    public WebElement inputCommunicationNumber() {
        return communicationNumber;
    }
}
