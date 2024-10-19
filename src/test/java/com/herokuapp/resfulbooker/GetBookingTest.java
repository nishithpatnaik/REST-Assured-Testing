package com.herokuapp.resfulbooker;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingTest {
  @Test
  public void getBookingIds_OldFashion() 
  {
	  Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/5");
	  response.print();
	  Assert.assertEquals(response.getStatusCode(), 200, "Response is NOT 200");
	  //Verify All Fields
	  SoftAssert softassert = new SoftAssert();
	  
	  //FirstName
	  String actualFirstName = response.jsonPath().getString("firstname");
	  softassert.assertEquals(actualFirstName, "Mary", "First Name does not Match the Actual First Name");
	  
	  //LastName
	  String lastName = response.jsonPath().getString("lastname");
	  
	  //TotalPrice
	  int totalprice = response.jsonPath().getInt("totalprice");
	  softassert.assertEquals(totalprice, 664, "Price does not match");
	  
	  //Deposit Paid Status
	  boolean depositpaid = response.jsonPath().getBoolean("depositpaid");
	  softassert.assertTrue(depositpaid, "Deposit Paid Should Be True");
	  
	  //Checkout Date
	  String checkoutDate = response.jsonPath().getString("bookingdates.checkout");
	  softassert.assertEquals(checkoutDate,"2021-01-18");
	
	  softassert.assertAll();
	  
  }
}
