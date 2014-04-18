package client.model;

/**
 * Describes the properties of a guardian of the alleged victim.
 * @author Matt Orsini
 *
 */
public class Guardian extends PersonInfo {

	//public Long id;
	public String relationshipToVictim;
	
	public Guardian() {
		
	}

	public String getRelationshipToVictim() {
		return relationshipToVictim;
	}

	public void setRelationshipToVictim(String relationshipToVictim) {
		this.relationshipToVictim = relationshipToVictim;
	}
		
}
