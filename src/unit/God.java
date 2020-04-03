package unit;

import java.util.ArrayList;

import logic.GameController;
import logic.Sprites;
import unit.base.Movable;
import unit.base.Unit;

public class God extends Unit implements Movable {

	private int random;

	public God(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}

	public God(String name, String inactiveImageUrl, String activeImageUrl) {
		super(0, 0);
		setName(name);
		setInactiveImageUrl(inactiveImageUrl);
		setActiveImageUrl(activeImageUrl);
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

	public void randomUnit() {
		int max = 6;
		int min = 2;
		int range = max - min + 1;
		int random = (int) (Math.random() * range) + min;
		setRandom(random);
	}

	public void setRandom(int random) {
		this.random = random;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		Unit[] unit = new Unit[1];
		if (getRandom() == 2) {
			unit[0] = new Attacker(getName(), getCoordinate().getX(), getCoordinate().getY());
		}
		if (getRandom() == 3) {
			unit[0] = new BoxToBox(getName(), getCoordinate().getX(), getCoordinate().getY());
		}
		if (getRandom() == 4) {
			unit[0] = new Goalkeeper(getName(), getCoordinate().getX(), getCoordinate().getY());
		}
		if (getRandom() == 5) {
			unit[0] = new Playmaker(getName(), getCoordinate().getX(), getCoordinate().getY());
		}
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameController.gameBoard.placeUnit(unit[0], getCoordinate().getX(), getCoordinate().getY(), getOwner());
		canMove = unit[0].getMoveUnit();
		GameController.gameBoard.placeUnit(this, getCoordinate().getX(), getCoordinate().getY(), getOwner());
		return canMove;
	}

	public int getRandom() {
		return random;
	}

}
