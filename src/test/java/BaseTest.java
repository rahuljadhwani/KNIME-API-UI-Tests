import constants.GlobalConstants;
import enums.SpaceTypes;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.hubui.HomePage;
import pages.hubui.SpacePage;
import pages.hubui.WelcomePage;
import utils.DataStorageUtil;
import utils.DriverUtil;
import utils.PropertyReaderUtil;
import utils.api.TokenManager;


/**
 * This class contains setup and teardown steps for tests
 *
 */
public class BaseTest {

    @BeforeSuite(groups = "API")
    public void cookieSetup(){
        getDriver().get(GlobalConstants.getPropertyMap().get("url"));
        new HomePage().clickAcceptCookiesWithoutLogging().clickOnSignInButtonWithoutLogging().enterUsernameWoLogging(System.getProperty("username"))
                .enterPasswordWoLogging(System.getProperty("password")).clickSubmitButtonWoLogging();
        TokenManager.setCookies(getDriver().manage().getCookies());

        new WelcomePage().clickAvatarProfileWoLogging().clickLogoutWoLogging();
        DriverUtil.unloadWebDriver();
    }

    @BeforeMethod(groups = "UI")
    public void setup(){
        DriverUtil.getWebDriver().get(GlobalConstants.getPropertyMap().get("url"));
    }

    protected WelcomePage loginToKNIMEHub(){
        return new HomePage().clickAcceptCookies().clickOnSignInButton().enterUsername(System.getProperty("username"))
                .enterPassword(System.getProperty("password")).clickSubmitButton();
    }

    protected static WebDriver getDriver(){
        DriverUtil.getWebDriver().manage().window().maximize();
        return DriverUtil.getWebDriver();
    }

    protected SpacePage createPublicSpace(){
        return loginToKNIMEHub().clickAvatarProfile().clickUserSpaces().createSpace(SpaceTypes.PUBLIC)
                .verifySpaceCreatedMessage();
    }

    protected SpacePage createPrivateSpace(){
        return loginToKNIMEHub().clickAvatarProfile().clickUserSpaces().createSpace(SpaceTypes.PRIVATE)
                .verifySpaceCreatedMessage();
    }

    @AfterMethod(groups = "UI")
    public void teardown(){
        DriverUtil.unloadWebDriver();
    }

    @AfterSuite
    public void suiteTeardown(){
        DataStorageUtil.destroyDataStorage();
        PropertyReaderUtil.emptyPropertyMap();
    }

}
