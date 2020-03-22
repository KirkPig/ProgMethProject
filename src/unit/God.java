package unit;

import logic.Owner;
import logic.Sprites;
import unit.base.Unit;

public class God extends Unit {
	
	public God(Owner owner, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setOwner(owner);
	}
	
	public God(Owner owner) {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setOwner(owner);
	}

	@Override
	public int getSprites() {
		// TODO Auto-generated method stub
		return Sprites.GOD;
	}

}
