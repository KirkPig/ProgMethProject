package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.GameController;
import test.base.GameTest;
import unit.Attacker;
import unit.Defender;
import unit.God;
import unit.base.Unit;

public class GameBoardTest extends GameTest {

	
	Unit unit1 = new Attacker();
	Unit unit2 = new Defender();
	Unit unit3 = new God();
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
		
	}
	
	@Test
	void testCheckGameBoard() {
		
		GameController.gameBoard.addUnit(unit1, 5, 5);
		GameController.gameBoard.addUnit(unit2, 7, 6);
		assertEquals(false, GameController.gameBoard.checkGameBoard());
		GameController.gameBoard.addUnit(unit3, 6, 6);
		assertEquals(true, GameController.gameBoard.checkGameBoard());
		
	}
	
	@Test 
	void testPlaceUnit(){
		
		assertEquals(true, GameController.gameBoard.placeUnit(unit1, 1, 1, owner1));
		assertEquals(false, GameController.gameBoard.placeUnit(unit2, -1, -1, owner1));
		assertEquals(false, GameController.gameBoard.placeUnit(unit3, 1, 1, owner1));
		assertEquals(false, GameController.gameBoard.placeUnit(unit3, 9, 9, owner1));
		
		
	}
	
	@Test 
	void testAddUnit() {
		
		GameController.gameBoard.addUnit(unit1, 0, 3);
		assertEquals("(0,3)", GameController.gameBoard.getUnit(0, 3).getCoordinate().toString());
		assertEquals(2, GameController.gameBoard.getUnit(0, 3).getSprites());
		
	}
	
	@Test
	void testMoveUnit() {
		
		unit1.setOwner(owner1);
		unit2.setOwner(owner2);
		unit3.setOwner(owner1);
		GameController.gameBoard.addUnit(unit1, 5, 5);
		GameController.gameBoard.addUnit(unit2, 6, 6);
		GameController.gameBoard.addUnit(unit3, 7, 6);
		
		assertEquals(false, GameController.gameBoard.moveUnit(-1, -1, 7, 7, owner1));
		assertEquals(false, GameController.gameBoard.moveUnit(5, 5, -7, -7, owner1));
		assertEquals(false, GameController.gameBoard.moveUnit(1, 1, 7, 7, owner1));
		assertEquals(false, GameController.gameBoard.moveUnit(5, 5, 7, 6, owner1));
		assertEquals(false, GameController.gameBoard.moveUnit(6, 6, 7, 7, owner1));
		assertEquals(false, GameController.gameBoard.moveUnit(5, 5, 2, 2, owner1));
		assertEquals(false, GameController.gameBoard.moveUnit(5, 5, 7, 7, owner2));
		assertEquals(true, GameController.gameBoard.moveUnit(5, 5, 7, 7, owner1));
		
	}
	
	@Test
	void testGetDistance() {
		
		unit1.setOwner(owner1);
		unit2.setOwner(owner2);
		unit3.setOwner(owner1);
		GameController.gameBoard.addUnit(unit1, 5, 5);
		GameController.gameBoard.addUnit(unit2, 6, 6);
		GameController.gameBoard.addUnit(unit3, 7, 6);
		
		assertEquals(INF, GameController.gameBoard.getDistance(5, 5, false).get(7).get(6));
		assertEquals(2, GameController.gameBoard.getDistance(5, 5, true).get(7).get(6));
		assertEquals(4, GameController.gameBoard.getDistance(5, 5, false).get(8).get(7));
		
	}
	
	
	@Test
	void testGetAdjacentUnit() {
		
		for(Unit unit: GameController.gameBoard.getAdjacentUnit(1, 0)) {
			if(unit == null) {
				System.out.println("NULL");
			}
			else
				System.out.println(unit.getCoordinate().toString());
		}
		
	}
	
}
