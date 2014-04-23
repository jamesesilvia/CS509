package client.model;

/**
 * This class contains all relevant information to the abuse report. An abuse report is constructed of the following:
 * 1.) A reporter - the person who files the report.
 * 2.) An Abuser  - the person who is alleged of abusing a client.
 * 3.) A guardian (if necessary) - person responsible for the victim outside the alleged victim's caretaker.
 * 4.) A victim   - the person who is allegedly being or has been abused.
 * 
 * @author Matt Orsini
 *
 */

public class Report implements Cloneable {
	
	public Long id;	
	public Reporter reporter;
	public Abuser   abuser;
	public Guardian guardian;
	public Victim   victim;
	public PersonInfo collateralContact1;
	public PersonInfo collateralContact2;
	public PersonInfo collateralContact3;
	public PersonInfo collateralContact4;
	public PersonInfo collateralContact5;
	public String abuseDescr;
	public String victimRisk;
	public String injuryList;
	public String witnesses;
	public String caregiverRel;
	public boolean isOralReportFiled;
	public String oralReportFiledTime;
	public boolean isRiskToInvestigator;
	public String riskDescrToInvestigator;
	public String username;
	public String result;
	public String status;
	public String date; // date of report filed. FIXME: Do we need this.
	
	/**
	 * Construction of a new report container. Create the necessary objects an initializes the booleans 
	 * required for this abuse report.
	 */
	public Report() {
		// Construct new objects
		setReporter(new Reporter());
		setAbuser(new Abuser());
		setGuardian(new Guardian());
		setVictim(new Victim());
		
		// False unless set otherwise.
		setOralReportFiled(false);
		setRiskToInvestigator(false);
	}
	
	public Report(Report anotherReport) {
			
	}
	
	@Override
	public Report clone() throws CloneNotSupportedException {
		return (Report) super.clone();
	}
	
	/**
	 * Get the reporter in this report container.
	 * @return the reporter.
	 */
	public Reporter getReporter() {
		return reporter;
	}

	/**
	 * Set the reporter in this report container.
	 * @param reporter - the reporter to set.
	 */
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

	/**
	 * Get the guardian in this report container.
	 * @return the guardian.
	 */
	public Guardian getGuardian() {
		return guardian;
	}

	/**
	 * Set the guardian in this report container.
	 * @param guardian - the guardian to set.
	 */
	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	/**
	 * Get the abuser in this report container.
	 * @return the abuser.
	 */
	public Abuser getAbuser() {
		return abuser;
	}

	/**
	 * Set the abuser in this report container.
	 * @param abuser - the abuser.
	 */
	public void setAbuser(Abuser abuser) {
		this.abuser = abuser;
	}

	/**
	 * Get the victim in this report container.
	 * @return the victim.
	 */
	public Victim getVictim() {
		return victim;
	}

	/**
	 * Set the victim in this report container.
	 * @param victim - the victim to set.
	 */
	public void setVictim(Victim victim) {
		this.victim = victim;
	}

	
	/**
	 * Get the abuse description for this report.
	 * @return the abuse description.
	 */
	public String getAbuseDescr() {
		return abuseDescr;
	}
	
	/**
	 * Set the abuse description for this abuse report.
	 * @param abuseDescr - the abuse description.
	 */

	public void setAbuseDescr(String abuseDescr) {
		this.abuseDescr = abuseDescr;
	}

	/**
	 * Get the potential risk to the victim.
	 * @return the risk to the victim.
	 */
	public String getVictimRisk() {
		return victimRisk;
	}

	/**
	 * Set the potential risk to the victim.
	 * @param victimRisk - the risk to the victim.
	 */
	public void setVictimRisk(String victimRisk) {
		this.victimRisk = victimRisk;
	}

	/**
	 * Get the injury list associated with this abuse report.
	 * @return - the injury list to the victim.
	 */
	public String getInjuryList() {
		return injuryList;
	}

	/**
	 * Set the injury list for this abuse report.
	 * @param injuryList
	 */
	public void setInjuryList(String injuryList) {
		this.injuryList = injuryList;
	}

	/**
	 * Get the witnesses of the reported abuse.
	 * @return the witnesses of the abuse.
	 */
	public String getWitnesses() {
		return witnesses;
	}

	/**
	 * Set the witnesses of the reported abuse.
	 * @param witnesses - the witnesses of the abuse.
	 */
	public void setWitnesses(String witnesses) {
		this.witnesses = witnesses;
	}

	/**
	 * Get the relationship between the alleged abuser and the alleged victim. This could be
	 * the assistance, if any, the alleged abuser provides to the person with the disability.
	 * @return the relationship between the alleged abuser and the alleged victim.
	 */
	public String getCaregiverRel() {
		return caregiverRel;
	}

	/**
	 * Set the relationship between the alleged abuser and the alleged victim. This could be
	 * the assistance, if any, the alleged abuser provides to the person with the disability.
	 * @param caregiverRel - the relationship between the alleged abuser and the alleged victim.
	 */
	public void setCaregiverRel(String caregiverRel) {
		this.caregiverRel = caregiverRel;
	}

	/**
	 * Returns whether or not an oral report has been filed with the DPPC hotline. 
	 * @return - true if a report has been filed, false otherwise.
	 */
	public boolean isIsOralReportFiled() {
		return isOralReportFiled;
	}

	/**
	 * Sets whether or not an oral report has been filed with the DPPC hotline.
	 * @param isOralReportFiled - whether or not a report has been filed with the DPPC hotline.
	 */
	public void setOralReportFiled(boolean isOralReportFiled) {
		this.isOralReportFiled = isOralReportFiled;
	}

	/**
	 * Returns when the last time in which an oral report was filed.
	 * @return - the time the oral report was filed.
	 */
	public String getOralReportFiledTime() {
		return oralReportFiledTime;
	}

	/**
	 * Sets the oral report filed time. This is a date, month, hour, and minute representation
	 * of the last time the report was filed on the DPPC hotline.
	 * @param oralReportFiledTime
	 */
	public void setOralReportFiledTime(String oralReportFiledTime) {
		this.oralReportFiledTime = oralReportFiledTime;
	}

	/**
	 * Returns whether or not there is a potential risk to the investigator.
	 * @return - true if a risk exists, false otherwise.
	 */
	public boolean isIsRiskToInvestigator() {
		return isRiskToInvestigator;
	}

	/**
	 * Set as true if a risk to the investigator exists in this abuse case. Do not set otherwise.
	 * @param isRiskToInvestigator
	 */
	public void setRiskToInvestigator(boolean isRiskToInvestigator) {
		this.isRiskToInvestigator = isRiskToInvestigator;
	}

	/**
	 * Returns the potential risk(s) to the investigator.
	 * @return the risk to the investigator.
	 */
	public String getRiskDescrToInvestigator() {
		return riskDescrToInvestigator;
	}

	/**
	 * Sets the potential risk(s) to the investigator.
	 * @param riskToInvestigator - the risk(s) to the investigator.
	 */
	public void setRiskDescrToInvestigator(String riskDescrToInvestigator) {
		this.riskDescrToInvestigator = riskDescrToInvestigator;
	}


	/**
	 * Get the current status of this outstanding abuse report.
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the current status of this outstanding abuse report.
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the result of the closed abuse report.
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Set the result of the closed abuse report.
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Get the username of the persxon filing or editing the report.
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the username of the person filing or editing the report.
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the ID of this report. This is also the public log number.
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the I Dof this report. This is also the public log number.
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the collateralContact1
	 */
	public PersonInfo getCollateralContact1() {
		return collateralContact1;
	}

	/**
	 * @param collateralContact1 the collateralContact1 to set
	 */
	public void setCollateralContact1(PersonInfo collateralContact1) {
		this.collateralContact1 = collateralContact1;
	}

	/**
	 * @return the collateralContact2
	 */
	public PersonInfo getCollateralContact2() {
		return collateralContact2;
	}

	/**
	 * @param collateralContact2 the collateralContact2 to set
	 */
	public void setCollateralContact2(PersonInfo collateralContact2) {
		this.collateralContact2 = collateralContact2;
	}

	/**
	 * @return the collateralContact4
	 */
	public PersonInfo getCollateralContact4() {
		return collateralContact4;
	}

	/**
	 * @param collateralContact4 the collateralContact4 to set
	 */
	public void setCollateralContact4(PersonInfo collateralContact4) {
		this.collateralContact4 = collateralContact4;
	}

	/**
	 * @return the collateralContact5
	 */
	public PersonInfo getCollateralContact5() {
		return collateralContact5;
	}

	/**
	 * @param collateralContact5 the collateralContact5 to set
	 */
	public void setCollateralContact5(PersonInfo collateralContact5) {
		this.collateralContact5 = collateralContact5;
	}

	/**
	 * @return the collateralContact3
	 */
	public PersonInfo getCollateralContact3() {
		return collateralContact3;
	}

	/**
	 * @param collateralContact3 the collateralContact3 to set
	 */
	public void setCollateralContact3(PersonInfo collateralContact3) {
		this.collateralContact3 = collateralContact3;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
}
