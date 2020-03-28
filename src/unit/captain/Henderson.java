package unit.captain;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import unit.Captain;
import unit.Empty;
import unit.base.Unit;

public class Henderson extends Captain {

	@Override
	public ArrayList<Unit> getMoveUnit() {
		// TODO Auto-generated method stub
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameBoard gameBoard = GameController.gameBoard;
		ArrayList<ArrayList<Integer>> distance = gameBoard.getDistance(this.getCoordinate().getX(), this.getCoordinate().getY(), false);
		for(int i = 0 ; i< distance.size(); i++) {
			for(int j = 0; j < distance.size();j++) {
				if(distance.get(i).get(j) == 1 || distance.get(i).get(j) == 2) {
					for(var k: GameController.gameBoard.getAdjacentUnit(i, j)) {
						if(k.getCoordinate() != this.getCoordinate()) {
							if(!(k instanceof Empty)) {
								canMove.add(k);
								break;
							}
						}
					}
				}
			}
		}
		return canMove;	
	}

}