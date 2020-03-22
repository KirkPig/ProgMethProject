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
	
	
}
