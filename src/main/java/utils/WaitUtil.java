package utils;

import constants.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    public static WebElement waitForClickablity(By locator){
       return new WebDriverWait(DriverUtil.getWebDriver(), GlobalConstants.getEXPLICIT_WAIT_TIMEOUT()).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForVisibility(By locator){
        return new WebDriverWait(DriverUtil.getWebDriver(), GlobalConstants.getEXPLICIT_WAIT_TIMEOUT()).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
