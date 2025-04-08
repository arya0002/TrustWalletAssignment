package pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import reports.ExtentLogger;
import utils.driver.DriverManager;


public class WalletHomePage extends BasePage {

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id='topBarWalletName']")
    private WebElement textField_WalletName;


    public WalletHomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void isWalletHeaderVisible() throws InterruptedException {
        isElementVisible(textField_WalletName,"Wallet header");
        ExtentLogger.info("User landed on wallet page");
    }


    public String getWalletname(){
        return getText(textField_WalletName);
    }



}
