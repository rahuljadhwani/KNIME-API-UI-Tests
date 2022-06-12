import constants.GlobalConstants;
import enums.SpaceTypes;
import org.testng.annotations.Test;
import pages.HomePage;
public class TestOne extends BaseTest {


    @Test
    public void testKnimeHubLogin() {
        new HomePage().clickAcceptCookies().clickOnSignInButton().enterUsername(GlobalConstants.getPropertyMap().get("username"))
                .enterPassword(GlobalConstants.getPropertyMap().get("password")).clickSubmitButton()
                .clickAvatarProfile().clickLogout();
    }

    @Test(dependsOnMethods = "testKnimeHubLogin")
    public void testCreateAndDeletePublicSpace() {
        new HomePage().clickAcceptCookies().clickOnSignInButton().enterUsername(GlobalConstants.getPropertyMap().get("username"))
                .enterPassword(GlobalConstants.getPropertyMap().get("password")).clickSubmitButton().clickAvatarProfile().clickUserSpaces()
                .createSpace(SpaceTypes.PUBLIC).verifySpaceCreatedMessage().clickMoreOptions().deleteSpace()
                .enterSpaceNameToDeleteSpace().deleteSpaceConfirm().verifySpaceDeletedMessage();
    }

    @Test(dependsOnMethods = "testKnimeHubLogin")
    public void testCreateAndDeletePrivateSpace() {
        new HomePage().clickAcceptCookies().clickOnSignInButton().enterUsername(GlobalConstants.getPropertyMap().get("username"))
                .enterPassword(GlobalConstants.getPropertyMap().get("password")).clickSubmitButton().clickAvatarProfile().clickUserSpaces()
                .createSpace(SpaceTypes.PRIVATE).verifySpaceCreatedMessage().clickMoreOptions().deleteSpace()
                .enterSpaceNameToDeleteSpace().deleteSpaceConfirm().verifySpaceDeletedMessage();
    }

}
