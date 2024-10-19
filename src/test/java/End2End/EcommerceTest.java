package End2End;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;


public class EcommerceTest {

	
	public static void main(String[] args) {
		
		RequestSpecification loginreq = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com/") //https://rahulshettyacademy.com/client/
				.setContentType(ContentType.JSON)
				.build();

	
	
	//-------------LOGIN--------------
		//CREATING AN OBJECT FOR POJO CLASS LOGIN
		Login loginobj = new Login();
		//SET USERNAME
		loginobj.setUserEmail("nishith@gmail.com");
		//SET PASSWORD
		loginobj.setUserPassword("Rest@ssured1");
		
		//RECEIVE THE TOKEN AS A STRING
		String AuthToken = 
		given()
			.spec(loginreq)
			.body(loginobj)
			.log().all().
		when().
			post("api/ecom/auth/login")
		
		.then()
			.statusCode(200)
			.log().all().extract().asString();
		
		//CONVERT THE STRING RESPONSE TOKEN INTO JSONPATH
		//Alternatively, you can create separate LOGIN Classes for serialization and de-serialization
		JsonPath jtoken = new JsonPath(AuthToken);
		//RETRIEVE THE "token" NODE FROM THE RESPONSE 
		String token = jtoken.getString("token");
		String userId = jtoken.getString("userId");
		//String token = AuthToken.getToken();
		//System.out.println(token);
		
		

		//--------------CREATE PRODUCT------------------
		RequestSpecification prodspec = new RequestSpecBuilder()
			.setBaseUri("https://rahulshettyacademy.com/")
			.addHeader("Authorization", token)
			.build();
	
	
		String newProdDetails=
		given()
			.spec(prodspec)
			.param("productName", "rasgulla")
			.param("productAddedBy", userId)
			.param("productCategory", "Dessert")
			.param("productSubCategory", "Sweets")
			.param("productPrice", "11500")
			.param("productDescription", "Addias Originals")
			.param("productFor", "men")
			.multiPart("productImage",new File("/Users/Nish/Pictures/Screenshots/iphone.png"))
			//.log().all()
		.when()
			.post("api/ecom/product/add-product")
		.then()
			.statusCode(201)
			.log().all()
			.extract().asString();
		
		JsonPath jnewprod = new JsonPath(newProdDetails);
		//System.out.println(jnewprod.getString("productId"));
		String productId = jnewprod.getString("productId");
		//System.out.println(jnewprod.getString("message"));

		
		//----------------CREATE AN ORDER------------------
		
		
		//---NEW PAYLOAD------
	/*	{
		    "orders": [
		        {
		            "country": "United States",
		            "productOrderedId": "6581ca979fd99c85e8ee7faf"
		        }
		    ]
		}*/
		
		//CREATE ORDER DETAILS FROM OrderDetails CLASS - THERE CAN BE MULTIPLE ORDER DETAILS FROM THE OrderDetails Class.
		OrderDetails orderdetails = new OrderDetails();
		orderdetails.setCountry("United States");
		orderdetails.setProductOrderedId(productId);
		
		//CREATE A LIST TO ADD THE ABOVE CREATED ORDER DETAILS LIST
		List<OrderDetails> orderlist = new ArrayList<OrderDetails>();
		orderlist.add(orderdetails); //create a loop to add multiple objects to the list one by one
		
		//CREATE A CREATEORDER CLASS OBJECT AND PASS THE ABOVE CREATED LIST
		CreateOrder newProd = new CreateOrder();
		newProd.setOrders(orderlist);
		
		
		//---------USE THE ABOVE CREATED PAYLOAD TO CREATE THE ORDER THROUGH POST REQUEST-------
		
		String resOrder=
		given()
			.log().all()
			.spec(prodspec)
			.contentType("application/json")
			.body(newProd)		
		.when()
			.post("/api/ecom/order/create-order")
		.then()
			.log().all().statusCode(201).extract().asString();
		
		JsonPath jorder = new JsonPath(resOrder);
		String orderId = jorder.getString("orders[0]");
		System.out.println("Order ID = "+orderId);
		
		//------------GET ORDER DETAILS------------------
		
		
		YourOrders response =
		given()
			.log().all()
			.spec(prodspec)
			.queryParam("id", orderId)
		.when()
			.get("api/ecom/order/get-orders-details")
		.then()
			.log().all().statusCode(200).extract().as(YourOrders.class);
		
		
		System.out.println(response.getMessage());
		System.out.println(response.getData().getProductDescription());
		System.out.println(response.getData().getProductImage());
	
		
		
		//------------------DELETE ORDER----------------
		//YET TO BE IMPLEMENTED
		
		
		
		
		//-------------------------DELETE PRODUCT------------------------------
		
		
		given()
			.spec(prodspec)
			.pathParam("productID", productId)
			.log().all()
		.when()
			.delete("api/ecom/product/delete-product/{productID}")
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
