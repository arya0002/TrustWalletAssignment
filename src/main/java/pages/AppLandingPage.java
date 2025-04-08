package pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.driver.DriverManager;


public class AppLandingPage extends BasePage{



    @AndroidFindBy(xpath="//android.view.View[@resource-id='CreateNewWalletButton']")
    private WebElement button_CreateNewWallet;

    @AndroidFindBy(xpath="//android.view.View[@resource-id='ImportWalletButton']")
    private WebElement button_ExistingWallet;

    public AppLandingPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public CreateConfirmPasscodePage clickCreateNewWallet() throws InterruptedException {
        click(button_CreateNewWallet,"CreateNewWallet button");
        return new CreateConfirmPasscodePage();
    }

    public void clickIAlreadyHaveWallet() throws InterruptedException {
        click(button_ExistingWallet,"IAlreadyHaveAWallet button");
    }

}
