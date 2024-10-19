package com.herokuapp.resfulbooker;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetBookingIdsTest {
	
	@Test
	public void GetBookingIdsTest()
	{
		given().
		when().
			get("https://restful-booker.herokuapp.com/booking").
		then().
			assertThat().statusCode(200);
	}
	
	

}
