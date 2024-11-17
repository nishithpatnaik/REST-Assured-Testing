package CakePojo;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class Test_Cakes {

	public static void main(String[] args) throws IOException {
	
		String cake_payload = Payload_Cakes.getCakePayload();
		//System.out.println(cake_payload);
		
		
		  defaultParser = Parser.JSON;
		  
		  POJO_Cake_Root response = given() 
				  .contentType("ContentType.JSON") //  simulate the JSON content type 
				  .body(cake_payload) // pass the JSON string as  the body 
				  .post("/fakeUrl") // fake URL, won't make an actual call
		  .as(POJO_Cake_Root.class); // deserialize directly into User POJO
		  
		  System.out.println(response.getItems());
		 
		 
		
		
		  /*JsonPath jp = new JsonPath(cake_payload); 
		  POJO_Cake_Root response =  jp.getObject("", POJO_Cake_Root.class);
		  System.out.println(response.getItems().getItem().get(0).getName());
		  System.out.println(response.getItems().getItem().get(0).getPpu());
		  int count = response.getItems().getItem().size();
		  
		  for(int i=0;i<count;i++)
		  {
			  System.out.println(response.getItems().getItem().get(i).getBatters().getBatter().get(2).getType());
		  }
		  
		  int toppingcount = response.getItems().getItem().get(0).getTopping().size();
		  for (int j=0;j<toppingcount;j++)
		  {
			  System.out.println(response.getItems().getItem().get(0).getTopping().get(j).getType());
			  
		  }*/
		 
				

	}

}
