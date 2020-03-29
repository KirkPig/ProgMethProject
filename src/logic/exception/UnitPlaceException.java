package logic.exception;

import java.awt.Color;

@SuppressWarnings("serial")
public class UnitPlaceException extends Exception {
	
	public UnitPlaceException(int errorCode) {
		// TODO Auto-generated constructor stub
		switch(errorCode) {
		case 1:
			System.out.println(Color.RED + "UnitPlaceException: Don't Have This Unit In Team left");
			break;
		case 2:
			System.out.println(Color.RED + "UnitPlaceException: Can't Place on Board");
			break;
		}
		
	}

}
