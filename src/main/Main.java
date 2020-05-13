package main;


import gui.AvatarPane;
import gui.CaptainPicPane;
import gui.CaptainSkillPane;
import gui.ImageUrl;
import gui.TeamPicPane;
import gui.TutorialPane;
import gui.UnitBarPane;
import gui.UnitPane;
import gui.WinPane;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
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
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.GameController;
import logic.Owner;

public class Main extends Application {
	public static Stage primaryStage;
	public static AudioClip sound1 = new AudioClip("file:res/sound/intro.mp3");
	public static AudioClip sound2 = new AudioClip("file:res/sound/crowd.mp3");
	public static AudioClip sound3 = new AudioClip("file:res/sound/win.mp3");

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		Main.primaryStage = primaryStage;
		primaryStage.setScene(getCoverScene());
		primaryStage.setTitle("FIFA Hex");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Scene getCoverScene() {
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
				sound1.play();
				primaryStage.setScene(getMainmenuScene());
			}

		});
		coverSceneRoot.getChildren().add(playButton);

		Scene coverScene = new Scene(coverSceneRoot, 1920, 1017);
		return coverScene;
	}

	public static Scene getMainmenuScene() {
		AnchorPane mainmenuSceneRoot = new AnchorPane();
		mainmenuSceneRoot.setBackground(new Background(new BackgroundImage(
				new Image(ImageUrl.coverBackground, 1920, 1017, false, false), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

		ImageView mainmenuLego = new ImageView(new Image(ImageUrl.mainmenuLogo));
		mainmenuLego.setX(503);
		mainmenuLego.setY(83);
		mainmenuSceneRoot.getChildren().add(mainmenuLego);

		ImageView mainmenuForegroundLeft = new ImageView(new Image(ImageUrl.mainmenuForegroundLeft));
		mainmenuForegroundLeft.setX(50);
		mainmenuForegroundLeft.setY(218);
		mainmenuSceneRoot.getChildren().add(mainmenuForegroundLeft);

		ImageView mainmenuForegroundRight = new ImageView(new Image(ImageUrl.mainmenuForegroundRight));
		mainmenuForegroundRight.setX(1356);
		mainmenuForegroundRight.setY(215);
		mainmenuSceneRoot.getChildren().add(mainmenuForegroundRight);

		ImageView mainmenuForegroundDown = new ImageView(new Image(ImageUrl.mainmenuForegroundDown));
		mainmenuForegroundDown.setX(0);
		mainmenuForegroundDown.setY(770);
		mainmenuSceneRoot.getChildren().add(mainmenuForegroundDown);

		VBox playButton = new VBox();
		ImageView playButtonImage = new ImageView(new Image(ImageUrl.mainmenuPlayButton));
		playButton.getChildren().add(playButtonImage);
		playButton.setTranslateX(630);
		playButton.setTranslateY(372);
		mainmenuSceneRoot.getChildren().add(playButton);

		FadeTransition fadePlayButton = new FadeTransition();
		fadePlayButton.setAutoReverse(true);
		fadePlayButton.setCycleCount(Animation.INDEFINITE);
		fadePlayButton.setFromValue(10);
		fadePlayButton.setToValue(0.5);
		fadePlayButton.setDuration(Duration.millis(500));
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
				primaryStage.setScene(getSelectTeamScene());
			}

		});

		VBox quitButton = new VBox();
		ImageView quitButtonImage = new ImageView(new Image(ImageUrl.mainmenuQuitButton));
		quitButton.getChildren().add(quitButtonImage);
		quitButton.setTranslateX(1101);
		quitButton.setTranslateY(372);
		mainmenuSceneRoot.getChildren().add(quitButton);

		FadeTransition fadeQuitButton = new FadeTransition();
		fadeQuitButton.setAutoReverse(true);
		fadeQuitButton.setCycleCount(Animation.INDEFINITE);
		fadeQuitButton.setFromValue(10);
		fadeQuitButton.setToValue(0.5);
		fadeQuitButton.setDuration(Duration.millis(500));
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
		
		VBox tutorialButton = new VBox();
		ImageView tutorialButtonImage = new ImageView(new Image(ImageUrl.mainmenuTutorialButton));
		tutorialButton.getChildren().add(tutorialButtonImage);
		tutorialButton.setTranslateX(797);
		tutorialButton.setTranslateY(634);
		mainmenuSceneRoot.getChildren().add(tutorialButton);
		
		FadeTransition fadeTutorialButton = new FadeTransition();
		fadeTutorialButton.setAutoReverse(true);
		fadeTutorialButton.setCycleCount(Animation.INDEFINITE);
		fadeTutorialButton.setFromValue(10);
		fadeTutorialButton.setToValue(0.5);
		fadeTutorialButton.setDuration(Duration.millis(500));
		fadeTutorialButton.setNode(tutorialButton);
		fadeTutorialButton.play();
		
		tutorialButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				fadeTutorialButton.stop();
				tutorialButton.setOpacity(1.0);
			}

		});

		tutorialButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				fadeTutorialButton.play();
			}

		});

		tutorialButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainmenuSceneRoot.getChildren().add(getTutorial());
			}

		});
		
		ImageView soundButton = new ImageView();
		sound3.stop();
		if(sound1.isPlaying()) {
			soundButton.setImage(new Image(ImageUrl.soundOn));
		}else {
			soundButton.setImage(new Image(ImageUrl.soundOff));
		}
		soundButton.setTranslateX(1747);
		soundButton.setTranslateY(23);
		mainmenuSceneRoot.getChildren().add(soundButton);
		
		soundButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(0.7);;
			}

		});

		soundButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(1);;
			}

		});

		soundButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(0.1);
				if(sound1.isPlaying()) {
					sound1.stop();
					soundButton.setImage(new Image(ImageUrl.soundOff));
				}else {
					sound1.play();
					soundButton.setImage(new Image(ImageUrl.soundOn));
				}
				

			}

		});
		
		
		//Test Tutorial
		//mainmenuSceneRoot.getChildren().add(getTutorial());

		Scene mainmenuScene = new Scene(mainmenuSceneRoot, 1920, 1017);
		return mainmenuScene;
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
		 * unitbar
		 */
		UnitBarPane unitBarPane = new UnitBarPane(unitPane);
		unitBarPane.setTranslateX(0);
		unitBarPane.setTranslateY(711);
		gameSceneRoot.getChildren().add(unitBarPane);
		
		/*
		 * avatar
		 */
		int teamPlayer1 = 0;
		int teamPlayer2 = 0;
		switch(GameController.player1.getTeam().getName()) {
		case "liverpool":
			teamPlayer1 = 0; 
			break;
		case "manUnited":
			teamPlayer1 = 1; 
			break;
		case "manCity":
			teamPlayer1 = 2; 
			break;
		case "spur":
			teamPlayer1 = 3; 
			break;
		}
		switch(GameController.player2.getTeam().getName()) {
		case "liverpool":
			teamPlayer2 = 0; 
			break;
		case "manUnited":
			teamPlayer2 = 1; 
			break;
		case "manCity":
			teamPlayer2 = 2; 
			break;
		case "spur":
			teamPlayer2 = 3; 
			break;
		}
		
		AvatarPane avatarPlayer1 = new AvatarPane(teamPlayer1);
		avatarPlayer1.setTranslateX(0);
		avatarPlayer1.setTranslateY(510);
		
		AvatarPane avatarPlayer2 = new AvatarPane(teamPlayer2);
		avatarPlayer2.setTranslateX(0);
		avatarPlayer2.setTranslateY(510);
		
		if(GameController.getCurrentPlayer().equals(GameController.player1)) {
			gameSceneRoot.getChildren().add(avatarPlayer1);
		}else {
			gameSceneRoot.getChildren().add(avatarPlayer2);
		}
		
		final ObjectProperty<Owner> previousOwner = new SimpleObjectProperty<Owner>(GameController.getCurrentPlayer());
		AnimationTimer switchTurnCheck = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if(!GameController.getCurrentPlayer().equals(previousOwner.get())) {
					previousOwner.set(GameController.getCurrentPlayer());
					if(GameController.getCurrentPlayer().equals(GameController.player1)) {
						gameSceneRoot.getChildren().add(avatarPlayer1);
						gameSceneRoot.getChildren().remove(avatarPlayer2);
					}else {
						gameSceneRoot.getChildren().add(avatarPlayer2);
						gameSceneRoot.getChildren().remove(avatarPlayer1);
						
					}
					unitBarPane.updateBarCell();
				}
				
				
			}
		};
		switchTurnCheck.start();
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
		
		AnimationTimer checkWin = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if(GameController.isGameEnd()) {
					if(sound2.isPlaying()) {
						sound3.play();
						sound2.stop();
					}
					WinPane winPane = new WinPane();
					winPane.setTranslateX(0);
					winPane.setTranslateY(0);
					gameSceneRoot.getChildren().add(winPane);
					this.stop();
					switchTurnCheck.stop();
					gameSceneRoot.getChildren().remove(unitBarPane);
					gameSceneRoot.getChildren().remove(avatarPlayer1);
					gameSceneRoot.getChildren().remove(avatarPlayer2);
				}
			}
		};
		checkWin.start();

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
		
		/*
		 * quitButton
		 */
		VBox quitButton = new VBox();
		ImageView quitButtonImage = new ImageView(new Image(ImageUrl.gameQuitButton));
		quitButton.getChildren().add(quitButtonImage);
		quitButton.setTranslateX(73);
		quitButton.setTranslateY(43);
		gameSceneRoot.getChildren().add(quitButton);
		
		ColorAdjust adjustNormal = new ColorAdjust();
		adjustNormal.setBrightness(0);
		ColorAdjust adjustEntered = new ColorAdjust();
		adjustEntered.setBrightness(-0.5);
		ColorAdjust adjustClicked = new ColorAdjust();
		adjustClicked.setBrightness(-0.8);
		
		quitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				quitButton.setEffect(adjustEntered);
			}
		});
		
		quitButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				quitButton.setEffect(adjustNormal);
			}
		});
		
		quitButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(sound2.isPlaying()) {
					sound2.stop();
					sound1.play();
				}
				quitButton.setEffect(adjustClicked);
				gameSceneRoot.getChildren().remove(unitBarPane);
				gameSceneRoot.getChildren().remove(avatarPlayer1);
				gameSceneRoot.getChildren().remove(avatarPlayer2);
				primaryStage.setScene(getMainmenuScene());
			}
		});
		
		quitButton.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				quitButton.setEffect(adjustEntered);
			}
		});
		
		//soundButton
		ImageView soundButton = new ImageView();
		if(sound2.isPlaying()) {
			soundButton.setImage(new Image(ImageUrl.soundOn));
		}else {
			soundButton.setImage(new Image(ImageUrl.soundOff));
		}
		soundButton.setTranslateX(1747);
		soundButton.setTranslateY(23);
		gameSceneRoot.getChildren().add(soundButton);
		
		soundButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(0.7);;
			}

		});

		soundButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(1);;
			}

		});

		soundButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(0.1);
				if(sound2.isPlaying() && !GameController.isGameEnd()) {
					sound2.stop();
					soundButton.setImage(new Image(ImageUrl.soundOff));
				}else if(!sound2.isPlaying() && !GameController.isGameEnd()) {
					sound2.play();
					soundButton.setImage(new Image(ImageUrl.soundOn));
				}
				
				if(sound3.isPlaying() && GameController.isGameEnd()) {
					sound3.stop();
					soundButton.setImage(new Image(ImageUrl.soundOff));
				}else if(!sound3.isPlaying() && GameController.isGameEnd()){
					sound3.play();
					soundButton.setImage(new Image(ImageUrl.soundOn));
				}
				

			}

		});
		
		return gameScene;
	}

	public static Scene getSelectTeamScene() {

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
		 * Captain Pic Pane
		 */
		
		CaptainPicPane captainPicPane1 = new CaptainPicPane(0);
		captainPicPane1.setTranslateX(142);
		captainPicPane1.setTranslateY(672);
		selectTeamSceneRoot.getChildren().add(captainPicPane1);
		
		CaptainPicPane captainPicPane2 = new CaptainPicPane(1);
		captainPicPane2.setTranslateX(1599);
		captainPicPane2.setTranslateY(672);
		selectTeamSceneRoot.getChildren().add(captainPicPane2);
		
		/*
		 * Captain Skill Pane
		 */
		
		CaptainSkillPane captainSkillPane1 = new CaptainSkillPane(0);
		captainSkillPane1.setTranslateX(389);
		captainSkillPane1.setTranslateY(713);
		selectTeamSceneRoot.getChildren().add(captainSkillPane1);
		
		CaptainSkillPane captainSkillPane2 = new CaptainSkillPane(1);
		captainSkillPane2.setTranslateX(1116);
		captainSkillPane2.setTranslateY(713);
		selectTeamSceneRoot.getChildren().add(captainSkillPane2);
		
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
		
		leftButton1.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton1.setEffect(adjustClicked);
				teamPicPane1.teamNumDown();
				captainPicPane1.teamNumDown();
				captainSkillPane1.teamNumDown();
				if(teamPicPane1.getTeamNum() == teamPicPane2.getTeamNum()) {
					teamPicPane1.teamNumDown();
					captainPicPane1.teamNumDown();
					captainSkillPane1.teamNumDown();
				}
				teamPicPane1.setImageUrl();
				captainPicPane1.setImageUrl();
				captainSkillPane1.updateSkill();
			}
		});
		
		leftButton1.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton1.setEffect(adjustEntered);
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
		
		leftButton2.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton2.setEffect(adjustClicked);
				teamPicPane2.teamNumDown();
				captainPicPane2.teamNumDown();
				captainSkillPane2.teamNumDown();
				if(teamPicPane1.getTeamNum() == teamPicPane2.getTeamNum()) {
					teamPicPane2.teamNumDown();
					captainPicPane2.teamNumDown();
					captainSkillPane2.teamNumDown();
				}
				teamPicPane2.setImageUrl();
				captainPicPane2.setImageUrl();
				captainSkillPane2.updateSkill();
			}
		});
		
		leftButton2.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton2.setEffect(adjustEntered);
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
		
		rightButton1.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton1.setEffect(adjustClicked);
				teamPicPane1.teamNumUp();
				captainPicPane1.teamNumUp();
				captainSkillPane1.teamNumUp();
				if(teamPicPane1.getTeamNum() == teamPicPane2.getTeamNum()) {
					teamPicPane1.teamNumUp();
					captainPicPane1.teamNumUp();
					captainSkillPane1.teamNumUp();
				}
				teamPicPane1.setImageUrl();
				captainPicPane1.setImageUrl();
				captainSkillPane1.updateSkill();
			}
		});
		
		rightButton1.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton1.setEffect(adjustEntered);
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
		
		rightButton2.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton2.setEffect(adjustClicked);
				teamPicPane2.teamNumUp();
				captainPicPane2.teamNumUp();
				captainSkillPane2.teamNumUp();
				if(teamPicPane1.getTeamNum() == teamPicPane2.getTeamNum()) {
					teamPicPane2.teamNumUp();
					captainPicPane2.teamNumUp();
					captainSkillPane2.teamNumUp();
				}
				teamPicPane2.setImageUrl();
				captainPicPane2.setImageUrl();
				captainSkillPane2.updateSkill();
			}
		});
		
		rightButton2.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton2.setEffect(adjustEntered);
			}
		});
		
		/*
		 * Play Button
		 */
		
		playButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				playButton.setEffect(adjustEntered);
			}
		});
		
		playButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				playButton.setEffect(adjustNormal);
			}
		});
		
		playButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(sound1.isPlaying()) {
					sound1.stop();
					sound2.play();
				}
				playButton.setEffect(adjustClicked);
				String team1 = null, team2 = null;
				switch(teamPicPane1.getTeamNum()) {
				case 0:
					team1 = "liverpool"; 
					break;
				case 1:
					team1 = "manUnited";
					break;
				case 2:
					team1 = "manCity";
					break;
				case 3:
					team1 = "spur";
					break;
				}
				switch(teamPicPane2.getTeamNum()) {
				case 0:
					team2 = "liverpool"; 
					break;
				case 1:
					team2 = "manUnited";
					break;
				case 2:
					team2 = "manCity";
					break;
				case 3:
					team2 = "spur";
					break;
				}
				GameController.InitializeGame(team1, team2, 1, 1);
				primaryStage.setScene(getGameScene());
			}
		});
		
		/*
		 * Back Button
		 */
		
		backButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				backButton.setEffect(adjustEntered);
			}
		});
		
		backButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				backButton.setEffect(adjustNormal);
			}
		});
		
		backButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				backButton.setEffect(adjustClicked);
				primaryStage.setScene(getMainmenuScene());
			}
		});
		
		/*
		 * Sound
		 */
		
		ImageView soundButton = new ImageView();
		sound3.stop();
		if(sound1.isPlaying()) {
			soundButton.setImage(new Image(ImageUrl.soundOn));
		}else {
			soundButton.setImage(new Image(ImageUrl.soundOff));
		}
		soundButton.setTranslateX(1747);
		soundButton.setTranslateY(23);
		ColorAdjust color = new ColorAdjust();
		color.setBrightness(1);
		soundButton.setEffect(color);
		selectTeamSceneRoot.getChildren().add(soundButton);
		
		
		soundButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(0.7);;
			}

		});

		soundButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(1);;
			}

		});

		soundButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(0.1);
				if(sound1.isPlaying()) {
					sound1.stop();
					soundButton.setImage(new Image(ImageUrl.soundOff));
				}else {
					sound1.play();
					soundButton.setImage(new Image(ImageUrl.soundOn));
				}
				

			}

		});
		

		Scene selectTeamScene = new Scene(selectTeamSceneRoot, 1920, 1017);
		return selectTeamScene;
	}

	public static Parent getTutorial() {
		
		AnchorPane tutorialPane = new AnchorPane();
		tutorialPane.setPrefSize(1920, 1017);
		tutorialPane.setTranslateX(0);
		tutorialPane.setTranslateY(0);
		
		ImageView background = new ImageView(new Image(ImageUrl.coverBackground, 1920, 1017, false, false));
		ColorAdjust adjust = new ColorAdjust();
		adjust.setBrightness(-0.7);
		adjust.setInput(new GaussianBlur());
		background.setEffect(adjust);
		background.setTranslateX(0);
		background.setTranslateY(0);
		tutorialPane.getChildren().add(background);
		
		TutorialPane pane = new TutorialPane(0);
		pane.setTranslateX(300);
		pane.setTranslateY(150);
		tutorialPane.getChildren().add(pane);
		
		ImageView tutorialBackButton = new ImageView(new Image(ImageUrl.selectTeamBackButton));
		tutorialBackButton.setTranslateX(26);
		tutorialBackButton.setTranslateY(969);
		tutorialPane.getChildren().add(tutorialBackButton);
		
		ColorAdjust adjustNormal = new ColorAdjust();
		adjustNormal.setBrightness(0);
		ColorAdjust adjustEntered = new ColorAdjust();
		adjustEntered.setBrightness(-0.5);
		ColorAdjust adjustClicked = new ColorAdjust();
		adjustClicked.setBrightness(-0.8);
		
		tutorialBackButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				tutorialBackButton.setEffect(adjustEntered);
			}
		});
		
		tutorialBackButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				tutorialBackButton.setEffect(adjustNormal);
			}
		});
		
		tutorialBackButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				tutorialBackButton.setEffect(adjustClicked);
				primaryStage.setScene(getMainmenuScene());
			}
		});
		
		ImageView leftButton = new ImageView(new Image(ImageUrl.selectTeamLeftButton));
		leftButton.setTranslateX(41);
		leftButton.setTranslateY(432);
		tutorialPane.getChildren().add(leftButton);
		
		leftButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton.setEffect(adjustEntered);
			}
		});
		
		leftButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton.setEffect(adjustNormal);
			}
		});
		
		leftButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton.setEffect(adjustClicked);
				pane.pageNumDown();
				pane.setImageUrl();
			}
		});
		
		leftButton.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				leftButton.setEffect(adjustEntered);
			}
		});
		
		ImageView rightButton = new ImageView(new Image(ImageUrl.selectTeamRightButton));
		rightButton.setTranslateX(1814);
		rightButton.setTranslateY(432);
		tutorialPane.getChildren().add(rightButton);
		
		rightButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton.setEffect(adjustEntered);
			}
		});
		
		rightButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton.setEffect(adjustNormal);
			}
		});
		
		rightButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton.setEffect(adjustClicked);
				pane.pageNumUp();
				pane.setImageUrl();
			}
		});
		
		rightButton.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				rightButton.setEffect(adjustEntered);
			}
		});
		
		ImageView soundButton = new ImageView();
		if(sound1.isPlaying()) {
			soundButton.setImage(new Image(ImageUrl.soundOn));
		}else {
			soundButton.setImage(new Image(ImageUrl.soundOff));
		}
		soundButton.setTranslateX(1747);
		soundButton.setTranslateY(23);
		ColorAdjust color = new ColorAdjust();
		color.setBrightness(1);
		soundButton.setEffect(color);
		tutorialPane.getChildren().add(soundButton);
		
		
		soundButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(0.7);;
			}

		});

		soundButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(1);;
			}

		});

		soundButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				soundButton.setOpacity(0.1);
				if(sound1.isPlaying()) {
					sound1.stop();
					soundButton.setImage(new Image(ImageUrl.soundOff));
				}else {
					sound1.play();
					soundButton.setImage(new Image(ImageUrl.soundOn));
				}
				

			}

		});
		
		
		
		return tutorialPane;
	}
}
