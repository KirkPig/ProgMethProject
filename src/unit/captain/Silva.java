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

	public Silva(String inactiveImageUrl, String activeImageUrl) {
		// TODO Auto-generated constructor stub
		super("David Silva", 0, 0);
		setInactiveImageUrl(inactiveImageUrl);
		setActiveImageUrl(activeImageUrl);
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
		ArrayList<ArrayList<Integer>> distance = gameBoard.getDistance(this.getCoordinate().getX(),
				this.getCoordinate().getY(), false);
		for (int i = 0; i < distance.size(); i++) {
			for (int j = 0; j < distance.size(); j++) {
				if (distance.get(i).get(j) == 1) {
					for (Unit u : gameBoard.getAdjacentUnit(i, j)) {
						if (u == null) {
							continue;
						}
						if (!(u instanceof Empty) && u != this) {
							canMove.add(gameBoard.getUnit(i, j));
							// System.out.println(gameBoard.getUnit(i, j).getCoordinate().toString());
							break;
						}
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
		GameBoard gameBoard = GameController.gameBoard;
		for (int i = 0; i < gameBoard.getWidth(); i++) {
			for (int j = 0; j < gameBoard.getHeight(); j++) {
				if (gameBoard.getUnit(i, j) instanceof Defender) {
					def = (Defender) gameBoard.getUnit(i, j);
					if (def.getCaptureUnit() == null) {
						continue;
					}
					if (def.getCaptureUnit() instanceof Silva) {
						for (Unit u: gameBoard.getAdjacentUnit(i, j)) {
							if (u instanceof Empty) {
								canExit.add(u);
							}
						}
						return canExit;
					}
				}
			}
		}
		return canExit;
	}

}
