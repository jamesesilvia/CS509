package client.abuse_report.models;

/**
 * The alleged abuser being accused of abusing the Victim.
 * @author Matt Orsini
 *
 */
public class Abuser extends Individual {

	private String socSecurityNum;
	private String dateOfBirth;

	/**
	 * Constructor for an Abuser. Superclass is an Individual.
	 */
	public Abuser(){
		// FIXME: empty constructor.
	}

	/**
	 * Returns the Social Security number for the Abuser.
	 * @return socSecurityNum
	 */
	public String getSocSecurityNum() {
		return socSecurityNum;
	}
	/**
	 * Set the Social Security number for the Abuser.
	 * @param socSecurityNum
	 */
	public void setSocSecurityNum(String socSecurityNum) {
		this.socSecurityNum = socSecurityNum;
	}

	/**
	 * Returns the date of birth for the Abuser.
	 * @return dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * Set the date of birth for the Abuser.
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}