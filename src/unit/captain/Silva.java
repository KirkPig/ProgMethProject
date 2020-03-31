package unit.captain;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import unit.Captain;
import unit.Defender;
import unit.Empty;
import unit.base.Skilled;
import unit.base.Unit;

public class Silva extends Captain implements Skilled {

	private Defender def;
	
	public Silva(int x, int y) {
		// TODO Auto-generated constructor stub
		super("David Silva", x, y);
	}

	public Silva() {
		// TODO Auto-generated constructor stub
		super("David Silva", 0, 0);
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		// TODO Auto-generated method stub
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameBoard gameBoard = GameController.gameBoard;
		ArrayList<ArrayList<Integer>> distance = gameBoard.getDistance(this.getCoordinate().getX(), this.getCoordinate().getY(), false);
		for(int i = 0 ; i< distance.size(); i++) {
			for(int j = 0; j < distance.size();j++) {
				if(distance.get(i).get(j) == 1) {
					if(gameBoard.canMoveUnit(this.getCoordinate().getX(), this.getCoordinate().getY(), i, j, this.getOwner())) {
						canMove.add(GameController.gameBoard.getUnit(i, j));
					}
				}
			}
		}
		return canMove;
	}

	@Override
	public ArrayList<Unit> useSkill() {
		// TODO Auto-generated method stub
		ArrayList<Unit> canExit = new ArrayList<Unit>();
		GameBoard gameBoard = new GameBoard();
		for(int i = 0;i< 10; i++) {
			for (int j= 0; j<10;j++) {
				if(gameBoard.getUnit(i, j) instanceof Defender) {
					def = (Defender) gameBoard.getUnit(i, j);
					if(def.getCaptureUnit() == null) {
						continue;
					}
					if(def.getCaptureUnit() instanceof Silva) {
						ArrayList<Unit> adjacent = gameBoard.getAdjacentUnit(i, j);
						for(int k = 0;k< adjacent.size();k++) {
							if(adjacent.get(k) instanceof Empty) {
								canExit.add(adjacent.get(k));
							}
						}
					}
				}
			}
		}
		return canExit;
	}

}
