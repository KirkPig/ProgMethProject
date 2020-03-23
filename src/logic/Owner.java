package logic;

import java.util.ArrayList;

import team.Team;
import unit.base.Unit;

public class Owner {
	
	private String name;
	private boolean placeCaptain;
	private Team team;
	
	public Owner(String teamName) {
		// TODO Auto-generated constructor stub
		setTeam(new Team(teamName));
		setPlaceCaptain(false);
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Team getTeam() {
		return team;
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
