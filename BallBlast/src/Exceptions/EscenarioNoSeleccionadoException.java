package Exceptions;

public class EscenarioNoSeleccionadoException extends Exception{

	
	public EscenarioNoSeleccionadoException() {
		super("No se ha seleccionado un escenario");
	}
}
