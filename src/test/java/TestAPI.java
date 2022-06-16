import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.CreateSpace;

public class TestAPI extends BaseTest {


    @Test(description = "Public space creation API test", groups = "API")
    public void testPublicSpaceCreation(){
        Response response = new CreateSpace().createPublicSpace(false);
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println(response.getBody().toString());
    }

    @Test(description = "Private space creation API test", groups = "API")
    public void testPrivateSpaceCreation(){
        Response response = new CreateSpace().createPrivateSpace(false);
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println(response.getBody().toString());
    }


}
