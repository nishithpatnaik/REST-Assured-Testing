package FilePayload;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

//JSON body for POST method in this example is being read directly from a JSON File
//When you read a file, its in Bytes. We need to convert Bytes into String format for passing into JSON Body

public class JsonFromFile {
	@Test
	public void readJsonFile() throws IOException
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
	
		
		try {
			given()
				.queryParam("key", "qaclick123")
				.header("Content-Type","application/json")
				.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Nish\\eclipse-workspace\\RahulShetty_API Document\\samplePayload.json"))))
				//.body(Files.readAllLines(Paths.get("C:\\Users\\Nish\\eclipse-workspace\\RahulShetty_API Document\\samplePayload.json")))
				.log().all()
			.when()
				.post("maps/api/place/add/json")
			.then()
				.log().all()
				.statusCode(200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
