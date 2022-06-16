package pages;

import constants.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import reports.ExtentLogger;
import utils.DriverUtil;
import utils.WaitUtil;

import java.util.Set;

/**
 * This class contains reusable methods by UI Page objects
 *
 */
public class BasePage {


    public static WebDriver getDriver(){
        return DriverUtil.getWebDriver();
    }

    public static void click(By locator, String elementName){
        WaitUtil.waitForClickablity(locator);
        getDriver().findElement(locator).click();
        ExtentLogger.info(elementName +" clicked.");
    }

    public static void click(By locator){
        WaitUtil.waitForClickablity(locator);
        getDriver().findElement(locator).click();
    }

    public static void sendKeys(By locator, String dataToEnter, String elementName){
        WaitUtil.waitForVisibility(locator);
        getDriver().findElement(locator).sendKeys(dataToEnter);
        ExtentLogger.info("*data* entered in "+ elementName);
    }

    public static void sendKeys(By locator, String dataToEnter){
        WaitUtil.waitForVisibility(locator);
        getDriver().findElement(locator).sendKeys(dataToEnter);
    }

    public static boolean checkIfDisplayed(By locator){
        return WaitUtil.waitForVisibility(locator).isDisplayed();
    }

    public static String getText(By locator){
        return WaitUtil.waitForVisibility(locator).getText();
    }

    public static Set<Cookie> getCookies(){
        DriverUtil.getWebDriver().get(GlobalConstants.getPropertyMap().get("url"));
        new HomePage().clickAcceptCookies().clickOnSignInButton().enterUsername(GlobalConstants.getPropertyMap().get("username"))
                .enterPassword(GlobalConstants.getPropertyMap().get("password")).clickSubmitButton();
        return getDriver().manage().getCookies();
    }

}
