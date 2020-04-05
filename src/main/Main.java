package main;

import gui.ImageUrl;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
		primaryStage.setScene(getGameScene());
		primaryStage.setTitle("FIFA Hex");
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	public static void main(String[] args) {
		// test
		GameController.InitializeGame("manUnited", "liverpool", 1, 1);
		launch(args);

	}

	public static Scene getCoverSceneRoot() {
		AnchorPane coverSceneRoot = new AnchorPane();

		coverSceneRoot.setBackground(new Background(new BackgroundImage(
				new Image(ImageUrl.coverBackground, 1280, 720, false, false), BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

		ImageView coverLogo = new ImageView(new Image(ImageUrl.coverLogo));
		coverLogo.setX(272);
		coverLogo.setY(94);
		coverSceneRoot.getChildren().add(coverLogo);

		ImageView coverSideLogo = new ImageView(new Image(ImageUrl.coverSideLogo));
		coverSideLogo.setX(888);
		coverSideLogo.setY(10);
		coverSceneRoot.getChildren().add(coverSideLogo);

		ImageView coverForeground = new ImageView(new Image(ImageUrl.coverForeground));
		coverForeground.setX(247);
		coverForeground.setY(360);
		coverSceneRoot.getChildren().add(coverForeground);

		VBox playButton = new VBox();
		ImageView playButtonImage = new ImageView(new Image(ImageUrl.coverPlayButton));
		ImageView playButtonLabel = new ImageView(new Image(ImageUrl.coverPlayButtonLabel));
		playButton.getChildren().add(playButtonImage);
		playButton.getChildren().add(playButtonLabel);

		playButton.setAlignment(Pos.CENTER);
		playButton.setSpacing(30);
		playButton.setTranslateX(492);
		playButton.setTranslateY(300);

		FadeTransition fadePlayButton = new FadeTransition();
		fadePlayButton.setAutoReverse(true);
		fadePlayButton.setCycleCount(Animation.INDEFINITE);
		fadePlayButton.setFromValue(10);
		fadePlayButton.setToValue(0.5);
		fadePlayButton.setDuration(Duration.millis(300));
		fadePlayButton.setNode(playButton);
		fadePlayButton.play();

		coverSceneRoot.getChildren().add(playButton);

		
		Scene coverScene = new Scene(coverSceneRoot, 1280, 720);
		return coverScene;
	}

	public static Scene getGameScene() {
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

}
