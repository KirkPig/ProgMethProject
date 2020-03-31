package logic.exception;

@SuppressWarnings("serial")
public class UnitPlaceException extends Exception {

	private String errorMessage;

	public UnitPlaceException(String errorMessage) {
		// TODO Auto-generated constructor stub
		setErrorMessage("UnitPlaceException: " + errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
