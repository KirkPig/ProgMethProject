package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.GameController;
import test.base.GameTest;
import unit.Playmaker;
import unit.base.Unit;

public class PlayMakerTest extends GameTest {
	Unit unit1 = new Playmaker();
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
		answer.add(GameController.gameBoard.getUnit(3, 2));
		answer.add(GameController.gameBoard.getUnit(3, 4));
		answer.add(GameController.gameBoard.getUnit(4, 2));
		answer.add(GameController.gameBoard.getUnit(4, 5));
		answer.add(GameController.gameBoard.getUnit(5,2 ));
		answer.add(GameController.gameBoard.getUnit(5, 3));
		for(int i = 0;i< unit1.getMoveUnit().size();i++) {
			System.out.println(unit1.getMoveUnit().get(i).getCoordinate());
			//System.out.println(",");
			//System.out.println(answer.get(i).getCoordinate());
			//System.out.println("I");
		}
		for(Unit unitTest: answer) {
			assertEquals(true, unit1.getMoveUnit().contains(unitTest));
		}
	}
}
