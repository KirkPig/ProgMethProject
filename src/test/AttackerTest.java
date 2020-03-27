package test;

import test.base.GameTest;
import unit.Attacker;
import unit.BoxToBox;
import unit.Captain;
import unit.Defender;
import unit.Goalkeeper;
import unit.God;
import unit.base.Unit;

public class AttackerTest extends GameTest {
	Unit unit1 = new Attacker();
	Unit unit2 = new Defender();
	Unit unit3 = new BoxToBox();
	Unit unit4 = new Goalkeeper();
	Unit unit5 = new Captain();
	Unit unit6 = new God();
	
	protected void setUpBeforeEachTest() {
		super.setUpBeforeEachTest();
	}
	
	
}
