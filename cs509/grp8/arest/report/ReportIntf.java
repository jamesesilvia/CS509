package cs509.grp8.arest.report;

/**
 * This interface represents communication with an abuse report form. 
 * @author Matt Orsini
 *
 */
public interface ReportIntf {

	/** 
	 * Set the reporter of this incident. This field is required.
	 * @param reporter
	 */
	void setReporter(Object reporter);
	
	/**
	 * Set the Alleged Victim of incident. This field is required.
	 * @param victim
	 */
	void setAllegedVictim(Object victim);
	
	/**
	 * Set the Alleged Abuser of incident. This field is required.
	 * @param abuser
	 */
	void setAllegedAbuser(Object abuser);
	
	/**
	 * Set the Guardian of the Alleged Victim. This field is NOT required, if none exists.
	 * @param guardian
	 */
	void setGuardian(Object guardian);
	
}
