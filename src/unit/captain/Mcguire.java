package unit.captain;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import unit.Captain;
import unit.base.Unit;

public class Mcguire extends Captain {

	public Mcguire(int x, int y) {
		// TODO Auto-generated constructor stub
		super("Harry Mcguire", x, y);
	}

	public Mcguire() {
		// TODO Auto-generated constructor stub
		super("Harry Mcguire", 0, 0);
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		// TODO Auto-generated method stub
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameBoard gameBoard = GameController.gameBoard;
		ArrayList<ArrayList<Integer>> distance = gameBoard.getDistance(this.getCoordinate().getX(),
				this.getCoordinate().getY(), false);

		for (int i = 0; i < distance.size(); i++) {
			for (int j = 0; j < distance.size(); j++) {
				if (distance.get(i).get(j) == 1) {
					if (gameBoard.canMoveUnit(this.getCoordinate().getX(), this.getCoordinate().getY(), i, j,
							this.getOwner())) {
						canMove.add(GameController.gameBoard.getUnit(i, j));
					}
				}
			}
		}
		return canMove;
	}

}
