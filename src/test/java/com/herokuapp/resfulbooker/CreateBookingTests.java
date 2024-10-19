package com.herokuapp.resfulbooker;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.restfullbooker.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class CreateBookingTests extends BaseTest{
  @Test
  public void createBookingTest() {
	  
	  Response response = createBooking();
	  response.print();
	  //Check Response Status
	  Assert.assertEquals(response.getStatusCode(), 200, "Booking Creation Failed !");
	  
	  //Verification
	  Response getresponse = RestAssured.get("https://restful-booker.herokuapp.com/booking/1851");
	  SoftAssert softassert = new SoftAssert();
	  
	  //First Name validation
	  String firstName = getresponse.jsonPath().getString("firstname");
	  softassert.assertEquals(firstName, "Nishith", "FirstName is not matching");
	  
	  //Checkin Date validation
	  String checkindate = response.jsonPath().getString("booking.bookingdates.checkin");
	  softassert.assertEquals(checkindate, "2018-01-01");
	  
	  
	  softassert.assertAll();
	  
	 
  }


/*
 * HTTP/1.1 200 OK

{
    "bookingid": 1,
    "booking": {
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
}
 */

}
