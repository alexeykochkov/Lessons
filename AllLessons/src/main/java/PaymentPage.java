import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span[normalize-space()='20.00 BYN']")
    private WebElement money;

    @FindBy(xpath = "//div[@class='pay-description__text']/span[contains(text(), 'Номер:375297777777')]")
    private WebElement telephone;

    @FindBy(xpath = "//div[@class='content ng-tns-c2312288139-1']/label[contains(text(), 'Номер карты')]")
    private WebElement numberOfCard;

    @FindBy(xpath = "//div[@class='content ng-tns-c2312288139-4']/label[contains(text(), 'Срок действия')]")
    private WebElement validityPeriod;

    @FindBy(xpath = "//div[@class='content ng-tns-c2312288139-3']/label[contains(text(), 'Имя держателя (как на карте)')]")
    private WebElement cardholderName;

    @FindBy(xpath = "//label[@class='ng-tns-c2312288139-5 ng-star-inserted'][text()='CVC']")
    private WebElement cvcPlaceholder;

    @FindBy(xpath = "//button[@class='colored disabled'][contains(text(), 'Оплатить  20.00 BYN')]")
    private WebElement summaButton;

    @FindBy(xpath = "//img[@src='assets/images/payment-icons/card-types/visa-system.svg']")
    private WebElement visaImg;

    @FindBy(xpath = "//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']")
    private WebElement mastercardImg;

    @FindBy(xpath = "//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']")
    private WebElement belcardImg;

    public WebElement moneyInfo() {
        return money;
    }

    public WebElement telephoneInfo() {
        return telephone;
    }

    public WebElement numberOfCardInfo() {
        return numberOfCard;
    }

    public WebElement validityPeriodInfo() {
        return validityPeriod;
    }

    public WebElement cardholderNameInfo() {
        return cardholderName;
    }

    public WebElement cvcPlaceholderInfo() {
        return cvcPlaceholder;
    }

    public WebElement summaButtonInfo() {
        return summaButton;
    }

    public WebElement visaImgInfo() {
        return visaImg;
    }

    public WebElement mastercardImgInfo() {
        return mastercardImg;
    }

    public WebElement belcardImgInfo() {
        return belcardImg;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
