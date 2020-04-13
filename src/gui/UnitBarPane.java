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
import logic.GameController;
import logic.Owner;
import team.TeamImageUrl;
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
	public static UnitBarCell selectedUnitBarCell = null;
	private UnitPane unitPane;

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
					if (selectedUnitBarCell != null) {
						if (selectedUnitBarCell.equals(e.getSource())) {
							selectedUnitBarCell.getUnit().setSelected(false);
							selectedUnitBarCell.updateCell();
							selectedUnitBarCell = null;
							unitPane.resetBoard();
						} else {
							selectedUnitBarCell.getUnit().setSelected(false);
							selectedUnitBarCell.updateCell();
							selectedUnitBarCell = (UnitBarCell) e.getSource();
							unitPane.resetBoard();
							selectedUnitBarCell.getUnit().setSelected(true);
							selectedUnitBarCell.updateCell();
							for (var u : unitPane.getUnitCells()) {
								if (GameController.getNextPlace().contains(u.getUnit())) {
									u.getUnit().setSelected(true);
								}
							}
							unitPane.updateBoard();
						}
					} else {
						selectedUnitBarCell = (UnitBarCell) e.getSource();
						unitPane.resetBoard();
						selectedUnitBarCell.getUnit().setSelected(true);
						selectedUnitBarCell.updateCell();
						for (var u : unitPane.getUnitCells()) {
							if (GameController.getNextPlace().contains(u.getUnit())) {
								u.getUnit().setSelected(true);
							}
						}
						unitPane.updateBoard();
					}

				}

			});
			getChildren().add(unitBarCell);
		}
	}
}
