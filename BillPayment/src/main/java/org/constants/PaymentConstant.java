package org.constants;

public class PaymentConstant {
	
	public static String GETALLPAYMENT = "select accno,pmethod,pamount from payment";
    public static String CREATEPAYMENT = "insert  into  payment (accno,pmethod,pamount) values (?,?,?)";
    public static String GETPAYMENTBYID = "SELECT * FROM payment WHERE pid = ?";
    public static String UPDATEPAYMENT = "UPDATE payment SET accno = ? , pmethod = ? , pamount = ?  WHERE pid = ?";
    public static String DELETEPAYMENT = "DELETE FROM payment WHERE pid = ?";

}
