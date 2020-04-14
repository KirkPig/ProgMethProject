package logic;

import java.util.ArrayList;

import unit.Defender;
import unit.Empty;
import unit.base.Coordinate;
import unit.base.Movable;
import unit.base.Unit;

public class GameBoard {

	private static final int INF = 1000000000;
	private ArrayList<ArrayList<Unit>> units;
	private int width;
	private int height;

	public GameBoard(int width, int height) {
		// TODO Auto-generated constructor stub
		this.units = new ArrayList<ArrayList<Unit>>();
		this.width = width;
		this.height = height;
		InitializedBoard();
	}

	public GameBoard() {
		// TODO Auto-generated constructor stub
		this.units = new ArrayList<ArrayList<Unit>>();
		this.width = 10;
		this.height = 10;
		InitializedBoard();
	}

	public void InitializedBoard() {
		for (int i = 0; i < width; i++) {
			ArrayList<Unit> e = new ArrayList<Unit>();
			for (int j = 0; j < height; j++) {
				e.add(new Empty(i, j));
			}
			units.add(e);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isUnitMovable(int x, int y) {
		Unit unit = getUnit(x, y);
		if (unit instanceof Empty) {
			return false;
		}
		GameController.gameBoard.addUnit(new Empty(), x, y);
		boolean check = GameController.gameBoard.checkGameBoard();
		GameController.gameBoard.addUnit(unit, x, y);
		return check;

	}

	public void printBoard() {
		int k = 0;
		for (var row : units) {
			String rowstring = "";
			if (k % 2 == 1) {
				rowstring += " ";
			}
			for (Unit c : row) {
				rowstring += c.getSprites() + " ";
			}
			System.out.println(rowstring);
			k++;
		}
	}

	public void placeUnit(Unit unit, int x, int y, Owner owner) {
		// TODO Auto-generated method stub
		unit.setOwner(owner);
		addUnit(unit, x, y);
	}

	public boolean isEmpty(int x, int y) {
		// TODO Auto-generated method stub
		if (getUnit(x, y) instanceof Empty)
			return true;
		else
			return false;

	}

	public void addUnit(Unit unit, int x, int y) {
		// TODO Auto-generated method stub
		unit.setCoordinate(new Coordinate(x, y));
		units.get(x).set(y, unit);
	}

	public void moveUnit(int x1, int y1, int x2, int y2, Owner owner) {
		// TODO Auto-generated method stub
		Unit unit = getUnit(x1, y1);
		Unit k = getUnit(x2, y2);
		if (unit instanceof Defender) {
			Defender def = (Defender) unit;
			if (def.getCaptureUnit() != null) {
				k = def.getCaptureUnit();
				def.setCaptureUnit(null);
			}
			if (!isEmpty(x2, y2)) {

				def.setCaptureUnit(getUnit(x2, y2));
				addUnit(new Empty(x2, y2), x2, y2);
				k = getUnit(x2, y2);

			}
		}
		if (unit instanceof Defender) {
			Defender def = (Defender) unit;
			if (def.getCaptureUnit() != null)
				def.getCaptureUnit().setCapture(true);
			k.setCapture(false);
		}
		addUnit(k, x1, y1);
		addUnit(unit, x2, y2);

	}

	public Unit getUnit(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return null;
		}
		return units.get(x).get(y);
	}

	public ArrayList<Unit> getOwnerUnit(Owner owner) {
		ArrayList<Unit> ownerUnit = new ArrayList<Unit>();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!(getUnit(i, j) instanceof Empty)) {
					if (getUnit(i, j).getOwner().equals(owner)) {
						ownerUnit.add(getUnit(i, j));
					}
				}
			}
		}
		return ownerUnit;
	}

	public ArrayList<ArrayList<Integer>> getDistance(int x, int y, boolean isThrough) {

		ArrayList<ArrayList<Integer>> distance = new ArrayList<ArrayList<Integer>>();
		Unit unit = getUnit(x, y);
		addUnit(new Empty(), x, y);

		for (int i = 0; i < width; i++) {
			ArrayList<Integer> e = new ArrayList<Integer>();
			for (int j = 0; j < height; j++) {
				e.add(INF);
			}
			distance.add(e);
		}

		distance.get(x).set(y, 0);

		for (int k = 0; k < width * height; k++) {

			boolean chk = false;

			// Horizontal
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height - 1; j++) {
					if (isThrough || (isEmpty(i, j) && isEmpty(i, j + 1))) {

						boolean condition = false;

						if (i % 2 == 0) {

							if (isEmpty(i - 1, j) || isEmpty(i + 1, j)) {
								condition = true;
							}

						} else {

							if (isEmpty(i - 1, j + 1) || isEmpty(i + 1, j + 1)) {
								condition = true;
							}

						}

						// Relax Function
						if (condition && distance.get(i).get(j + 1) > distance.get(i).get(j) + 1) {
							distance.get(i).set(j + 1, distance.get(i).get(j) + 1);
							chk = true;
						}

						if (condition && distance.get(i).get(j) > distance.get(i).get(j + 1) + 1) {
							distance.get(i).set(j, distance.get(i).get(j + 1) + 1);
							chk = true;
						}

					}
				}

			}

			// Vertical
			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width - 1; i++) {

					if (isThrough || (isEmpty(i, j) && isEmpty(i + 1, j))) {

						if (i % 2 == 0
								&& (getAdjacentUnit(i, j).get(1) == null
										|| getAdjacentUnit(i, j).get(1) instanceof Movable)
								&& (getAdjacentUnit(i, j).get(5) == null
										|| getAdjacentUnit(i, j).get(5) instanceof Movable)) {
							continue;
						}

						if (i % 2 == 1
								&& (getAdjacentUnit(i, j).get(3) == null
										|| getAdjacentUnit(i, j).get(3) instanceof Movable)
								&& (getAdjacentUnit(i, j).get(4) == null
										|| getAdjacentUnit(i, j).get(4) instanceof Movable)) {

						}

						if (distance.get(i + 1).get(j) > distance.get(i).get(j) + 1) {
							distance.get(i + 1).set(j, distance.get(i).get(j) + 1);
							chk = true;
						}

						if (distance.get(i).get(j) > distance.get(i + 1).get(j) + 1) {
							distance.get(i).set(j, distance.get(i + 1).get(j) + 1);
							chk = true;
						}

					}

				}
			}

			// swap
			for (int j = 1; j < height; j++) {

				for (int i = 0; i < width - 1; i++) {

					if (i % 2 == 0) {

						if (isThrough || (isEmpty(i, j) && isEmpty(i + 1, j - 1))) {

							if ((getAdjacentUnit(i, j).get(3) == null
									|| getAdjacentUnit(i, j).get(3) instanceof Movable)
									&& (getAdjacentUnit(i, j).get(4) == null
											|| getAdjacentUnit(i, j).get(4) instanceof Movable)) {

							}

							if (distance.get(i).get(j) > distance.get(i + 1).get(j - 1) + 1) {
								distance.get(i).set(j, distance.get(i + 1).get(j - 1) + 1);
								chk = true;
							}

							if (distance.get(i + 1).get(j - 1) > distance.get(i).get(j) + 1) {
								distance.get(i + 1).set(j - 1, distance.get(i).get(j) + 1);
								chk = true;
							}

						}

					} else {

						if (isThrough || (isEmpty(i, j - 1) && isEmpty(i + 1, j))) {

							if ((getAdjacentUnit(i, j).get(1) == null
									|| getAdjacentUnit(i, j).get(1) instanceof Movable)
									&& (getAdjacentUnit(i, j).get(5) == null
											|| getAdjacentUnit(i, j).get(5) instanceof Movable)) {
								continue;
							}

							if (distance.get(i + 1).get(j) > distance.get(i).get(j - 1) + 1) {
								distance.get(i + 1).set(j, distance.get(i).get(j - 1) + 1);
								chk = true;
							}

							if (distance.get(i).get(j - 1) > distance.get(i + 1).get(j) + 1) {
								distance.get(i).set(j - 1, distance.get(i + 1).get(j) + 1);
								chk = true;
							}

						}

					}

				}

			}

			if (!chk) {
				break;
			}

		}

		addUnit(unit, x, y);

		return distance;

	}

	public ArrayList<Unit> getAdjacentUnit(int x, int y) {
		ArrayList<Unit> adjacentUnit = new ArrayList<Unit>();

		if (x % 2 == 0) {

			if (x > 0 && y > 0)
				adjacentUnit.add(getUnit(x - 1, y - 1));
			else
				adjacentUnit.add(null);

			if (x < width - 1 && y > 0)
				adjacentUnit.add(getUnit(x + 1, y - 1));
			else
				adjacentUnit.add(null);

		}

		if (x > 0)
			adjacentUnit.add(getUnit(x - 1, y));
		else
			adjacentUnit.add(null);

		if (x < width - 1)
			adjacentUnit.add(getUnit(x + 1, y));
		else
			adjacentUnit.add(null);

		if (x % 2 == 1) {

			if (x > 0 && y < height - 1)
				adjacentUnit.add(getUnit(x - 1, y + 1));
			else
				adjacentUnit.add(null);

			if (x < width - 1 && y < height - 1)
				adjacentUnit.add(getUnit(x + 1, y + 1));
			else
				adjacentUnit.add(null);

		}

		if (y > 0)
			adjacentUnit.add(getUnit(x, y - 1));
		else
			adjacentUnit.add(null);
		if (y < height - 1)
			adjacentUnit.add(getUnit(x, y + 1));
		else
			adjacentUnit.add(null);

		return adjacentUnit;
	}

	public boolean checkGameBoard() {

		ArrayList<ArrayList<Unit>> copyBoard = new ArrayList<ArrayList<Unit>>();
		ArrayList<Coordinate> queue = new ArrayList<Coordinate>();

		for (int i = 0; i < width; i++) {
			ArrayList<Unit> e = new ArrayList<Unit>();
			for (int j = 0; j < height; j++) {
				e.add(getUnit(i, j));
			}
			copyBoard.add(e);
		}

		for (var i : copyBoard) {
			boolean chk = false;
			for (var j : i) {
				if (j instanceof Movable) {
					queue.add(j.getCoordinate());
					chk = true;
					break;
				}
			}
			if (chk)
				break;
		}

		while (!queue.isEmpty()) {

			/*
			 * Queue
			 */
			for (var u : queue) {
				System.out.print(u + "//");
			}
			System.out.print("\n");

			var t = queue.get(0);
			queue.remove(0);

			// System.out.println(t.getCoordinate());

			
			int x = t.getX();
			int y = t.getY();
			if (copyBoard.get(x).get(y) instanceof Empty) {
				System.out.println(t + " Empty");
				continue;
			}
			
			copyBoard.get(x).set(y, new Empty(x, y));

			if (x > 0)
				queue.add(new Coordinate(x - 1, y));
			if (x < width - 1)
				queue.add(new Coordinate(x + 1, y));
			if (y > 0)
				queue.add(new Coordinate(x, y - 1));
			if (y < height - 1)
				queue.add(new Coordinate(x, y + 1));

			if (x % 2 == 0) {

				if (x > 0 && y > 0)
					queue.add(new Coordinate(x - 1, y - 1));
				if (x < width - 1 && y > 0)
					queue.add(new Coordinate(x + 1, y - 1));

			} else {

				if (x > 0 && y < height - 1)
					queue.add(new Coordinate(x - 1, y + 1));
				if (x < width - 1 && y < height - 1)
					queue.add(new Coordinate(x + 1, y + 1));

			}

		}

		// System.out.println("-----------------------------------");

		for (var i : copyBoard) {
			for (var j : i) {
				if (!(j instanceof Empty)) {
					return false;
				}
			}
		}

		return true;

	}

}
