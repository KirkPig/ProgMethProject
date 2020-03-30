package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.GameController;
import test.base.GameTest;
import unit.Defender;
import unit.Playmaker;
import unit.base.Unit;
import unit.captain.Silva;

public class SilvaTest extends GameTest {
	Unit unit1 = new Silva();
	Unit unit2 = new Playmaker();
	Unit unit3 = new Playmaker();
	Unit unit4 = new Defender();
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
	}
	
	@Test
	void testGetMoveUnit() {
		unit2.setOwner(owner2);
		unit3.setOwner(owner1);
		GameController.gameBoard.addUnit(unit1, 2, 3);
		GameController.gameBoard.addUnit(unit2, 3, 3);
		GameController.gameBoard.addUnit(unit3, 4, 3);
		ArrayList<Unit> answer = new ArrayList<Unit>();
		answer.add(GameController.gameBoard.getUnit(2, 4));
		answer.add(GameController.gameBoard.getUnit(3, 2));
		for(Unit unitTest: answer) {
			assertEquals(true, unit1.getMoveUnit().contains(unitTest));
		}
	}
	
	@Test
	void testUseSkill() {
		Silva unit1 = new Silva();
		unit2.setOwner(owner2);
		unit3.setOwner(owner1);
		unit4.setOwner(owner1);
		GameController.gameBoard.addUnit(unit1, 2, 3);
		GameController.gameBoard.addUnit(unit2, 3, 3);
		GameController.gameBoard.addUnit(unit3, 4, 3);
		GameController.gameBoard.addUnit(unit4, 1, 3);
		GameController.gameBoard.moveUnit(1, 3, 2, 3, owner1);
		ArrayList<Unit> answer = new ArrayList<Unit>();
		answer.add(GameController.gameBoard.getUnit(1, 2));
		answer.add(GameController.gameBoard.getUnit(1, 3));
		answer.add(GameController.gameBoard.getUnit(2, 2));
		answer.add(GameController.gameBoard.getUnit(2, 4));
		answer.add(GameController.gameBoard.getUnit(3, 2));
		for(int i = 0;i< unit1.useSkill().size();i++) {
			System.out.println(unit1.useSkill().get(i).getCoordinate());
			//System.out.println(",");
			//System.out.println(answer.get(i).getCoordinate());
			//System.out.println("I");
		}
		for(Unit unitTest :answer)
		assertEquals(true, unit1.useSkill().contains(unitTest));
	}
}
