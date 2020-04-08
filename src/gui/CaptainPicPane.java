package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CaptainPicPane extends ImageView {
	
	private String[] teamPicUrl;
	private int teamNum;
	
	public CaptainPicPane(int teamNum) {
		// TODO Auto-generated constructor stub
		this.teamPicUrl = new String[4];
		teamPicUrl[0] = ImageUrl.captainPicLiverpool;
		teamPicUrl[1] = ImageUrl.captainPicManUnited;
		teamPicUrl[2] = ImageUrl.captainPicManCity;
		teamPicUrl[3] = ImageUrl.captainPicSpur;
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
