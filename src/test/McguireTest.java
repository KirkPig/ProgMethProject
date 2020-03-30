package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.GameController;
import test.base.GameTest;
import unit.Defender;
import unit.Goalkeeper;
import unit.Playmaker;
import unit.base.Unit;

public class McguireTest extends GameTest {
	Unit unit1 = new Goalkeeper();
	Unit unit2 = new Playmaker();
	Unit unit3 = new Defender();
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
	}
	
	@Test
	void testGetMoveUnit() {
		Unit unit = GameController.gameBoard.getUnit(5, 4);
		unit1.setOwner(owner1);
		unit2.setOwner(owner2);
		unit3.setOwner(owner1);
		GameController.gameBoard.addUnit(unit1, 3, 4);
		GameController.gameBoard.addUnit(unit2, 3, 5);
		GameController.gameBoard.addUnit(unit3, 4, 6);
		ArrayList<Unit> answer = new ArrayList<Unit>();
		answer.add(GameController.gameBoard.getUnit(4, 5));
		answer.add(GameController.gameBoard.getUnit(5, 3));
		answer.add(GameController.gameBoard.getUnit(5, 5));
		answer.add(GameController.gameBoard.getUnit(6, 4));
		for(int i = 0;i< unit.getMoveUnit().size();i++) {
			System.out.println(unit.getMoveUnit().get(i).getCoordinate());
			//System.out.println(",");
			//System.out.println(answer.get(i).getCoordinate());
			//System.out.println("I");
		}
		assertEquals(true, unit.getMoveUnit().contains(answer.get(0)));
		assertEquals(true, unit.getMoveUnit().contains(answer.get(1)));
		assertEquals(true, unit.getMoveUnit().contains(answer.get(2)));
		assertEquals(false, unit.getMoveUnit().contains(answer.get(3)));
	}
	
	@Test
	void testCanNotCapture() {
		unit1.setOwner(owner1);
		unit2.setOwner(owner2);
		unit3.setOwner(owner1);
		GameController.gameBoard.addUnit(unit1, 3, 4);
		GameController.gameBoard.addUnit(unit2, 3, 5);
		GameController.gameBoard.addUnit(unit3, 4, 5);
		assertEquals(false, unit3.getMoveUnit().contains(GameController.gameBoard.getUnit(5, 4)));
	}
}
