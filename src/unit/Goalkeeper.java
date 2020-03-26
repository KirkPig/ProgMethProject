package unit;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import logic.Sprites;
import unit.base.Unit;

public class Goalkeeper extends Unit {
	
	public Goalkeeper(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Goalkeeper(String name) {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName(name);
	}
	
	public Goalkeeper() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.GOALKEEPER;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameBoard gameBoard = new GameBoard();
		ArrayList<ArrayList<Integer>> distance = gameBoard.getDistance(this.getCoordinate().getX(), this.getCoordinate().getY(), false);
		for(int i = 0 ; i< distance.size(); i++) {
			for(int j = 0; j < distance.size();j++) {
				if(distance.get(i).get(j) == 3) {
					canMove.add(GameController.gameBoard.getUnit(i, j));
				}
				}
			}
		return canMove;	
		}
}
