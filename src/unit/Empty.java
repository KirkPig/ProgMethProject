package unit;

import java.util.ArrayList;

import logic.Sprites;
import unit.base.Unit;

public class Empty extends Unit {

	public Empty(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Empty() {
		// TODO Auto-generated constructor stub
		super(0, 0);
	}

	@Override
	public int getSprites() {
		return Sprites.EMPTY;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		return null;
	}

}
