package factories;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class DriverFactory {

    //private constructor to restrict object creation
    private DriverFactory() {
    }

    public static WebDriver getWebDriverForSpecifiedBrowser(String browser) {

        if (!Objects.isNull(browser)) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
        }
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}


