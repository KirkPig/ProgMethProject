package team;

import java.util.ArrayList;

import unit.base.Unit;

public class Team {
	
	private String name;
	private ArrayList<Unit> unitUsed;
	private ArrayList<Unit> unitNotUsed;
	
	public Team(String name) {
		// TODO Auto-generated constructor stub
		setName(name);
		setUnitNotUsed(new ArrayList<Unit>());
		setUnitUsed(new ArrayList<Unit>());
	}
	
	public void setUnitNotUsed(ArrayList<Unit> unitNotUsed) {
		this.unitNotUsed = unitNotUsed;
	}
	
	public void setUnitUsed(ArrayList<Unit> unitUsed) {
		this.unitUsed = unitUsed;
	}
	
	public ArrayList<Unit> getUnitNotUsed() {
		return unitNotUsed;
	}
	
	public ArrayList<Unit> getUnitUsed() {
		return unitUsed;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
