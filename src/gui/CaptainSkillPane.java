package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class CaptainSkillPane extends VBox {
	
	private int teamNum;
	private Label captainSkill;

	public CaptainSkillPane(int teamNum) {
		// TODO Auto-generated constructor stub
		Image background = new Image(ImageUrl.selectTeamCaptainSkill);
		setBackground(new Background(
				new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		setPrefSize(background.getWidth(), background.getHeight());
		setAlignment(Pos.CENTER);
		this.teamNum = teamNum;
		Label labelHead = new Label("Captain Skill");
		labelHead.setTextFill(Paint.valueOf(Color.WHITE.toString()));
		labelHead.setTextAlignment(TextAlignment.CENTER);
		labelHead.setFont(new Font("TH Sarabun New", 30));
		getChildren().add(labelHead);
		
		captainSkill = new Label("test");
		captainSkill.setTextFill(Paint.valueOf(Color.WHITE.toString()));
		captainSkill.setTextAlignment(TextAlignment.CENTER);
		captainSkill.setFont(new Font("TH Sarabun New", 24));
		getChildren().add(captainSkill);
		updateSkill();
	}
	
	public void updateSkill() {
		switch(teamNum) {
		case 0:
			captainSkill.setText("(Passive)\nCan move 1-2 block around you");
			break;
		case 1:
			captainSkill.setText("(Passive)\nDefender can't be place on top this unit");
			break;
		case 2:
			captainSkill.setText("(Action)If on top of this unit have defender, this unit can move out from top of defender");
			break;
		case 3:
			captainSkill.setText("(Action)Once per game, you can move like Box to Box Unit");
			break;
		}
	}
	
	public int getTeamNum() {
		return teamNum;
	}

	public void teamNumUp() {
		if(teamNum >= 3) {
			teamNum = 0;
		}else {
			teamNum++;
		}
	}
	
	public void teamNumDown() {
		if(teamNum <= 0) {
			teamNum = 3;
		}else {
			teamNum--;
		}
	}

}
