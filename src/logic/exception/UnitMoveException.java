package logic.exception;

import java.awt.Color;

@SuppressWarnings("serial")
public class UnitMoveException extends Exception {

	private String errorMessage;
	
	public UnitMoveException(int errorCode) {
		// TODO Auto-generated constructor stub
		switch(errorCode) {
		case 1:
			this.setErrorMessage(Color.RED + "UnitMoveException: Unit you selected can't move");
			break;
		case 2:
			this.setErrorMessage(Color.RED + "UnitMoveException: Can't move on Board");
			break;
		case 3:
			this.setErrorMessage(Color.RED + "UnitMoveException: Selected wrong place to move");
			break;
		case 4:
			this.setErrorMessage(Color.RED + "UnitMoveException: Captain doesn't place");
			break;
			
		}
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
