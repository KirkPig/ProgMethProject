package gui;

public class GameGUIController {
	private static UnitCell selectedUnit = null;
	private static UnitBarCell unitBarCell = null;
	private static UnitCell silvaSelected = null;
	private static UnitCell kaneSelected = null;
	
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
	
	public static void resetSilvaSelected() {
		silvaSelected = null;
	}
	
	public static void resetKaneSelected() {
		kaneSelected = null;
	}
	
	public static boolean isUnitSelected() {
		return (selectedUnit != null);
	}
	
	public static boolean isUnitBarSelected() {
		return (unitBarCell != null);
	}
	
	public static boolean isSilvaSelected() {
		return (silvaSelected != null);
	}
	
	public static boolean isKaneSelected() {
		return (kaneSelected != null);
	}

	public static UnitCell getSilvaSelected() {
		return silvaSelected;
	}

	public static void setSilvaSelected(UnitCell silvaSelected) {
		GameGUIController.silvaSelected = silvaSelected;
	}

	public static UnitCell getKaneSelected() {
		return kaneSelected;
	}

	public static void setKaneSelected(UnitCell kaneSelected) {
		GameGUIController.kaneSelected = kaneSelected;
	}
}
