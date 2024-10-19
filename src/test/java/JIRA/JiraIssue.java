package JIRA;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;



public class JiraIssue {

	@Test
	public void CreateBug()
	{
		//RestAssured.baseURI = "https://nishithpatnaik.atlassian.net/";
		
		String BugDetails = 
		given()
			.header("Authorization",JIRAData.Auth())
			.header("Content-Type","application/json")
			.body(JIRAData.BugData())
			.log().all()
		.when()
			.post(JIRAData.BaseURI()+ "rest/api/2/issue")
		.then()
			.log().all()
			.statusCode(201)
			.extract().response().asString();
		
		JsonPath js = new JsonPath(BugDetails);
		String BugID = js.getString("id");
		System.out.println(BugID);
		
		//ADD Attachment
		given()
			.header("X-Atlassian-Token","no-check")
			.header("Authorization",JIRAData.Auth())
			.pathParam("issueID", BugID)
			.multiPart("file", new File("/Users/Nish/Pictures/Screenshots/iphone.png"))
			.log().all()
		.when()
			.post(JIRAData.BaseURI()+ "rest/api/2/issue/{issueID}/attachments")
		.then()
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void DeleteBug()
	{
		given()
			.header("Authorization",JIRAData.Auth())
			.pathParam("issueID", "SCRUM-10")
			.log().all()
		.when()
			.delete(JIRAData.BaseURI()+ "rest/api/2/issue/{issueID}")
		.then()
			.statusCode(204)
			.log().all();
	}
	
	@Test
	public void GetBug()
	{
		given()
		.header("Authorization",JIRAData.Auth())
		.pathParam("issueID", "SCRUM-10")
		.log().all()
	.when()
		.get(JIRAData.BaseURI()+ "rest/api/2/issue/{issueID}")
	.then()
		.statusCode(200)
		.log().all();
	}
}
	

