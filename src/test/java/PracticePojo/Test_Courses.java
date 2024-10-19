package PracticePojo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import POJO.DeSerializeRoot;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;


public class Test_Courses {
	
	static String access_token;
	@Test(priority = 1)
	public static void DeserializeToken()
	{
		
		//Extracting token using PojoAcessToken Class
		PojoAccessToken token = 
		given()
			.log().all()
			.baseUri("https://rahulshettyacademy.com/oauthapi/")
			.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
			.formParam("scope", "trust")
			.formParam("grant_type", "client_credentials")
		.when()
			.post("oauth2/resourceOwner/token")
		.then()
			.log().all()
			.statusCode(200).extract().as(PojoAccessToken.class); //EXTRACTING AS A POJO CLASS
		
		access_token = token.getAccess_token();
		
		System.out.println("------------------------------------------------------------------------------------");
		
	}
	
	
	
	@Test(priority = 2)
	public void DeserializeCourses()
	{
		Pojo_CoursesMain rootRes = 
			given()
				.queryParam("access_token", access_token)
				.baseUri("https://rahulshettyacademy.com/oauthapi/")
			.when()
				
				.get("getCourseDetails")
			.then()
				.log().all()
				.statusCode(401)
				//.extract().asString();
				.extract().as(Pojo_CoursesMain.class); //EXTRACTING AS A POJO CLASS
		
			
	
	//DESERIALIZING
		//System.out.println("response= "+rootRes);
		System.out.println(rootRes.getLinkedIn());
		
	}
	
	
	@Ignore
	public void ExternalFile() throws IOException //USING EXTERNAL FILE FOR GET METHOD. JSONPATH TO EXTRACT
	{
		//Fetching the JSON Body directly from an external file
		String JsonBody = new String(Files.readAllBytes(Paths.get("C:\\Users\\Nish\\eclipse-workspace\\RahulShetty_API Document\\Courses.json")));
		//List<String> JsonBody = Files.readAllLines(Paths.get("C:\\Users\\Nish\\eclipse-workspace\\RahulShetty_API Document\\samplePayload.json"));
		JsonPath js = new JsonPath(JsonBody);
		
		//Fetching the Size of array webAutomation from the json
		int WebAutomation = js.getInt("courses.webAutomation.size()");
		
		//looping through the WebAutomation array to print courseTile
		  for(int i = 0 ; i<WebAutomation; i++) 
		  {
		  System.out.println(js.getString("courses.webAutomation["+i+"].courseTitle"));
		  }
		 
		
		
	}
	
	
}
