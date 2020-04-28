package commonutils;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import java.io.File;


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
	public Response postRequestBasic(String request, String filename) {
			response = given().contentType("application/json").
					body(new File(System.getProperty("user.dir")+"/testdata//inputjson//"+filename))
					.post(request);
			return response;
	}

	public Response putRequest(String url, String filename, String header, String headerVal) {
			response = given().header(header,headerVal).contentType("application/json").
					body(new File(System.getProperty("user.dir")+"/testdata//inputjson//"+filename))
					.put(url);
			return response;
	}
	public Response deleteRequest(String url, String header, String headerVal) {
		response = given().header(header,headerVal).contentType("application/json").delete(url);
		return response;
	}

	
	

}
