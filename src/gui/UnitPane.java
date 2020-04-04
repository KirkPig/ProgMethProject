package gui;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import logic.GameController;
import unit.Empty;

public class UnitPane extends AnchorPane {

	private double gapX = 83.0;
	private double gapY = 40.0;

	public UnitPane() {
		// TODO Auto-generated constructor stub
		Image backgroundImage = new Image(ImageUrl.gameBackground, 1100, 890, false, false);
		this.setPrefSize(backgroundImage.getWidth(), backgroundImage.getHeight());
		this.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

		for (int i = 0; i < GameController.gameBoard.getWidth(); i++) {
			for (int j = 0; j < GameController.gameBoard.getHeight(); j++) {
				UnitCell unitCell = new UnitCell(GameController.gameBoard.getUnit(i, j));
				if (i % 2 == 1) {
					unitCell.setTranslateX(unitCell.getTranslateX() + (unitCell.getPrefWidth() / 2));
				}
				if (unitCell.getUnit() instanceof Empty) {
					unitCell.setOpacity(0.80);
				}

				unitCell.setTranslateX(unitCell.getTranslateX() + gapX);
				unitCell.setTranslateY(unitCell.getTranslateY() + gapY);
				this.getChildren().add(unitCell);
			}
		}
	}

}
