package unit;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import logic.Sprites;
import unit.base.Movable;
import unit.base.Unit;

public class BoxToBox extends Unit implements Movable{
	
	public BoxToBox(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public BoxToBox(String name) {
		super(0, 0);
		setName(name);
	}
	
	public BoxToBox() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.BOXTOBOX;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameBoard gameBoard = GameController.gameBoard;
		ArrayList<ArrayList<Integer>> distance = gameBoard.getDistance(this.getCoordinate().getX(), this.getCoordinate().getY(), false);
		for(int i = 0 ; i< distance.size();i++) {
			for(int j = 0; j < distance.size();j++) {
				
			}
		}
		for(int i = 0 ; i< distance.size();i++) {
			for(int j = 0; j < distance.size();j++) {
				if (distance.get(i).get(j) != 1000000000 && 
						gameBoard.canMoveUnit(this.getCoordinate().getX(), this.getCoordinate().getY(), i, j, this.getOwner())) {
					System.out.println(GameController.gameBoard.getUnit(i, j).getCoordinate().toString());
					canMove.add(GameController.gameBoard.getUnit(i, j));
				}
			}
			
		}
		return canMove;
		
	}

}
