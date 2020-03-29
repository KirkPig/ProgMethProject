package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.GameController;
import test.base.GameTest;
import unit.Goalkeeper;
import unit.Playmaker;
import unit.base.Unit;

public class GoalKeeperTest extends GameTest {
	Unit unit1 = new Goalkeeper();
	Unit unit2 = new Playmaker();
	Unit unit3 = new Playmaker();
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
	}
	
	@Test
	void testGetMoveUnit() {
		unit1.setOwner(owner1);
		unit2.setOwner(owner2);
		unit3.setOwner(owner1);
		GameController.gameBoard.addUnit(unit1, 2, 3);
		GameController.gameBoard.addUnit(unit2, 3, 3);
		GameController.gameBoard.addUnit(unit3, 4, 3);
		ArrayList<Unit> answer = new ArrayList<Unit>();
		answer.add(GameController.gameBoard.getUnit(4, 5));
		answer.add(GameController.gameBoard.getUnit(5, 2));
		for(Unit unitTest: answer) {
			assertEquals(true, unit1.getMoveUnit().contains(unitTest));
		}
	}
}
