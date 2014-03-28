package cs509.grp8.arest.report;

import com.sun.xml.internal.fastinfoset.util.StringArray;


/**
 * A victim is an Individual who has been allegedly abused by an Abuser.
 * @author Matt Orsini
 *
 */
public class Victim extends Individual {

	private boolean male;
	private boolean female;
	private String dateOfBirth;
	private String age;
	private String maritalStatus; 
	
	private StringArray disabilities = null;

	/**
	 * Constructor for Victim. Superclass is an Individual.
	 */
	public Victim(){
		// FIXME: Empty constructor.
	}

	/**
	 * Returns if the Victim is a male.
	 * @return male
	 */
	public boolean isMale() {
		return male;
	}
	/**
	 * Sets the Victim to male. Victims cannot be male and female, so female will be cleared.
	 * @param male
	 */
	public void setMale(boolean male) {
		if(male) {
			this.male = male;
			setFemale(false);
		}
	}

	/**
	 * Returns if the Victim is a female.
	 * @return female
	 */
	public boolean isFemale() {
		return female;
	}
	/**
	 * Sets the Victim is a female. Victims cannot be male and female, so male will be cleared.
	 * @param female
	 */
	public void setFemale(boolean female) {
		if(female){
			this.female = female;
			setMale(false);
		}
	}

	/**
	 * Returns the date of birth for the Victim.
	 * @return dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * Set the date of birth for the Victim.
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	 * @param n           - the index
	 */
	public void setDisabilities(StringArray disabilities, int n){
		this.disabilities = disabilities;
	}
	
	/**
	 * Gets all disabilities for this client.
	 * @return
	 */
	public StringArray getDisabilities() {
		return disabilities;
	}
	
	/**
	 * Returns the disability at a specified index.
	 * @param n
	 * @return
	 */
	public String getDisabilityAt(int n) {
		return disabilities.get(n);
	}

}