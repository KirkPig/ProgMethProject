package main;

import gui.ImageUrl;
import gui.TeamPicPane;
import gui.UnitPane;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.GameController;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		primaryStage.setScene(getSelectTeamScene(primaryStage));
		primaryStage.setTitle("FIFA Hex");
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	public static void main(String[] args) {
		// test
		GameController.InitializeGame("manUnited", "liverpool", 3, 3);
		launch(args);
	}

	public static Scene getCoverScene(Stage primaryStage) {
		AnchorPane coverSceneRoot = new AnchorPane();

		coverSceneRoot.setBackground(new Background(new BackgroundImage(
				new Image(ImageUrl.coverBackground, 1920, 1017, false, false), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

		ImageView coverLogo = new ImageView(new Image(ImageUrl.coverLogo));
		coverLogo.setX(543);
		coverLogo.setY(153);
		coverSceneRoot.getChildren().add(coverLogo);

		ImageView coverSideLogo = new ImageView(new Image(ImageUrl.coverSideLogo));
		coverSideLogo.setX(1162);
		coverSideLogo.setY(84);
		coverSceneRoot.getChildren().add(coverSideLogo);

		ImageView coverForeground = new ImageView(new Image(ImageUrl.coverForeground));
		coverForeground.setX(516);
		coverForeground.setY(655);
		coverSceneRoot.getChildren().add(coverForeground);

		VBox playButton = new VBox();
		ImageView playButtonImage = new ImageView(new Image(ImageUrl.coverPlayButton));
		ImageView playButtonLabel = new ImageView(new Image(ImageUrl.coverPlayButtonLabel));
		playButton.getChildren().add(playButtonImage);
		playButton.getChildren().add(playButtonLabel);

		playButton.setAlignment(Pos.CENTER);
		playButton.setSpacing(30);
		playButton.setTranslateX(786);
		playButton.setTranslateY(430);

		FadeTransition fadePlayButton = new FadeTransition();
		fadePlayButton.setAutoReverse(true);
		fadePlayButton.setCycleCount(Animation.INDEFINITE);
		fadePlayButton.setFromValue(10);
		fadePlayButton.setToValue(0.5);
		fadePlayButton.setDuration(Duration.millis(300));
		fadePlayButton.setNode(playButton);
		fadePlayButton.play();

		playButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				fadePlayButton.stop();
				playButton.setOpacity(1.0);
			}

		});

		playButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				fadePlayButton.play();
			}

		});

		playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				primaryStage.setScene(getMainmenuScene(primaryStage));
			}

		});

		coverSceneRoot.getChildren().add(playButton);

		Scene coverScene = new Scene(coverSceneRoot, 1920, 1017);
		return coverScene;
	}

	public static Scene getMainmenuScene(Stage primaryStage) {
		AnchorPane mainmenuSceneRoot = new AnchorPane();
		mainmenuSceneRoot.setBackground(new Background(new BackgroundImage(
				new Image(ImageUrl.coverBackground, 1920, 1017, false, false), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

		ImageView mainmenuLego = new ImageView(new Image(ImageUrl.mainmenuLogo));
		mainmenuLego.setX(503);
		mainmenuLego.setY(83);
		mainmenuSceneRoot.getChildren().add(mainmenuLego);

		ImageView mainmenuForegroundLeft = new ImageView(new Image(ImageUrl.mainmenuForegroundLeft));
		mainmenuForegroundLeft.setX(201);
		mainmenuForegroundLeft.setY(218);
		mainmenuSceneRoot.getChildren().add(mainmenuForegroundLeft);

		ImageView mainmenuForegroundRight = new ImageView(new Image(ImageUrl.mainmenuForegroundRight));
		mainmenuForegroundRight.setX(1206);
		mainmenuForegroundRight.setY(215);
		mainmenuSceneRoot.getChildren().add(mainmenuForegroundRight);

		ImageView mainmenuForegroundDown = new ImageView(new Image(ImageUrl.mainmenuForegroundDown));
		mainmenuForegroundDown.setX(0);
		mainmenuForegroundDown.setY(720);
		mainmenuSceneRoot.getChildren().add(mainmenuForegroundDown);

		VBox playButton = new VBox();
		ImageView playButtonImage = new ImageView(new Image(ImageUrl.mainmenuPlayButton));
		playButton.getChildren().add(playButtonImage);
		playButton.setTranslateX(680);
		playButton.setTranslateY(372);
		mainmenuSceneRoot.getChildren().add(playButton);

		FadeTransition fadePlayButton = new FadeTransition();
		fadePlayButton.setAutoReverse(true);
		fadePlayButton.setCycleCount(Animation.INDEFINITE);
		fadePlayButton.setFromValue(10);
		fadePlayButton.setToValue(0.5);
		fadePlayButton.setDuration(Duration.millis(300));
		fadePlayButton.setNode(playButton);
		fadePlayButton.play();

		playButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				fadePlayButton.stop();
				playButton.setOpacity(1.0);
			}

		});

		playButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				fadePlayButton.play();
			}

		});

		playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				primaryStage.setScene(getGameScene(primaryStage));
			}

		});

		VBox quitButton = new VBox();
		ImageView quitButtonImage = new ImageView(new Image(ImageUrl.mainmenuQuitButton));
		quitButton.getChildren().add(quitButtonImage);
		quitButton.setTranslateX(1051);
		quitButton.setTranslateY(372);
		mainmenuSceneRoot.getChildren().add(quitButton);

		FadeTransition fadeQuitButton = new FadeTransition();
		fadeQuitButton.setAutoReverse(true);
		fadeQuitButton.setCycleCount(Animation.INDEFINITE);
		fadeQuitButton.setFromValue(10);
		fadeQuitButton.setToValue(0.5);
		fadeQuitButton.setDuration(Duration.millis(300));
		fadeQuitButton.setNode(quitButton);
		fadeQuitButton.play();

		quitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				fadeQuitButton.stop();
				quitButton.setOpacity(1.0);
			}

		});

		quitButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				fadeQuitButton.play();
			}

		});

		quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				primaryStage.close();
			}

		});

		Scene mainmenuScene = new Scene(mainmenuSceneRoot, 1920, 1017);
		return mainmenuScene;
	}

	public static Scene getGameScene(Stage primaryStage) {
		AnchorPane gameSceneRoot = new AnchorPane();

		/*
		 * Background
		 */
		gameSceneRoot.setBackground(new Background(new BackgroundImage(
				new Image(ImageUrl.coverBackground, 1920, 1017, false, false), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

		/*
		 * UnitPane
		 */
		UnitPane unitPane = new UnitPane();
		unitPane.setTranslateX(25);
		unitPane.setTranslateY(-280);
		gameSceneRoot.getChildren().add(unitPane);

		/*
		 * HUD
		 */

		/*
		 * GameScene Create
		 */
		Scene gameScene = new Scene(gameSceneRoot, 1920, 1017);

		/*
		 * UnitPane Scroll Y-axis
		 */
		final double minY = -900.0;
		final double maxY = 220.0;
		final DoubleProperty speedY = new SimpleDoubleProperty();
		speedY.set(0.0);
		AnimationTimer unitPaneTransitionY = new AnimationTimer() {

			@Override
			public void handle(long e) {
				// TODO Auto-generated method stub
				if (speedY.get() != 0.0) {
					unitPane.setTranslateY(Math.max(minY, Math.min(maxY, unitPane.getTranslateY() + speedY.get())));
				}
			}
		};
		unitPaneTransitionY.start();

		/*
		 * UnitPane Scroll X-axis
		 */
		final double minX = -200.0;
		final double maxX = 250.0;
		final DoubleProperty speedX = new SimpleDoubleProperty();
		speedX.set(0.0);
		AnimationTimer unitPaneTransitionX = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				if (speedX.get() != 0.0) {
					unitPane.setTranslateX(Math.max(minX, Math.min(maxX, unitPane.getTranslateX() + speedX.get())));
				}
			}

		};
		unitPaneTransitionX.start();

		/*
		 * KeyPress Action
		 */
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getCode().equals(KeyCode.W)) {
					speedY.set(3.0);
				} else if (e.getCode().equals(KeyCode.S)) {
					speedY.set(-3.0);
				} else if (e.getCode().equals(KeyCode.A)) {
					speedX.set(3.0);
				} else if (e.getCode().equals(KeyCode.D)) {
					speedX.set(-3.0);
				}
			}

		});

		/*
		 * KeyReleased Action
		 */
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getCode().equals(KeyCode.W) || e.getCode().equals(KeyCode.S)) {
					speedY.set(0.0);
				} else if (e.getCode().equals(KeyCode.A) || e.getCode().equals(KeyCode.D)) {
					speedX.set(0.0);
				}
			}
		});

		return gameScene;
	}

	public static Scene getSelectTeamScene(Stage primaryStage) {

		AnchorPane selectTeamSceneRoot = new AnchorPane();

		selectTeamSceneRoot.setBackground(new Background(new BackgroundImage(
				new Image(ImageUrl.selectTeamBackground), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		
		
		ImageView selectTeamLogo = new ImageView(new Image(ImageUrl.selectTeamLogo));
		selectTeamLogo.setTranslateX(782);
		selectTeamLogo.setTranslateY(77.1);
		selectTeamSceneRoot.getChildren().add(selectTeamLogo);
		
		ImageView playButton = new ImageView(new Image(ImageUrl.selectTeamPlayButton));
		playButton.setTranslateX(1680);
		playButton.setTranslateY(969);
		selectTeamSceneRoot.getChildren().add(playButton);
		
		ImageView backButton = new ImageView(new Image(ImageUrl.selectTeamBackButton));
		backButton.setTranslateX(126);
		backButton.setTranslateY(969);
		selectTeamSceneRoot.getChildren().add(backButton);
		
		/*
		 * Variable for select team
		 */
		ColorAdjust adjustNormal = new ColorAdjust();
		adjustNormal.setBrightness(0);
		ColorAdjust adjustEntered = new ColorAdjust();
		adjustEntered.setBrightness(-0.5);
		ColorAdjust adjustClicked = new ColorAdjust();
		adjustClicked.setBrightness(-0.8);
		
		/*
		 * Player Label
		 */
		
		ImageView lebel_player1 = new ImageView(new Image(ImageUrl.selectTeamLabelPlayer1));
		lebel_player1.setTranslateX(401);
		lebel_player1.setTranslateY(190.1);
		selectTeamSceneRoot.getChildren().add(lebel_player1);
		
		ImageView lebel_player2 = new ImageView(new Image(ImageUrl.selectTeamLabelPlayer2));
		lebel_player2.setTranslateX(1373);
		lebel_player2.setTranslateY(190.1);
		selectTeamSceneRoot.getChildren().add(lebel_player2);
		
		/*
		 * Team Pic Pane
		 */
		
		TeamPicPane teamPicPane1 = new TeamPicPane(0);
		teamPicPane1.setTranslateX(126);
		teamPicPane1.setTranslateY(270);
		selectTeamSceneRoot.getChildren().add(teamPicPane1);
		
		TeamPicPane teamPicPane2 = new TeamPicPane(1);
		teamPicPane2.setTranslateX(1099);
		teamPicPane2.setTranslateY(270);
		selectTeamSceneRoot.getChildren().add(teamPicPane2);
		
		/*
		 * Left/Right Team Pick Pane Button
		 */
		
		ImageView leftButton1 = new ImageView(new Image(ImageUrl.selectTeamLeftButton));
		leftButton1.setTranslateX(41);
		leftButton1.setTranslateY(432);
		selectTeamSceneRoot.getChildren().add(leftButton1);
		
		leftButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton1.setEffect(adjustEntered);
			}
		});
		
		leftButton1.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton1.setEffect(adjustNormal);
			}
		});
		
		leftButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton1.setEffect(adjustClicked);
				teamPicPane1.teamNumDown();
				if(teamPicPane1.getTeamNum() == teamPicPane2.getTeamNum()) {
					teamPicPane1.teamNumDown();
				}
				teamPicPane1.setImageUrl();
			}
		});
		
		ImageView leftButton2 = new ImageView(new Image(ImageUrl.selectTeamLeftButton));
		leftButton2.setTranslateX(1014);
		leftButton2.setTranslateY(432);
		selectTeamSceneRoot.getChildren().add(leftButton2);
		
		leftButton2.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton2.setEffect(adjustEntered);
			}
		});
		
		leftButton2.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton2.setEffect(adjustNormal);
			}
		});
		
		leftButton2.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton2.setEffect(adjustClicked);
				teamPicPane2.teamNumDown();
				if(teamPicPane1.getTeamNum() == teamPicPane2.getTeamNum()) {
					teamPicPane2.teamNumDown();
				}
				teamPicPane2.setImageUrl();
			}
		});
		
		ImageView rightButton1 = new ImageView(new Image(ImageUrl.selectTeamRightButton));
		rightButton1.setTranslateX(841);
		rightButton1.setTranslateY(432);
		selectTeamSceneRoot.getChildren().add(rightButton1);
		
		rightButton1.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton1.setEffect(adjustEntered);
			}
		});
		
		rightButton1.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton1.setEffect(adjustNormal);
			}
		});
		
		rightButton1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton1.setEffect(adjustClicked);
				teamPicPane1.teamNumUp();
				if(teamPicPane1.getTeamNum() == teamPicPane2.getTeamNum()) {
					teamPicPane1.teamNumUp();
				}
				teamPicPane1.setImageUrl();
			}
		});
		
		ImageView rightButton2 = new ImageView(new Image(ImageUrl.selectTeamRightButton));
		rightButton2.setTranslateX(1814);
		rightButton2.setTranslateY(432);
		selectTeamSceneRoot.getChildren().add(rightButton2);
		
		rightButton2.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton2.setEffect(adjustEntered);
			}
		});
		
		rightButton2.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton2.setEffect(adjustNormal);
			}
		});
		
		rightButton2.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton2.setEffect(adjustClicked);
				teamPicPane2.teamNumUp();
				if(teamPicPane1.getTeamNum() == teamPicPane2.getTeamNum()) {
					teamPicPane2.teamNumUp();
				}
				teamPicPane2.setImageUrl();
			}
		});
		
		/*
		 * Select Time
		 */

		Scene selectTeamScene = new Scene(selectTeamSceneRoot, 1920, 1017);
		return selectTeamScene;
	}

}
