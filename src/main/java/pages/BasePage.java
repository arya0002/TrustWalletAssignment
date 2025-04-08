package pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reports.ExtentLogger;
import utils.driver.DriverManager;

import java.time.Duration;

import static utils.DynamicXpathUtils.getXpath;


public class BasePage {


    private void explicitWait(WebElement element){
        new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10)).withMessage(()->"some problem in finding element "+element)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void isElementVisible(WebElement element, String elementname){
       explicitWait(element);
       Assert.assertTrue(element.isDisplayed(),elementname+" is not displayed");
       ExtentLogger.pass(elementname+" is displayed");
    }
    protected String getText(WebElement element){
        explicitWait(element);
        String textValue = element.getText();
        ExtentLogger.info("Text extracted from element "+element+" is "+textValue);
        return textValue;
    }
    protected void click(WebElement element, String elementname){
        explicitWait(element);
        element.click();
        ExtentLogger.pass(elementname+" is clicked successfully");
    }

    protected void click(By by, String elementname){
        click((WebElement) DriverManager.getDriver().findElement(by),elementname);
        ExtentLogger.pass(elementname+" is clicked successfully");
    }

    protected void click(String locatortype,String value,String elementname){
        if (locatortype.equalsIgnoreCase("xpath")){
            click(By.xpath(value),elementname);
        } else if (locatortype.equalsIgnoreCase("id")) {
            click(By.id(value),elementname);

        }
    }

    protected void chooseItemAndclick(String xpath,String value){
        for (int i = 0; i < value.length(); i++) {
            // Print current character
            System.out.print(value.charAt(i) + " ");
            String newXpath = getXpath(xpath, String.valueOf(value.charAt(i)));
            click(DriverManager.getDriver().findElement(By.xpath(newXpath)),String.valueOf(value.charAt(i)));
        }
    }

}
