package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TeamPicPane extends ImageView {
	
	private String[] teamPicUrl;
	private int teamNum;
	
	public TeamPicPane(int teamNum) {
		// TODO Auto-generated constructor stub
		this.teamPicUrl = new String[4];
		teamPicUrl[0] = ImageUrl.teamPicLiverpool;
		teamPicUrl[1] = ImageUrl.teamPicManUnited;
		teamPicUrl[2] = ImageUrl.teamPicManCity;
		teamPicUrl[3] = ImageUrl.teamPicSpur;
		this.teamNum = teamNum;
		setImageUrl();
	}
	
	public void setImageUrl() {
		// TODO Auto-generated method stub
		setImage(new Image(teamPicUrl[teamNum]));
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
