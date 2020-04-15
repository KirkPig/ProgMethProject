package gui;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import logic.GameController;
import unit.Empty;
import unit.base.Coordinate;
import unit.base.Unit;

public class UnitCell extends Pane {

	private Coordinate coordinate = null;
	private double scale = 0.5;

	public UnitCell(int x, int y) {
		// TODO Auto-generated constructor stub
		setCoordinate(x, y);
		updateCell();
		
	}

	public Unit getUnit() {
		return GameController.gameBoard.getUnit(coordinate.getX(), coordinate.getY());
	}

	public void updateCell() {
		int i = coordinate.getX();
		int j = coordinate.getY();
		Image unitImage = new Image(getUnit().getImageUrl());
		this.setMinSize(unitImage.getWidth(), unitImage.getHeight());
		this.setBackground(new Background(new BackgroundImage(unitImage, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		
		if(i%2==1) {
			setTranslateX((double)j * 178.0 * 10 / 9 + 89.0 - (getMinWidth()/2.0));
		}else {
			setTranslateX((double)j * 178.0 * 10 / 9 - (getMinWidth()/2.0));
		}
		setTranslateY((double)i * 205.0 * 9 / 10 - (getMinHeight()/2.0));
		
		if (getUnit() instanceof Empty) {
			setOpacity(0.80);
		}else {
			setOpacity(1);
		}
			
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(int x, int y) {
		this.coordinate = new Coordinate(x, y);
	}
}
