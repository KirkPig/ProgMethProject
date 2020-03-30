package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.GameController;
import test.base.GameTest;
import unit.God;
import unit.Playmaker;
import unit.base.Unit;

public class GodTest extends GameTest {
	Unit unit1 = new God();
	Unit unit2 = new Playmaker();
	Unit unit3 = new Playmaker();
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
	}
	
	@Test
	void testGetMoveUnit() {
		GameController.gameBoard.placeUnit(unit1, 2, 3, owner1);
		GameController.gameBoard.placeUnit(unit2, 3, 3, owner1);
		GameController.gameBoard.placeUnit(unit2, 4, 3, owner1);
		System.out.println(unit1.getRandom());
		System.out.println(unit1.getMoveUnit().get(0).getCoordinate());
		if(unit1.getRandom() == 2) {
			ArrayList<Unit> answer = new ArrayList<Unit>();
			answer.add(GameController.gameBoard.getUnit(6, 5));
			assertEquals(true, unit1.getMoveUnit().contains(answer.get(0)));
		}
		if(unit1.getRandom() == 3) {
			ArrayList<Unit> answer = new ArrayList<Unit>();
			answer.add(GameController.gameBoard.getUnit(2, 4));
			answer.add(GameController.gameBoard.getUnit(3, 2));
			answer.add(GameController.gameBoard.getUnit(3, 4));
			answer.add(GameController.gameBoard.getUnit(4, 2));
			answer.add(GameController.gameBoard.getUnit(4, 5));
			answer.add(GameController.gameBoard.getUnit(5, 2));
			answer.add(GameController.gameBoard.getUnit(5, 3));
			answer.add(GameController.gameBoard.getUnit(5, 5));
			answer.add(GameController.gameBoard.getUnit(6, 4));
			answer.add(GameController.gameBoard.getUnit(6, 5));
			for(Unit unitTest :answer)
			assertEquals(true, unit1.getMoveUnit().contains(unitTest));
		}
		if(unit1.getRandom() == 4) {
			ArrayList<Unit> answer = new ArrayList<Unit>();
			answer.add(GameController.gameBoard.getUnit(2, 4));
			answer.add(GameController.gameBoard.getUnit(3, 2));
			answer.add(GameController.gameBoard.getUnit(3, 3));
			for(Unit unitTest: answer) {
				assertEquals(true, unit1.getMoveUnit().contains(unitTest));
			}
		}
		if(unit1.getRandom() == 5) {
			ArrayList<Unit> answer = new ArrayList<Unit>();
			answer.add(GameController.gameBoard.getUnit(4, 5));
			answer.add(GameController.gameBoard.getUnit(5, 2));
			for(Unit unitTest: answer) {
				assertEquals(true, unit1.getMoveUnit().contains(unitTest));
			}
		}
		if(unit1.getRandom() == 6) {
			ArrayList<Unit> answer = new ArrayList<Unit>();
			answer.add(GameController.gameBoard.getUnit(3, 2));
			answer.add(GameController.gameBoard.getUnit(3, 4));
			answer.add(GameController.gameBoard.getUnit(4, 2));
			answer.add(GameController.gameBoard.getUnit(4, 5));
			answer.add(GameController.gameBoard.getUnit(5,2 ));
			answer.add(GameController.gameBoard.getUnit(5, 3));
			for(Unit unitTest: answer) {
				assertEquals(true, unit1.getMoveUnit().contains(unitTest));
			}
		}
	}
}
