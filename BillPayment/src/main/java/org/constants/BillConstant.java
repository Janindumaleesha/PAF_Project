package org.constants;

public class BillConstant {
	
	public static String GETALLBILL = "select accNo,mreading,billdate,nodates,chargeunits,nounits,outsamount,totalamount from bill";
    public static String CREATEBILL = "insert  into  bill (accNo,mreading,billdate,nodates,chargeunits,nounits,outsamount,totalamount) values (?,?,?,?,?,?,?,?)";
    public static String GETBILLBYID = "SELECT * FROM bill WHERE billno = ?";
    public static String UPDATEBILL = "UPDATE bill SET accNo = ? , mreading = ? , billdate = ? , nodates = ? , chargeunits = ? , nounits = ? , outsamount = ? , totalamount = ?  WHERE billno = ?";
    public static String DELETEBILL = "DELETE FROM bill WHERE billno = ?";

}
