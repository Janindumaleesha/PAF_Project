package web.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import web.constants.Constant;
import web.constants.CustomerConstant;
import web.modal.Customer;
import web.util.DatabaseConnection;

public class CustomerController {
	
	//get all customer details snippet
	public static ArrayList<Customer> getCustomers() throws ClassNotFoundException, SQLException {
		ArrayList<Customer> plist = new ArrayList<>();
		String getQury = CustomerConstant.GETALLCUSTOMER;
		Connection con = DatabaseConnection.getConnection();

		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();

		while(rs.next()) {
			Customer customer = new Customer();
			customer.setFirstName(rs.getString(Constant.INDEX_ONE));
			customer.setLastName(rs.getString(Constant.INDEX_TWO));
			customer.setAccountNumber(rs.getInt(Constant.INDEX_TREE));
			customer.setEmail(rs.getString(Constant.INDEX_FOUR));
			customer.setNic(rs.getString(Constant.INDEX_FIVE));
			customer.setMobile(rs.getString(Constant.INDEX_SIX));
			customer.setAddress(rs.getString(Constant.INDEX_SEVEN));
			customer.setUserName(rs.getString(Constant.INDEX_EIGHT));
			customer.setPassword(rs.getString(Constant.INDEX_NINE));


			plist.add(customer);
		}
		return plist;

	}
	
	//create customer snippet
	public static Customer createCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		String CreateQury =CustomerConstant.CREATECUSTOMER;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		preparedStatement.setString(Constant.INDEX_ONE, customer.getFirstName());
		preparedStatement.setString(Constant.INDEX_TWO, customer.getLastName());
		preparedStatement.setInt(Constant.INDEX_TREE, customer.getAccountNumber());
		preparedStatement.setString(Constant.INDEX_FOUR, customer.getEmail());
		preparedStatement.setString(Constant.INDEX_FIVE, customer.getNic());
		preparedStatement.setString(Constant.INDEX_SIX, customer.getMobile());
		preparedStatement.setString(Constant.INDEX_SEVEN, customer.getAddress());
		preparedStatement.setString(Constant.INDEX_EIGHT, customer.getUserName());
		preparedStatement.setString(Constant.INDEX_NINE, customer.getPassword());
		
				  
		boolean isCreate = preparedStatement.execute();
	    if(!isCreate) {
	    	return customer;
		}
		else {
			return null;
		}
	}
	
	//get by ID snippet
	
	public static Customer getCustomerByID(int cusId) throws SQLException, ClassNotFoundException {
		
		String getdata_query = CustomerConstant.GETCUSTOMERBYID;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
				
		Customer customer = null;
				
		preparedStatement.setInt(Constant.INDEX_ONE, cusId);
				
		ResultSet rs = preparedStatement.executeQuery();
				
		while(rs.next()) {
			int userID = rs.getInt(Constant.INDEX_ONE);
			String firstName = rs.getString(Constant.INDEX_TWO);
			String lastName = rs.getString(Constant.INDEX_TREE);
			int accountNumber = rs.getInt(Constant.INDEX_FOUR);
			String email = rs.getString(Constant.INDEX_FIVE);
			String nic = rs.getString(Constant.INDEX_SIX);
			String mobile = rs.getString(Constant.INDEX_SEVEN);
			String address = rs.getString(Constant.INDEX_EIGHT);
			String userName = rs.getString(Constant.INDEX_NINE);
			String password = rs.getString(Constant.INDEX_TEN);

			customer = new Customer(userID, firstName, lastName, accountNumber, email, nic, mobile, address, userName, password);
		}
		return customer;
				
	}
	
	//Update customer snippet
	public static Customer updateCustomer(Customer customer,int cusId) throws SQLException, ClassNotFoundException {
		
		String update_query = CustomerConstant.UPDATECUSTOMER;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setString(Constant.INDEX_ONE, customer.getFirstName());
		preparedStatement.setString(Constant.INDEX_TWO, customer.getLastName());
		preparedStatement.setInt(Constant.INDEX_TREE, customer.getAccountNumber());
		preparedStatement.setString(Constant.INDEX_FOUR, customer.getEmail());
		preparedStatement.setString(Constant.INDEX_FIVE, customer.getNic());
		preparedStatement.setString(Constant.INDEX_SIX, customer.getMobile());
		preparedStatement.setString(Constant.INDEX_SEVEN, customer.getAddress());
		preparedStatement.setString(Constant.INDEX_EIGHT, customer.getUserName());
		preparedStatement.setString(Constant.INDEX_NINE, customer.getPassword());

		
		preparedStatement.setInt(Constant.INDEX_TEN, cusId); //ask
				
		if(preparedStatement.executeUpdate() > 0) {
			return getCustomerByID(cusId); //ask
		}
		else {
			return null;
		}
				
	}
	
	//Delete customer snippet
	public static boolean deleteCustomer(int cusId) throws SQLException, ClassNotFoundException {
		
		String delete_query = CustomerConstant.DELETECUSTOMER;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, cusId);
		boolean isDeleted = preparedStatement.execute();
				
		return isDeleted;
				
	}

}
