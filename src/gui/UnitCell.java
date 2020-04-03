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
		this.setPrefSize(100, 100);
		this.setBackground(new Background(new BackgroundImage(new Image(unit.getImageUrl()), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		this.setTranslateX(unit.getCoordinate().getY()*74);
		this.setTranslateY(unit.getCoordinate().getX()*84);
	}

}
