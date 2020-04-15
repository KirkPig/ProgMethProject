package gui;



import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import logic.GameController;
import unit.Attacker;
import unit.BoxToBox;
import unit.Captain;
import unit.Defender;
import unit.Goalkeeper;
import unit.God;
import unit.Playmaker;
import unit.base.Unit;

public class UnitBarPane extends Pane {
	private String UnitBarUrl;
	private UnitPane unitPane;
	private boolean isShow = true;

	public UnitBarPane(UnitPane unitPane) {
		this.unitPane = unitPane;
		this.UnitBarUrl = ImageUrl.unitBar;
		this.setPrefSize(1920, 290);
		setImageUrl();
		updateBarCell();
		
	}

	public void setImageUrl() {
		// TODO Auto-generated method stub
		setBackground(new Background(new BackgroundImage(new Image(this.UnitBarUrl), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
	}
	
	

	public void updateBarCell() {
		getChildren().clear();
		for ( int i = GameController.getCurrentPlayer().getTeam().getUnitNotUsed().size()-1 ; i >= 0 ; i--) {
			Unit u = GameController.getCurrentPlayer().getTeam().getUnitNotUsed().get(i);
			UnitBarCell unitBarCell = null;
			unitBarCell = new UnitBarCell(u);
			if (u instanceof Captain) {
				unitBarCell.setTranslateX(348);
				unitBarCell.setTranslateY(40);
			} else if (u instanceof Attacker) {
				unitBarCell.setTranslateX(575);
				unitBarCell.setTranslateY(40);
			} else if (u instanceof BoxToBox) {
				unitBarCell.setTranslateX(802);
				unitBarCell.setTranslateY(40);
			} else if (u instanceof Defender) {
				unitBarCell.setTranslateX(1029);
				unitBarCell.setTranslateY(40);
			} else if (u instanceof Goalkeeper) {
				unitBarCell.setTranslateX(1256);
				unitBarCell.setTranslateY(40);
			} else if (u instanceof Playmaker) {
				unitBarCell.setTranslateX(1483);
				unitBarCell.setTranslateY(40);
			} else if (u instanceof God) {
				unitBarCell.setTranslateX(1710);
				unitBarCell.setTranslateY(40);
			}
			unitBarCell.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {
					// TODO Auto-generated method stub
					if(!GameGUIController.isUnitSelected()) {
						if (GameGUIController.isUnitBarSelected()) {
							if (GameGUIController.getUnitBarCell().equals(e.getSource())) {
								GameGUIController.getUnitBarCell().getUnit().setSelected(false);
								GameGUIController.getUnitBarCell().updateCell();
								GameGUIController.resetUnitBarCell();
								unitPane.resetBoard();
							} else {
								GameGUIController.getUnitBarCell().getUnit().setSelected(false);
								GameGUIController.getUnitBarCell().updateCell();
								GameGUIController.setUnitBarCell((UnitBarCell) e.getSource()); 
								unitPane.resetBoard();
								GameGUIController.getUnitBarCell().getUnit().setSelected(true);
								GameGUIController.getUnitBarCell().updateCell();
								for (var u : unitPane.getUnitCells()) {
									if (GameController.getNextPlace().contains(u.getUnit())) {
										u.getUnit().setSelected(true);
									}
								}
								unitPane.updateBoard();
							}
						} else {
							GameGUIController.setUnitBarCell((UnitBarCell) e.getSource());
							unitPane.resetBoard();
							GameGUIController.getUnitBarCell().getUnit().setSelected(true);
							GameGUIController.getUnitBarCell().updateCell();
							for (var u : unitPane.getUnitCells()) {
								if (GameController.getNextPlace().contains(u.getUnit())) {
									u.getUnit().setSelected(true);
								}
							}
							unitPane.updateBoard();
						}
					}

				}

			});
			getChildren().add(unitBarCell);
		}
		ImageView teamLabel = new ImageView();
		switch (GameController.getCurrentPlayer().getTeam().getName()) {
		case "liverpool": 
			teamLabel.setImage(new Image(ImageUrl.liverpoolLabel));
			break;
		case "manUnited" :
			teamLabel.setImage(new Image(ImageUrl.manUnitedLabel));
			break;
		case "manCity" :
			teamLabel.setImage(new Image(ImageUrl.manCityLabel));
			break;
		case "spur" :
			teamLabel.setImage(new Image(ImageUrl.spurLabel));
			break;
		}
		teamLabel.setTranslateX(301);
		teamLabel.setTranslateY(657-711);
		getChildren().add(teamLabel);
		
		VBox hideButton = new VBox();
		ImageView hideButtonImage = new ImageView(new Image(ImageUrl.hideButton));
		hideButton.getChildren().add(hideButtonImage);
		hideButton.setTranslateX(1639);
		hideButton.setTranslateY(670-711);
		hideButton.setPrefHeight(45);
		hideButton.setPrefWidth(238);
		getChildren().add(hideButton);
		
		hideButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(isShow) {
					setTranslateY(getTranslateY()+300);
					isShow = false;
				}else {
					setTranslateY(getTranslateY()-300);
					isShow = true;
				}
			}
		} );
		
		
	}
}
