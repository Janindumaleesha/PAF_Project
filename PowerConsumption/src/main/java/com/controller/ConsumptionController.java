package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.constants.Constant;
import com.constants.ConsumptionConstant;
import com.modal.Consumption;
import com.util.DatabaseConnection;

public class ConsumptionController {
	
    //get all
	public static ArrayList<Consumption> getConsumptions() throws ClassNotFoundException, SQLException {
		ArrayList<Consumption> plist = new ArrayList<>();
		String getQury = ConsumptionConstant.GETALLCONSUMPTION;
		Connection con = DatabaseConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			Consumption consumption = new Consumption();
			consumption.setAccountNumber(rs.getInt(Constant.INDEX_ONE));
			consumption.setPremisesID(rs.getString(Constant.INDEX_TWO));
			consumption.setMonth(rs.getString(Constant.INDEX_TREE));
			consumption.setDate(rs.getString(Constant.INDEX_FOUR));
			consumption.setUnits(rs.getInt(Constant.INDEX_FIVE));
			
			
			plist.add(consumption);
		}
		return  plist;
		
	}
	
	//create
	public static Consumption createConsumption(Consumption consumption) throws SQLException, ClassNotFoundException {
		  String CreateQury =ConsumptionConstant.CREATECONSUMPTION;
		  Connection con = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		  preparedStatement.setInt(Constant.INDEX_ONE, consumption.getAccountNumber());
		  preparedStatement.setString(Constant.INDEX_TWO, consumption.getPremisesID());
		  preparedStatement.setString(Constant.INDEX_TREE, consumption.getMonth());
		  preparedStatement.setString(Constant.INDEX_FOUR, consumption.getDate());
		  preparedStatement.setInt(Constant.INDEX_FIVE, consumption.getUnits());
		 
		  boolean isCreate = preparedStatement.execute();
		  if(!isCreate) {
			  return consumption;
		  }
		  else {
			  return null;
		  }
	}
	
	//get by ID
	
	public static Consumption getConsumptionByID(int conId) throws SQLException, ClassNotFoundException {
		
		String getdata_query = ConsumptionConstant.GETCONSUMPTIONBYID;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
				
		Consumption consumption = null;
				
		preparedStatement.setInt(Constant.INDEX_ONE, conId);
				
		ResultSet rs = preparedStatement.executeQuery();
				
		while(rs.next()) {
			int consumptionID = rs.getInt(Constant.INDEX_ONE);
			int accountNumber = rs.getInt(Constant.INDEX_TWO);
			String premisesID = rs.getString(Constant.INDEX_TREE);
			String month = rs.getString(Constant.INDEX_FOUR);
			String date = rs.getString(Constant.INDEX_FIVE);
			int units = rs.getInt(Constant.INDEX_SIX);
			
			consumption = new Consumption(consumptionID, accountNumber, premisesID, month, date, units);
		}
		return consumption;
				
	}
	
	//Update
	public static Consumption updateConsumption(Consumption consumption,int conId) throws SQLException, ClassNotFoundException {
		
		String update_query = ConsumptionConstant.UPDATECONSUMPTION;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, consumption.getAccountNumber());
		preparedStatement.setString(Constant.INDEX_TWO, consumption.getPremisesID());
		preparedStatement.setString(Constant.INDEX_TREE, consumption.getMonth());
		preparedStatement.setString(Constant.INDEX_FOUR, consumption.getDate());
		preparedStatement.setInt(Constant.INDEX_FIVE, consumption.getUnits());
		
		preparedStatement.setInt(Constant.INDEX_SIX, conId); //ask
				
		if(preparedStatement.executeUpdate() > 0) {
			return getConsumptionByID(conId); //ask
		}
		else {
			return null;
		}
				
	}
	
	//Delete
	public static boolean deleteConsumption(int conId) throws SQLException, ClassNotFoundException {
		
		String delete_query = ConsumptionConstant.DELETECONSUMPTION;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, conId);
		boolean isDeleted = preparedStatement.execute();
				
		return isDeleted;
				
	}

}
