package unit;

import java.util.ArrayList;

import logic.Sprites;
import unit.base.Unit;

public class BoxToBox extends Unit {
	
	public BoxToBox(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public BoxToBox(String name) {
		super(0, 0);
		setName(name);
	}
	
	public BoxToBox() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.BOXTOBOX;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		return null;
	}

}
