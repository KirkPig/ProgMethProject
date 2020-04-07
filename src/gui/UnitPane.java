package gui;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import logic.GameController;
import logic.exception.UnitMoveException;
import unit.Empty;
import unit.base.Unit;

public class UnitPane extends Group {

	private UnitCell selectedUnit = null;

	public UnitPane() {

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

				});
				if (unitCell.getUnit() instanceof Empty) {
					this.getChildren().add(unitCell);
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
									e1.printStackTrace();
									unitCell.setVisible(true);
									resetBoard();
								}
								selectedUnit = null;
								updateBoard();

							}
						}
					}

				});
				if (!(unitCell.getUnit() instanceof Empty)) {
					this.getChildren().add(unitCell);
				}
			}
		}

	}

	public void updateBoard() {
		for (Node i : this.getChildren()) {
			if (i instanceof UnitCell) {
				((UnitCell) i).updateCell();
			}
		}
	}

	public void resetBoard() {
		for (Node i : this.getChildren()) {
			if (i instanceof UnitCell) {
				((UnitCell) i).getUnit().setSelected(false);
			}
		}
		updateBoard();
	}

}
