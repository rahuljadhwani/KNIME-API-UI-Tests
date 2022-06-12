import constants.GlobalConstants;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDashboardPage;
import utils.DriverUtil;

public class TestOne extends BaseTest{

    @BeforeMethod
    public void setup(){
        DriverUtil.getWebDriver().get("https://hub.knime.com");
    }


    @Test
    public void testKnimeHubLogin() throws InterruptedException {
        UserDashboardPage userDashboardPage = new HomePage().clickAcceptCookies().clickOnSignInButton().enterUsername(GlobalConstants.getPropertyMap().get("username")).enterPassword(GlobalConstants.getPropertyMap().get("password")).clickSubmitButton();
        userDashboardPage.clickAvatarProfile().clickLogout();
    }

    @AfterMethod
    public void teardown(){
        DriverUtil.unloadWebDriver();
    }

}
