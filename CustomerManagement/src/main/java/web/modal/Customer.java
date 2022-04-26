package web.modal;

public class Customer {
	
	private int userID;
	private String firstName;
	private String lastName;
	private int accountNumber;
	private String email;
	private String nic;
	private String mobile;
	private String address;
	private String userName;
	private String password;
	
	public Customer(int userID, String firstName, String lastName, int accountNumber, String email, String nic,
			String mobile, String address, String userName, String password) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.email = email;
		this.nic = nic;
		this.mobile = mobile;
		this.address = address;
		this.userName = userName;
		this.password = password;
	}

	public Customer() {
	
	}

	public int getUserID() {
		return userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getNic() {
		return nic;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAddress() {
		return address;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", accountNumber=" + accountNumber + ", email=" + email + ", nic=" + nic + ", mobile=" + mobile
				+ ", address=" + address + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	
	

}
