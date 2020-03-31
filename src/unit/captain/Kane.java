package unit.captain;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import unit.Captain;
import unit.Empty;
import unit.base.Skilled;
import unit.base.Unit;

public class Kane extends Captain implements Skilled {
	
	private boolean isSkillUsable = true;
	
	public Kane(int x, int y) {
		// TODO Auto-generated constructor stub
		super("Harry Kane", x, y);
	}

	public Kane() {
		// TODO Auto-generated constructor stub
		super("Harry Kane", 0, 0);
	}

	@Override
	public ArrayList<Unit> useSkill() {
		// TODO Auto-generated method stub
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameBoard gameBoard = GameController.gameBoard;
		if(this.isSkillUsable()) {
			ArrayList<ArrayList<Integer>> distance = gameBoard.getDistance(this.getCoordinate().getX(), this.getCoordinate().getY(), false);
			for(int i = 0 ; i< distance.size(); i++) {
				for(int j = 0; j < distance.size();j++) {
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

	@Override
	public ArrayList<Unit> getMoveUnit() {
		// TODO Auto-generated method stub
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameBoard gameBoard = GameController.gameBoard;
		ArrayList<ArrayList<Integer>> distance = gameBoard.getDistance(this.getCoordinate().getX(), this.getCoordinate().getY(), false);
		for(int i = 0 ; i< distance.size(); i++) {
			for(int j = 0; j < distance.size();j++) {
				if(distance.get(i).get(j) == 1) {
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

	public boolean isSkillUsable() {
		return isSkillUsable;
	}

	public void setSkillUsable(boolean isSkillUsable) {
		this.isSkillUsable = isSkillUsable;
	}

}
