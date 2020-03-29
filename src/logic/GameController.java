package logic;

import java.util.Scanner;

import logic.exception.UnitMoveException;
import logic.exception.UnitPlaceException;
import unit.base.Unit;

public class GameController {

	public static GameBoard gameBoard;
	public static Owner player1;
	public static Owner player2;
	public static int turn;
	protected static Scanner scanner = new Scanner(System.in);

	public static void InitializeGame() {
		gameBoard = new GameBoard();
		turn = 0;
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

	}

	public static void moveUnit(int x1, int y1, int x2, int y2) throws UnitMoveException {
		
		

	}

	public static Owner getCurrentPlayer() {
		// TODO Auto-generated method stub
		if (turn == 0) {
			return player1;
		} else {
			return player2;
		}
	}

	public static void setupTeamPick(String team1, String team2) {

		player1 = new Owner(team1);
		player2 = new Owner(team2);

	}

	public static void nextTurn() {
		turn = (turn == 0) ? 1 : 0;
	}

	public static void main(String[] args) {
		System.out.println("**********FIFA TIE HEX**********");
		System.out.println("(1)New Game");
		System.out.println("(2)Quit");
		System.out.print("Input Command : ");
		int command = scanner.nextInt();
		if (command == 1) {
			InitializeGame();
			Owner[] playerTurn = new Owner[2];
			playerTurn[0] = player1;
			playerTurn[1] = player2;
			Unit[] unit = new Unit[2];

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
			int position = scanner.nextInt();

			unit[0] = player1.getTeam().getUnit(position);

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
			position = scanner.nextInt();

			unit[1] = player2.getTeam().getUnit(position);
			setupFirstPick(unit[0], unit[1]);

			while (true) {

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
						e.printStackTrace();
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

					if (gameBoard.getUnit(x1, y1).isMovable()) {
						System.out.println(gameBoard.getUnit(x1, y1).getCoordinate() + " Movable");
					} else {
						System.out.println("-----UnitMoveException-----");
					}
					for (int i = 0; i < gameBoard.getUnit(x1, y1).getMoveUnit().size(); i++) {
						if (x2 == gameBoard.getUnit(x1, y1).getMoveUnit().get(i).getCoordinate().getX()
								&& y2 == gameBoard.getUnit(x1, y1).getMoveUnit().get(i).getCoordinate().getY()
								&& gameBoard.getUnit(x1, y1).isMovable()) {
							System.out.println(gameBoard.getUnit(x1, y1).getCoordinate() + " Movable");
							break;
						}
					}
					if (gameBoard.moveUnit(x1, y1, x2, y2, playerTurn[turn])) {
						nextTurn();
					} else {
						System.out.println("-----UnitMoveException-----");
					}

				} else {
					System.out.println("-----NonCommandException-----");
				}

			}

		} else if (command == 2) {
			return;
		} else {
			System.out.println("-----NonCommandException-----");
			return;
		}
	}

}
