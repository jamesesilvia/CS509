package client.abuse_report.models;


/**
 * A victim is an Individual who has been allegedly abused by an Abuser.
 * @author Matt Orsini
 *
 */
public class Victim extends PersonInfo {

	//public Long id;
	public String sex;
	public String dob;
	public String age;
	public String maritalStatus; 
	
	public String disability;
	public String ethnicity;
	public String communicationNeeds;
	public String currentlyServedBy;
	public boolean awarenessOfReport;
	public String typeOfService;
	public String typesOfAbuse;
	public String freqOfAbuse;
	public String dateOfLastIncident;

	/**
	 * Constructor for Victim. Superclass is an Individual.
	 */
	public Victim(){
	}


	/**
	 * Returns the date of birth for the Victim.
	 * @return the date of birth
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * Set the date of birth for the Victim.
	 * @param dateOfBirth
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * Returns the age of the Victim.
	 * @return age
	 */
	public String getAge() {
		return age;
	}
	
	/**
	 * Set the age of the Victim.
	 * @param string
	 */
	public void setAge(String string) {
		this.age = string;
	}

	/**
	 * Returns the marital status of the Victim.
	 * @return
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}
	/**
	 * Sets the marital status of the Victim. 
	 * 	@param maritalStatus
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	/**
	 * Sets the disabilities for this client.
	 * @param disability  - the disability
	 */
	public void setDisability(String disability){
		this.disability = disability;
	}
	
	/**
	 * Gets all disabilities for this client.
	 * @return disabilities - the disability array.
	 */
	public String getDisability(){
		return disability;
	}
	
	/**
	 * Get the ethnicity for this client.
	 * @return ethnicity - the ethnicity of the client.
	 */
	public String getEthnicity() {
		return ethnicity;
	}

	/**
	 * Set the ethnicity for this client.
	 * @param ethnicity - the ethnicity of the client.
	 */
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	
	/**
	 * Set the communication needs for thsi client.
	 * @param comNeeds
	 */
	public void setCommunicationNeeds(String communicationNeeds) {
		this.communicationNeeds = communicationNeeds;
	}
	
	/**
	 * Get the communication needs for this client.
	 */
	public String getCommunicationNeeds() {
		return communicationNeeds;
	}

	
	/**
	 * @return if the client is aware of this abuse report.
	 */
	public boolean isAwarenessOfReport() {
		return awarenessOfReport;
	}
	
	/**
	 * @param awareOfReport is the client's awareness of this abuse report.
	 */
	public void setAwareOfReport(boolean awarenessOfReport) {
		this.awarenessOfReport = awarenessOfReport;
	}

	/**
	 * Get the type of service.
	 * @return the type of service.
	 */
	public String getTypeOfService() {
		return typeOfService;
	}

	/**
	 * Set the type of service
	 * @param typeOfService - the typeOfService
	 */
	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	/**
	 * Get all types of abuse.
	 * @return the typesOfAbuse
	 */
	public String getTypesOfAbuse() {
		return typesOfAbuse;
	}
	
	/**
	 * Set all types of abuse.
	 * @param typesOfAbuse - the types of abuse.
	 */
	public void setTypesOfAbuse(String typesOfAbuse) {
		this.typesOfAbuse = typesOfAbuse;
	}
	
	/**
	 * Gets the frequency of abuse.
	 * @return the freqOfAbuse
	 */
	public String getFreqOfAbuse() {
		return freqOfAbuse;
	}

	/**
	 * Set the frequency of abuse.
	 * @param freqOfAbuse the freqOfAbuse to set
	 */
	public void setFreqOfAbuse(String freqOfAbuse) {
		this.freqOfAbuse = freqOfAbuse;
	}

	/**
	 * Get the date of the last incident.
	 * @return the dateOfLastIncident
	 */
	public String getDateOfLastIncident() {
		return dateOfLastIncident;
	}

	/**
	 * Set the date of the last incident.
	 * @param dateOfLastIncident the dateOfLastIncident to set
	 */
	public void setDateOfLastIncident(String dateOfLastIncident) {
		this.dateOfLastIncident = dateOfLastIncident;
	}

	/**
	 * Returns the services provided to this victim.
	 * @return the services provided to this victim.
	 */
	public String getCurrentlyServedBy() {
		return currentlyServedBy;
	}
	
	
	/**
	 * Set the services provided to this victim.
	 * @param currServedBy - the services provided to this victim.
	 */
	public void setCurrentlyServedBy(String currServedBy) {
		this.currentlyServedBy = currServedBy;
	}


	/**
	 * Gets the sex of this victim.
	 * @return the sex of this victim.
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the sex of this victim.
	 * @param sex - the sex of this victim.
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}