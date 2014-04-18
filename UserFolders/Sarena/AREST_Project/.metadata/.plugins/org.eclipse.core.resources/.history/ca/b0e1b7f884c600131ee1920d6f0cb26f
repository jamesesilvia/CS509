package client.abuse_report.models;

/** 
 * Individual describes the common attributes between all persons involved with
 * an abuse report.
 * 
 * @author Matt Orsini
 */

public class PersonInfo {

	public Long id;
	public String firstName;
	public String lastName;
	public String address;
	public String phoneNumber;

	/**
	 * Constructor
	 */
	public PersonInfo() {
	}
	
	/**
	 * Constructor used when only a name and phoneNumber number are needed.
	 * @param firstName
	 * @param phoneNumber
	 */
	public PersonInfo(String firstName, String phoneNumber) {
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
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
	 * Get the phoneNumber number of the individual.
	 * @return phoneNumber - the phoneNumber number of the individual
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set the phoneNumber number of the individual.
	 * @param phoneNumber - the phoneNumber number of the individual
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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