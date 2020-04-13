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

	private UnitCell selectedUnit = null;
	public int avatarNum;
	private ArrayList<UnitCell> unitCells;

	public UnitPane() {
		this.unitCells = new ArrayList<UnitCell>();
		for (int i = 0; i < GameController.gameBoard.getWidth(); i++) {
			for (int j = 0; j < GameController.gameBoard.getHeight(); j++) {
				UnitCell unitCell = new UnitCell(GameController.gameBoard.getUnit(i, j));
				unitCell.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent e) {
						// TODO Auto-generated method stub
						if (!(unitCell.getUnit() instanceof Empty)
								&& unitCell.getUnit().getOwner().equals(GameController.getCurrentPlayer())) {
							if (selectedUnit == null) {
								if (unitCell.getUnit().getOwner().isPlaceCaptain()) {
									selectedUnit = unitCell;
									unitCell.getUnit().setSelected(!unitCell.getUnit().isSelected());
									for (Unit u : unitCell.getUnit().getMoveUnit()) {
										u.setSelected(!u.isSelected());
									}
									updateBoard();
								}
							} else {
								if (unitCell.equals(selectedUnit)) {
									unitCell.getUnit().setSelected(!unitCell.getUnit().isSelected());
									for (Unit u : unitCell.getUnit().getMoveUnit()) {
										u.setSelected(!u.isSelected());
									}
									updateBoard();
									selectedUnit = null;
								} else {
									selectedUnit.getUnit().setSelected(!selectedUnit.getUnit().isSelected());
									for (Unit u : selectedUnit.getUnit().getMoveUnit()) {
										u.setSelected(!u.isSelected());
									}
									updateBoard();
									selectedUnit = unitCell;
									unitCell.getUnit().setSelected(!unitCell.getUnit().isSelected());
									for (Unit u : unitCell.getUnit().getMoveUnit()) {
										u.setSelected(!u.isSelected());
									}
									updateBoard();
								}
							}
						} else {
							if (unitCell.getUnit().isSelected()) {
								if (UnitBarPane.selectedUnitBarCell != null) {
									try {
										GameController.placeNewUnit(
												UnitBarPane.selectedUnitBarCell.getUnit().getSprites(),
												((UnitCell) e.getSource()).getUnit().getCoordinate().getX(),
												((UnitCell) e.getSource()).getUnit().getCoordinate().getY());
										UnitBarPane.selectedUnitBarCell.getUnit().setSelected(false);
										GameController.nextTurn();
										resetBoard();
										updateBoard();
									} catch (UnitPlaceException e1) {
										System.out.println(e1.getErrorMessage());
										resetBoard();
										updateBoard();
									}
								} else {
									try {
										selectedUnit.getUnit().setSelected(false);
										unitCell.getUnit().setSelected(false);
										unitCell.setVisible(false);
										updateBoard();
										GameController.moveUnit(selectedUnit.getUnit().getCoordinate().getX(),
												selectedUnit.getUnit().getCoordinate().getY(),
												unitCell.getUnit().getCoordinate().getX(),
												unitCell.getUnit().getCoordinate().getY());
										TranslateTransition animation = new TranslateTransition();
										animation.setNode(selectedUnit);
										animation.setDuration(Duration.millis(500));
										animation.setFromX(selectedUnit.getTranslateX());
										animation.setFromY(selectedUnit.getTranslateY());
										animation.setToX(unitCell.getTranslateX());
										animation.setToY(unitCell.getTranslateY());
										animation.play();

										unitCell.setVisible(true);
										GameController.nextTurn();
									} catch (UnitMoveException e1) {
										// TODO Auto-generated catch block
										System.out.println(e1.getErrorMessage());
										unitCell.setVisible(true);
										resetBoard();
									}
									selectedUnit = null;
									updateBoard();

								}

							}
						}
					}

				});
				if (unitCell.getUnit() instanceof Empty) {
					this.getChildren().add(unitCell);
					unitCells.add(unitCell);
				}
			}
		}

		for (int i = 0; i < GameController.gameBoard.getWidth(); i++) {
			for (int j = 0; j < GameController.gameBoard.getHeight(); j++) {
				UnitCell unitCell = new UnitCell(GameController.gameBoard.getUnit(i, j));

				unitCell.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent e) {
						// TODO Auto-generated method stub
						if (!(unitCell.getUnit() instanceof Empty)
								&& unitCell.getUnit().getOwner().equals(GameController.getCurrentPlayer())) {
							if (selectedUnit == null) {
								if (unitCell.getUnit().getOwner().isPlaceCaptain()) {
									selectedUnit = unitCell;
									unitCell.getUnit().setSelected(!unitCell.getUnit().isSelected());
									for (Unit u : unitCell.getUnit().getMoveUnit()) {
										u.setSelected(!u.isSelected());
									}
									updateBoard();
								}
							} else {
								if (unitCell.equals(selectedUnit)) {
									unitCell.getUnit().setSelected(!unitCell.getUnit().isSelected());
									for (Unit u : unitCell.getUnit().getMoveUnit()) {
										u.setSelected(!u.isSelected());
									}
									updateBoard();
									selectedUnit = null;
								} else {
									selectedUnit.getUnit().setSelected(!selectedUnit.getUnit().isSelected());
									for (Unit u : selectedUnit.getUnit().getMoveUnit()) {
										u.setSelected(!u.isSelected());
									}
									updateBoard();
									selectedUnit = unitCell;
									unitCell.getUnit().setSelected(!unitCell.getUnit().isSelected());
									for (Unit u : unitCell.getUnit().getMoveUnit()) {
										u.setSelected(!u.isSelected());
									}
									updateBoard();
								}
							}
						} else {
							if (unitCell.getUnit().isSelected()) {
								if (UnitBarPane.selectedUnitBarCell != null) {
									try {
										GameController.placeNewUnit(
												UnitBarPane.selectedUnitBarCell.getUnit().getSprites(),
												((UnitCell) e.getSource()).getUnit().getCoordinate().getX(),
												((UnitCell) e.getSource()).getUnit().getCoordinate().getY());
										UnitBarPane.selectedUnitBarCell.getUnit().setSelected(false);
										((UnitCell) e.getSource()).setUnit(UnitBarPane.selectedUnitBarCell.getUnit());
										GameController.nextTurn();
										resetBoard();
										updateBoard();
									} catch (UnitPlaceException e1) {
										System.out.println(e1.getErrorMessage());
										resetBoard();
										updateBoard();
									}
								} else {
									try {
										selectedUnit.getUnit().setSelected(false);
										unitCell.getUnit().setSelected(false);
										unitCell.setVisible(false);
										updateBoard();
										GameController.moveUnit(selectedUnit.getUnit().getCoordinate().getX(),
												selectedUnit.getUnit().getCoordinate().getY(),
												unitCell.getUnit().getCoordinate().getX(),
												unitCell.getUnit().getCoordinate().getY());
										TranslateTransition animation = new TranslateTransition();
										animation.setNode(selectedUnit);
										animation.setDuration(Duration.millis(500));
										animation.setFromX(selectedUnit.getTranslateX());
										animation.setFromY(selectedUnit.getTranslateY());
										animation.setToX(unitCell.getTranslateX());
										animation.setToY(unitCell.getTranslateY());
										animation.play();

										unitCell.setVisible(true);
										GameController.nextTurn();
									} catch (UnitMoveException e1) {
										// TODO Auto-generated catch block
										System.out.println(e1.getErrorMessage());
										unitCell.setVisible(true);
										resetBoard();
									}
									selectedUnit = null;
									updateBoard();

								}

							}
						}
					}

				});
				if (!(unitCell.getUnit() instanceof Empty)) {
					this.getChildren().add(unitCell);
					unitCells.add(unitCell);
				}
			}
		}

	}

	public void updateBoard() {
		for (var i : this.unitCells) {
			i.updateCell();
		}
	}

	public void resetBoard() {
		for (var i : this.unitCells) {
			i.getUnit().setSelected(false);
		}
		updateBoard();
	}

	public ArrayList<UnitCell> getUnitCells() {
		return unitCells;
	}

}
