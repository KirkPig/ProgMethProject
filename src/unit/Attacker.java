package unit;

import java.util.ArrayList;

import logic.Sprites;
import unit.base.Unit;


public class Attacker extends Unit  {
	
	public Attacker(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Attacker(String name) {
		super(0, 0);
		setName(name);
	}
	
	public Attacker() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.ATTACKER;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		return null;
	}

	
	
	
}
