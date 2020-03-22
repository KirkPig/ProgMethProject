package unit;

import logic.Owner;
import logic.Sprites;
import unit.base.Unit;

public class Goalkeeper extends Unit {
	
	public Goalkeeper(Owner owner, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setOwner(owner);
	}
	
	public Goalkeeper(Owner owner) {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setOwner(owner);
	}

	@Override
	public int getSprites() {
		// TODO Auto-generated method stub
		return Sprites.GOALKEEPER;
	}

}
