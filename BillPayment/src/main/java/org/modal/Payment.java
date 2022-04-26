package org.modal;

public class Payment {
	
	private int pid;
	private int accno;
	private String pmethod;
	private String pamount;
	
	public Payment(int pid, int accno, String pmethod, String pamount) {
		this.pid = pid;
		this.accno = accno;
		this.pmethod = pmethod;
		this.pamount = pamount;
	}

	public Payment() {
		
	}

	public int getPid() {
		return pid;
	}

	public int getAccno() {
		return accno;
	}

	public String getPmethod() {
		return pmethod;
	}

	public String getPamount() {
		return pamount;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public void setPmethod(String pmethod) {
		this.pmethod = pmethod;
	}

	public void setPamount(String pamount) {
		this.pamount = pamount;
	}

	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", accno=" + accno + ", pmethod=" + pmethod + ", pamount=" + pamount + "]";
	}

}
