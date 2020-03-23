package unit;

import java.util.ArrayList;

import logic.Sprites;
import unit.base.Unit;

public class Playmaker extends Unit{
	
	public Playmaker(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Playmaker(String name) {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName(name);
	}
	
	public Playmaker() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.PLAYMAKER;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		return null;
	}

}
