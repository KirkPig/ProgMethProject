package logic;

import java.util.Scanner;

import logic.exception.UnitMoveException;
import logic.exception.UnitPlaceException;
import unit.Captain;
import unit.Defender;
import unit.base.Unit;

public class GameController {

	public static GameBoard gameBoard;
	public static Owner player1;
	public static Owner player2;
	public static int turn;
	public static boolean gameEnd;
	protected static Scanner scanner = new Scanner(System.in);

	public static void InitializeGame(String team1, String team2, int positionUnit1, int positionUnit2) {
		gameBoard = new GameBoard();
		turn = 0;
		setupTeamPick(team1, team2);
		Unit unit1 = player1.getTeam().getUnit(positionUnit1);
		Unit unit2 = player2.getTeam().getUnit(positionUnit2);
		setupFirstPick(unit1, unit2);
		gameEnd = false;
	}

	public static void printBoard() {
		// TODO Auto-generated method stub
		gameBoard.printBoard();
	}

	public static void setupFirstPick(Unit unit1, Unit unit2) {

		unit1.setOwner(player1);
		gameBoard.addUnit(unit1, 4, 4);
		player1.getTeam().useUnit(unit1);
		unit2.setOwner(player2);
		gameBoard.addUnit(unit2, 5, 4);
		player2.getTeam().useUnit(unit2);

	}

	public static void placeNewUnit(int position, int x, int y) throws UnitPlaceException {

		Unit unit = getCurrentPlayer().getTeam().getUnit(position);
		if (unit == null) {
			throw new UnitPlaceException(1);
		}
		if (!gameBoard.placeUnit(unit, x, y, getCurrentPlayer())) {
			throw new UnitPlaceException(2);
		}
		if(unit instanceof Captain) {
			getCurrentPlayer().setPlaceCaptain(true);
		}
		getCurrentPlayer().getTeam().useUnit(unit);

	}

	public static void moveUnit(int x1, int y1, int x2, int y2) throws UnitMoveException {

		if (!gameBoard.getUnit(x1, y1).isMovable()) {
			throw new UnitMoveException(1);
		}
		Unit unit1 = gameBoard.getUnit(x1, y1);
		Unit unit2 = gameBoard.getUnit(x2, y2);
		if (!unit1.getMoveUnit().contains(unit2)) {
			throw new UnitMoveException(3);
		}
		if(getCurrentPlayer().isPlaceCaptain()) {
			throw new UnitMoveException(4);
		}
		if (!gameBoard.moveUnit(x1, y1, x2, y2, getCurrentPlayer())
				&& !(gameBoard.getUnit(x1, y1) instanceof Defender)) {
			throw new UnitMoveException(2);
		}

	}

	public static Owner getCurrentPlayer() {
		// TODO Auto-generated method stub
		return (turn == 0) ? player1 : player2;
	}

	public static void setupTeamPick(String team1, String team2) {

		player1 = new Owner(team1);
		player2 = new Owner(team2);

	}

	public static void nextTurn() {
		turn = (turn == 0) ? 1 : 0;
	}
	
	public static Owner getWinner() {
		if(!player1.isPlaceCaptain() || !player2.isPlaceCaptain()) {
			return null;
		}
		if(player1.getTeam().getCaptain().isSurrounded()) {
			return player1;
		}
		if(player2.getTeam().getCaptain().isSurrounded()) {
			return player2;
		}
		return null;
	}
	
	public static boolean isGameEnd() {
		if(player1.getTeam().getCaptain().isSurrounded() ||
				player2.getTeam().getCaptain().isSurrounded()) {
			gameEnd = true;
		}
		return gameEnd;
	}

	
	public static void main(String[] args) {
		System.out.println("**********FIFA TIE HEX**********");
		System.out.println("(1)New Game");
		System.out.println("(2)Quit");
		System.out.print("Input Command : ");
		int command = scanner.nextInt();
		if (command == 1) {

			// For Setup Game
			String team1 = "", team2 = "";

			System.out.println("**********SELECT YOUR TEAM**********");
			System.out.println("PLAYER 1");
			System.out.println("(1) LIVERPOOL");
			System.out.println("(2) MAN UNITED");
			System.out.println("(3) MAN CITY");
			System.out.println("(4) SPUR");
			System.out.print("Input Command : ");
			command = scanner.nextInt();
			switch (command) {
			case 1:
				team1 = "liverpool";
				break;
			case 2:
				team1 = "manUnited";
				break;
			case 3:
				team1 = "manCity";
				break;
			case 4:
				team1 = "spur";
				break;
			}

			System.out.println("PLAYER 2");
			System.out.println("(1) LIVERPOOL");
			System.out.println("(2) MAN UNITED");
			System.out.println("(3) MAN CITY");
			System.out.println("(4) SPUR");
			System.out.print("Input Command : ");
			command = scanner.nextInt();
			switch (command) {
			case 1:
				team2 = "liverpool";
				break;
			case 2:
				team2 = "manUnited";
				break;
			case 3:
				team2 = "manCity";
				break;
			case 4:
				team2 = "spur";
				break;
			}

			System.out.println("**********FIFA TIE HEX**********");
			System.out.println("-->PLAYER 1 please select your first unit");
			System.out.println("**********Place New Unit**********");
			System.out.println("(1)Captain");
			System.out.println("(2)Attacker");
			System.out.println("(3)BoxToBox");
			System.out.println("(4)Defender");
			System.out.println("(5)Goalkeeper");
			System.out.println("(6)Playmaker");
			System.out.println("(7)God");
			System.out.print("Input Unit : ");
			int positionUnit1 = scanner.nextInt();

			System.out.println("**********FIFA TIE HEX**********");
			System.out.println("-->PLAYER 2 please select your first unit");
			System.out.println("**********Place New Unit**********");
			System.out.println("(1)Captain");
			System.out.println("(2)Attacker");
			System.out.println("(3)BoxToBox");
			System.out.println("(4)Defender");
			System.out.println("(5)Goalkeeper");
			System.out.println("(6)Playmaker");
			System.out.println("(7)God");
			System.out.print("Input Unit : ");
			int positionUnit2 = scanner.nextInt();

			//Initialized New Game
			InitializeGame(team1, team2, positionUnit1, positionUnit2);

			int position;

			while (getWinner() == null) {

				printBoard();
				System.out.println("**********FIFA TIE HEX**********");
				System.out.println("-->Team " + getCurrentPlayer().getTeam().getName() + " turn to play.");
				System.out.println("(1)Place New Unit");
				System.out.println("(2)Move Unit");
				System.out.println("(999)Quit");
				System.out.print("Input Command : ");
				command = scanner.nextInt();

				if (command == 999)
					break;

				if (command == 1) {

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
					position = scanner.nextInt();
					if (command == 999)
						break;
					System.out.print("Input X : ");
					int x = scanner.nextInt();
					System.out.print("Input Y : ");
					int y = scanner.nextInt();

					if (position == 999) {
						break;
					}

					try {
						placeNewUnit(position, x, y);
						nextTurn();
					} catch (UnitPlaceException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getErrorMessage());
					}

				} else if (command == 2) {
					int x1, y1, x2, y2;
					System.out.println("**********Move Unit**********");
					System.out.println("-->Input Unit Coordinate");
					System.out.print("Input X : ");
					x1 = scanner.nextInt();
					System.out.print("Input Y : ");
					y1 = scanner.nextInt();
					System.out.print("PATH THAT YOU CAN MOVE");

					for (int i = 0; i < gameBoard.getUnit(x1, y1).getMoveUnit().size(); i++) {
						System.out.println(gameBoard.getUnit(x1, y1).getMoveUnit().get(i).getCoordinate());
					}

					System.out.println("-->Input New Coordinate");
					System.out.print("Input X : ");
					x2 = scanner.nextInt();
					System.out.print("Input Y : ");
					y2 = scanner.nextInt();

					try {
						moveUnit(x1, y1, x2, y2);
						nextTurn();
					} catch (UnitMoveException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getErrorMessage());
					}

				} else {
					System.out.println("-----NonCommandException-----");
				}
				
				if(getWinner() != null) {
					break;
				}
			}
			System.out.println("*******************************");
			System.out.println(getWinner().getName() + " Win!!!");
			System.out.println("*******************************");

		} else if (command == 2) {
			return;
		} else {
			System.out.println("-----NonCommandException-----");
			return;
		}
	}

}
