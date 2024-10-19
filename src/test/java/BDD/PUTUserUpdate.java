package BDD;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;




public class PUTUserUpdate {
	
	@Test
	public void putUserUpdate() {
		
/*		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name","Ritchie");
		map.put("job","Flare");
		System.out.println(map);*/
		
		JSONObject body = new JSONObject();
		body.put("name","Ritchie");
		body.put("job","Flare");
		System.out.println(body.toJSONString());
		
		
		baseURI = "https://reqres.in/api";
				
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(body.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
		
		
	}
	
	

}
