package unit;

import java.util.ArrayList;

import logic.Sprites;
import unit.base.Unit;

public class Goalkeeper extends Unit {
	
	public Goalkeeper(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Goalkeeper(String name) {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName(name);
	}
	
	public Goalkeeper() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.GOALKEEPER;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		return null;
	}

}
