package unit;

import logic.Owner;
import logic.Sprites;
import unit.base.Unit;

public class Playmaker extends Unit{
	
	public Playmaker(Owner owner) {
		// TODO Auto-generated constructor stub
		setOwner(owner);
	}

	@Override
	public int getSprites() {
		// TODO Auto-generated method stub
		return Sprites.PLAYMAKER;
	}

}
