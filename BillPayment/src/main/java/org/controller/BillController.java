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
			bill.setMreading(rs.getInt(Constant.INDEX_TWO));
			bill.setBilldate(rs.getString(Constant.INDEX_TREE));
			bill.setNodates(rs.getInt(Constant.INDEX_FOUR));
			bill.setChargeunits(rs.getString(Constant.INDEX_FIVE));
			bill.setNounits(rs.getInt(Constant.INDEX_SIX));
			bill.setOutsamount(rs.getString(Constant.INDEX_SEVEN));
			bill.setTotalamount(rs.getString(Constant.INDEX_EIGHT));
			
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
		  preparedStatement.setInt(Constant.INDEX_TWO, bill.getMreading());
		  preparedStatement.setString(Constant.INDEX_TREE, bill.getBilldate());
		  preparedStatement.setInt(Constant.INDEX_FOUR, bill.getNodates());
		  preparedStatement.setString(Constant.INDEX_FIVE, bill.getChargeunits());
		  preparedStatement.setInt(Constant.INDEX_SIX, bill.getNounits());
		  preparedStatement.setString(Constant.INDEX_SEVEN, bill.getOutsamount());
		  preparedStatement.setString(Constant.INDEX_EIGHT, bill.getTotalamount());
		  
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
			int billno = rs.getInt(Constant.INDEX_ONE);
			int accNo = rs.getInt(Constant.INDEX_TWO);
			int mreading = rs.getInt(Constant.INDEX_TREE);
			String billdate = rs.getString(Constant.INDEX_FOUR);
			int nodates = rs.getInt(Constant.INDEX_FIVE);
			String chargeunits = rs.getString(Constant.INDEX_SIX);
			int nounits = rs.getInt(Constant.INDEX_SEVEN);
			String outsamount = rs.getString(Constant.INDEX_EIGHT);
			String totalamount = rs.getString(Constant.INDEX_NINE);
			
			
			bill = new Bill(billno, accNo, mreading, billdate, nodates, chargeunits, nounits, outsamount, totalamount);
		}
		return bill;
				
	}
	
	//Update
	public static Bill updateBill(Bill bill,int bilId) throws SQLException, ClassNotFoundException {
		
		String update_query = BillConstant.UPDATEBILL;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, bill.getAccNo());
		preparedStatement.setInt(Constant.INDEX_TWO, bill.getMreading());
		preparedStatement.setString(Constant.INDEX_TREE, bill.getBilldate());
		preparedStatement.setInt(Constant.INDEX_FOUR, bill.getNodates());
		preparedStatement.setString(Constant.INDEX_FIVE, bill.getChargeunits());
		preparedStatement.setInt(Constant.INDEX_SIX, bill.getNounits());
		preparedStatement.setString(Constant.INDEX_SEVEN, bill.getOutsamount());
		preparedStatement.setString(Constant.INDEX_EIGHT, bill.getTotalamount());
		
		preparedStatement.setInt(Constant.INDEX_NINE, bilId); //ask
				
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
