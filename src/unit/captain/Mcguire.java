package unit.captain;

import java.util.ArrayList;

import logic.GameController;
import unit.Captain;
import unit.Empty;
import unit.base.Unit;

public class Mcguire extends Captain{

	@Override
	public ArrayList<Unit> getMoveUnit() {
		// TODO Auto-generated method stub
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		int x = getCoordinate().getX();
		int y = getCoordinate().getY();
		for(Unit i: GameController.gameBoard.getAdjacentUnit(x, y)) {
			if(i instanceof Empty) {
				for(var j: GameController.gameBoard.getAdjacentUnit(i.getCoordinate().getX(), i.getCoordinate().getY())) {
					if(j.getCoordinate() != this.getCoordinate()) {
						if(!(j instanceof Empty)) {
							canMove.add(i);
							break;
						}
					}
				}
			}
		}
		return canMove;
	}
	
	

}
