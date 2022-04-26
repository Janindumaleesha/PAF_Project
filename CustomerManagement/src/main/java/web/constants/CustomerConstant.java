package web.constants;

//common queries for DB
public class CustomerConstant {
	
	public static String GETALLCUSTOMER = "select firstName,lastName,accountNumber,email,nic,mobile,address,userName,password from customer";
	public static String CREATECUSTOMER = "insert into customer (firstName,lastName,accountNumber,email,nic,mobile,address,userName,password) values (?,?,?,?,?,?,?,?,?)";
	public static String GETCUSTOMERBYID = "SELECT * FROM customer WHERE userID = ?";
	public static String UPDATECUSTOMER = "UPDATE customer SET firstName = ? , lastName = ? , accountNumber = ? , email = ? , nic = ? , mobile = ? , address = ? , userName = ? , password = ? WHERE userID = ?";
	public static String DELETECUSTOMER = "DELETE FROM customer WHERE userID = ?";

}
