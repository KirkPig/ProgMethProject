package logic;

import java.util.ArrayList;

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
		if(!checkGameBoard()) {
			addUnit(new Empty(), x, y);
		}
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
		if(checkGameBoard()) {
			addUnit(getUnit(x1, y1), x2, y2);
			if(!checkGameBoard()) {
				System.out.println("-----GameRuleException-----");
				addUnit(unit, x1, y1);
				addUnit(new Empty(), x2, y2);
			}
		}else {
			System.out.println("-----GameRuleException-----");
			addUnit(unit, x1, y1);
		}
		
	}
	
	public Unit getUnit(int x, int y){
		return units[x][y];
	}
	
	public boolean checkGameBoard() {
		//All Unit have to connected each other
		
		Unit[][] copyBoard = units;
		ArrayList<Unit> queue = new ArrayList<Unit>();
		
		for(Unit[] i: units) {
			for(Unit j: i) {
				if(!(j instanceof Empty)) {
					queue.add(j);
					break;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Unit t = queue.get(0);
			queue.remove(0);
			if(t instanceof Empty) continue;
			else {
				int x = t.getCoordinate().getX();
				int y = t.getCoordinate().getY();
				copyBoard[x][y] = new Empty();
				if(x%2==0) {
					
					
					if(x>0)queue.add(copyBoard[x-1][y]);
					if(x<width-1)queue.add(copyBoard[x+1][y]);
					if(y>0)queue.add(copyBoard[x][y-1]);
					if(y<height-1)queue.add(copyBoard[x][y+1]);
					
					if(x>0 && y>0)queue.add(copyBoard[x-1][y-1]);
					if(x<width-1 && y>0)queue.add(copyBoard[x+1][y-1]);
					
					
					
				}else {
					
					if(x>0)queue.add(copyBoard[x-1][y]);
					if(x<width-1)queue.add(copyBoard[x+1][y]);
					if(y>0)queue.add(copyBoard[x][y-1]);
					if(y<height-1)queue.add(copyBoard[x][y+1]);
					
					if(x>0 && y<height-1)queue.add(copyBoard[x-1][y+1]);
					if(x<width-1 && y<height-1)queue.add(copyBoard[x+1][y+1]);
					
				}
			}
			
		}
		
		for(Unit[] i: copyBoard) {
			for(Unit j: i) {
				if(!(j instanceof Empty)) {
					return false;
				}
			}
		}
		
		return true;
		
	}

}
