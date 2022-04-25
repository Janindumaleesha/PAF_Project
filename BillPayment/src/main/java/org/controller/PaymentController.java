package org.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.constants.Constant;
import org.constants.PaymentConstant;
import org.modal.Payment;
import org.util.DatabaseConnection;

public class PaymentController {
	
    //get all
	public static ArrayList<Payment> getPayments() throws ClassNotFoundException, SQLException {
		ArrayList<Payment> plist = new ArrayList<>();
		String getQury = PaymentConstant.GETALLPAYMENT;
		Connection con = DatabaseConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			Payment payment = new Payment();
			payment.setAccNo(rs.getInt(Constant.INDEX_ONE));
			payment.setFname(rs.getString(Constant.INDEX_TWO));
			payment.setLname(rs.getString(Constant.INDEX_TREE));
			payment.setEmail(rs.getString(Constant.INDEX_FOUR));
			payment.setPmethod(rs.getString(Constant.INDEX_FIVE));
			payment.setPamount(rs.getDouble(Constant.INDEX_SIX));
			
			plist.add(payment);
		}
		return  plist;
		
	}
	
	//create
	public static Payment createPayment(Payment payment) throws SQLException, ClassNotFoundException {
		  String CreateQury = PaymentConstant.CREATEPAYMENT;
		  Connection con = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		  preparedStatement.setInt(Constant.INDEX_ONE, payment.getAccNo());
		  preparedStatement.setString(Constant.INDEX_TWO, payment.getFname());
		  preparedStatement.setString(Constant.INDEX_TREE, payment.getLname());
		  preparedStatement.setString(Constant.INDEX_FOUR, payment.getEmail());
		  preparedStatement.setString(Constant.INDEX_FIVE, payment.getPmethod());
		  preparedStatement.setDouble(Constant.INDEX_SIX, payment.getPamount());
		  
		  boolean isCreate = preparedStatement.execute();
		  if(!isCreate) {
			  return payment;
		  }
		  else {
			  return null;
		  }
	}
	
	//get by ID
	
	public static Payment getPaymentByID(int payId) throws SQLException, ClassNotFoundException {
		
		String getdata_query = PaymentConstant.GETPAYMENTBYID;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
				
		Payment payment = null;
				
		preparedStatement.setInt(Constant.INDEX_ONE, payId);
				
		ResultSet rs = preparedStatement.executeQuery();
				
		while(rs.next()) {
			int pid = rs.getInt(Constant.INDEX_ONE);
			int AccNo = rs.getInt(Constant.INDEX_TWO);
			String Fname = rs.getString(Constant.INDEX_TREE);
			String Lname = rs.getString(Constant.INDEX_FOUR);
			String email = rs.getString(Constant.INDEX_FIVE);
			String Pmethod = rs.getString(Constant.INDEX_SIX);
			double pamount = rs.getDouble(Constant.INDEX_SEVEN);
			
			
			payment = new Payment(pid, AccNo, Fname, Lname, email, Pmethod, pamount);
		}
		return payment;
				
	}
	
	//Update
	public static Payment updatePayment(Payment payment,int payId) throws SQLException, ClassNotFoundException {
		
		String update_query = PaymentConstant.UPDATEPAYMENT;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, payment.getAccNo());
		preparedStatement.setString(Constant.INDEX_TWO, payment.getFname());
		preparedStatement.setString(Constant.INDEX_TREE, payment.getLname());
		preparedStatement.setString(Constant.INDEX_FOUR, payment.getEmail());
		preparedStatement.setString(Constant.INDEX_FIVE, payment.getPmethod());
		preparedStatement.setDouble(Constant.INDEX_SIX, payment.getPamount());
		
		preparedStatement.setInt(Constant.INDEX_SEVEN, payId); //ask
				
		if(preparedStatement.executeUpdate() > 0) {
			return getPaymentByID(payId); //ask
		}
		else {
			return null;
		}
				
	}
	
	//Delete
	public static boolean deletePayment(int payId) throws SQLException, ClassNotFoundException {
		
		String delete_query = PaymentConstant.DELETEPAYMENT;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, payId);
		boolean isDeleted = preparedStatement.execute();
				
		return isDeleted;
				
	}

}
