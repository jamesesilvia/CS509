
package client.abuse_report.models;


/**
 * A reporter is the individual who is reporting the incident. Superclass
 * is an Individual.
 * @author Matt Orsini
 *
 */
public class Reporter extends Individual {

	private boolean mandated;

	/**
	 * Constructor for a reporter. Superclass is an Individual.
	 */
	public Reporter(){

	}

	/**
	 * Determine if the reporter is mandated or non-mandated.
	 * @return mandated
	 */
	public boolean isMandated() {
		return mandated;
	}
	/**
	 * Set if the reporter is mandated.
	 * @param mandated
	 */
	public void setMandated(boolean mandated) {
		this.mandated = mandated;
	}

	/**
	 * Checks if the first name of the reporter has been altered in the GUI by the user.
	 * @param name
	 * @return
	 */
	private boolean checkString(String name1, String name2) {
		boolean passed = false;
		if(name1.equals(name2)) {
			passed = true;
		}
		return passed;
	}

}