package org.modal;

public class Payment {
	
	private int pid;
	private int AccNo;
	private String Fname;
	private String Lname;
	private String email;
	private String Pmethod;
	private double pamount;
	
	public Payment(int pid, int accNo, String fname, String lname, String email, String pmethod, double pamount) {
		this.pid = pid;
		AccNo = accNo;
		Fname = fname;
		Lname = lname;
		this.email = email;
		Pmethod = pmethod;
		this.pamount = pamount;
	}

	public Payment() {
		
	}

	public int getPid() {
		return pid;
	}

	public int getAccNo() {
		return AccNo;
	}

	public String getFname() {
		return Fname;
	}

	public String getLname() {
		return Lname;
	}

	public String getEmail() {
		return email;
	}

	public String getPmethod() {
		return Pmethod;
	}

	public double getPamount() {
		return pamount;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setAccNo(int accNo) {
		AccNo = accNo;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPmethod(String pmethod) {
		Pmethod = pmethod;
	}

	public void setPamount(double pamount) {
		this.pamount = pamount;
	}

	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", AccNo=" + AccNo + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email
				+ ", Pmethod=" + Pmethod + ", pamount=" + pamount + "]";
	}
	

}
