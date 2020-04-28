package fisdomSpecs;

import apiservice.FisdomService;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    public FisdomService fisdomService = new FisdomService();
    public SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void setBaseURI(){
        RestAssured.baseURI=EndPoint.BASEURI;
    }
}
