package gui;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import logic.GameController;
import main.Main;

public class WinPane extends Group {
	public WinPane() {
		
		ImageView background = new ImageView();
		background.setTranslateX(320);
		background.setTranslateY(180);
		if(GameController.getWinner() == null) {
			background.setImage(new Image(ImageUrl.drawBackground));
		}else if(GameController.getWinner().getTeam().getName() == "liverpool") {
			background.setImage(new Image(ImageUrl.liverpoolBackground));
		}else if(GameController.getWinner().getTeam().getName() == "manUnited") {
			background.setImage(new Image(ImageUrl.manUnitedBackground));
		}else if(GameController.getWinner().getTeam().getName() == "manCity") {
			background.setImage(new Image(ImageUrl.manCityBackground));
		}else if(GameController.getWinner().getTeam().getName() == "spur") {
			background.setImage(new Image(ImageUrl.spurBackground));
		}
		getChildren().add(background);
		
		ImageView label = new ImageView();
		label.setTranslateX(122+270);
		label.setTranslateY(445+180);
		if(GameController.getWinner() != null) {
			if(GameController.getWinner().equals(GameController.player1)) {
				label.setImage(new Image(ImageUrl.player1));
			}else {
				label.setImage(new Image(ImageUrl.player2));
			}
			getChildren().add(label);
		}
		
		
		ImageView restartButton = new ImageView(new Image(ImageUrl.restartButton));
		restartButton.setTranslateX(305+320);
		restartButton.setTranslateY(610+180);
		getChildren().add(restartButton);
		
		ImageView mainmenuButton = new ImageView(new Image(ImageUrl.mainmenuButton));
		mainmenuButton.setTranslateX(702+320);
		mainmenuButton.setTranslateY(610+180);
		getChildren().add(mainmenuButton);
		
		ColorAdjust adjust = new ColorAdjust();
		adjust.setBrightness(-0.2);
		ColorAdjust normal = new ColorAdjust();
		normal.setBrightness(0);
		
		//restart
		restartButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				restartButton.setEffect(adjust);
			}
		});
		
		restartButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				restartButton.setEffect(normal);
			}
		});
		
		restartButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				if(Main.soundWin.isPlaying()) {
					Main.soundWin.stop();
					Main.soundIntro.play();
				}
				Main.primaryStage.setScene(Main.getSelectTeamScene());
			}
		});
		
		//mainmenu
		mainmenuButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				mainmenuButton.setEffect(adjust);
			}
		});
		
		mainmenuButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				mainmenuButton.setEffect(normal);
			}
		});
		
		mainmenuButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				if(Main.soundWin.isPlaying()) {
					Main.soundWin.stop();
					Main.soundIntro.play();
				}
				Main.primaryStage.setScene(Main.getMainmenuScene());
			}
		});
	}
	
	
}
