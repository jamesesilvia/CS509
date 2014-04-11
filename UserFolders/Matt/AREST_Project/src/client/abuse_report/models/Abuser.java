package client.abuse_report.models;

/**
 * The alleged abuser being accused of abusing the Victim.
 * @author Matt Orsini
 *
 */
public class Abuser extends Individual {

	private String social;
	private String dob;
	private String relationshipToVictim;

	/**
	 * Constructor for an Abuser. Superclass is an Individual.
	 */
	public Abuser(){
		// FIXME: empty constructor.
	}

	/**
	 * Returns the Social Security number for the Abuser.
	 * @return social
	 */
	public String getSocial() {
		return social;
	}
	/**
	 * Set the Social Security number for the Abuser.
	 * @param social
	 */
	public void setSocial(String social) {
		this.social = social;
	}

	/**
	 * Returns the date of birth for the Abuser.
	 * @return dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * Set the date of birth for the Abuser.
	 * @param dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	/**
	 * Get the relationship to the victim. Each individual in the report has
	 * a relationship to the alleged victim.
	 * @return relationshipToVictim - the relationship to the victim
	 */
	public String getRelationshipToVictim() {
		return relationshipToVictim;
	}
	/**
	 * Set the relationship to the victim. Each individual in the report has
	 * a relationship to the alleged victim.
	 * @param relationshipToVictim - the relationship to the victim
	 */
	public void setRelationshipToVictim(String relationshipToVictim) {
		this.relationshipToVictim = relationshipToVictim;
	}

}