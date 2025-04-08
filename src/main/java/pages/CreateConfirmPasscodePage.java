package pages;


import generic.GeneratePasscode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import reports.ExtentLogger;
import utils.driver.DriverManager;


public class CreateConfirmPasscodePage extends BasePage {

    String passcode;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Create passcode']")
    private WebElement header_CreatePasscodePage;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Confirm passcode']")
    private WebElement header_ConfirmPasscodePage;

    @AndroidFindBy(xpath="//android.view.View[@content-desc='Back']")
    private WebElement button_Back;

    private String numberButtons = "//android.widget.TextView[@text='%s']";

    public CreateConfirmPasscodePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void isCreatePasscodeHeaderVisible() throws InterruptedException {
        isElementVisible(header_CreatePasscodePage,"CreatePassCode header");
    }


    public void isConfirmPasscodeHeaderVisible() throws InterruptedException {
        isElementVisible(header_ConfirmPasscodePage,"ConfirmPassCode header");
    }

    public void fillNewPasscode(){
        passcode = GeneratePasscode.getNewPasscode();
        ExtentLogger.info("New passcode got created is: "+passcode);
        chooseItemAndclick(numberButtons,passcode);
    }

    public CreateWalletPage fillExistingpassode(){
        ExtentLogger.info("Existing passcode is: "+ passcode);
        chooseItemAndclick(numberButtons,passcode);
        return new CreateWalletPage();
    }

    public void clickBackButton() throws InterruptedException {
        click(button_Back,"Back button");
    }

}
