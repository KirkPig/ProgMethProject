package unit;

import logic.Sprites;
import unit.base.Unit;

public class Empty extends Unit {

	@Override
	public int getSprites() {
		return Sprites.EMPTY;
	}

}
