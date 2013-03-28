package control;

public class Storage {
	

	private String freezerType;
	private String freezerNo;
	private String position;
	private String note;

	
	public Storage(String freezerType, String freezerNo, String position, String note) 
	
	{
		this.freezerType = freezerType;
		this.freezerNo = freezerNo;
		this.position = position;
		this.note = note;
	}


	public String getFreezerType() {
		return freezerType;
	}


	public void setFreezerType(String freezerType) {
		this.freezerType = freezerType;
	}


	public String getFreezerNo() {
		return freezerNo;
	}


	public void setFreezerNo(String freezerNo) {
		this.freezerNo = freezerNo;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}
	
	
	

}
