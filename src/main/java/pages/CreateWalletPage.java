package pages;


import generic.GeneratePasscode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import reports.ExtentLogger;
import utils.driver.DriverManager;


public class CreateWalletPage extends BasePage {

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Keep up with the market!']")
    private WebElement header_NotificationPopupPage;

    @AndroidFindBy(xpath="//android.view.View[@resource-id='toolbar']")
    private WebElement header_CreateNewWalletPage;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Enable']")
    private WebElement button_EnableNotification;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Skip')]")
    private WebElement button_SkipNotification;

    @AndroidFindBy(xpath="//android.view.View[@resource-id='secretPhraseCreateButton']")
    private WebElement button_SecretPhraseWallet;



    @AndroidFindBy(xpath="//android.view.View[@resource-id='swiftCreateButton']")
    private WebElement button_SwiftWallet;





    public CreateWalletPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void isNotificationPageHeaderVisible() throws InterruptedException {
        isElementVisible(header_NotificationPopupPage,"KeepUpWithTheMarket header");
        ExtentLogger.info("User got the enable or skip notification popup");
    }


    public void isCreateNewWalletHeaderVisible() throws InterruptedException {
        isElementVisible(header_CreateNewWalletPage,"CreateNewWallet header");
        ExtentLogger.info("User landed on create new wallet page");
    }

    public void clickEnableButton(){
        click(button_EnableNotification,"enable button");
        ExtentLogger.info("User enabled the notification");
    }

    public void clickSkipButton(){
        click(button_SkipNotification,"Skip, i will do later button");
        ExtentLogger.info("User skipped the notification");
    }

    public WalletHomePage clickSecretPhraseCreateButton(){
        click(button_SecretPhraseWallet,"Secret phrase create button");
        return new WalletHomePage();
    }

    public void clickSwiftCreateButton(){
        click(button_SwiftWallet,"Swift create button");
    }



}
