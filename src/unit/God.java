package unit;

import java.util.ArrayList;

import logic.Sprites;
import unit.base.Movable;
import unit.base.Unit;

public class God extends Unit implements Movable{
	
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
		Unit[] unit = new Unit[1];
		int max = 7; 
        int min = 2; 
        int range = max - min + 1; 
        int rand = (int)(Math.random() * range) + min;
        if(rand == 2) {
        	unit[0] = new Attacker(getName(), getCoordinate().getX(), getCoordinate().getY());
        }
        if(rand == 3) {
        	unit[0] = new BoxToBox(getName(), getCoordinate().getX(), getCoordinate().getY());
        }
        if(rand == 4) {
        	unit[0] = new Defender(getName(), getCoordinate().getX(), getCoordinate().getY());
        }
        if(rand == 5) {
        	unit[0] = new Goalkeeper(getName(), getCoordinate().getX(), getCoordinate().getY());
        }
        if(rand == 6) {
        	unit[0] = new Playmaker(getName(), getCoordinate().getX(), getCoordinate().getY());
        }
        
        return unit[0].getMoveUnit();	
	}

}
