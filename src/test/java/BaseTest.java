import constants.GlobalConstants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverUtil;

public class BaseTest {

    @BeforeMethod
    public void setup(){
        DriverUtil.getWebDriver().get(GlobalConstants.getPropertyMap().get("url"));
    }


    @AfterMethod
    public void teardown(){
        DriverUtil.unloadWebDriver();
    }


}
