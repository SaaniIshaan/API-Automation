package apitests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

//import org.asynchttpclient.uri.Uri;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;

import api.constants.FileConstants;
import api.testdata.AddUser;
import api.testdata.DeleteUser;
import api.testdata.GetUser;
import api.testdata.UpdateUser;
import api.utils.CommonUtilities;
import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class LoginTest extends APIBaseTest{
	
	
	@BeforeClass
	public void setURI() throws IOException {
		
		String uri = CommonUtilities.readFileAndReturnString(FileConstants.URI_FILE_PATH);
		RestAssured.baseURI = JsonPath.read(uri, "$.login.prod");
		System.out.println(RestAssured.baseURI);
	}
		
	@Test(enabled = true)
	public void loginTC_01() throws IOException {
		
	
		APIBaseTest.test = extent.createTest("login test");
	

		HashMap<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
	 
		HashMap<String,String> logincreds = new HashMap<>();
		logincreds.put("username", "guptamonika@tekarch.com");
		logincreds.put("password","Admin123");
	 	test.info("credntial provided");
	
	 	Response res = RestUtils.postReq( logincreds, headers, JsonPath.read(uri, "$.login.endpoints.login"));
	 		res.then().assertThat().statusCode(201).extract().response();
			
	 		res.then().assertThat().body(matchesJsonSchema(new File(FileConstants.LOGIN_SCHEMA)));
			
	 		System.out.println(res.asPrettyString());
	 			
	 		APIBaseTest.extent.flush();
	 
	
	}
	
	
	// @Test(enabled = true)
	 
	 public void getData_TC02() {
		 
	 HashMap<String, String> headers = new HashMap<>();
	  
	 headers.put("Token", token);
	 headers.put("Content-Type", "application/json");
	 
	 Response getUserData = RestUtils.getReq( headers, JsonPath.read(uri, "$.login.endpoints.getdata"));
	 getUserData.then().assertThat().statusCode(200).extract().response();
	 
	 getUserData.then().assertThat().body(matchesJsonSchema(new File(FileConstants.GET_DATA_SCHEMA)));
	 System.out.println(getUserData.prettyPrint());
	 
	 	
	 List<String> accountNumbers = getUserData.jsonPath().getList("accountno");
			assertThat(accountNumbers.size(),greaterThan(10000));
	 		 System.out.println(getUserData.prettyPrint());
	
	 }

	 
	// @Test(enabled = true)
	 
	 public void addData_TC02() throws JsonProcessingException {
		 
		 HashMap<String, String> headers = new HashMap<>();
		 headers.put("Token", token);
		 headers.put("Content-Type", "application/json");
		 
		 AddUser adduser = new AddUser("TA-1234000", "1","987654","90000");
		 
		 String sPayload = CommonUtilities.serializeObject(adduser);
		 
		 Response addUserData = RestUtils.postReq( sPayload, headers, JsonPath.read(uri,"$.login.endpoints.adddata"));
		 addUserData.then().assertThat().statusCode(201).extract().response();
		 
		 addUserData.then().assertThat().body(matchesJsonSchema(new File(FileConstants.ADD_DATA_SCHEMA)));
		 System.out.println( addUserData.prettyPrint());
		 
		 
	 }
	 
		@Test(enabled = true)
	 	public void updateData_TC02() throws JsonProcessingException {
		 
		 HashMap<String, String> headers = new HashMap<>();
		 headers.put("Token", token);
		 headers.put("Content-Type", "application/json");
		 
		 UpdateUser updateuser = new UpdateUser("TA-1234000", "2", "70000", "123450","3NFEupEYQGG2EFz1gvBG","4MtcFy4uKNmYGQTkkmLv");
		 
		 String sPayload = CommonUtilities.serializeObject(updateuser);
		 System.out.println(sPayload);
		 Response updateUserData = RestUtils.putReq( sPayload, headers, JsonPath.read(uri,"$.login.endpoints.updatedata"));
		 updateUserData.then().assertThat().statusCode(201).extract().response();
		 
		 updateUserData.then().assertThat().body(matchesJsonSchema(new File(FileConstants.UPDATE_DATA_SCHEMA)));
		 System.out.println( updateUserData.prettyPrint());
		 
		 
	  }
	 
//	 @Test(enabled = true)
	 
	 public void deleteData_TC02() throws JsonProcessingException {
	 
		 HashMap<String, String> headers = new HashMap<>();
		 headers.put("Token", token);
		 headers.put("Content-Type", "application/json");
		 
		 DeleteUser deleteuser = new DeleteUser("3NFEupEYQGG2EFz1gvBG","K1uwjdavSPFVMrPTnMAM");
		 
		String sPayload = CommonUtilities.serializeObject(deleteuser);
		
		Response deleteUserData = RestUtils.deleteReq(sPayload, headers, JsonPath.read(uri,"$.login.endpoints.deletedata"));
		deleteUserData.then().assertThat().statusCode(200).extract().response();
		
		deleteUserData.then().assertThat().body(matchesJsonSchema(new File(FileConstants.DELETE_DATA_SCHEMA)));
		System.out.println( deleteUserData.prettyPrint());
		
	 }	
		
 }
	
