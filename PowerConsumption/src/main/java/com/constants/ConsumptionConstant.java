package com.constants;

public class ConsumptionConstant {
	
	public static String GETALLCONSUMPTION = "select accountNumber,premisesID,month,date,units from consumption";
    public static String CREATECONSUMPTION = "insert  into consumption (accountNumber,premisesID,month,date,units) values (?,?,?,?,?)";
    public static String GETCONSUMPTIONBYID = "SELECT * FROM consumption WHERE consumptionID = ?";
    public static String UPDATECONSUMPTION = "UPDATE consumption SET accountNumber = ? , premisesID = ? , month = ? , date = ? , units = ?  WHERE consumptionID = ?";
    public static String DELETECONSUMPTION = "DELETE FROM consumption WHERE consumptionID = ?";

}
