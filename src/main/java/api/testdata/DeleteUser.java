package api.testdata;

public class DeleteUser {

	private String userid;
	private String id;
	
	public DeleteUser(String userid, String id) {
		this.userid = userid;
		this.id = id;
		
	}
	public String getUserid() {
		return userid;
	}
	public String getId() {
		return id;
	}
	
}
