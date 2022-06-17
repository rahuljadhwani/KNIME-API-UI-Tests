import constants.GlobalConstants;
import org.testng.annotations.Test;
import pages.hubui.HomePage;

/**
 * This class contains UI test methods
 *
 */
public class TestUI extends BaseTest {


    @Test(description = "Knime hub login test", groups = "UI", enabled = false)
    public void testKnimeHubLogin() {
        new HomePage().clickAcceptCookies().clickOnSignInButton().enterUsername(GlobalConstants.getPropertyMap().get("username"))
                .enterPassword(GlobalConstants.getPropertyMap().get("password")).clickSubmitButton()
                .clickAvatarProfile().clickLogout();
    }

    @Test(description = " UI test - Create and Delete Public space on KNIME hub test", groups = "UI")
    public void testCreateAndDeletePublicSpace() {
        createPublicSpace().clickMoreOptions().deleteSpace().enterSpaceNameToDeleteSpace()
                .deleteSpaceConfirm().verifySpaceDeletedMessage();
    }

    @Test(description = " UI test - Create and Delete Private space on KNIME hub test", groups = "UI")
    public void testCreateAndDeletePrivateSpace() {
        createPrivateSpace().clickMoreOptions().deleteSpace().enterSpaceNameToDeleteSpace()
                .deleteSpaceConfirm().verifySpaceDeletedMessage();
    }

    @Test(description = " UI test - Verify UI elements on Your spaces page", groups = "UI")
    public void testWebElementsOnYourSpacesPage(){
        loginToKNIMEHub().clickAvatarProfile().clickUserSpaces().verifyYourSpacesHeader()
                .verifySpaceList().verifyCreateNewSpaceOptions().verifyFooterDetails();
    }

}
