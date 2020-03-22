package logic;

import java.util.Scanner;

import unit.Attacker;
import unit.BoxToBox;
import unit.Captain;
import unit.Defender;
import unit.Goalkeeper;
import unit.God;
import unit.Playmaker;

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
			playerTurn[0] = new Owner("MUN");
			playerTurn[1] = new Owner("LFC");
			
			int turn = 0;
			
			while(true) {
				
				printBoard();
				System.out.println("**********FIFA TIE HEX**********");
				System.out.println("-->Team " + playerTurn[turn%2].getTeamName() + " turn to play.");
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
						check = gameBoard.placeUnit(new Captain(playerTurn[turn%2]), x, y);
						break;
					case 2:
						check = gameBoard.placeUnit(new Attacker(playerTurn[turn%2]), x, y);
						break;
					case 3:
						check = gameBoard.placeUnit(new BoxToBox(playerTurn[turn%2]), x, y);
						break;
					case 4:
						check = gameBoard.placeUnit(new Defender(playerTurn[turn%2]), x, y);
						break;
					case 5:
						check = gameBoard.placeUnit(new Goalkeeper(playerTurn[turn%2]), x, y);
						break;
					case 6:
						check = gameBoard.placeUnit(new Playmaker(playerTurn[turn%2]), x, y);
						break;
					case 7:
						check = gameBoard.placeUnit(new God(playerTurn[turn%2]), x, y);
						break;
					}
					
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
					System.out.println("-->Input New Coordinate");
					System.out.print("Input X : ");
					x2 = scanner.nextInt();
					System.out.print("Input Y : ");
					y2 = scanner.nextInt();
					
					if(gameBoard.moveUnit(x1, y1, x2, y2)) {
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
