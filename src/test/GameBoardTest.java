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

	
	Unit unit1 = new Attacker(owner1);
	Unit unit2 = new Defender(owner1);
	Unit unit3 = new God(owner1);
	
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
		
		assertEquals(true, GameController.gameBoard.placeUnit(unit1, 1, 1));
		assertEquals(false, GameController.gameBoard.placeUnit(unit2, -1, -1));
		assertEquals(false, GameController.gameBoard.placeUnit(unit3, 1, 1));
		
		
	}
	
	@Test 
	void testAddUnit() {
		
		GameController.gameBoard.addUnit(unit1, 5, 5);
		assertEquals("(5,5)", GameController.gameBoard.getUnit(5, 5).getCoordinate().toString());
		assertEquals(2, GameController.gameBoard.getUnit(5, 5).getSprites());
		
	}
	
	@Test
	void testMoveUnit() {
		
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
	
	
}
