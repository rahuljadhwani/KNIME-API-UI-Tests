package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class contains method for capturing screenshots
 *
 */
public class ScreenshotUtil {

    private ScreenshotUtil(){

    }

    public static String getBase64Img(){
        return ((TakesScreenshot)DriverUtil.getWebDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
