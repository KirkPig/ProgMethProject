package unit;

import java.util.ArrayList;

import logic.GameBoard;
import logic.Sprites;
import unit.base.Unit;

public class God extends Unit {
	
	public God(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public God(String name) {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName(name);
	}
	
	public God() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		return Sprites.GOD;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		ArrayList<Unit> canMove = new ArrayList<Unit>();
		int max = 7; 
        int min = 2; 
        int range = max - min + 1; 
        int rand = (int)(Math.random() * range) + min;
        if(rand == 2) {
        	return new Attacker().getMoveUnit();
        }
        if(rand == 3) {
        	return new BoxToBox().getMoveUnit();
        }
        if(rand == 4) {
        	return new Defender().getMoveUnit();
        }
        if(rand == 5) {
        	return new Goalkeeper().getMoveUnit();
        }
        if(rand == 6) {
        	return new Playmaker().getMoveUnit();
        }
		return null;	
	}

}
