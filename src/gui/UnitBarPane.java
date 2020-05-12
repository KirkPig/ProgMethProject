package gui;



import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
import unit.captain.Kane;
import unit.captain.Silva;

public class UnitBarPane extends Group {
	private String unitBarUrl;
	private UnitPane unitPane;
	private boolean isShow = true;

	public UnitBarPane(UnitPane unitPane) {
		this.unitPane = unitPane;
		this.unitBarUrl = ImageUrl.unitBar;
		updateBarCell();
		
	}
	
	

	public void updateBarCell() {
		getChildren().clear();
		ImageView background = new ImageView(new Image(this.unitBarUrl));
		background.setTranslateX(0);
		background.setTranslateY(0);
		this.getChildren().add(background);
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
					((ImageView) hideButton.getChildren().get(0)).setImage(new Image(ImageUrl.openButton));
					isShow = false;
				}else {
					setTranslateY(getTranslateY()-300);
					((ImageView) hideButton.getChildren().get(0)).setImage(new Image(ImageUrl.hideButton));
					isShow = true;
				}
			}
		} );
		
		ImageView dribbleButton = new ImageView(new Image(ImageUrl.dribbleButton));
		dribbleButton.setTranslateX(hideButton.getTranslateX()-dribbleButton.getFitWidth()-10);
		dribbleButton.setTranslateY(544-711-55);
		getChildren().add(dribbleButton);
		
		
		ImageView warHorseButton = new ImageView(new Image(ImageUrl.warHorseButton));
		warHorseButton.setTranslateX(hideButton.getTranslateX()-warHorseButton.getFitWidth()-10);
		warHorseButton.setTranslateY(544-711-55);
		getChildren().add(warHorseButton);
		
		if(GameController.getCurrentPlayer().getTeam().getCaptain() instanceof Kane) {
			if(GameController.getCurrentPlayer().isPlaceCaptain() && ((Kane) GameController.getCurrentPlayer().getTeam().getCaptain()).isSkillUsable()) {
				warHorseButton.setVisible(true);
			}else {
				warHorseButton.setVisible(false);
			}
			dribbleButton.setVisible(false);
		}else if(GameController.getCurrentPlayer().getTeam().getCaptain() instanceof Silva) {
			warHorseButton.setVisible(false);
			if(GameController.getCurrentPlayer().isPlaceCaptain()) {
				dribbleButton.setVisible(true);
			}else {
				dribbleButton.setVisible(false);
			}
		}else {
			warHorseButton.setVisible(false);
			dribbleButton.setVisible(false);
		}
		
		ColorAdjust adjust = new ColorAdjust();
		adjust.setBrightness(-0.2);
		ColorAdjust normal = new ColorAdjust();
		normal.setBrightness(0);
		

		/*
		 * dribble
		 */
		dribbleButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				dribbleButton.setEffect(adjust);
			}
		});
		
		dribbleButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				dribbleButton.setEffect(normal);
			}
		});
		
		dribbleButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				if(GameController.getCurrentPlayer().isPlaceCaptain()) {
					if(GameController.getCurrentPlayer().getTeam().getCaptain().isCapture()) {
						if(!GameGUIController.isUnitSelected()) {
							ArrayList<Unit> canExit = ((Silva) GameController.getCurrentPlayer().getTeam().getCaptain()).useSkill();
							for(Unit u : canExit) {
								u.setSelected(true);
							}
							
							for(var u: unitPane.getChildren()) {
								if(u instanceof UnitCell) {
									UnitCell unitCell = (UnitCell) u;
									if(unitCell.getUnit() instanceof Defender) {
										if(((Defender)unitCell.getUnit()).getCaptureUnit() != null) {
											if(((Defender)unitCell.getUnit()).getCaptureUnit() instanceof Silva) {
												Defender def = (Defender) unitCell.getUnit();
												Silva silva = (Silva) def.getCaptureUnit();
												silva.setCapture(false);
												def.setCapture(true);
												silva.setCaptureUnit(def);
												def.setCaptureUnit(null);
												GameController.gameBoard.addUnit(silva, def.getCoordinate().getX(), def.getCoordinate().getY());
												GameGUIController.setSelectedUnit(unitCell);
												GameGUIController.setSilvaSelected(unitCell);
												break;
											}
										}
									}
								}
							}
							unitPane.updateBoard();
						}
						
					}else {
						if(GameGUIController.isSilvaSelected()) {
							System.out.println("KUOY");
							Silva silva = (Silva) GameGUIController.getSilvaSelected().getUnit();
							Defender def = (Defender) silva.getCaptureUnit();
							def.setCapture(false);
							silva.setCapture(true);
							def.setCaptureUnit(silva);
							silva.setCaptureUnit(null);
							GameController.gameBoard.addUnit(def, silva.getCoordinate().getX(), silva.getCoordinate().getY());
							GameGUIController.resetSilvaSelected();
							GameGUIController.resetSelectedUnit();
							unitPane.resetBoard();
						}
					}
				}
				
			}
		});
		
		
		/*
		 * warhorse
		 */
		warHorseButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				warHorseButton.setEffect(adjust);
			}
		});
		
		warHorseButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				warHorseButton.setEffect(normal);
			}
		});
		
		warHorseButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				if(GameController.getCurrentPlayer().isPlaceCaptain()) {
					if(!GameGUIController.isUnitSelected()) {
						ArrayList<Unit> canRun = ((Kane) GameController.getCurrentPlayer().getTeam().getCaptain()).useSkill();
						for(Unit u : canRun) {
							u.setSelected(true);
						}
						for(var u: unitPane.getChildren()) {
							if(u instanceof UnitCell) {
								UnitCell unitCell = (UnitCell) u;
								if(unitCell.getUnit() instanceof Kane) {
									GameGUIController.setSelectedUnit(unitCell);
									GameGUIController.setKaneSelected(unitCell);
									break;
								}
							}
						}
						unitPane.updateBoard();
					}else {
						if(GameGUIController.isKaneSelected()) {
							GameGUIController.resetSelectedUnit();
							GameGUIController.resetKaneSelected();
							unitPane.resetBoard();
						}
					}
				}
				
				
			}
		});
		
		
	}
}
