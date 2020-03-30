package unit;

import java.util.ArrayList;

import logic.Sprites;
import unit.base.Movable;
import unit.base.Unit;

public class God extends Unit implements Movable{

private int random;

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
	
	public void setRandom() {
		this.random = this.getRandom();
	}
	
	@Override
	public ArrayList<Unit> getMoveUnit() {
		Unit[] unit = new Unit[1];
        if(random == 2) {
        	unit[0] = new Attacker(getName(), getCoordinate().getX(), getCoordinate().getY());
        }
        if(random == 3) {
        	unit[0] = new BoxToBox(getName(), getCoordinate().getX(), getCoordinate().getY());
        }
        if(random == 4) {
        	unit[0] = new Defender(getName(), getCoordinate().getX(), getCoordinate().getY());
        }
        if(random == 5) {
        	unit[0] = new Goalkeeper(getName(), getCoordinate().getX(), getCoordinate().getY());
        }
        if(random == 6) {
        	unit[0] = new Playmaker(getName(), getCoordinate().getX(), getCoordinate().getY());
        }
        
        return unit[0].getMoveUnit();	
	}

}
