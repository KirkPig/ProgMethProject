package unit;

import java.util.ArrayList;

import logic.Sprites;
import unit.base.Unit;

public class Defender extends Unit{
	
	public Defender(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y);
		setName(name);
	}
	
	public Defender(String name) {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName(name);
	}
	
	public Defender() {
		// TODO Auto-generated constructor stub
		super(0, 0);
		setName("...");
	}

	@Override
	public int getSprites() {
		// TODO Auto-generated method stub
		return Sprites.DEFENDER;
	}

	@Override
	public ArrayList<Unit> getMoveUnit() {
		return null;
	}

}
