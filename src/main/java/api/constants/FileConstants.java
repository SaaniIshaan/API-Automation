package api.constants;

import api.utils.CommonUtilities;

public class FileConstants {
	
	public static final String URI_FILE_PATH = System.getProperty("user.dir")+"/src/main/java/api/testdata/uriconfigs.json";
	
	public static final String USER_CONFIG_FILE_PATH = System.getProperty("user.dir")+"/src/main/java/api/testdata/userconfig.json";
	
	public static final String LOGIN_SCHEMA = System.getProperty("user.dir")+"/src/main/java/api/testdata/schema/loginschema.json";
		
	public static final String GET_DATA_SCHEMA = System.getProperty("user.dir")+"/src/main/java/api/testdata/schema/getdataschema.json";
	
	public static final String ADD_DATA_SCHEMA = System.getProperty("user.dir")+"/src/main/java/api/testdata/schema/adddataschema.json";
	
	public static final String UPDATE_DATA_SCHEMA = System.getProperty("user.dir")+"/src/main/java/api/testdata/schema/updatedataschema.json";
	
	public static final String DELETE_DATA_SCHEMA = System.getProperty("user.dir")+"/src/main/java/api/testdata/schema/deletedataschema.json";
	
	public static final String REPORTS_PATH = System.getProperty("user.dir")+"/src/main/resources/Reports/"+ CommonUtilities.getStringDateAndTimeStamp()+"_USER.html";
	
	
	}	
