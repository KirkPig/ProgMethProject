package test.base;

import org.junit.jupiter.api.BeforeEach;

import logic.GameController;
import logic.Owner;

public class GameTest {
	
	protected Owner owner1 = new Owner("1");
	protected Owner owner2 = new Owner("2");
	protected static final int INF = 1000000000;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		
		GameController.InitializeGame("liverpool", "manUnited", 1, 1); //Reset the Board
		
	}

}
