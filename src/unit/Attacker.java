package unit;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import logic.Sprites;
import unit.base.Movable;
import unit.base.Unit;

public class Attacker extends Unit implements Movable{
	
	public Attacker(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Attacker(String name, String inactiveImageUrl, String activeImageUrl) {
		super(0, 0);
		setName(name);
		setInactiveImageUrl(inactiveImageUrl);
		setActiveImageUrl(activeImageUrl);
	}
	
	public Attacker() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.ATTACKER;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameBoard gameBoard = GameController.gameBoard;
		gameBoard.addUnit(new Empty(), this.getCoordinate().getX(), this.getCoordinate().getY());
		if(gameBoard.checkGameBoard()) {
			ArrayList<Unit> adjacentUnit = gameBoard.getAdjacentUnit(this.getCoordinate().getX(), this.getCoordinate().getY());
			for(int i = 0; i< adjacentUnit.size();i++) {
				if(adjacentUnit.get(i) != null && !(adjacentUnit.get(i) instanceof Empty)) {
					Unit unit = adjacentUnit.get(i);
					boolean end = true;
					while(end) {
						if(unit == null) {
							end = false;
						}else if(unit.getSprites() == 0) {
							canMove.add(unit);
							end = false;
						}else {
							unit = gameBoard.getAdjacentUnit(unit.getCoordinate().getX(), unit.getCoordinate().getY()).get(i);
						}
					}
				}
			}
			gameBoard.addUnit(this, this.getCoordinate().getX(), this.getCoordinate().getY());
			return canMove;
		}else {
			gameBoard.addUnit(this, this.getCoordinate().getX(), this.getCoordinate().getY());
			return canMove;
		}
		
		
	}

}
