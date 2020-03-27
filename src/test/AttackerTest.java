package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import logic.GameController;
import test.base.GameTest;
import unit.Attacker;
import unit.Empty;
import unit.base.Unit;

public class AttackerTest extends GameTest {
	Unit unit1 = new Attacker();
	Unit unit2 = new Attacker();
	Unit unit3 = new Attacker();
	Unit unit4 = new Attacker();
	Unit unit5 = new Attacker();
	Unit unit6 = new Attacker();
	
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
	}
	
	void testMoveAttacker() {
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
		answer.add(new Empty(1, 4));
		answer.add(new Empty(5, 3));
		assertEquals(answer, unit1.getMoveUnit());
	}
}
