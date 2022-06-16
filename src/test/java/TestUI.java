import constants.GlobalConstants;
import enums.SpaceTypes;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SpacePage;
import pages.UserDashboardPage;
import pages.YourSpacesPage;

public class TestUI extends BaseTest {


    @Test(description = "Knime hub login test", groups = "UI", enabled = false)
    public void testKnimeHubLogin() {
        new HomePage().clickAcceptCookies().clickOnSignInButton().enterUsername(GlobalConstants.getPropertyMap().get("username"))
                .enterPassword(GlobalConstants.getPropertyMap().get("password")).clickSubmitButton()
                .clickAvatarProfile().clickLogout();
    }

    @Test(description = " Create and Delete Public space on KNIME hub test", groups = "UI")
    public void testCreateAndDeletePublicSpace() {
        createPublicSpace().clickMoreOptions().deleteSpace().enterSpaceNameToDeleteSpace()
                .deleteSpaceConfirm().verifySpaceDeletedMessage();
    }

    @Test(description = " Create and Delete Private space on KNIME hub test", groups = "UI")
    public void testCreateAndDeletePrivateSpace() {
        createPrivateSpace().clickMoreOptions().deleteSpace().enterSpaceNameToDeleteSpace()
                .deleteSpaceConfirm().verifySpaceDeletedMessage();
    }

    @Test(description = "Verify UI elements on Your spaces page", groups = "UI")
    public void testWebElementsOnYourSpacesPage(){
        loginToKNIMEHub().clickAvatarProfile().clickUserSpaces().verifyYourSpacesHeader()
                .verifySpaceList().verifyCreateNewSpaceOptions().verifyFooterDetails();
    }


    private SpacePage createPublicSpace(){
        return loginToKNIMEHub().clickAvatarProfile().clickUserSpaces().createSpace(SpaceTypes.PUBLIC)
                .verifySpaceCreatedMessage();
    }

    private SpacePage createPrivateSpace(){
        return loginToKNIMEHub().clickAvatarProfile().clickUserSpaces().createSpace(SpaceTypes.PRIVATE)
                .verifySpaceCreatedMessage();
    }

    private UserDashboardPage loginToKNIMEHub(){
        return new HomePage().clickAcceptCookies().clickOnSignInButton().enterUsername(GlobalConstants.getPropertyMap().get("username"))
                .enterPassword(GlobalConstants.getPropertyMap().get("password")).clickSubmitButton();
    }

}
