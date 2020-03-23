package unit;

import java.util.ArrayList;

import logic.Sprites;
import unit.base.Unit;

public class God extends Unit {
	
	public God(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public God(String name) {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName(name);
	}
	
	public God() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.GOD;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		return null;
	}

}
