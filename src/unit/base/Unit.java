package unit.base;

import java.util.ArrayList;


import logic.GameController;
import logic.Owner;
import unit.Empty;

public abstract class Unit {
	
	private String name;
	private Coordinate coordinate;
	private Owner owner;
	private boolean isCapture;
	
	public Unit(int x, int y) {
		// TODO Auto-generated constructor stub
		setCoordinate(new Coordinate(x, y));
		setOwner(null);
		setCapture(false);
	}
	
	public abstract int getSprites();
	public abstract ArrayList<Unit> getMoveUnit();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public int getRandom() {
		int max = 7; 
        int min = 2; 
        int range = max - min + 1; 
        int random = (int)(Math.random() * range) + min;
        return random;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public boolean isMovable() {
		
		GameController.gameBoard.addUnit(new Empty(), getCoordinate().getX(), getCoordinate().getY());
		boolean check = GameController.gameBoard.checkGameBoard();
		GameController.gameBoard.addUnit(this, getCoordinate().getX(), getCoordinate().getY());
		return check;
		
	}

	public boolean isCapture() {
		return isCapture;
	}

	public void setCapture(boolean isCapture) {
		this.isCapture = isCapture;
	}
	
}
