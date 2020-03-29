package team;

import java.util.ArrayList;

import unit.Attacker;
import unit.BoxToBox;
import unit.Captain;
import unit.Defender;
import unit.Goalkeeper;
import unit.God;
import unit.Playmaker;
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
	
	public Unit getUnit(int position) {
		
		/*Position number
		 * 1)Captain
		 * 2)Attacker
		 * 3)BoxtoBox
		 * 4)Defender
		 * 5)Goalkeeper
		 * 6)Playmaker
		 * 7)God
		 */
		
		switch(position) {
		case 1:
			for(Unit u: unitNotUsed) {
				if(u instanceof Captain) {
					return u;
				}
			}
			return null;
		case 2:
			for(Unit u: unitNotUsed) {
				if(u instanceof Attacker) {
					return u;
				}
			}
			return null;
		case 3:
			for(Unit u: unitNotUsed) {
				if(u instanceof BoxToBox) {
					return u;
				}
			}
			return null;
		case 4:
			for(Unit u: unitNotUsed) {
				if(u instanceof Defender) {
					return u;
				}
			}
			return null;
		case 5:
			for(Unit u: unitNotUsed) {
				if(u instanceof Goalkeeper) {
					return u;
				}
			}
			return null;
		case 6:
			for(Unit u: unitNotUsed) {
				if(u instanceof Playmaker) {
					return u;
				}
			}
			return null;
		case 7:
			for(Unit u: unitNotUsed) {
				if(u instanceof God) {
					return u;
				}
			}
			return null;
		}
		
		return null;
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
