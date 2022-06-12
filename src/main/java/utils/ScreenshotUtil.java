package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtil {

    public static String getBase64Img(){
        return ((TakesScreenshot)DriverUtil.getWebDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
