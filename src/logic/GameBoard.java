package logic;

import java.util.ArrayList;

import unit.Defender;
import unit.Empty;
import unit.base.Coordinate;
import unit.base.Movable;
import unit.base.Unit;
import unit.captain.Silva;

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
		for (var row: units) {
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
			if (k instanceof Empty) {
				if (((Defender) unit).getCaptureUnit() == null);
				else {
					k = ((Defender) unit).getCaptureUnit();
					((Defender) unit).setCaptureUnit(null);
					k.setCapture(false);
				}
			} else {
				if (((Defender) unit).getCaptureUnit() == null) {
					k.setCapture(true);
					((Defender) unit).setCaptureUnit(k);
					k = new Empty(x2, y2);
				} else {
					var temp = ((Defender) unit).getCaptureUnit();
					k.setCapture(true);
					((Defender) unit).setCaptureUnit(k);
					k = temp;
					k.setCapture(false);
				}
			}
		}else if(unit instanceof Silva) {
			if (k instanceof Empty) {
				if (((Silva) unit).getCaptureUnit() == null);
				else {
					k = ((Silva) unit).getCaptureUnit();
					((Silva) unit).setCaptureUnit(null);
					k.setCapture(false);
				}
			} else {
				if (((Silva) unit).getCaptureUnit() == null) {
					k.setCapture(true);
					((Silva) unit).setCaptureUnit(k);
					k = new Empty(x2, y2);
				} else {
					var temp = ((Silva) unit).getCaptureUnit();
					k.setCapture(true);
					((Silva) unit).setCaptureUnit(k);
					k = temp;
					k.setCapture(false);
				}
			}
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

			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {

					for (int n = 0; n < 6; n++) {

						ArrayList<Unit> adjacentUnit = getAdjacentUnit(i, j);

						if (adjacentUnit.get(n) == null) {
							continue;
						}

						int a = getAdjacentUnit(i, j).get(n).getCoordinate().getX();
						int b = getAdjacentUnit(i, j).get(n).getCoordinate().getY();
						int c = (n == 0) ? 5 : n - 1;
						int d = (n == 5) ? 0 : n + 1;

						if(!isThrough) {
							if (adjacentUnit.get(c) == null) {
								if (adjacentUnit.get(d) == null) {
									continue;
								} else if (adjacentUnit.get(d) instanceof Movable) {
									continue;
								}
							} else if (adjacentUnit.get(d) == null) {
								if (adjacentUnit.get(c) == null) {
									continue;
								} else if (adjacentUnit.get(c) instanceof Movable) {
									continue;
								}
							} else {
								int cx = adjacentUnit.get(c).getCoordinate().getX();
								int cy = adjacentUnit.get(c).getCoordinate().getY();
								int dx = adjacentUnit.get(d).getCoordinate().getX();
								int dy = adjacentUnit.get(d).getCoordinate().getY();
								if (!isEmpty(cx, cy) && !isEmpty(dx, dy)) {
									continue;
								}
							}
						}

						if (isThrough || isEmpty(a, b)) {

							if (distance.get(a).get(b) > distance.get(i).get(j) + 1) {
								distance.get(a).set(b, distance.get(i).get(j) + 1);
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

		ArrayList<Unit> units = new ArrayList<Unit>();
		units.add(adjacentUnit.get(0));
		units.add(adjacentUnit.get(2));
		units.add(adjacentUnit.get(5));
		units.add(adjacentUnit.get(3));
		units.add(adjacentUnit.get(1));
		units.add(adjacentUnit.get(4));

		return units;
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

			var t = queue.get(0);
			queue.remove(0);

			// System.out.println(t.getCoordinate());

			int x = t.getX();
			int y = t.getY();
			if (copyBoard.get(x).get(y) instanceof Empty) {
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
