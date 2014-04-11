package client.abuse_report.models;

public class Guardian extends Individual{

	private String relationshipToVictim;
	
	public Guardian() {
	
	}

	public String getRelationshipToVictim() {
		return relationshipToVictim;
	}

	public void setRelationshipToVictim(String relationshipToVictim) {
		this.relationshipToVictim = relationshipToVictim;
	}
		
}
