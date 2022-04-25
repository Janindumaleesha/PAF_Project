package org.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.constants.Constant;
import org.constants.BillConstant;
import org.modal.Bill;
import org.util.DatabaseConnection;

public class BillController {
	
    //get all
	public static ArrayList<Bill> getBills() throws ClassNotFoundException, SQLException {
		ArrayList<Bill> plist = new ArrayList<>();
		String getQury = BillConstant.GETALLBILL;
		Connection con = DatabaseConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			Bill bill = new Bill();
			bill.setAccNo(rs.getInt(Constant.INDEX_ONE));
			bill.setFname(rs.getString(Constant.INDEX_TWO));
			bill.setLname(rs.getString(Constant.INDEX_TREE));
			bill.setAddress(rs.getString(Constant.INDEX_FOUR));
			bill.setMReading(rs.getInt(Constant.INDEX_FIVE));
			bill.setBilldate(rs.getString(Constant.INDEX_SIX));
			bill.setNodates(rs.getInt(Constant.INDEX_SEVEN));
			bill.setChargeunits(rs.getDouble(Constant.INDEX_EIGHT));
			bill.setNounits(rs.getInt(Constant.INDEX_NINE));
			bill.setOutsamount(rs.getDouble(Constant.INDEX_TEN));
			bill.setTotalamonut(rs.getDouble(Constant.INDEX_ELEVEN));
			
			plist.add(bill);
		}
		return  plist;
		
	}
	
	//create
	public static Bill createBill(Bill bill) throws SQLException, ClassNotFoundException {
		  String CreateQury = BillConstant.CREATEBILL;
		  Connection con = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		  preparedStatement.setInt(Constant.INDEX_ONE, bill.getAccNo());
		  preparedStatement.setString(Constant.INDEX_TWO, bill.getFname());
		  preparedStatement.setString(Constant.INDEX_TREE, bill.getLname());
		  preparedStatement.setString(Constant.INDEX_FOUR, bill.getAddress());
		  preparedStatement.setInt(Constant.INDEX_FIVE, bill.getMReading());
		  preparedStatement.setString(Constant.INDEX_SIX, bill.getBilldate());
		  preparedStatement.setInt(Constant.INDEX_SEVEN, bill.getNodates());
		  preparedStatement.setDouble(Constant.INDEX_EIGHT, bill.getChargeunits());
		  preparedStatement.setInt(Constant.INDEX_NINE, bill.getNounits());
		  preparedStatement.setDouble(Constant.INDEX_TEN, bill.getOutsamount());
		  preparedStatement.setDouble(Constant.INDEX_ELEVEN, bill.getTotalamonut());
		  
		  boolean isCreate = preparedStatement.execute();
		  if(!isCreate) {
			  return bill;
		  }
		  else {
			  return null;
		  }
	}
	
	//get by ID
	
	public static Bill getBillByID(int bilId) throws SQLException, ClassNotFoundException {
		
		String getdata_query = BillConstant.GETBILLBYID;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
				
		Bill bill = null;
				
		preparedStatement.setInt(Constant.INDEX_ONE, bilId);
				
		ResultSet rs = preparedStatement.executeQuery();
				
		while(rs.next()) {
			int BillNo = rs.getInt(Constant.INDEX_ONE);
			int AccNo = rs.getInt(Constant.INDEX_TWO);
			String Fname = rs.getString(Constant.INDEX_TREE);
			String Lname = rs.getString(Constant.INDEX_FOUR);
			String Address = rs.getString(Constant.INDEX_FIVE);
			int MReading = rs.getInt(Constant.INDEX_SIX);
			String Billdate = rs.getString(Constant.INDEX_SEVEN);
			int Nodates = rs.getInt(Constant.INDEX_EIGHT);
			Double Chargeunits = rs.getDouble(Constant.INDEX_NINE);
			int Nounits = rs.getInt(Constant.INDEX_TEN);
			Double Outsamount = rs.getDouble(Constant.INDEX_ELEVEN);
			Double Totalamonut = rs.getDouble(Constant.INDEX_TWELVE);
			
			
			bill = new Bill(BillNo, AccNo, Fname, Lname, Address, MReading, Billdate, Nodates, Chargeunits, Nounits, Outsamount, Totalamonut);
		}
		return bill;
				
	}
	
	//Update
	public static Bill updateBill(Bill bill,int bilId) throws SQLException, ClassNotFoundException {
		
		String update_query = BillConstant.UPDATEBILL;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, bill.getAccNo());
		preparedStatement.setString(Constant.INDEX_TWO, bill.getFname());
		preparedStatement.setString(Constant.INDEX_TREE, bill.getLname());
		preparedStatement.setString(Constant.INDEX_FOUR, bill.getAddress());
		preparedStatement.setInt(Constant.INDEX_FIVE, bill.getMReading());
		preparedStatement.setString(Constant.INDEX_SIX, bill.getBilldate());
		preparedStatement.setInt(Constant.INDEX_SEVEN, bill.getNodates());
		preparedStatement.setDouble(Constant.INDEX_EIGHT, bill.getChargeunits());
		preparedStatement.setInt(Constant.INDEX_NINE, bill.getNounits());
		preparedStatement.setDouble(Constant.INDEX_TEN, bill.getOutsamount());
		preparedStatement.setDouble(Constant.INDEX_ELEVEN, bill.getTotalamonut());
		
		preparedStatement.setInt(Constant.INDEX_TWELVE, bilId); //ask
				
		if(preparedStatement.executeUpdate() > 0) {
			return getBillByID(bilId); //ask
		}
		else {
			return null;
		}
				
	}
	
	//Delete
	public static boolean deleteBill(int bilId) throws SQLException, ClassNotFoundException {
		
		String delete_query = BillConstant.DELETEBILL;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, bilId);
		boolean isDeleted = preparedStatement.execute();
				
		return isDeleted;
				
	}

}
