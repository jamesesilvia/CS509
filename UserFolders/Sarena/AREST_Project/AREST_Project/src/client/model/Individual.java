package client.model;

/** 
 * Individual describes the common attributes between all persons involved with
 * an abuse report.
 * 
 * @author Matt Orsini
 */

// FIXME: Change to personinfo class. 
public class Individual {

	protected Long id;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected String telephone;

	/**
	 * Constructor
	 */
	public Individual() {
	}
	
	/**
	 * Constructor used when only a name and telephone number are needed.
	 * @param firstName
	 * @param telephone
	 */
	public Individual(String firstName, String telephone) {
		this.firstName = firstName;
		this.telephone = telephone;
		this.lastName = null;
		this.address = null;
	}


	/**
	 * Get the name of the required individual.
	 * @return name - the name of the individual
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Set the name of the required individual.
	 * @param name - the name of the individual
	 */
	public void setFirstName(String name) {
		this.firstName = name;
	}

	/**
	 * Return the address of the individual.
	 * @return address - the address of the individual
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Set the address of the individual.
	 * @param address - the address of the individual
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the telephone number of the individual.
	 * @return telephone - the telephone number of the individual
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Set the telephone number of the individual.
	 * @param telephone - the telephone number of the individual
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Get the last name of the individual.
	 * @return - the last name of the individual
	 */
	public String getLastName(){
		return lastName;
	}

	/**
	 * Set the last name of the individual.
	 * @param name - the last name of the individual
	 */
	public void setLastName(String name){
		this.lastName = name;
	}

}