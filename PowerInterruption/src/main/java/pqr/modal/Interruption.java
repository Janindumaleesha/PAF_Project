package pqr.modal;

public class Interruption {
	
	private int interruptionID;
	private String date;
	private String timeSlot;
	private String locationID;
	private String area;
	private String reason;
	private String status;
	
	public Interruption(int interruptionID, String date, String timeSlot, String locationID, String area, String reason,
			String status) {
		this.interruptionID = interruptionID;
		this.date = date;
		this.timeSlot = timeSlot;
		this.locationID = locationID;
		this.area = area;
		this.reason = reason;
		this.status = status;
	}

	public Interruption() {
		
	}

	public int getInterruptionID() {
		return interruptionID;
	}

	public String getDate() {
		return date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public String getLocationID() {
		return locationID;
	}

	public String getArea() {
		return area;
	}

	public String getReason() {
		return reason;
	}

	public String getStatus() {
		return status;
	}

	public void setInterruptionID(int interruptionID) {
		this.interruptionID = interruptionID;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Interruption [interruptionID=" + interruptionID + ", date=" + date + ", timeSlot=" + timeSlot
				+ ", locationID=" + locationID + ", area=" + area + ", reason=" + reason + ", status=" + status + "]";
	}
	

}
