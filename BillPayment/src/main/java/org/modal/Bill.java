package org.modal;

public class Bill {
	
	private int billno;
	private int accNo;
	private int mreading;
	private String billdate;
	private int nodates;
	private String chargeunits;
	private int nounits;
	private String outsamount;
	private String totalamount;
	
	public Bill(int billno, int accNo, int mreading, String billdate, int nodates, String chargeunits, int nounits,
			String outsamount, String totalamount) {
		this.billno = billno;
		this.accNo = accNo;
		this.mreading = mreading;
		this.billdate = billdate;
		this.nodates = nodates;
		this.chargeunits = chargeunits;
		this.nounits = nounits;
		this.outsamount = outsamount;
		this.totalamount = totalamount;
	}

	public Bill() {
		
	}

	public int getBillno() {
		return billno;
	}

	public int getAccNo() {
		return accNo;
	}

	public int getMreading() {
		return mreading;
	}

	public String getBilldate() {
		return billdate;
	}

	public int getNodates() {
		return nodates;
	}

	public String getChargeunits() {
		return chargeunits;
	}

	public int getNounits() {
		return nounits;
	}

	public String getOutsamount() {
		return outsamount;
	}

	public String getTotalamount() {
		return totalamount;
	}

	public void setBillno(int billno) {
		this.billno = billno;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public void setMreading(int mreading) {
		this.mreading = mreading;
	}

	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}

	public void setNodates(int nodates) {
		this.nodates = nodates;
	}

	public void setChargeunits(String chargeunits) {
		this.chargeunits = chargeunits;
	}

	public void setNounits(int nounits) {
		this.nounits = nounits;
	}

	public void setOutsamount(String outsamount) {
		this.outsamount = outsamount;
	}

	public void setTotalamount(String totalamount) {
		this.totalamount = totalamount;
	}

	@Override
	public String toString() {
		return "Bill [billno=" + billno + ", accNo=" + accNo + ", mreading=" + mreading + ", billdate=" + billdate
				+ ", nodates=" + nodates + ", chargeunits=" + chargeunits + ", nounits=" + nounits + ", outsamount="
				+ outsamount + ", totalamount=" + totalamount + "]";
	}
	
}

