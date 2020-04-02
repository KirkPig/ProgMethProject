package unit.base;

import java.util.ArrayList;

import logic.Owner;

public abstract class Unit {
	
	private String name;
	private Coordinate coordinate;
	private Owner owner;
	private boolean isCapture;
	private boolean isSelected;
	private String activeImageUrl;
	private String inactiveImageUrl;
	
	public Unit(int x, int y) {
		// TODO Auto-generated constructor stub
		setCoordinate(new Coordinate(x, y));
		setOwner(null);
		setCapture(false);
		setSelected(false);
		setActiveImageUrl("");
		setInactiveImageUrl("");
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
	
	public Owner getOwner() {
		return owner;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public boolean isCapture() {
		return isCapture;
	}

	public void setCapture(boolean isCapture) {
		this.isCapture = isCapture;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public String getActiveImageUrl() {
		return activeImageUrl;
	}

	public void setActiveImageUrl(String activeImageUrl) {
		this.activeImageUrl = activeImageUrl;
	}

	public String getInactiveImageUrl() {
		return inactiveImageUrl;
	}

	public void setInactiveImageUrl(String inactiveImageUrl) {
		this.inactiveImageUrl = inactiveImageUrl;
	}
	
}
