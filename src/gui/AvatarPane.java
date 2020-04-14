package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AvatarPane extends ImageView {
	private String[] avatarPicUrl;
	private int avatarNum;
	public AvatarPane(int avatarNum) {
		// TODO Auto-generated constructor stub
		this.avatarPicUrl = new String[4];
		avatarPicUrl[0] = ImageUrl.avatarLiverpool;
		avatarPicUrl[1] = ImageUrl.avatarManUnited;
		avatarPicUrl[2] = ImageUrl.avatarManCity;
		avatarPicUrl[3] = ImageUrl.avatarSpur;
		this.avatarNum = avatarNum;
		setImageUrl();
	}
	
	public void setImageUrl() {
		// TODO Auto-generated method stub
		setImage(new Image(avatarPicUrl[avatarNum]));
	}

	public int getAvatarNum() {
		return avatarNum;
	}
	
	public void setAvatarNum(int num) {
		avatarNum = num;
	}
}
