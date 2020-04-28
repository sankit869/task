package fisdomSpecs;

import commonutils.curdUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class FisdomTest extends  BaseTest implements EndPoint{
    public curdUtils curdUtils;
    Response response;
    private int bookingid ;
    private String token;
    Random rand = new Random(1000);


    @BeforeClass
    public void getToken(){
        response=curdUtils.getinstance().postRequestBasic(EndPoint.AUTH,"auth.json");
        token = response.getBody().jsonPath().get("token");
    }

    @Test(priority=1)
    public void createBooking(){
        response=curdUtils.getinstance().postRequestBasic(EndPoint.CREATEBOOKING,"createbooking.json");
        bookingid = response.body().jsonPath().get("bookingid");
        response.then().assertThat().statusCode(200);
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.firstname"),"Test");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.lastname"),"Automation");
        softAssert.assertEquals(response.getBody().jsonPath().getInt("booking.totalprice"),1000);
        softAssert.assertEquals(response.getBody().jsonPath().getBoolean("booking.depositpaid"),true);
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.additionalneeds"),"Breakfast");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.bookingdates.checkin"),"2020-05-01");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.bookingdates.checkout"),"2020-05-03");
        softAssert.assertAll();

    }
    @Test
    public void createBookingwithoutAdditionalneeds(){
        response=curdUtils.getinstance().postRequestBasic(EndPoint.CREATEBOOKING,"createbooking.json");
        response.then().assertThat().statusCode(200);
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.firstname"),"Test");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.lastname"),"Automation");
        softAssert.assertEquals((response.getBody().jsonPath().getInt("booking.totalprice")) ,1000);
        softAssert.assertEquals(response.getBody().jsonPath().getBoolean("booking.depositpaid"),true);
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.bookingdates.checkin"),"2020-05-01");
        softAssert.assertEquals(response.getBody().jsonPath().get("booking.bookingdates.checkout"),"2020-05-03");
        softAssert.assertAll();


    }
    @Test(priority=2)
    public void testBookedDetails(){
        System.out.println(EndPoint.GETBOOKING+bookingid);
        response = curdUtils.getinstance().getRequest(EndPoint.GETBOOKING+bookingid);
        response.then().assertThat().statusCode(200);
        softAssert.assertEquals(response.getBody().jsonPath().get("firstname"),"Test");
        softAssert.assertEquals(response.getBody().jsonPath().get("lastname"),"Automation");
        softAssert.assertEquals(response.getBody().jsonPath().getInt("totalprice"),1000);
        softAssert.assertEquals(response.getBody().jsonPath().getBoolean("depositpaid"),true);
        softAssert.assertEquals(response.getBody().jsonPath().get("additionalneeds"),"Breakfast");
        softAssert.assertEquals(response.getBody().jsonPath().get("bookingdates.checkin"),"2020-05-01");
        softAssert.assertEquals(response.getBody().jsonPath().get("bookingdates.checkout"),"2020-05-03");
        softAssert.assertAll();
    }
    @Test(priority=3)
    public void TestUpdateBooking(){
        response = curdUtils.getinstance().putRequest(EndPoint.GETBOOKING+bookingid, "updatebooking.json","Cookie","token="+token);
        response.then().assertThat().statusCode(200);
    }
    @Test(priority=4)
    public void TestUpdatePartialBooking(){
        response = curdUtils.getinstance().putRequest(EndPoint.GETBOOKING+bookingid, "partialupdatebooking.json","Cookie","token="+token);
        response.then().assertThat().statusCode(200);
    }
    @Test(priority = 5)
    public void TestUpdatewithInvalidBooking(){
        response = curdUtils.getinstance().putRequest(EndPoint.GETBOOKING+rand, "partialupdatebooking.json","Cookie","token="+token);
        response.then().assertThat().statusCode(405);
        // here http code should be 404 api should not handle.
    }
    @Test(priority=6)
    public void TestDeleteBooking(){
        response = curdUtils.getinstance().deleteRequest(EndPoint.GETBOOKING+bookingid,"Cookie","token="+token);
        response.then().assertThat().statusCode(201);
    }
    @Test(priority=7)
    public void TestDeleteInvalidBooking(){
        response = curdUtils.getinstance().deleteRequest(EndPoint.GETBOOKING+rand,"Cookie","token="+token);
        response.then().assertThat().statusCode(405);
    }
    @Test
    public void getTest(){
        response = curdUtils.getinstance().getRequest(EndPoint.GETBOOKING+rand);
        response.then().assertThat().statusCode(404);
    }
    @Test
    public void TestUpdatewithInvalidToken(){
        response = curdUtils.getinstance().putRequest(EndPoint.GETBOOKING+rand, "partialupdatebooking.json","Cookie","token=abc");
        response.then().assertThat().statusCode(403);
    }

}
