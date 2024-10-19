package JSONSchemaValidation;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.testng.annotations.Test;

public class SchemaTestBookingDetails {
	
	//GET BOOKING DETAILS - http://rahulshettyacademy.com/maps/api/place/get/json?place_id=aa7a30d500e7510d38bc159d5f8a6268&key=qaclick123
	@Test
	public void JsonSchemaTest()
	{
	
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		given()
			.log().all()
			.queryParam("key", "qaclick123").
			
		when()
			.get("/maps/api/place/get/json?place_id=aa7a30d500e7510d38bc159d5f8a6268").
		then()
			.assertThat()
			.body(matchesJsonSchemaInClasspath("BookingDetails_schema.json")) //Stored at "C:\Users\Nish\eclipse-workspace\REST Assured Testing\target\classes\BookingDetails_schema.json"
			.statusCode(200)
			.log().all();
		}

}


