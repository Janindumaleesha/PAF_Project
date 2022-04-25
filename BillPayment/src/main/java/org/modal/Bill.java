package org.modal;

public class Bill {
	
	private int BillNo;
	private int AccNo;
	private String Fname;
	private String Lname;
	private String Address;
	private int MReading;
	private String Billdate;
	private int Nodates;
	private double Chargeunits;
	private int Nounits;
	private double Outsamount;
	private double Totalamonut;
	
	public Bill(int billNo, int accNo, String fname, String lname, String address, int mReading, String billdate,
			int nodates, double chargeunits, int nounits, double outsamount, double totalamonut) {
		BillNo = billNo;
		AccNo = accNo;
		Fname = fname;
		Lname = lname;
		Address = address;
		MReading = mReading;
		Billdate = billdate;
		Nodates = nodates;
		Chargeunits = chargeunits;
		Nounits = nounits;
		Outsamount = outsamount;
		Totalamonut = totalamonut;
	}

	public Bill() {
		
	}

	public int getBillNo() {
		return BillNo;
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

	public String getAddress() {
		return Address;
	}

	public int getMReading() {
		return MReading;
	}

	public String getBilldate() {
		return Billdate;
	}

	public int getNodates() {
		return Nodates;
	}

	public double getChargeunits() {
		return Chargeunits;
	}

	public int getNounits() {
		return Nounits;
	}

	public double getOutsamount() {
		return Outsamount;
	}

	public double getTotalamonut() {
		return Totalamonut;
	}

	public void setBillNo(int billNo) {
		BillNo = billNo;
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

	public void setAddress(String address) {
		Address = address;
	}

	public void setMReading(int mReading) {
		MReading = mReading;
	}

	public void setBilldate(String billdate) {
		Billdate = billdate;
	}

	public void setNodates(int nodates) {
		Nodates = nodates;
	}

	public void setChargeunits(double chargeunits) {
		Chargeunits = chargeunits;
	}

	public void setNounits(int nounits) {
		Nounits = nounits;
	}

	public void setOutsamount(double outsamount) {
		Outsamount = outsamount;
	}

	public void setTotalamonut(double totalamonut) {
		Totalamonut = totalamonut;
	}

	@Override
	public String toString() {
		return "Bill [BillNo=" + BillNo + ", AccNo=" + AccNo + ", Fname=" + Fname + ", Lname=" + Lname + ", Address="
				+ Address + ", MReading=" + MReading + ", Billdate=" + Billdate + ", Nodates=" + Nodates
				+ ", Chargeunits=" + Chargeunits + ", Nounits=" + Nounits + ", Outsamount=" + Outsamount
				+ ", Totalamonut=" + Totalamonut + "]";
	}

}
