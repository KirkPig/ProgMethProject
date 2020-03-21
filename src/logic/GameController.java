package logic;

import java.util.Scanner;

import unit.Attacker;
import unit.BoxToBox;
import unit.Captain;
import unit.Defender;
import unit.Empty;
import unit.Goalkeeper;
import unit.God;
import unit.Playmaker;

public class GameController {
	
	public static GameBoard gameBoard;
	protected static Scanner scanner = new Scanner(System.in);
	
	public GameController() {
		// TODO Auto-generated constructor stub
		gameBoard = new GameBoard();
	}
	
	public void printBoard() {
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
			GameController gameController = new GameController();
			Owner owner1 = new Owner("MUN");
			Owner owner2 = new Owner("LFC");
			int turn = 0;
			
			while(true) {
				Owner playerTurn;
				if(turn%2 == 0) {
					playerTurn = owner1;
				}else {
					playerTurn = owner2;
				}
				
				gameController.printBoard();
				System.out.println("**********FIFA TIE HEX**********");
				System.out.println("-->Team " + playerTurn.getTeamName() + " turn to play.");
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
					switch(command) {
					case 1:
						if(playerTurn.isPlaceCaptain()) {
							gameBoard.addUnit(new Captain(playerTurn), x, y);
							playerTurn.setPlaceCaptain(true);
						}else {
							System.out.println("-----GameRuleException-----");
						}
						break;
					case 2:
						gameBoard.placeUnit(new Attacker(playerTurn), x, y);
						break;
					case 3:
						gameBoard.placeUnit(new BoxToBox(playerTurn), x, y);
						break;
					case 4:
						gameBoard.placeUnit(new Defender(playerTurn), x, y);
						break;
					case 5:
						gameBoard.placeUnit(new Goalkeeper(playerTurn), x, y);
						break;
					case 6:
						gameBoard.placeUnit(new Playmaker(playerTurn), x, y);
						break;
					case 7:
						gameBoard.placeUnit(new God(playerTurn), x, y);
						break;
					}
					
					turn++;
					
				}else if(command == 2) {
					int x1, y1, x2, y2;
					System.out.println("**********Move Unit**********");
					
					do {
						System.out.println("-->Input Unit Coordinate");
						System.out.print("Input X : ");
						x1 = scanner.nextInt();
						System.out.print("Input Y : ");
						y1 = scanner.nextInt();
						
						if(gameBoard.getUnit(x1, y1) instanceof Empty) {
							System.out.println("-----EmptyUnitSelectException-----");
						}else if(gameBoard.getUnit(x1, y1).getOwner() != playerTurn) {
							System.out.println("-----SelectOpponentUnitException-----");
						}else {
							break;
						}
						
					}while(true);
					
					do {
						System.out.println("-->Input New Coordinate");
						System.out.print("Input X : ");
						x2 = scanner.nextInt();
						System.out.print("Input Y : ");
						y2 = scanner.nextInt();
						
						if(!(gameBoard.getUnit(x2, y2) instanceof Empty)) {
							System.out.println("-----NonEmptyCoordinatePlaceException-----");
						}else {
							break;
						}
						
					}while(true);
					
					gameBoard.moveUnit(x1, y1, x2, y2);
					
					turn++;
					
				}else {
					System.out.println("**********ERROR**********");
				}
				
				if(turn%2 == 0) {
					owner1 = playerTurn;
				}else {
					owner2 = playerTurn;
				}
				
				
			}
			
		}else if(command == 2) {
			return;
		}else {
			System.out.println("**********ERROR**********");
			return;
		}
	}

}
