package factories;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    //private constructor to restrict object creation
    private DriverFactory() {
    }

    public static WebDriver getWebDriverForSpecifiedBrowser(String browser) {

        switch (browser.toUpperCase()) {
            case "CHROME": {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case "FIREFOX": {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            }
            default:
                return null;
        }
    }
}


