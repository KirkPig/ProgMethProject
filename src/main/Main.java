package main;

import gui.ImageUrl;
import gui.UnitPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameController;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		primaryStage.setScene(getCoverScene());
		primaryStage.setResizable(false);
		primaryStage.setTitle("FIFA Hex");
		primaryStage.show();
	}

	public static void main(String[] args) {
		//test
		GameController.InitializeGame("manUnited", "liverpool", 1, 1);
		launch(args);

	}

	public static Scene getCoverScene() {
		AnchorPane coverSceneRoot = new AnchorPane();

		coverSceneRoot.setBackground(
				new Background(new BackgroundImage(new Image(ImageUrl.coverBackground, 1280, 720, false, false), BackgroundRepeat.REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

		ImageView coverLogo = new ImageView(new Image(ImageUrl.coverLogo));
		coverLogo.setX(272);
		coverLogo.setY(94);
		coverSceneRoot.getChildren().add(coverLogo);
		
		ImageView coverSideLogo = new ImageView(new Image(ImageUrl.coverSideLogo));
		coverSideLogo.setX(888);
		coverSideLogo.setY(10);
		coverSceneRoot.getChildren().add(coverSideLogo);

		Scene coverScene = new Scene(coverSceneRoot, 1280, 720);
		return coverScene;
	}
	
	public static Scene getGameScene() {
		AnchorPane gameSceneRoot = new AnchorPane();
		
		//Background
		gameSceneRoot.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		
		//UnitPane
		UnitPane unitPane = new UnitPane();
		unitPane.setTranslateX(500);
		unitPane.setTranslateY(50);
		gameSceneRoot.getChildren().add(unitPane);
		
		Scene gameScene = new Scene(gameSceneRoot, 1920, 1017);
		return gameScene;
	}

}
