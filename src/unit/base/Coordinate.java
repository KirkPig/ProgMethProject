package unit.base;

public class Coordinate {
	
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		// TODO Auto-generated constructor stub
		
		setX(x);
		setY(y);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + getX() + "," + getY() + ")";
	}
	

}
