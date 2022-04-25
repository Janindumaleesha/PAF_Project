package pqr.constants;

public class InterruptionConstant {
	
	public static String GETALLINTERRUPTION = "select date,timeSlot,locationID,area,reason,status from interruption";
    public static String CREATEINTERRUPTION= "insert into interruption (date,timeSlot,locationID,area,reason,status) values (?,?,?,?,?,?)";
    public static String GETINTERRUPTIONBYID = "SELECT * FROM interruption WHERE interruptionID = ?";
    public static String UPDATEINTERRUPTION = "UPDATE interruption SET date = ? , timeSlot = ? , locationID = ? , area = ? , reason = ? , status = ?  WHERE interruptionID = ?";
    public static String DELETEINTERRUPTION = "DELETE FROM interruption WHERE interruptionID = ?";

}
