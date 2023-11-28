package api_Testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginTest {
	
// Using valid credentials
	@Test(priority= 0)
	public void loginTC_01() {
		
	RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	Response res = RestAssured.given().headers("Content-Type","application/json").when()
			.body("{\"username\":\"guptamonika@tekarch.com\",\"password\":\"Admin123\"}")
			.post("/login").then().assertThat().statusCode(201).extract().response();
	
//	Response res1 = RestAssured.given().contentType(ContentType.JSON).when().body("").post("");
		
	System.out.println(res.asPrettyString());	  	
	
	}
	
	
//Using invalid credential
//	@Test
	public void loginTC_02() {
		
	RestAssured.baseURI	= "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	Response res = RestAssured.given().headers("Content-Type","application/json").when()
			.body("{\"username\":\"guptamonika@tekarch.com1\",\"password\":\"Admin12\"}")
			.post("/login").then().assertThat().statusCode(401).extract().response();;
		
	System.out.println(res.asPrettyString());
	
	}
	
//using invalid endpoint
	@Test
	public void loginTest_03() {
		
	RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	Response res = RestAssured.given().headers("Content-Type","application/json").when()
			.body("{\"username\":\"guptamonika@tekarch.com\",\"password\":\"Admin123\"}")
			.post("/getdata").then().assertThat().statusCode(403).extract().response();;
			
	System.out.println(res.asPrettyString());	  	
		
	}
	
//Using wrong json 
//	@Test
	public void loginTest_04() {
		
	RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	Response res = RestAssured.given().headers("Content-Type","application/javascript").when()
			.body("{\"username\":\"guptamonika@tekarch.com\",\"password\":\"Admin123\"}")
			.post("/login").then().assertThat().statusCode(200).extract().response();;
				
	System.out.println(res.asPrettyString());	  	
			
		
	}
	
//using bad Request
//	@Test
	public void loginTest_05() {
		
	RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	Response res = RestAssured.given().headers("Content-Type","application/json").when()
			.body("{\"username\":\"guptamonika@tekarch.com\",\"password\":\"Admin123\"}")
			.put("/login").then().assertThat().statusCode(403).extract().response();;
				
	System.out.println(res.asPrettyString());	  	
			
	}
	
		
}
	
	

