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
	God unit1 = new God();
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
		//GameController.gameBoard.placeUnit(unit1, 2, 3, owner1);
		//GameController.gameBoard.placeUnit(unit2, 3, 3, owner1);
		//GameController.gameBoard.placeUnit(unit2, 4, 3, owner1);
		//System.out.println(unit1.getRandom());
		//System.out.println(unit1.getMoveUnit().get(0).getCoordinate());
		
		ArrayList<Unit> answer = new ArrayList<Unit>();
		
		unit1.setRandom(2);
		System.out.println("222222222222222222222222222222222");
		/*
		 * 
		 * Bug Make Program Freeze and crash
		 * 
		 * 
		 */ 
		for(int i = 0;i< unit1.getMoveUnit().size();i++) {
			System.out.println(unit1.getMoveUnit().get(i).getCoordinate());
			//System.out.println(",");
			//System.out.println(answer.get(i).getCoordinate());
			//System.out.println("I");
		}
		answer.add(GameController.gameBoard.getUnit(6, 5));
		assertEquals(true, unit1.getMoveUnit().contains(answer.get(0)));
	
		
		unit1.setRandom(3);
		System.out.println("333333333333333333333333333333333333");
		answer = new ArrayList<Unit>();
		for(int i = 0;i< unit1.getMoveUnit().size();i++) {
			System.out.println(unit1.getMoveUnit().get(i).getCoordinate());
			//System.out.println(",");
			//System.out.println(answer.get(i).getCoordinate());
			//System.out.println("I");
		}
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
			
		unit1.setRandom(4);
		System.out.println("44444444444444444444444444444444444444444");
		answer = new ArrayList<Unit>();
		for(int i = 0;i< unit1.getMoveUnit().size();i++) {
			System.out.println(unit1.getMoveUnit().get(i).getCoordinate());
			//System.out.println(",");
			//System.out.println(answer.get(i).getCoordinate());
			//System.out.println("I");
		}
		answer.add(GameController.gameBoard.getUnit(4, 5));
		answer.add(GameController.gameBoard.getUnit(5, 2));
		for(Unit unitTest: answer) {
			assertEquals(true, unit1.getMoveUnit().contains(unitTest));
		}
			
		unit1.setRandom(5);
		System.out.println("5555555555555555555555555555555555555555");
		answer = new ArrayList<Unit>();
		for(int i = 0;i< unit1.getMoveUnit().size();i++) {
			System.out.println(unit1.getMoveUnit().get(i).getCoordinate());
			//System.out.println(",");
			//System.out.println(answer.get(i).getCoordinate());
			//System.out.println("I");
		}
		answer.add(GameController.gameBoard.getUnit(3, 2));
		answer.add(GameController.gameBoard.getUnit(3, 4));
		answer.add(GameController.gameBoard.getUnit(4, 2));
		answer.add(GameController.gameBoard.getUnit(4, 5));
		answer.add(GameController.gameBoard.getUnit(5, 2));
		answer.add(GameController.gameBoard.getUnit(5, 3));
		for(Unit unitTest: answer) {
			assertEquals(true, unit1.getMoveUnit().contains(unitTest));
		}
	}
}
