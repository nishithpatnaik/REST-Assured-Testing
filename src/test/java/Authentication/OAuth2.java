package Authentication;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class OAuth2 {

	@Test
	public void GenerateToken() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi/";

		String responseToken = given()
				//param or formParams both work !
				.param("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParams("grant_type", "client_credentials")
				.formParams("scope", "trust").log().all().when().post("oauth2/resourceOwner/token").then().log().all()
				.statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(responseToken);
		// js.prettyPrint()
		String token = (js.getString("access_token"));
		System.out.println(token);
		System.out.println("----------------------------------------------------------------");

		String responseBody = 
				given()
					.queryParam("access_token", token.toString())
					.log().all()
				.when()
					.get("getCourseDetails")
				.then().statusCode(401).body("instructor", equalTo("RahulShetty"))
					.body("courses.mobile", not(empty())) // CHECK IF MOBILE COURSES ARRAY EXISTS OR NOT
					.body("courses.api", notNullValue())// CHECKS IF A KEY CALLED API EXISTS OR NOT
					.log().all()
					.extract().response().asString();

		JsonPath jbody = new JsonPath(responseBody);

		// PRINT ALL THE COURSE TITLES UNDER WEB AUTOMATION
		// ArrayList count = new ArrayList(jbody.getList("courses.webAutomation"));
		// int count1 = jbody.getList("courses.webAutomation").size();
		int count2 = jbody.getInt("courses.webAutomation.size()");
		// System.out.println(webAutomation);
		for (int i = 0; i < count2; i++) {
			System.out.println("Printing courses names and their cost under Web Automation");
			System.out.println(jbody.getString("courses.webAutomation[" + i + "].courseTitle"));
			System.out.println(jbody.getString("courses.webAutomation[" + i + "].price"));

		}
		// CHECK IF COURSE ON MOBILE EXISTS
		Assert.assertTrue(jbody.getList("courses.mobile").size() > 0);
		Assert.assertTrue(jbody.getList("courses.api").size() > 0, "API course exists!");
		SoftAssert softAssert = new SoftAssert();

		// Check if specific course categories exist and are not empty
		softAssert.assertTrue(jbody.getList("courses.webAutomation").size() > 0, "Web Automation courses should exist");
		softAssert.assertAll();

		// Extract all Course Titless irrespective of the parent node

		/*
		 * int coursesize = jbody.getInt("courses.size()");
		 * System.out.println(jbody.getString("$..[*].courseTitle"));
		 * 
		 * for (int k=0;k<coursesize;k++) { int topiccount =
		 * jbody.getInt("courses.webAutomation.size()"); //NEED to find out how to regex
		 * "webAutomation
		 * 
		 * for(int l = 0;l<topiccount;l++) { System.out.println(); }
		 * 
		 * }
		 */
		

		
	}

}
