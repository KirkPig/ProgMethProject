package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.GameController;
import test.base.GameTest;
import unit.BoxToBox;
import unit.base.Unit;

public class BoxToBoxTest extends GameTest{
	
	Unit unit1 = new BoxToBox();
	Unit unit2 = new BoxToBox();
	Unit unit3 = new BoxToBox();
	Unit unit4 = new BoxToBox();
	Unit unit5 = new BoxToBox();
	Unit unit6 = new BoxToBox();
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		
	}
	
	@Test
	public void testGetMoveUnit() {
		unit1.setOwner(owner1);
		unit2.setOwner(owner2);
		unit3.setOwner(owner1);
		unit4.setOwner(owner2);
		unit5.setOwner(owner2);
		unit6.setOwner(owner2);
		GameController.gameBoard.addUnit(unit1, 1, 1);
		GameController.gameBoard.addUnit(unit2, 1, 2);
		GameController.gameBoard.addUnit(unit3, 1, 3);
		GameController.gameBoard.addUnit(unit4, 2, 2);
		GameController.gameBoard.addUnit(unit5, 3, 2);
		GameController.gameBoard.addUnit(unit6, 4, 3);
		ArrayList<Unit> answer = new ArrayList<Unit>();
		answer.add(GameController.gameBoard.getUnit(0, 2));
		answer.add(GameController.gameBoard.getUnit(0, 4));
		answer.add(GameController.gameBoard.getUnit(1, 4));
		answer.add(GameController.gameBoard.getUnit(2, 1));
		answer.add(GameController.gameBoard.getUnit(2, 3));
		answer.add(GameController.gameBoard.getUnit(2, 4));
		answer.add(GameController.gameBoard.getUnit(3, 1));
		answer.add(GameController.gameBoard.getUnit(3, 3));
		answer.add(GameController.gameBoard.getUnit(4, 2));
		answer.add(GameController.gameBoard.getUnit(4, 4));
		answer.add(GameController.gameBoard.getUnit(5, 2));
		answer.add(GameController.gameBoard.getUnit(5, 3));
		for(Unit unitTest: answer) {
			assertEquals(true, unit1.getMoveUnit().contains(unitTest));
		}
		
	}

}
