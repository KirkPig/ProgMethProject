package gui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;

public class CaptainSkillPane extends VBox {

	public CaptainSkillPane() {
		// TODO Auto-generated constructor stub
		Image background = new Image(ImageUrl.selectTeamCaptainSkill);
		setBackground(new Background(
				new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		setPrefSize(background.getWidth(), background.getHeight());
		setAlignment(Pos.CENTER);
	}

}
