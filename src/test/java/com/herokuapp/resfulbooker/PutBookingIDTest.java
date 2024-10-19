package com.herokuapp.resfulbooker;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.restfullbooker.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutBookingIDTest extends BaseTest
{
  @Test
  public void putBookingIDTest() 
  {
	  //Create a response object which will receive the Created Booking Details
	  Response responseCreate = createBooking();
	  responseCreate.print();
	  
	  //Verify that the Booking was successfully Created
	  Assert.assertEquals(responseCreate.statusCode(), 200, "Booking Creation Failed !");
	  
	  //Create a JSON Object Body 
	  JSONObject body = new JSONObject();
	  body.put("firstname","Nishith");
	  body.put("lastname","Ritchie");
	  body.put("totalprice",777);
	  body.put("depositpaid",true);
	  JSONObject bookingdates = new JSONObject();
	  bookingdates.put("checkin", "2024-01-01");
	  bookingdates.put("checkout", "2024-02-02");
	  body.put("bookingdates", bookingdates);
	  body.put("additionalneeds", "complimentary-breakfast");
	  
	  //Fetch the Booking ID that was created
	  int bookingId = responseCreate.jsonPath().getInt("bookingid");
	  
	  //Send the PUT Request and receive the response body with AUTHORIZATION	  
	  Response responsePut = RestAssured.given().auth().preemptive().basic("admin", "password123").contentType(ContentType.JSON).body(body.toString())
			  .put("https://restful-booker.herokuapp.com/booking/:" + bookingId);
	  
	  responsePut.print();
	  
	  //Verification of the PUT Changes
	  Assert.assertEquals(responsePut.getStatusCode(), 200, "PUT request failed");
	  
	  String firstname = responsePut.jsonPath().getString("firstname");
	  SoftAssert softassert = new SoftAssert();
	  softassert.assertEquals(firstname,"Nishith");
	  String checkin = responsePut.jsonPath().getString("bookingdates.checkin");
	  softassert.assertEquals(checkin,"2024-01-01");
	  String checkout = responsePut.jsonPath().getString("bookingdates.checkout");
	  softassert.assertEquals(checkout,"2024-01-01");
	  softassert.assertAll();

	  
  }
}
