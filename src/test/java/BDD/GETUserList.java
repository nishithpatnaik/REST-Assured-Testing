package BDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class GETUserList {
	
	@Test
	public void getUserList()
	{
		baseURI = "https://reqres.in/api/users?page=2";
		given().
			get(baseURI).
		then().
			statusCode(200).
			body("data[0].email",equalTo("michael.lawson@reqres.in")).
			body("data.first_name",hasItems("Michael","Lindsay")).
			log().all();
			
	}

}
