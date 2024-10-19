package BDD;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class POSTCreateUser {
	
	@Test
	public void postCreateUser() {
		
		baseURI = "https://reqres.in";
		JSONObject jbody = new JSONObject();
		jbody.put("name", "nishith");
		jbody.put("job", "luminate");
				
		given().
			contentType(ContentType.JSON).
			
			body(jbody.toJSONString()).		
		when().
			post("/api/users").
		then().
			statusCode(201).
			body("name",equalTo("nishith")).
			log().all();
		
	}

}
