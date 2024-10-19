package LibraryAPI;
import static io.restassured.RestAssured.*;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;


//OPEN POSTMAN TO VISUALIZE THE PAYLOADS


public class LibraryAPI {
	
	//PARAMETERIZING DATA
	@DataProvider(name = "NewBooks")
	public Object[][] getData()
	{
		//array = collection of elements
		//multidimensional array = collection of arrays. Each array represents one iteration. Can hold multiple data types
		Object[][] newbooks = new Object[][] {{"Nish",100},{"Rich",200}}; //2 Iterations
		return newbooks;
	}
	
	//CREATE A BOOK
	@Test(priority = 1, dataProvider = "NewBooks")
	public void NewBook(String name, int serial)
	{
		given()
			.body(LibraryData.CreateBook(name, serial))
			.log().all()
		.when()
			.post(LibraryData.BaseURI() + "Library/Addbook.php")
		.then()
			.log().all()
			.statusCode(200);
		System.out.println("-------------------------END of NewBook----------------------------------------");
	}
	
	
	//GET A BOOK
	@Test(priority = 2, dataProvider = "NewBooks")
	public void GetBook(String name, int serial)
	{
		String ID = name+serial;
		String BookDetails =
		given()
			.queryParam("ID", ID)
			.log().all()
		.when()
			.get(LibraryData.BaseURI() + "Library/GetBook.php")
		.then()
			.log().all()
			.statusCode(200)
			.extract()
			.response()
			.asString();
		
		//CREATING A JSONPATH OBJECT TO FETCH THE RESPONSE BODY AND TRAVERSE THROUGH IT
		JsonPath jp = new JsonPath(BookDetails);
		//ASSERTING USING JSONPATH
		jp.getString("[0].book_name").equalsIgnoreCase("Learn Appium Automation with Java");
		//ASSERTING USING SOFTASSERTS
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(jp.getString("[0].author"), "John foe");
		sa.assertAll();
		
		System.out.println("--------------------------------------------------------------");
	}
	
	@Test(priority = 3)
	public void GetAllBooks()
	{
		String AllBooks =
				
				given()
					.queryParam("AuthorName", "John foe")
					.log().all()
				.when()
					.get(LibraryData.BaseURI() + "Library/GetBook.php")
				.then()
					//.log().all()
					.statusCode(200)
					.extract()
					.response()
					.asString();
		
		JsonPath allbooks = new JsonPath(AllBooks);
		//int count = allbooks.getList("$").size(); //TO FIND THE SIZE OF A JSON BODY [{},{},{},{}] - HERE THE LIST HAS NO NAME
		//OR
		int count = allbooks.getInt("size()");//This also works to find the size
		System.out.println(count);
		//System.out.println(allbooks.getString("[1].isbn"));
		List<String> bookNames = allbooks.getList("book_name");
		SoftAssert sa = new SoftAssert();
		for (String bookname : bookNames)
		{
			//System.out.println(bookname);
			sa.assertEquals(bookname, "Learn Appium Automation with Java");
			sa.assertAll();
		}
		
		System.out.println("--------------------------------------------------------------");
		
	}
	
	//DELETING A BOOK
	@Test(priority = 4, dataProvider = "NewBooks")
	public void RemoveBook(String name, int serial)
	{
		given()
		.body(LibraryData.BookID(name,serial))
		.log().all()
	.when()
		.delete(LibraryData.BaseURI() + "Library/DeleteBook.php")
	.then()
		.log().all()
		.statusCode(200);
		System.out.println("--------------------------------------------------------------");
	}

}

	
