package POJO_Serialize;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;


public class SerializeRoot {
	
	@Test
	public void SetBody()
	{
	AddPlace a = new AddPlace();
	a.setAccuracy(777);
	a.setName("Nishith");
	a.setPhone_number("(+91) 983 893 3937");
	a.setAddress("8714 beacon tree ln, apt 5");
	List<String> types = new ArrayList<String>();
	types.add("shoe park");
	types.add("shop");
	a.setTypes(types);
	a.setWebsite("https://www.google.com");
	a.setLanguage("Hindi");
	Location l = new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	a.setLocation(l);
	
	
	RestAssured.baseURI = "https://rahulshettyacademy.com/";
	
	//String response = 
	given()
		.queryParam("key", "qaclick123")
		.body(a)
		.log().all()
	.when()
		.post("maps/api/place/add/json")
	.then()
	.statusCode(200)
	.log().all().extract().asPrettyString();
	
	//System.out.println(response);
	
	
	
	
	}
	
	
	
}
