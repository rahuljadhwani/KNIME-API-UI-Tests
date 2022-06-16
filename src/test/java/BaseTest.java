import constants.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import pages.UserDashboardPage;
import utils.DriverUtil;
import utils.api.TokenManager;


public class BaseTest {

    @BeforeSuite(groups = "API")
    public void cookieSetup(){
        getDriver().get(GlobalConstants.getPropertyMap().get("url"));
        new HomePage().clickAcceptCookiesWithoutLogging().clickOnSignInButtonWithoutLogging().enterUsernameWoLogging(GlobalConstants.getPropertyMap().get("username"))
                .enterPasswordWoLogging(GlobalConstants.getPropertyMap().get("password")).clickSubmitButtonWoLogging();
        TokenManager.setCookies(getDriver().manage().getCookies());
        new UserDashboardPage().clickAvatarProfileWoLogging().clickLogoutWoLogging();
        DriverUtil.unloadWebDriver();
    }

    @BeforeMethod(groups = "UI")
    public void setup(){
        DriverUtil.getWebDriver().get(GlobalConstants.getPropertyMap().get("url"));
    }


    @AfterMethod(groups = "UI")
    public void teardown(){
        DriverUtil.unloadWebDriver();
    }

    public static WebDriver getDriver(){
        return DriverUtil.getWebDriver();
    }




}
