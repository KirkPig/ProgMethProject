package logic;

import unit.Empty;
import unit.base.Coordinate;
import unit.base.Unit;

public class GameBoard {
	
	private Unit[][] units;
	private int width;
	private int height;
	
	public GameBoard(int width, int height) {
		// TODO Auto-generated constructor stub
		this.units = new Unit[width][height];
		this.width = width;
		this.height = height;
		for(int i = 0;i<width;i++) {
			for(int j = 0;j<height;j++) {
				this.units[i][j] = new Empty();
			}
		}
	}
	
	public GameBoard() {
		// TODO Auto-generated constructor stub
		this.units = new Unit[10][10];
		for(int i = 0;i<10;i++) {
			for(int j = 0;j<10;j++) {
				this.units[i][j] = new Empty();
			}
		}
	}
	
	public void printBoard() {
		int k = 0;
		for(Unit[] row: units) {
			String rowstring = "";
			if(k%2==1) {
				rowstring += " ";
			}
			for(Unit c:row) {
				rowstring += c.getSprites() + " ";
			}
			System.out.println(rowstring);
			k++;
		}
	}
	
	public void placeUnit(Unit unit, int x, int y) {
		// TODO Auto-generated method stub
		addUnit(unit, x, y);
	}
	
	public boolean isEmpty(int x, int y) {
		// TODO Auto-generated method stub
		if(units[x][y] instanceof Empty)
			return true;
		else return false;

	}
	
	public void addUnit(Unit unit, int x, int y) {
		// TODO Auto-generated method stub
		unit.setCoordinate(new Coordinate(x, y));
		units[x][y] = unit;
	}
	
	public void moveUnit(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		Unit unit = getUnit(x1, y1);
		addUnit(new Empty(), x1, y1);
		addUnit(unit, x2, y2);
		
	}
	
	public Unit getUnit(int x, int y){
		return units[x][y];
	}

}
