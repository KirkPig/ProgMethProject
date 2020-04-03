package unit;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import logic.Sprites;
import unit.base.Movable;
import unit.base.Unit;
import unit.captain.Mcguire;

public class Defender extends Unit implements Movable{
	
	private Unit captureUnit = null;
	
	public Defender(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Defender(String name, String inactiveImageUrl, String activeImageUrl) {
		super(0, 0);
		setName(name);
		setInactiveImageUrl(inactiveImageUrl);
		setActiveImageUrl(activeImageUrl);
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
		System.out.println("---------------------------------------");
		/*for(int i = 0 ; i< distance.size();i++) {
			String rowstring = "";
			if(i%2==1) {
				rowstring += " ";
			}
			for(int j = 0; j < distance.size();j++) {
				if(distance.get(i).get(j) == 1000000000) {
					rowstring += "- ";
				}else {
					rowstring += distance.get(i).get(j).toString() + " ";
				}
			}
			System.out.println(rowstring);
		}*/
		for(int i = 0 ; i< distance.size(); i++) {
			for(int j = 0; j < distance.size();j++) {
				if(distance.get(i).get(j) == 1 && !(gameBoard.getUnit(i, j) instanceof Mcguire)) {
					for(Unit u: gameBoard.getAdjacentUnit(i, j)) {
						if(u == null) {
							continue;
						}
						if(!(u instanceof Empty) && u != this) {
							canMove.add(gameBoard.getUnit(i, j));
							//System.out.println(gameBoard.getUnit(i, j).getCoordinate().toString());
							break;
						}
					}
				}
			}
		}
		return canMove;	
	}

}
