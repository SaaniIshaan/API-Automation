package api.testdata;

public class UpdateUser {
	
	private String accountno;
	private String departmentno;
	private String salary;
	private String pincode;
	private String userid;
	private String id;
	
	public UpdateUser(String accountno, String departmentno, String salary, String pincode, String userid, String id) {
		this.accountno = accountno;
		this.departmentno = departmentno;
		this.salary = salary;
		this.pincode = pincode;
		this.userid = userid;
		this.id = id;
	}
	
	public String UpdateAccountNo() {
		return accountno;
	}
	public String UpdateDepartmentNo() {
		return departmentno;
	}
	public String UpdateSalary() {
		return salary;
	}
	public String UpdatePinCode() {
		return pincode;
	}
	public String UpdateUserid() {
		return userid;
	}
	public String UpdateId() {
		return id;
	}
	
}
