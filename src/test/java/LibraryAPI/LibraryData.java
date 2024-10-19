package LibraryAPI;

import io.restassured.RestAssured;

public class LibraryData {
	
	
	
	public static String BaseURI()
	{
		return RestAssured.baseURI = "http://216.10.245.166/"; //or https://rahulshettyacademy.com
	}
	
	
	
	public static String CreateBook(String name, int serial)
	{
		String reqBody = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+name+"\",\r\n"
				+ "\"aisle\":"+serial+",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		
				
		return reqBody;
	}
	
	public static String BookID(String name, int serial)
	{
		String ID = name+serial;
		//System.out.println(ID);
		String bookId = "{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+ID+"\"\r\n"
				+ " \r\n"
				+ "} \r\n"
				+ "";
		return bookId;
	}

}
