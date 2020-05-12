package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TutorialPane extends ImageView {
	private String[] pagePicUrl;
	private int pageNum;
	
	public TutorialPane(int pageNum) {
		// TODO Auto-generated constructor stub
		this.pagePicUrl = new String[12];
		pagePicUrl[0] = ImageUrl.page1;
		pagePicUrl[1] = ImageUrl.page2;
		pagePicUrl[2] = ImageUrl.page3;
		pagePicUrl[3] = ImageUrl.page4;
		pagePicUrl[4] = ImageUrl.page5;
		pagePicUrl[5] = ImageUrl.page6;
		pagePicUrl[6] = ImageUrl.page7;
		pagePicUrl[7] = ImageUrl.page8;
		pagePicUrl[8] = ImageUrl.page9;
		pagePicUrl[9] = ImageUrl.page10;
		pagePicUrl[10] = ImageUrl.page11;
		pagePicUrl[11] = ImageUrl.page12;
		this.pageNum = pageNum;
		setImageUrl();
	}
	
	public void setImageUrl() {
		// TODO Auto-generated method stub
		setImage(new Image(pagePicUrl[pageNum]));
	}

	public int getPageNum() {
		return pageNum;
	}

	public void pageNumUp() {
		if(pageNum >= 11) {
			pageNum = 11;
		}else {
			pageNum++;
		}
	}
	
	public void pageNumDown() {
		if(pageNum <= 0) {
			pageNum = 0;
		}else {
			pageNum--;
		}
	}

}
