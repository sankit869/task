package fisdomSpecs;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    public SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void setBaseURI(){
        RestAssured.baseURI=EndPoint.BASEURI;
    }
}
