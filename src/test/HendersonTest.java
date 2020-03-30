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

public class HendersonTest extends GameTest {
	Unit unit1 = new Goalkeeper();
	Unit unit2 = new Playmaker();
	Unit unit3 = new Playmaker();
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
	}
	
	@Test
	void testGetMoveUnit() {
		Unit unit = GameController.gameBoard.getUnit(4, 4);
		unit1.setOwner(owner1);
		unit2.setOwner(owner2);
		unit3.setOwner(owner1);
		GameController.gameBoard.addUnit(unit1, 5, 3);
		GameController.gameBoard.addUnit(unit2, 6, 4);
		GameController.gameBoard.addUnit(unit3, 6, 5);
		ArrayList<Unit> answer = new ArrayList<Unit>();
		answer.add(GameController.gameBoard.getUnit(4, 3));
		answer.add(GameController.gameBoard.getUnit(4, 5));
		answer.add(GameController.gameBoard.getUnit(5, 2));
		answer.add(GameController.gameBoard.getUnit(5, 5));
		answer.add(GameController.gameBoard.getUnit(6, 4));
		for(int i = 0;i< unit.getMoveUnit().size();i++) {
			System.out.println(unit.getMoveUnit().get(i).getCoordinate());
			System.out.println(unit.getMoveUnit().get(0).getCoordinate().getX() == answer.get(0).getCoordinate().getX());
			System.out.println(answer.get(i).getCoordinate());
			System.out.println("I");
		}
		assertEquals(true, unit.getMoveUnit().contains(answer.get(0)));
		//assertEquals(true, unit.getMoveUnit().contains(answer.get(1)));
		assertEquals(true, unit.getMoveUnit().contains(answer.get(2)));
		assertEquals(true, unit.getMoveUnit().contains(answer.get(3)));
		assertEquals(false, unit.getMoveUnit().contains(answer.get(4)));
	
	}
}
