package unit;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import logic.Sprites;
import unit.base.Unit;

public class Defender extends Unit{
	
	private Unit captureUnit = null;
	
	public Defender(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Defender(String name) {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName(name);
	}
	
	public Defender() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}
	
	public Unit getCaptureUnit() {
		return captureUnit;
	}
	
	public void setCaptureUnit(Unit captureUnit) {
		this.captureUnit = captureUnit;
	}

	@Override
	public int getSprites() {
		// TODO Auto-generated method stub
		return Sprites.DEFENDER;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameBoard gameBoard = GameController.gameBoard;
		ArrayList<ArrayList<Integer>> distance = gameBoard.getDistance(this.getCoordinate().getX(), this.getCoordinate().getY(), true);
		for(int i = 0 ; i< distance.size(); i++) {
			for(int j = 0; j < distance.size();j++) {
				if(distance.get(i).get(j) == 1) {
					canMove.add(GameController.gameBoard.getUnit(i, j));
				}
			}
		}
		return canMove;	
	}

}
