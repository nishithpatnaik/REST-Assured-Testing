package CakePojo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Payload_Cakes {
	
	public static String getCakePayload() throws IOException
	{
		String payload = new String(Files.readAllBytes(Paths.get("C:\\Users\\Nish\\eclipse-workspace\\SampleJSONs\\Cake.json")));
		
		return payload;
		
	}

}
