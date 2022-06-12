package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverUtil;
import utils.WaitUtil;

public class BasePage {


    public static WebDriver getDriver(){
        return DriverUtil.getWebDriver();
    }

    public static void click(By locator, String elementName){
        WaitUtil.waitForClickablity(locator);
        getDriver().findElement(locator).click();
    }

    public static void sendKeys(By locator, String dataToEnter, String elementName){
        WaitUtil.waitForVisibility(locator);
        getDriver().findElement(locator).sendKeys(dataToEnter);
    }

    public static void checkIfDisplayed(By locator){
        WaitUtil.waitForVisibility(locator).isDisplayed();
    }

    public static String getText(By locator){
        return WaitUtil.waitForVisibility(locator).getText();
    }

}
