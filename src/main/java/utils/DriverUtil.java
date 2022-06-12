package utils;

import factories.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class DriverUtil {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    //private constructor to restrict object creation
    private DriverUtil() {
    }

    public static void setWebDriver() {
        if (null == webDriverThreadLocal.get()) {
            webDriverThreadLocal.set(DriverFactory.getWebDriverForSpecifiedBrowser(System.getProperty("browser")));
        }
    }

    public static WebDriver getWebDriver() {
        if (Objects.isNull(webDriverThreadLocal.get())) {
            webDriverThreadLocal.set(DriverFactory.getWebDriverForSpecifiedBrowser(System.getProperty("browser")));
        }
        return webDriverThreadLocal.get();
    }

    /**
     * Unload threadsafe instance of webDriver from webDriverThreadLocal
     */
    public static void unloadWebDriver() {
        if (null != webDriverThreadLocal.get()) {
            webDriverThreadLocal.get().quit();
            webDriverThreadLocal.remove();
        }
    }

}
