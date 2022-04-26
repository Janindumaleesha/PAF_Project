package raq.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import raq.constants.Constant;
import raq.constants.ComplaintConstant;
import raq.modal.Complaint;
import raq.util.DatabaseConnection;

public class ComplaintController {
	
    //get all complaints
	public static ArrayList<Complaint> getComplaints() throws ClassNotFoundException, SQLException {
		ArrayList<Complaint> plist = new ArrayList<>();
		String getQury = ComplaintConstant.GETALLCOMPLAINTS;
		Connection con = DatabaseConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			Complaint complaint = new Complaint();
			complaint.setAccountNumber(rs.getInt(Constant.INDEX_ONE));
			complaint.setComplaintDate(rs.getString(Constant.INDEX_TWO));
			complaint.setnComplaint(rs.getString(Constant.INDEX_TREE));
			complaint.setAnythingMoreToTell(rs.getString(Constant.INDEX_FOUR));
			
			plist.add(complaint);
		}
		return  plist;
		
	}
	
	//create complaint 
	public static Complaint createComplaint(Complaint complaint) throws SQLException, ClassNotFoundException {
		  String CreateQury =ComplaintConstant.CREATECOMPLAINTS;
		  Connection con = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		  preparedStatement.setInt(Constant.INDEX_ONE, complaint.getAccountNumber());
		  preparedStatement.setString(Constant.INDEX_TWO, complaint.getComplaintDate());
		  preparedStatement.setString(Constant.INDEX_TREE, complaint.getnComplaint());
		  preparedStatement.setString(Constant.INDEX_FOUR, complaint.getAnythingMoreToTell());
		  
		  boolean isCreate = preparedStatement.execute();
		  if(!isCreate) {
			  return complaint;
		  }
		  else {
			  return null;
		  }
	}
	
	//get by ID from complaint
	
	public static Complaint getComplaintByID(int compId) throws SQLException, ClassNotFoundException {
		
		String getdata_query = ComplaintConstant.GETCOMPLAINTSBYID;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
				
		Complaint complaint = null;
				
		preparedStatement.setInt(Constant.INDEX_ONE, compId);
				
		ResultSet rs = preparedStatement.executeQuery();
				
		while(rs.next()) {
			int complaintID = rs.getInt(Constant.INDEX_ONE);
			int accountNumber = rs.getInt(Constant.INDEX_TWO);
			String complaintDate = rs.getString(Constant.INDEX_TREE);
			String nComplaint = rs.getString(Constant.INDEX_FOUR);
			String anythingMoreToTell = rs.getString(Constant.INDEX_FIVE);
			
			
			complaint = new Complaint(complaintID, accountNumber, complaintDate, nComplaint, anythingMoreToTell);
		}
		return complaint;
				
	}
	
	//Update Complaint
	public static Complaint updateComplaint(Complaint complaint,int compId) throws SQLException, ClassNotFoundException {
		
		String update_query = ComplaintConstant.UPDATECOMPLAINTS;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, complaint.getAccountNumber());
		preparedStatement.setString(Constant.INDEX_TWO, complaint.getComplaintDate());
		preparedStatement.setString(Constant.INDEX_TREE, complaint.getnComplaint());
		preparedStatement.setString(Constant.INDEX_FOUR, complaint.getAnythingMoreToTell());
		
		preparedStatement.setInt(Constant.INDEX_FIVE, compId); //ask
				
		if(preparedStatement.executeUpdate() > 0) {
			return getComplaintByID(compId); //ask
		}
		else {
			return null;
		}
				
	}
	
	//Delete
	public static boolean deleteComplaint(int compId) throws SQLException, ClassNotFoundException {
		
		String delete_query = ComplaintConstant.DELETECOMPLAINTS;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, compId);
		boolean isDeleted = preparedStatement.execute();
				
		return isDeleted;
				
	}
	
}
