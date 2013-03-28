package control;


/**
 * 
 * @author Michael and Timmy
 *
 */
public class Antibody {
	
	
	// Variables for objects of the type, Antibody:
	// Coded by Michael and Timmy.

	private int pk_AntibodyId;
	private int AbID;
	private String AbName;
	private String freezerType;
	private String freezerNumber;
	private String position;
	private String Gene;
	private String Epitope;
	private String Clonality;
	private String PrimarySecondary;
	private String Specificity;
	private String Modifications;
	private String Host;
	private String BatchNo;
	private String ExpiryDate;
	private String Manufacturer;
	private String Datasheet;
	private String Applications;
	private String ProtocolModifications;
	private String Notes;
	
	
	// Constructor for objects of the type, Antibody:
	// Coded by Michael and Timmy.
	
	public Antibody(int pk_AntibodyId, int abID, String abName,
			String freezerType, String freezerNumber, String position,
			String gene, String epitope, String clonality,
			String primarySecondary, String specificity, String modifications,
			String host, String batchNo, String expiryDate,
			String manufacturer, String datasheet, String applications,
			String protocolModifications, String notes) {
		
		this.pk_AntibodyId = pk_AntibodyId;
		this.AbID = abID;
		this.AbName = abName;
		this.freezerType = freezerType;
		this.freezerNumber = freezerNumber;
		this.position = position;
		this.Gene = gene;
		this.Epitope = epitope;
		this.Clonality = clonality;
		this.PrimarySecondary = primarySecondary;
		this.Specificity = specificity;
		this.Modifications = modifications;
		this.Host = host;
		this.BatchNo = batchNo;
		this.ExpiryDate = expiryDate;
		this.Manufacturer = manufacturer;
		this.Datasheet = datasheet;
		this.Applications = applications;
		this.ProtocolModifications = protocolModifications;
		this.Notes = notes;
	}
	
	// Getters and setters for objects of the type, Antibody:
	// Coded by Michael and Timmy.
	
	public int getPk_AntibodyId() {
		return pk_AntibodyId;
	}

	public void setPk_AntibodyId(int pk_AntibodyId) {
		this.pk_AntibodyId = pk_AntibodyId;
	}
	public int getAbID() {
		return AbID;
	}
	public void setAbID(int abID) {
		AbID = abID;
	}
	public String getAbName() {
		return AbName;
	}
	public void setAbName(String abName) {
		AbName = abName;
	}
		

	public String getFreezerType() {
		return freezerType;
	}


	public void setFreezerType(String freezerType) {
		this.freezerType = freezerType;
	}


	public String getFreezerNumber() {
		return freezerNumber;
	}


	public void setFreezerNumber(String freezerNumber) {
		this.freezerNumber = freezerNumber;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}

	public String getGene() {
		return Gene;
	}
	public void setGene(String gene) {
		Gene = gene;
	}
	public String getEpitope() {
		return Epitope;
	}
	public void setEpitope(String epitope) {
		Epitope = epitope;
	}
	public String getClonality() {
		return Clonality;
	}
	public void setClonality(String clonality) {
		Clonality = clonality;
	}
	public String getPrimarySecondary() {
		return PrimarySecondary;
	}
	public void setPrimarySecondary(String primarySecondary) {
		PrimarySecondary = primarySecondary;
	}
	public String getSpecificity() {
		return Specificity;
	}
	public void setSpecificity(String specificity) {
		Specificity = specificity;
	}
	public String getModifications() {
		return Modifications;
	}
	public void setModifications(String modifications) {
		Modifications = modifications;
	}
	public String getHost() {
		return Host;
	}
	public void setHost(String host) {
		Host = host;
	}
	public String getBatchNo() {
		return BatchNo;
	}
	public void setBatchNo(String batchNo) {
		BatchNo = batchNo;
	}
	public String getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public String getDatasheet() {
		return Datasheet;
	}
	public void setDatasheet(String datasheet) {
		Datasheet = datasheet;
	}
	public String getApplications() {
		return Applications;
	}
	public void setApplications(String applications) {
		Applications = applications;
	}
	public String getProtocolModifications() {
		return ProtocolModifications;
	}
	public void setProtocolModifications(String protocolModifications) {
		ProtocolModifications = protocolModifications;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	


}
