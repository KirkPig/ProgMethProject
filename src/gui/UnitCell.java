package gui;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import unit.base.Unit;

public class UnitCell extends Pane {

	Unit unit = null;

	public UnitCell(Unit unit) {
		// TODO Auto-generated constructor stub
		this.unit = unit;
		Image unitImage = new Image(unit.getImageUrl(), 89, 102, false, false);
		this.setPrefSize(unitImage.getWidth(), unitImage.getHeight());
		this.setBackground(new Background(
				new BackgroundImage(unitImage, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		this.setTranslateX(unit.getCoordinate().getY() * unitImage.getWidth());
		this.setTranslateY(unit.getCoordinate().getX() * (unitImage.getHeight() * 3 / 4 + 0.5));
	}
	
	public Unit getUnit() {
		return unit;
	}

}
