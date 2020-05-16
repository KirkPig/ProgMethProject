package logic.exception;

import java.awt.Color;

@SuppressWarnings("serial")
public class UnitMoveException extends Exception {

	private String errorMessage;
	
	public UnitMoveException(String errorMessage) {
		// TODO Auto-generated constructor stub
		setErrorMessage(errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
