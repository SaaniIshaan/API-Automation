package api.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import api.testdata.AddUser;
import api.testdata.DeleteUser;
import api.testdata.GetUser;
import api.testdata.UpdateUser;


public class CommonUtilities {
	
	public static String readFileAndReturnString(String filePath) throws IOException {
		
		byte[] fileContents = Files.readAllBytes(Paths.get(filePath));
		
		return new String(fileContents, StandardCharsets.UTF_8);
	}
	
	// To convert object to string and return the same
	public static String serializeObject(Object user) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		om.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CASE);
		String sJsonPayload = om.writeValueAsString(user);
		System.out.println(sJsonPayload) ;
			return sJsonPayload;
	}
	
	public static Object deSerializeJSON(String sJson) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		AddUser adduser = om.readValue(sJson, AddUser.class);
			return adduser;
	}
	
	public static Object deSerializeJSON2(String sJson) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		UpdateUser updateuser = om.readValue(sJson, UpdateUser.class);
			return updateuser;
	}
	
	public static Object deSerializeJSON3(String sJson) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		DeleteUser deleteuser = om.readValue(sJson, DeleteUser.class);
			return deleteuser;
	}
	
	public static String getStringDateAndTimeStamp() {
		String value = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	
			return  value;
	}
	

	
}