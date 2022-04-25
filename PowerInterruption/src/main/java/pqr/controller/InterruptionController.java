package pqr.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pqr.constants.Constant;
import pqr.constants.InterruptionConstant;
import pqr.modal.Interruption;
import pqr.util.DatabaseConnection;

public class InterruptionController {
	
    //get all
	public static ArrayList<Interruption> getInterruptions() throws ClassNotFoundException, SQLException {
		ArrayList<Interruption> plist = new ArrayList<>();
		String getQury = InterruptionConstant.GETALLINTERRUPTION;
		Connection con = DatabaseConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			Interruption interruption = new Interruption();
			interruption.setDate(rs.getString(Constant.INDEX_ONE));
			interruption.setTimeSlot(rs.getString(Constant.INDEX_TWO));
			interruption.setLocationID(rs.getString(Constant.INDEX_TREE));
			interruption.setArea(rs.getString(Constant.INDEX_FOUR));
			interruption.setReason(rs.getString(Constant.INDEX_FIVE));
			interruption.setStatus(rs.getString(Constant.INDEX_SIX));
			
			
			plist.add(interruption);
		}
		return  plist;
		
	}
	
	//create
	public static Interruption createInterruption(Interruption interruption) throws SQLException, ClassNotFoundException {
		  String CreateQury = InterruptionConstant.CREATEINTERRUPTION;
		  Connection con = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		  preparedStatement.setString(Constant.INDEX_ONE, interruption.getDate());
		  preparedStatement.setString(Constant.INDEX_TWO, interruption.getTimeSlot());
		  preparedStatement.setString(Constant.INDEX_TREE, interruption.getLocationID());
		  preparedStatement.setString(Constant.INDEX_FOUR, interruption.getArea());
		  preparedStatement.setString(Constant.INDEX_FIVE, interruption.getReason());
		  preparedStatement.setString(Constant.INDEX_SIX, interruption.getStatus());
		 
		  boolean isCreate = preparedStatement.execute();
		  if(!isCreate) {
			  return interruption;
		  }
		  else {
			  return null;
		  }
	}
	
	//get by ID
	
	public static Interruption getInterruptionByID(int intId) throws SQLException, ClassNotFoundException {
		
		String getdata_query = InterruptionConstant.GETINTERRUPTIONBYID;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
				
		Interruption interruption = null;
				
		preparedStatement.setInt(Constant.INDEX_ONE, intId);
				
		ResultSet rs = preparedStatement.executeQuery();
				
		while(rs.next()) {
			int interruptionID = rs.getInt(Constant.INDEX_ONE);
			String date = rs.getString(Constant.INDEX_TWO);
			String timeSlot = rs.getString(Constant.INDEX_TREE);
			String locationID = rs.getString(Constant.INDEX_FOUR);
			String area = rs.getString(Constant.INDEX_FIVE);
			String reason = rs.getString(Constant.INDEX_SIX);
			String status = rs.getString(Constant.INDEX_SEVEN);
			
			
			interruption = new Interruption(interruptionID, date, timeSlot, locationID, area, reason, status);
		}
		return interruption;
				
	}
	
	//Update
	public static Interruption updateInterruption(Interruption interruption,int intId) throws SQLException, ClassNotFoundException {
		
		String update_query = InterruptionConstant.UPDATEINTERRUPTION;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setString(Constant.INDEX_ONE, interruption.getDate());
		preparedStatement.setString(Constant.INDEX_TWO, interruption.getTimeSlot());
		preparedStatement.setString(Constant.INDEX_TREE, interruption.getLocationID());
		preparedStatement.setString(Constant.INDEX_FOUR, interruption.getArea());
		preparedStatement.setString(Constant.INDEX_FIVE, interruption.getReason());
		preparedStatement.setString(Constant.INDEX_SIX, interruption.getStatus());
		
		preparedStatement.setInt(Constant.INDEX_SEVEN, intId); //ask
				
		if(preparedStatement.executeUpdate() > 0) {
			return getInterruptionByID(intId); //ask
		}
		else {
			return null;
		}
				
	}
	
	//Delete
	public static boolean deleteInterruption(int intId) throws SQLException, ClassNotFoundException {
		
		String delete_query = InterruptionConstant.DELETEINTERRUPTION;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, intId);
		boolean isDeleted = preparedStatement.execute();
				
		return isDeleted;
				
	}

}
