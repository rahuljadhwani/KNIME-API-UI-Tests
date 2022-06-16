package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import utils.ScreenshotUtil;


/**
 * This class contains an abstraction layer for extent report logging. These methods are used by ListenerImplementation class
 *
 */
public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentsManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentsManager.getExtentTest().fail(message);
    }

    public static void failWithScreenshot(String message) {
        ExtentsManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Img()).build());
        ExtentsManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentsManager.getExtentTest().skip(message);
    }

    public static void info(String message) {
        ExtentsManager.getExtentTest().info(message);
    }

    public static void addHTTPResponseNode(String message, String data){
        ExtentsManager.getExtentTest().info(message).info("HTTP Response").info(data);
    }

}
