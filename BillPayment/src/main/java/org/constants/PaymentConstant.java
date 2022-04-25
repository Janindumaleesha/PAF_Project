package org.constants;

public class PaymentConstant {
	
	public static String GETALLPAYMENT = "select AccNo,Fname,Lname,email,Pmethod,pamount from payment";
    public static String CREATEPAYMENT = "insert  into  payment (AccNo,Fname,Lname,email,Pmethod,pamount) values (?,?,?,?,?,?)";
    public static String GETPAYMENTBYID = "SELECT * FROM payment WHERE pid = ?";
    public static String UPDATEPAYMENT = "UPDATE payment SET AccNo = ? , Fname = ? , Lname = ? , email = ? , Pmethod = ? , pamount = ?  WHERE pid = ?";
    public static String DELETEPAYMENT = "DELETE FROM payment WHERE pid = ?";

}
