import io.restassured.response.Response;
import org.testng.annotations.Test;
import reports.ExtentLogger;
import services.CreateSpace;
import services.DeleteSpace;
import utils.api.SpaceNameGenUtil;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class contains API test methods
 *
 */
public class TestAPI extends BaseTest {


    @Test(description = " API test - Public space creation and deletion", groups = "API", enabled = true)
    public void testPublicSpaceCreation(){
        Response response = new CreateSpace().createPublicSpace(false);
        assertThat(response.getStatusCode(), is(201));
        assertThat(response.jsonPath().get("id"), not(blankOrNullString()));
        ExtentLogger.info(SpaceNameGenUtil.getSpaceName()+ " public space created via API");
        ExtentLogger.info("Status line: "+ response.getStatusLine());



        Response deleteResponse = new DeleteSpace().deleteSpace();
        assertThat(deleteResponse.getStatusCode(), is(204));
        ExtentLogger.info(SpaceNameGenUtil.getSpaceName()+" public space deleted via API");
        ExtentLogger.info("Status line: "+ deleteResponse.getStatusLine());
    }

    @Test(description = " API test - Private space creation and deletion", groups = "API", enabled = true)
    public void testPrivateSpaceCreation(){
        Response response = new CreateSpace().createPrivateSpace(false);
        assertThat(response.getStatusCode(), is(201));
        assertThat(response.jsonPath().get("id"), not(blankOrNullString()));
        ExtentLogger.info(SpaceNameGenUtil.getSpaceName()+ " private space created via API");
        ExtentLogger.info("Status line: "+ response.getStatusLine());


        Response deleteResponse = new DeleteSpace().deleteSpace();
        assertThat(deleteResponse.getStatusCode(), is(204));
        ExtentLogger.info(SpaceNameGenUtil.getSpaceName()+" private space deleted via API");
        ExtentLogger.info("Status line: "+ deleteResponse.getStatusLine());

    }



}
