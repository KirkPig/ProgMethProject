package unit.captain;

import java.util.ArrayList;

import logic.GameBoard;
import unit.Captain;
import unit.Defender;
import unit.Empty;
import unit.base.Skilled;
import unit.base.Unit;

public class Silva extends Captain implements Skilled {

	private Defender def;

	@Override
	public ArrayList<Unit> getMoveUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Unit> useSkill() {
		// TODO Auto-generated method stub
		ArrayList<Unit> canExit = new ArrayList<Unit>();
		GameBoard gameBoard = new GameBoard();
		for(int i = 0;i< 10; i++) {
			for (int j= 0; j<10;j++) {
				if(gameBoard.getUnit(i, j) instanceof Defender)
					def = (Defender) gameBoard.getUnit(i, j);
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
		return canExit;
	}

}
