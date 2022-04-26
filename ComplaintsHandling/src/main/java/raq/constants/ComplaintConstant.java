package raq.constants;

public class ComplaintConstant {
	
	public static String GETALLCOMPLAINTS = "select accountNumber,complaintDate,nComplaint,anythingMoreToTell from complaints";
    public static String CREATECOMPLAINTS = "insert  into  complaints (accountNumber,complaintDate,nComplaint,anythingMoreToTell) values (?,?,?,?)";
    public static String GETCOMPLAINTSBYID = "SELECT * FROM complaints WHERE complaintID = ?";
    public static String UPDATECOMPLAINTS = "UPDATE complaints SET accountNumber = ? , complaintDate = ? , nComplaint = ? , anythingMoreToTell = ?  WHERE complaintID = ?";
    public static String DELETECOMPLAINTS = "DELETE FROM complaints WHERE complaintID = ?";
	
}
