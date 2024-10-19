package POJO;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PojoMain {

	@Test
	public void PojoCourses() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi/";

		//GENERATE & GRAB TOKEN
		String responseToken = 
			given()
				.formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.formParams("grant_type", "client_credentials")
				.formParams("scope", "trust")
				.log().all()
			.when()
				.post("oauth2/resourceOwner/token")
			.then()
				.log().all()
				.statusCode(200).extract().response().asString();
		
		
		//CREATE JSONPATH OBJECT TO EXTRACT THE TOKEN FROM RESPONSE BODY
		JsonPath js = new JsonPath(responseToken);
		String token = (js.getString("access_token"));
		System.out.println("token = " + token);
		System.out.println("----------------------------------------------------------------");

		
		//--------------------------POJO CLASSES - DESERIALIZATION USING GETTERS-------------------------
		
		DeSerializeRoot responseRoot = //POJO CLASS OBJECT RECEIVES THE DESERIALIZED RESPONSE BODY 
				given()
					.queryParam("access_token", token.toString()) //PASS THE TOKEN AS A QUERY PARAM
					//.log().all()
				.when()
					.log().all()
					.get("getCourseDetails")//.as(DeSerializeRoot.class); //THIS IS HOW POJO RECEIVES THE DESERIALIZED OBJECTS THROUGH THE DESERIALIZEROOT CLASS which we created
				.then().extract().as(DeSerializeRoot.class);
		
		
		
		  System.out.println(responseRoot.getInstructor());
		  System.out.println(responseRoot.getUrl());
		  System.out.println(responseRoot.getServices());
		  System.out.println(responseRoot.getExpertise());
		  System.out.println(responseRoot.getLinkedIn());
		  System.out.println(responseRoot.getCourses().getAPI().get(1).getCourseTitle());
		  System.out.println("Web Automation size = " + responseRoot.getCourses().getWebAutomation().size());
		  
		  
		  //ADDING EXPECTED COURSE TITLES TO AN ARRAY - THIS WILL BE ASSERTED AGAINST THE ACTUAL RESULTS
		  ArrayList<String> expectedcourse = new ArrayList<String>();
		  expectedcourse.add("Rest Assured Automation using Java");
		  expectedcourse.add("SoapUI Webservices testing");
		  
		  //Create a String Array List
		  ArrayList<String> actualcourse = new ArrayList<String>();
		  //CREATE AN ARRAY LIST TO STORE THE VALUES UNDER API LIST
		  //ArrayList<PojoAPI> api = new ArrayList<PojoAPI>(responseRoot.getCourses().getAPI());
		  List<PojoAPI> api = new ArrayList<PojoAPI>(responseRoot.getCourses().getAPI());
		  int apicount= api.size();
		  //LOOP THROUGH API LIST AND PRINT THE NODES
		  for (int i=0;i<apicount;i++)
		  {
			  System.out.println(api.get(i).getCourseTitle());
			  System.out.println(api.get(i).getPrice());
			  actualcourse.add(api.get(i).getCourseTitle());
			  
			  String coursename = api.get(i).getCourseTitle();
			  System.out.println("coursename = "+expectedcourse.contains(coursename));
			  Assert.assertTrue(expectedcourse.contains(coursename));
			  
			  
		  }
		  
		 
		  
		 
		 
		  //expectedcourse.add("Java");
		  
		  Assert.assertTrue(actualcourse.equals(expectedcourse));
	
		 
		
	}

}
