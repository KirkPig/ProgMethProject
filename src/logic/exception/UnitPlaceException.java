package logic.exception;

import java.awt.Color;

@SuppressWarnings("serial")
public class UnitPlaceException extends Exception {

	private String errorMessage;

	public UnitPlaceException(int errorCode) {
		// TODO Auto-generated constructor stub
		switch (errorCode) {
		case 1:
			this.setErrorMessage(Color.RED + "UnitPlaceException: Don't Have This Unit In Team left");
			break;
		case 2:
			this.setErrorMessage(Color.RED + "UnitPlaceException: Can't Place on Board");
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
