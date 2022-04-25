package org.constants;

public class BillConstant {
	
	public static String GETALLBILL = "select AccNo,Fname,Lname,Address,MReading,Billdate,Nodates,Chargeunits,Nounits,Outsamount,Totalamonut from bill";
    public static String CREATEBILL = "insert  into  bill (AccNo,Fname,Lname,Address,MReading,Billdate,Nodates,Chargeunits,Nounits,Outsamount,Totalamonut) values (?,?,?,?,?,?,?,?,?,?,?)";
    public static String GETBILLBYID = "SELECT * FROM bill WHERE BillNo = ?";
    public static String UPDATEBILL = "UPDATE bill SET AccNo = ? , Fname = ? , Lname = ? , Address = ? , MReading = ? , Billdate = ? , Nodates = ? , Chargeunits = ? , Nounits = ? , Outsamount = ? , Totalamonut = ?  WHERE BillNo = ?";
    public static String DELETEBILL = "DELETE FROM bill WHERE BillNo = ?";

}
