package api.testdata;

public class GetUser {
	
	private String accountno;
	private String departmentno;
	private String salary;
	private String pincode;
	private String userid;
	private String id;
	
	public GetUser(String accountno, String departmentno, String salary, String pincode, String userid, String id) {
		this.accountno = accountno;
		this.departmentno = departmentno;
		this.salary = salary;
		this.pincode = pincode;
		this.userid = userid;
		this.id = id;
	}
	
	public String getAccountNo() {
		return accountno;
	}
	public String getDepartmentNo() {
		return departmentno;
	}
	public String getSalary() {
		return salary;
	}
	public String getPinCode() {
		return pincode;
	}
	public String getUserid() {
		return userid;
	}
	public String getId() {
		return id;
	}
	
}
