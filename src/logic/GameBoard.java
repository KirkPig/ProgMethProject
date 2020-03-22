package logic;

import java.util.ArrayList;

import unit.Empty;
import unit.base.Coordinate;
import unit.base.Unit;

public class GameBoard {
	
	private ArrayList<ArrayList<Unit>> units;
	private int width;
	private int height;
	
	public GameBoard(int width, int height) {
		// TODO Auto-generated constructor stub
		this.units = new ArrayList<ArrayList<Unit>>();
		this.width = width;
		this.height = height;
		for(int i = 0;i<width;i++) {
			ArrayList<Unit> e = new ArrayList<Unit>();
			for(int j = 0;j<height;j++) {
				e.add(new Empty(i, j));
			}
			units.add(e);
		}
	}
	
	public GameBoard() {
		// TODO Auto-generated constructor stub
		this.units = new ArrayList<ArrayList<Unit>>();
		this.width = 10;
		this.height = 10;
		for(int i = 0;i<width;i++) {
			ArrayList<Unit> e = new ArrayList<Unit>();
			for(int j = 0;j<height;j++) {
				e.add(new Empty(i, j));
			}
			units.add(e);
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
	public void printBoard() {
		int k = 0;
		for(var row: units) {
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
	
	public boolean placeUnit(Unit unit, int x, int y) {
		// TODO Auto-generated method stub
		if(getUnit(x, y) == null) {
			return false;
		}
		if(getUnit(x, y) instanceof Empty) {
			addUnit(unit, x, y);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isEmpty(int x, int y) {
		// TODO Auto-generated method stub
		if(getUnit(x, y) instanceof Empty)
			return true;
		else return false;

	}
	
	public void addUnit(Unit unit, int x, int y) {
		// TODO Auto-generated method stub
		unit.setCoordinate(new Coordinate(x, y));
		units.get(x).set(y, unit);
	}
	
	public boolean moveUnit(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		if(!(getUnit(x2, y2) instanceof Empty) || (getUnit(x1, y1) instanceof Empty) || getUnit(x1, y1) == null || getUnit(x2, y2) == null) {
			return false;
		}
		Unit unit = getUnit(x1, y1);
		addUnit(new Empty(), x1, y1);
		if(!checkGameBoard()) {
			addUnit(unit, x1, y1);
			return false;
		}
		addUnit(unit, x2, y2);
		if(checkGameBoard()) {
			return true;
		}else {
			addUnit(unit, x1, y1);
			addUnit(new Empty(), x2, y2);
			return false;
		}
		
	}
	
	public Unit getUnit(int x, int y){
		if(x < 0|| x >= width || y < 0 || y >= height) {
			return null;
		}
		return units.get(x).get(y);
	}
	
	public ArrayList<Unit> getOwnerUnit(Owner owner) {
		ArrayList<Unit> ownerUnit = new ArrayList<Unit>();
		for(int i = 0;i<width;i++) {
			for(int j = 0;j<height;j++) {
				if(!(getUnit(i, j) instanceof Empty)) {
					if(getUnit(i, j).getOwner().equals(owner)) {
						ownerUnit.add(getUnit(i, j));
					}
				}
			}
		}
		return ownerUnit;
	}
	
	public ArrayList<Unit> getAdjacentUnit(int x, int y){
		ArrayList<Unit> adjacentUnit = new ArrayList<Unit>();
		
		if(x>0)
			adjacentUnit.add(getUnit(x-1, y));
		if(x<width-1)
			adjacentUnit.add(getUnit(x+1, y));
		if(y>0)
			adjacentUnit.add(getUnit(x, y-1));
		if(y<height-1)
			adjacentUnit.add(getUnit(x, y+1));
		
		if(x%2 == 0) {
			
			
			if(x>0 && y>0)
				adjacentUnit.add(getUnit(x-1, y-1));
			if(x>0 && y<height-1)
				adjacentUnit.add(getUnit(x-1, y+1));
			
		}else {
			
			if(x<width-1 && y>0)
				adjacentUnit.add(getUnit(x+1, y-1));
			if(x<width-1 && y<height-1)
				adjacentUnit.add(getUnit(x+1, y+1));
			
		}
		
		return adjacentUnit;
	}
	
	public boolean checkGameBoard() {
		
		ArrayList<ArrayList<Unit>> copyBoard = new ArrayList<ArrayList<Unit>>();
		ArrayList<Unit> queue = new ArrayList<Unit>();
		
		for(int i = 0;i<width;i++) {
			ArrayList<Unit> e = new ArrayList<Unit>();
			for(int j = 0;j<height;j++) {
				e.add(getUnit(i, j));
			}
			copyBoard.add(e);
		}
		
		for(var i: copyBoard) {
			boolean chk = false;
			for(var j: i) {
				if(!(j instanceof Empty)) {
					queue.add(j);
					chk = true;
					break;
				}
			}
			if(chk)
				break;
		}
		
		while(!queue.isEmpty()) {
			Unit t = queue.get(0);
			queue.remove(0);
			
			//System.out.println(t.getCoordinate());
			
			if(t instanceof Empty) continue;
			
			int x = t.getCoordinate().getX();
			int y = t.getCoordinate().getY();
			copyBoard.get(x).set(y, new Empty(x, y));
			
			if(x>0)
				queue.add(copyBoard.get(x-1).get(y));
			if(x<width-1)
				queue.add(copyBoard.get(x+1).get(y));
			if(y>0)
				queue.add(copyBoard.get(x).get(y-1));
			if(y<height-1)
				queue.add(copyBoard.get(x).get(y+1));
			
			if(x%2 == 0) {
				
				if(x>0 && y>0)
					queue.add(copyBoard.get(x-1).get(y-1));
				if(x>0 && y<height-1)
					queue.add(copyBoard.get(x-1).get(y+1));
				
			}else {
				
				if(x<width-1 && y>0)
					queue.add(copyBoard.get(x+1).get(y-1));
				if(x<width-1 && y<height-1)
					queue.add(copyBoard.get(x+1).get(y+1));
				
			}
			
		}
		
		//System.out.println("-----------------------------------");
		
		for(var i: copyBoard) {
			for(var j: i) {
				if(!(j instanceof Empty)) {
					return false;
				}
			}
		}
		
		return true;
		
	}

}
