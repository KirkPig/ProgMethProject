package unit;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import logic.Sprites;
import unit.base.Unit;


public class Attacker extends Unit  {
	
	public Attacker(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Attacker(String name) {
		super(0, 0);
		setName(name);
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
				if(adjacentUnit.get(i).getSprites() != 0) {
					boolean end = true;
					while(end) {
						int x2 = adjacentUnit.get(i).getCoordinate().getX();
						int y2 = adjacentUnit.get(i).getCoordinate().getY();
						adjacentUnit = gameBoard.getAdjacentUnit(x2, y2);
						if(adjacentUnit.get(i).getSprites() == 0) {
							canMove.add(GameController.gameBoard.getUnit(adjacentUnit.get(i).getCoordinate().getX(), adjacentUnit.get(i).getCoordinate().getY()));
							end = false;
						}
					}
				}
			}
			return canMove;
		}else {
			gameBoard.addUnit(this, this.getCoordinate().getX(), this.getCoordinate().getY());
			return null;
		}
		
		
	}

	
	
	
}
