package com.herokuapp.resfulbooker;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingID_OldFashion {
  @Test
  public void getBookingIds_OldFashion() 
  {
	  Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
	  //response.print();
	  Assert.assertEquals(response.getStatusCode(), 200, "Status Code returned is not 200");
	  
	  
	  List<Integer> bookingIds = response.jsonPath().getList("bookingid");
	  Assert.assertFalse(bookingIds.isEmpty(), "List is empty, but should not be");
	  
  }
}
