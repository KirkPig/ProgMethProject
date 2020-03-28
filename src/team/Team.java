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
		setUnitNotUsed(name);
		setUnitUsed(new ArrayList<Unit>());
	}
	
	public void setUnitNotUsed(String name) {
		if(name.equals("liverpool")) {
			ArrayList<Unit> clone = new ArrayList<Unit>(TeamSet.liverpool);
			this.unitNotUsed = clone;
		}else if(name.equals("manCity")) {
			ArrayList<Unit> clone = new ArrayList<Unit>(TeamSet.manCity);
			this.unitNotUsed = clone;
		}
		else if(name.equals("spur")) {
			ArrayList<Unit> clone = new ArrayList<Unit>(TeamSet.spur);
			this.unitNotUsed = clone;
		}
		else if(name.equals("manUnited")) {
			ArrayList<Unit> clone = new ArrayList<Unit>(TeamSet.manUnited);
			this.unitNotUsed = clone;
		}
	}
	
	public void useUnit(Unit unit) {
		this.unitNotUsed.remove(unit);
		this.unitUsed.add(unit);
	}
	
	public void setUnitUsed(ArrayList<Unit> unitUsed) {
		this.unitUsed = unitUsed;
	}
	
	public ArrayList<Unit> getUnitNotUsed() {
		return this.unitNotUsed;
	}
	
	public ArrayList<Unit> getUnitUsed() {
		return this.unitUsed;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
