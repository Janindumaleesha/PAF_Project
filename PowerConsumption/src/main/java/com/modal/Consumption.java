package com.modal;

public class Consumption {
	
	private int consumptionID;
	private int accountNumber;
	private String premisesID;
	private String month;
	private String date;
	private int units;

	
	public Consumption(int consumptionID, int accountNumber, String premisesID, String month, String date, int units) {
		this.consumptionID = consumptionID;
		this.accountNumber = accountNumber;
		this.premisesID = premisesID;
		this.month = month;
		this.date = date;
		this.units = units;
	}


	public Consumption() {
		
	}


	public int getConsumptionID() {
		return consumptionID;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public String getPremisesID() {
		return premisesID;
	}


	public String getMonth() {
		return month;
	}


	public String getDate() {
		return date;
	}


	public int getUnits() {
		return units;
	}


	public void setConsumptionID(int consumptionID) {
		this.consumptionID = consumptionID;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public void setPremisesID(String premisesID) {
		this.premisesID = premisesID;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setUnits(int units) {
		this.units = units;
	}


	@Override
	public String toString() {
		return "Consumption [consumptionID=" + consumptionID + ", accountNumber=" + accountNumber + ", premisesID="
				+ premisesID + ", month=" + month + ", date=" + date + ", units=" + units + "]";
	}
	
	
	
	

}
