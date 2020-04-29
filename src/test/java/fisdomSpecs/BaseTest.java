package fisdomSpecs;

import commonutils.Utils;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class BaseTest {
    public SoftAssert softAssert = new SoftAssert();
    String filepath ="/home/ankits/Desktop/ankit/task/config.properties";
    Utils util = new Utils();
    @BeforeClass
    public void setBaseURI() throws IOException {
        RestAssured.baseURI= (String) util.propertiesFileReader("BASEURI",filepath);
    }
}
