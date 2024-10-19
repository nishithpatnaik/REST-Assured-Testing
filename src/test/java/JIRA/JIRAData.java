package JIRA;

import io.restassured.RestAssured;

public class JIRAData {
	
	public static String BaseURI()
	{
		return RestAssured.baseURI = "https://nishithpatnaik.atlassian.net/";
	}
	
	public static String Auth()
	{
		String basicAuth = "Basic bmlzaGl0aHBhdG5haWtAZ21haWwuY29tOkFUQVRUM3hGZkdGMG0tWWJDOFdZNmhSaC1pSXhISFVsQ0hwWFJCZ21uNWo4R3R3S3Y1TjExdVVhQU0xQ1F2T3A3S3pfdVYtems2MXoyM2h4S3VTY2tPaGFMbjE3a0tuXzVfRUljX2xQdU1SNG1sRHlIUzhQTDdCODIyVmtRMnJYLU5SX192OUtjODVEMGFGNlZoYThjcFVGTVBEWnlTU0ltSzVFazlBb1QxMWhseVYzQWVaMGdNMD01NTM2NzU3Ng==";
		return basicAuth;
	}
	
	
	public static String BugData()
	{
		String bugdata = "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"First Bug via REST Assured\",\r\n"
				+ "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}\r\n"
				+ "";
		
		return bugdata;
	}
}
