package gui;

public class GameGUIController {
	private static  UnitCell selectedUnit;
	private static UnitBarCell unitBarCell;
	
	public static void setSelectedUnit(UnitCell selectedUnit) {
		GameGUIController.selectedUnit = selectedUnit;
	}
	
	public static UnitCell getSelectedUnit() {
		return selectedUnit;
	}
	
	public static void setUnitBarCell(UnitBarCell unitBarCell) {
		GameGUIController.unitBarCell = unitBarCell;
	}
	
	public static UnitBarCell getUnitBarCell() {
		return unitBarCell;
	}
	
	public static void resetSelectedUnit() {
		selectedUnit = null;
	}
	
	public static void resetUnitBarCell() {
		unitBarCell = null;
	}
	
	public static boolean isUnitSelected() {
		return (selectedUnit != null);
	}
	
	public static boolean isUnitBarSelected() {
		return (unitBarCell != null);
	}
}
