package com.herokuapp.restfullbooker;
import static io.restassured.RestAssured.*;

import javax.mail.internet.ContentType;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class BaseTest {
	
	protected Response createBooking() {
		//Create JSON Body
		  JSONObject body = new JSONObject();
		  body.put("firstname", "Nishith");
		  body.put("lastname", "Ritchie");
		  body.put("totalprice", 777);
		  body.put("depositpaid", true);
		  
		  JSONObject bookingdates = new JSONObject();
		  bookingdates.put("checkin","2018-01-01");
		  bookingdates.put("checkout","2019-01-01");
		  
		  body.put("bookingdates", bookingdates);
		  body.put("additionalneeds", "complimentary-breakfast");
		  
		  //Get Response
		  Response response = 
				  given().header("Content-Type","application.json")
				  		.body(body.toString())
				  .when().post("https://restful-booker.herokuapp.com/booking")
				  .then().extract().response();
		
		  return response;
	}


}
