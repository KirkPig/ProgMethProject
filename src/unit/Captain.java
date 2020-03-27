package unit;

import logic.GameController;
import logic.Sprites;
import unit.base.Unit;

public abstract class Captain extends Unit  {
	
	public Captain(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Captain(String name) {
		super(0, 0);
		setName(name);
	}
	
	public Captain() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.CAPTAIN;
	}
	
	public boolean isSurrounded() {
		int x = getCoordinate().getX();
		int y = getCoordinate().getY();
		for(var i : GameController.gameBoard.getAdjacentUnit(x, y)) {
			if(i instanceof Empty) {
				return false;
			}
		}
		return true;
	}

}
