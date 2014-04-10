package client.model;

public class Guardian extends Individual{

	public static final int MAX_NUM_GUARDIANS = 2;
	
	protected String[] firstName;
	protected String[] lastName;
	
	public Guardian() {
		firstName = new String[MAX_NUM_GUARDIANS];
		lastName = new String[MAX_NUM_GUARDIANS];
	}
	
	/**
	 * Set the first name of the guardian at the specified index.
	 * @param name - the name to set.
	 * @param n    - the index to set the name at.
	 */
	public void setFirstNameAt(String name, int n){
		firstName[n] = name;
	}
	
	/**
	 * Get the first name of the guardian at the specified index.
	 * @param n - the index to get the guardian's first name.
	 * @return - the guardian's first name at the nth index.
	 */
	public String getFirstNameAt(int n){
		return firstName[n];
	}
	
	/**
	 * Set the last name of the guardian at the specified index.
	 * @param name - the name to set.
	 * @param n    - the index to set the last name at.
	 */
	public void setLastNameAt(String name, int n){
		lastName[n] = name;
	}
	
	/**
	 * Get the last name of the guardian a the specified index.
	 * @param n - the index to get the guardian's last name.
	 * @return - the guardian's last name at the nth index.
	 */
	public String getLastNameAt(int n) {
		return lastName[n];
	}
	
}
