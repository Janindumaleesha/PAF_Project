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
			payment.setAccno(rs.getInt(Constant.INDEX_ONE));
			payment.setPmethod(rs.getString(Constant.INDEX_TWO));
			payment.setPamount(rs.getString(Constant.INDEX_TREE));
			
			plist.add(payment);
		}
		return  plist;
		
	}
	
	//create
	public static Payment createPayment(Payment payment) throws SQLException, ClassNotFoundException {
		  String CreateQury = PaymentConstant.CREATEPAYMENT;
		  Connection con = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		  preparedStatement.setInt(Constant.INDEX_ONE, payment.getAccno());
		  preparedStatement.setString(Constant.INDEX_TWO, payment.getPmethod());
		  preparedStatement.setString(Constant.INDEX_TREE, payment.getPamount());
		  
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
			int accno = rs.getInt(Constant.INDEX_TWO);
			String pmethod = rs.getString(Constant.INDEX_TREE);
			String pamount = rs.getString(Constant.INDEX_FOUR);
			
			
			payment = new Payment(pid, accno, pmethod, pamount);
		}
		return payment;
				
	}
	
	//Update
	public static Payment updatePayment(Payment payment,int payId) throws SQLException, ClassNotFoundException {
		
		String update_query = PaymentConstant.UPDATEPAYMENT;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, payment.getAccno());
		preparedStatement.setString(Constant.INDEX_TWO, payment.getPmethod());
		preparedStatement.setString(Constant.INDEX_TREE, payment.getPamount());
		
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
