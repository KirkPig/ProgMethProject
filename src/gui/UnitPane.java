package gui;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import logic.GameController;

public class UnitPane extends AnchorPane {

	public UnitPane() {
		// TODO Auto-generated constructor stub
		this.setPrefSize(1920, 1017);
		this.setBackground(new Background(new BackgroundImage(
				new Image("file:res/field/background.jpg", 1920, 1017, false, false), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		for (int i = 0; i < GameController.gameBoard.getWidth(); i++) {
			for (int j = 0; j < GameController.gameBoard.getHeight(); j++) {
				UnitCell unitCell = new UnitCell(GameController.gameBoard.getUnit(i, j));
				if(j%2 == 0) {
					unitCell.setTranslateY(unitCell.getTranslateY() + 40);
				}
				this.getChildren().add(unitCell);
			}
		}
	}

}
