package gui;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import unit.base.Unit;

public class UnitBarCell extends Pane {
	private Unit unit = null;

	public UnitBarCell(Unit unit) {
		// TODO Auto-generated constructor stub
		this.unit = unit;
		updateCell();
		
	}

	public Unit getUnit() {
		return unit;
	}

	public void updateCell() {
		Image unitImage = new Image(getUnit().getImageUrl());
		this.setMinSize(unitImage.getWidth(), unitImage.getHeight());
		this.setBackground(new Background(new BackgroundImage(unitImage, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		
	}

}
