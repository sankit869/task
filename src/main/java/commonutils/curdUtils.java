package commonutils;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;


public class curdUtils{
	public static curdUtils curd;
	Response response;

	
	public static curdUtils getinstance() {
		if(curd==null) {
			curd= new curdUtils();
			
		}
		return curd;
		
	}

	public Response getRequest(String request) {

		response = given().when().get(request);
			return response;
	}
	public io.restassured.response.Response postRequestBasic(String request, String payload) {
			response = given().contentType("application/json").body(payload).post(request);
			return response;
	}

	public Response putRequest(String url, String payLoad, String header, String headerVal) {
			response = given().header(header,headerVal).contentType("application/json").body(payLoad).put(url);
			return response;
	}
	public Response deleteRequest(String url, String header, String headerVal) {
		response = given().header(header,headerVal).contentType("application/json").delete(url);
		return response;
	}

	
	

}
