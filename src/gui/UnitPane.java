package gui;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class UnitPane extends AnchorPane {

	public UnitPane() {
		// TODO Auto-generated constructor stub
		setPrefSize(1280, 720);
		setBackground(new Background(new BackgroundImage(
				new Image("file:res/field/background.jpg", 1280, 720, false, false), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
	}

}
