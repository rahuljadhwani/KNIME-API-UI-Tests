package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import utils.ScreenshotUtil;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentsManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentsManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Img()).build());
        ExtentsManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentsManager.getExtentTest().skip(message);
    }

    public static void info(String message) {
        ExtentsManager.getExtentTest().info(message);
    }

}
