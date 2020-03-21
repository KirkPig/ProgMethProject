package logic;

public class Owner {
	
	private String name;
	private String teamName;
	private boolean placeCaptain;
	
	public Owner(String teamName) {
		// TODO Auto-generated constructor stub
		setTeamName(teamName);
	}
	
	public boolean isPlaceCaptain() {
		return placeCaptain;
	}
	
	public void setPlaceCaptain(boolean placeCaptain) {
		this.placeCaptain = placeCaptain;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamName() {
		return teamName;
	}
	

}
