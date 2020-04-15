package gui;

import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import logic.GameController;
import logic.exception.UnitMoveException;
import logic.exception.UnitPlaceException;
import unit.Empty;
import unit.base.Unit;

public class UnitPane extends Group {

	public int avatarNum;
	private ArrayList<UnitCell> unitCells;

	public UnitPane() {
		this.unitCells = new ArrayList<UnitCell>();
		for (int i = 0; i < GameController.gameBoard.getWidth(); i++) {
			for (int j = 0; j < GameController.gameBoard.getHeight(); j++) {
				UnitCell unitCell = new UnitCell(i, j);
				unitCell.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent e) {
						// TODO Auto-generated method stub
						if (!(((UnitCell) e.getSource()).getUnit() instanceof Empty) && ((UnitCell) e.getSource())
								.getUnit().getOwner().equals(GameController.getCurrentPlayer())) {
							if (!GameGUIController.isUnitBarSelected()) {
								if (GameGUIController.isUnitSelected()) {
									if (GameGUIController.getSelectedUnit().equals(e.getSource())) {
										resetBoard();
										GameGUIController.resetSelectedUnit();
									} else {
										resetBoard();
										GameGUIController.setSelectedUnit((UnitCell) e.getSource());
										GameGUIController.getSelectedUnit().getUnit().setSelected(true);
										System.out.print("PATH THAT YOU CAN MOVE");
										for (Unit u : GameGUIController.getSelectedUnit().getUnit().getMoveUnit()) {
											u.setSelected(true);
											System.out.println(u.getCoordinate().toString());
										}
										updateBoard();
									}
								} else {
									resetBoard();
									GameGUIController.setSelectedUnit((UnitCell) e.getSource());
									GameGUIController.getSelectedUnit().getUnit().setSelected(true);
									System.out.print("PATH THAT YOU CAN MOVE");
									for (Unit u : GameGUIController.getSelectedUnit().getUnit().getMoveUnit()) {
										u.setSelected(true);
										System.out.println(u.getCoordinate().toString());
									}
									updateBoard();
								}
							}
						} else {
							if (((UnitCell) e.getSource()).getUnit().isSelected()) {
								if (GameGUIController.isUnitBarSelected()) {
									try {
										GameController.placeNewUnit(
												GameGUIController.getUnitBarCell().getUnit().getSprites(),
												((UnitCell) e.getSource()).getUnit().getCoordinate().getX(),
												((UnitCell) e.getSource()).getUnit().getCoordinate().getY());
										GameGUIController.getUnitBarCell().getUnit().setSelected(false);
										GameController.nextTurn();
										resetBoard();
										updateBoard();
										GameGUIController.resetUnitBarCell();
									} catch (UnitPlaceException e1) {
										System.out.println(e1.getErrorMessage());
										resetBoard();
										updateBoard();
									}
									GameGUIController.resetSelectedUnit();
									GameGUIController.resetUnitBarCell();
								} else {
									if (GameGUIController.isUnitSelected()) {
										try {
											GameGUIController.getSelectedUnit().getUnit().setSelected(false);
											((UnitCell) e.getSource()).getUnit().setSelected(false);
											((UnitCell) e.getSource()).setVisible(false);
											updateBoard();
											GameController.moveUnit(
													GameGUIController.getSelectedUnit().getUnit().getCoordinate()
															.getX(),
													GameGUIController.getSelectedUnit().getUnit().getCoordinate()
															.getY(),
													((UnitCell) e.getSource()).getUnit().getCoordinate().getX(),
													((UnitCell) e.getSource()).getUnit().getCoordinate().getY());
											/*
											TranslateTransition animation = new TranslateTransition();
											animation.setNode(GameGUIController.getSelectedUnit());
											animation.setDuration(Duration.millis(500));
											animation.setFromX(GameGUIController.getSelectedUnit().getTranslateX());
											animation.setFromY(GameGUIController.getSelectedUnit().getTranslateY());
											animation.setToX(((UnitCell) e.getSource()).getTranslateX());
											animation.setToY(((UnitCell) e.getSource()).getTranslateY());
											animation.play();
											*/
											((UnitCell) e.getSource()).setVisible(true);
											GameController.nextTurn();

										} catch (UnitMoveException e1) {
											// TODO Auto-generated catch block
											System.out.println(e1.getErrorMessage());
											((UnitCell) e.getSource()).setVisible(true);
											resetBoard();
										}
										GameGUIController.resetSelectedUnit();
										GameGUIController.resetUnitBarCell();
										updateBoard();
									}

								}

							}
						}
					}

				});

				this.getChildren().add(unitCell);
				unitCells.add(unitCell);

			}
		}

	}

	public void updateBoard() {
		for (var i : getChildren()) {
			((UnitCell) i).updateCell();
		}
	}

	public void resetBoard() {
		for (var i : getChildren()) {
			((UnitCell) i).getUnit().setSelected(false);
		}
		updateBoard();
	}

	public ArrayList<UnitCell> getUnitCells() {
		return unitCells;
	}

}
