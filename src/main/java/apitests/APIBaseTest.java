package apitests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.jayway.jsonpath.JsonPath;

import api.constants.FileConstants;
import api.utils.CommonUtilities;
import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIBaseTest {
	
	static ExtentReports extent = new ExtentReports();
	static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	
	public static String uri;
	
	public static String token;
	
	public static void  setToken() throws IOException {
		uri = CommonUtilities.readFileAndReturnString(FileConstants.URI_FILE_PATH);
		RestAssured.baseURI = JsonPath.read(uri, "$.login.prod");
		
		String creds = CommonUtilities.readFileAndReturnString(FileConstants.USER_CONFIG_FILE_PATH);
		String un = JsonPath.read(creds, "$.prod.username");
		String pw = JsonPath.read(creds, "$.prod.password");
		
		HashMap<String, String> payload = new HashMap<>();
		payload.put("username", un);
		payload.put("password", pw);
		
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		Response res = RestUtils.postReq( payload, headers, JsonPath.read(uri,"$.login.endpoints.login"));
	//	System.out.println(res.asPrettyString());
		token = JsonPath.read(res.asString(),"$.[0].token");
	
	}
	
	
	@BeforeTest
	public void setUp() throws IOException {
		APIBaseTest.setToken();
		spark = new ExtentSparkReporter(new File(FileConstants.REPORTS_PATH));
		extent.attachReporter(spark);
		
	}
	
}	