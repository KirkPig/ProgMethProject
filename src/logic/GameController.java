package logic;

import java.util.Scanner;

import unit.Attacker;
import unit.BoxToBox;
import unit.Defender;
import unit.Goalkeeper;
import unit.God;
import unit.Playmaker;
import unit.base.Unit;
import unit.captain.Mcguire;

public class GameController {
	
	public static GameBoard gameBoard;
	protected static Scanner scanner = new Scanner(System.in);
	
	public static void InitializeGame() {
		gameBoard = new GameBoard();
		
	}
	
	public static void printBoard() {
		// TODO Auto-generated method stub
		gameBoard.printBoard();
	}
	
	public static void main(String[] args) {
		System.out.println("**********FIFA TIE HEX**********");
		System.out.println("(1)New Game");
		System.out.println("(2)Quit");
		System.out.print("Input Command : ");
		int command = scanner.nextInt();
		if(command == 1) {
			InitializeGame();
			Owner[] playerTurn = new Owner[2];
			playerTurn[0] = new Owner("manUnited");
			playerTurn[1] = new Owner("liverpool");
			Unit[] unit = new Unit[1];
			
			System.out.println("**********FIFA TIE HEX**********");
			System.out.println("-->Team " + playerTurn[0].getTeam().getName() + " please select your first unit");
			System.out.println("**********Place New Unit**********");
			System.out.println("(1)Captain");
			System.out.println("(2)Attacker");
			System.out.println("(3)BoxToBox");
			System.out.println("(4)Defender");
			System.out.println("(5)Goalkeeper");
			System.out.println("(6)Playmaker");
			System.out.println("(7)God");
			System.out.print("Input Unit : ");
			command = scanner.nextInt();
			
			switch(command) {
			case 1:
				unit[0] = new Mcguire();
				break;
			case 2:
				unit[0] = new Attacker();
				break;
			case 3:
				unit[0] = new BoxToBox();
				break;
			case 4:
				unit[0] = new Defender();
				break;
			case 5:
				unit[0] = new Goalkeeper();
				break;
			case 6:
				unit[0] = new Playmaker();
				break;
			case 7:
				unit[0] = new God();
				break;
			}
			
			unit[0].setOwner(playerTurn[0]);
			gameBoard.addUnit(unit[0], 4, 4);
			
			
			System.out.println("**********FIFA TIE HEX**********");
			System.out.println("-->Team " + playerTurn[1].getTeam().getName() + " please select your first unit");
			System.out.println("**********Place New Unit**********");
			System.out.println("(1)Captain");
			System.out.println("(2)Attacker");
			System.out.println("(3)BoxToBox");
			System.out.println("(4)Defender");
			System.out.println("(5)Goalkeeper");
			System.out.println("(6)Playmaker");
			System.out.println("(7)God");
			System.out.print("Input Unit : ");
			command = scanner.nextInt();
			
			switch(command) {
			case 1:
				unit[0] = new Mcguire();
				break;
			case 2:
				unit[0] = new Attacker();
				break;
			case 3:
				unit[0] = new BoxToBox();
				break;
			case 4:
				unit[0] = new Defender();
				break;
			case 5:
				unit[0] = new Goalkeeper();
				break;
			case 6:
				unit[0] = new Playmaker();
				break;
			case 7:
				unit[0] = new God();
				break;
			}
			
			unit[0].setOwner(playerTurn[1]);
			gameBoard.addUnit(unit[0], 5, 4);
			
			int turn = 0;
			
			
			
			while(true) {
				
				printBoard();
				System.out.println("**********FIFA TIE HEX**********");
				System.out.println("-->Team " + playerTurn[turn%2].getTeam().getName() + " turn to play.");
				System.out.println("(1)Place New Unit");
				System.out.println("(2)Move Unit");
				System.out.println("(999)Quit");
				System.out.print("Input Command : ");
				command = scanner.nextInt();
				
				if(command == 999) break;
				
				if(command == 1) {
					
					System.out.println("**********Place New Unit**********");
					System.out.println("(1)Captain");
					System.out.println("(2)Attacker");
					System.out.println("(3)BoxToBox");
					System.out.println("(4)Defender");
					System.out.println("(5)Goalkeeper");
					System.out.println("(6)Playmaker");
					System.out.println("(7)God");
					System.out.println("(999)Quit");
					System.out.print("Input Unit : ");
					command = scanner.nextInt();
					if(command == 999) break;
					System.out.print("Input X : ");
					int x = scanner.nextInt();
					System.out.print("Input Y : ");
					int y = scanner.nextInt();
					boolean check = false;
					
					
					
					switch(command) {
					case 1:
						unit[0] = new Mcguire();
						break;
					case 2:
						unit[0] = new Attacker();
						break;
					case 3:
						unit[0] = new BoxToBox();
						break;
					case 4:
						unit[0] = new Defender();
						break;
					case 5:
						unit[0] = new Goalkeeper();
						break;
					case 6:
						unit[0] = new Playmaker();
						break;
					case 7:
						unit[0] = new God();
						break;
					}
					
					check = gameBoard.placeUnit(unit[0], x, y, playerTurn[turn%2]);
					
					if(check) {
						turn++;
					}else {
						System.out.println("-----UnitPlaceException-----");
					}
					
				}else if(command == 2) {
					int x1, y1, x2, y2;
					System.out.println("**********Move Unit**********");
					System.out.println("-->Input Unit Coordinate");
					System.out.print("Input X : ");
					x1 = scanner.nextInt();
					System.out.print("Input Y : ");
					y1 = scanner.nextInt();
					System.out.print("PATH THAT YOU CAN MOVE");
					for(int i =0; i<gameBoard.getUnit(x1, y1).getMoveUnit().size();i++) {
						System.out.println(gameBoard.getUnit(x1, y1).getMoveUnit().get(i).getCoordinate());
					}
					System.out.println("-->Input New Coordinate");
					System.out.print("Input X : ");
					x2 = scanner.nextInt();
					System.out.print("Input Y : ");
					y2 = scanner.nextInt();
					
					if(gameBoard.getUnit(x1, y1).isMovable()) {
						System.out.println(gameBoard.getUnit(x1, y1).getCoordinate() + " Movable");
					}else {
						System.out.println("-----UnitMoveException-----");
					}
					for(int i =0; i<gameBoard.getUnit(x1, y1).getMoveUnit().size();i++) {
						if(x2 == gameBoard.getUnit(x1, y1).getMoveUnit().get(i).getCoordinate().getX() && y2 == gameBoard.getUnit(x1, y1).getMoveUnit().get(i).getCoordinate().getY()
								&& gameBoard.getUnit(x1, y1).isMovable()) {
							System.out.println(gameBoard.getUnit(x1, y1).getCoordinate() + " Movable");
							break;
						}
					}
					if(gameBoard.moveUnit(x1, y1, x2, y2, playerTurn[turn%2])) {
						turn+=1;
					}else {
						System.out.println("-----UnitMoveException-----");
					}
					
					
					
				}else {
					System.out.println("-----NonCommandException-----");
				}
				
				
			}
			
		}else if(command == 2) {
			return;
		}else {
			System.out.println("-----NonCommandException-----");
			return;
		}
	}
	
}
