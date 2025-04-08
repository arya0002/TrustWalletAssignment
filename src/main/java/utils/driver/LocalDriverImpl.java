package utils.driver;

import constants.FrameworkConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriverImpl implements IDriver {
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        //        //set the capabilities
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/androidAPP.apk");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Pixel 9 Pro");
//        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("udid", "emulator-5554");
//
//
//// both option will work, with UiAutomator2Options we dont have to put so many capabilities

        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setApp(FrameworkConstants.getInstance().getApkFilePath());

        // server details
        // There is a design change in the Java Client version 2.0.0 as they mention on their site: AppiumDriver is now an abstract class, use IOSDriver and AndroidDriver which both extend it.
        //Webdriver is parent interface for all driver so we can use it
//        try {
//            //driver = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
//            WebDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), capabilities);
//            System.out.println("Session id is:"+ driver.getSessionId());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("Appium server URL is invalid", e);
//        }
        return new AndroidDriver(new URL("http://0.0.0.0:4723"), capabilities);
    }
}
