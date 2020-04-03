package unit;

import java.util.ArrayList;

import logic.GameBoard;
import logic.GameController;
import logic.Sprites;
import unit.base.Movable;
import unit.base.Unit;

public class Playmaker extends Unit implements Movable{
	
	public Playmaker(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Playmaker(String name, String inactiveImageUrl, String activeImageUrl) {
		super(0, 0);
		setName(name);
		setInactiveImageUrl(inactiveImageUrl);
		setActiveImageUrl(activeImageUrl);
	}
	
	public Playmaker() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.PLAYMAKER;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		GameBoard gameBoard = GameController.gameBoard;
		int x = this.getCoordinate().getX();
		int y = this.getCoordinate().getY();
		
		//move number 1
		ArrayList<Unit> move1 = new ArrayList<Unit>();
		for(Unit i : gameBoard.getAdjacentUnit(x, y)) {
			
			if(!(i instanceof Empty)) {
				move1.add(i);
			}
			
		}
		
		//move number 2
		ArrayList<Unit> move2 = new ArrayList<Unit>();
		for(Unit i: move1) {
			
			for(Unit j: gameBoard.getAdjacentUnit(i.getCoordinate().getX(), i.getCoordinate().getY())) {
				if(!(j instanceof Empty) && !(j.getCoordinate().equals(this.getCoordinate()))) {
					move2.add(j);
				}
			}
			
		}
		
		//move number 3(finished)
		for(Unit i: move2) {
			
			for(Unit j: gameBoard.getAdjacentUnit(i.getCoordinate().getX(), i.getCoordinate().getY())) {
				if(j instanceof Empty) {
					canMove.add(j);
				}
			}
			
		}
		
		return canMove;	
	}

}
