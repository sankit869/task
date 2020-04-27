package fisdomSpecs;

import apiservice.FisdomService;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    public FisdomService fisdomService = new FisdomService();
    public SoftAssert softAssert = new SoftAssert();

}
